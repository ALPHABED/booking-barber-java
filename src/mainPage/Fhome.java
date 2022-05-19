package mainPage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Color;
import mainPage.Conek;


public class Fhome extends JFrame {
	
	
	private JPanel contentPane;
	private JTextField txtNamaCustomer;
	private JTextField txtNomorTelpon;
	private JTable table;
	
	
		
//	Author: GOEN 8-mei 2022 - 19 mei 2022
	/**
	 * Launch the application.
	 */
	
	
	
	
	String sql;
	java.sql.Statement s;
	ResultSet rs,rs1;
	Connection con = null;
	String[] data;
	DefaultTableModel model,model2;
	JTextField txtJam;
	String queryString;
	PreparedStatement pst;
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fhome frame = new Fhome();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * 
	 */
	

	
	public Fhome() {
		
		
		
		con = new Conek().getConnection();
		queryString = "SELECT * FROM tblantri";	
		
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 1178, 746);
			contentPane = new JPanel();
			contentPane.setBackground(new Color(100, 149, 237));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			SpringLayout sl_contentPane = new SpringLayout();
			contentPane.setLayout(sl_contentPane);
			
			JLabel lblNewLabel = new JLabel("BARBER QUE");
			sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 33, SpringLayout.NORTH, contentPane);
			sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 450, SpringLayout.WEST, contentPane);
			lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 36));
			contentPane.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Nama Customer");
			sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 172, SpringLayout.NORTH, contentPane);
			sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 31, SpringLayout.WEST, contentPane);
			lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
			contentPane.add(lblNewLabel_1);
			
			txtNamaCustomer = new JTextField();
			sl_contentPane.putConstraint(SpringLayout.NORTH, txtNamaCustomer, -2, SpringLayout.NORTH, lblNewLabel_1);
			sl_contentPane.putConstraint(SpringLayout.WEST, txtNamaCustomer, 53, SpringLayout.EAST, lblNewLabel_1);
			sl_contentPane.putConstraint(SpringLayout.SOUTH, txtNamaCustomer, 31, SpringLayout.NORTH, lblNewLabel_1);
			sl_contentPane.putConstraint(SpringLayout.EAST, txtNamaCustomer, 292, SpringLayout.EAST, lblNewLabel_1);
			contentPane.add(txtNamaCustomer);
			txtNamaCustomer.setColumns(10);
			
			JLabel lblNewLabel_1_1 = new JLabel("Nomor Telpon");
			sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1, 61, SpringLayout.SOUTH, lblNewLabel_1);
			sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1_1, 0, SpringLayout.WEST, lblNewLabel_1);
			lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
			contentPane.add(lblNewLabel_1_1);
			
			txtNomorTelpon = new JTextField();
			sl_contentPane.putConstraint(SpringLayout.NORTH, txtNomorTelpon, -2, SpringLayout.NORTH, lblNewLabel_1_1);
			sl_contentPane.putConstraint(SpringLayout.WEST, txtNomorTelpon, 0, SpringLayout.WEST, txtNamaCustomer);
			sl_contentPane.putConstraint(SpringLayout.SOUTH, txtNomorTelpon, 85, SpringLayout.SOUTH, txtNamaCustomer);
			sl_contentPane.putConstraint(SpringLayout.EAST, txtNomorTelpon, 0, SpringLayout.EAST, txtNamaCustomer);
			txtNomorTelpon.setColumns(10);
			contentPane.add(txtNomorTelpon);
			
			JDateChooser dateChoose = new JDateChooser();
			sl_contentPane.putConstraint(SpringLayout.NORTH, dateChoose, 45, SpringLayout.SOUTH, txtNomorTelpon);
			sl_contentPane.putConstraint(SpringLayout.WEST, dateChoose, 0, SpringLayout.WEST, txtNamaCustomer);
			sl_contentPane.putConstraint(SpringLayout.SOUTH, dateChoose, 78, SpringLayout.SOUTH, txtNomorTelpon);
			sl_contentPane.putConstraint(SpringLayout.EAST, dateChoose, 462, SpringLayout.WEST, contentPane);
			contentPane.add(dateChoose);
			
			JLabel lblNewLabel_1_1_1 = new JLabel("Tanggal Booking");
			sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1_1, 0, SpringLayout.NORTH, dateChoose);
			sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_1, 0, SpringLayout.WEST, lblNewLabel_1);
			lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
			contentPane.add(lblNewLabel_1_1_1);
			
			JButton btnBooking = new JButton("Booking");
			sl_contentPane.putConstraint(SpringLayout.NORTH, btnBooking, 148, SpringLayout.SOUTH, dateChoose);
			sl_contentPane.putConstraint(SpringLayout.SOUTH, btnBooking, -142, SpringLayout.SOUTH, contentPane);
			btnBooking.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
				
				
				 	
				 	String view= "dd-MM-yyyy";
				 	SimpleDateFormat fm = new SimpleDateFormat(view);
				 	String tgl= String.valueOf(fm.format(dateChoose.getDate()));
				 	
				 	
					String HitundataString = "SELECT COUNT(nomorAntri) FROM tblantri";
					try {
						rs1 = con.createStatement().executeQuery(HitundataString);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						rs1.next();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					int	incrementInteger = 0 ;
					try {
						incrementInteger = rs1.getInt(1)+1; 
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				 	try {
				 		
				 		// add data to table
				 		String query= "INSERT INTO tblantri VALUES" + "('"+ incrementInteger+"','"+txtNamaCustomer.getText()+"','"+txtNomorTelpon.getText()+"','"+tgl+"','"+txtJam.getText()+"')";
					 	PreparedStatement pst= con.prepareStatement(query);
					 	pst.execute();
					 	
					 	JOptionPane.showMessageDialog(null, "Simpan data berhasil ", "Info", JOptionPane.INFORMATION_MESSAGE);
					 	loadData(); // add new data after add to table
					 	
					} catch (SQLException e) {
						// TODO: handle exception
						
						
						JOptionPane.showMessageDialog(null, "Simpan data gagal ", "Info", JOptionPane.INFORMATION_MESSAGE);
						e.printStackTrace();
					
					}
				 	
				 	
				}
			});
			btnBooking.setForeground(new Color(255, 255, 255));
			btnBooking.setBackground(new Color(0, 0, 139));
			sl_contentPane.putConstraint(SpringLayout.WEST, btnBooking, 170, SpringLayout.WEST, contentPane);
			sl_contentPane.putConstraint(SpringLayout.EAST, btnBooking, 316, SpringLayout.WEST, contentPane);
			btnBooking.setFont(new Font("Times New Roman", Font.BOLD, 20));
			contentPane.add(btnBooking);
			
			JLabel lblNewLabel_1_1_1_1 = new JLabel("Jam Booking");
			sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1_1_1, 58, SpringLayout.SOUTH, lblNewLabel_1_1_1);
			sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_1_1, 0, SpringLayout.WEST, lblNewLabel_1);
			lblNewLabel_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
			contentPane.add(lblNewLabel_1_1_1_1);
			
			JScrollPane scrollPane = new JScrollPane();
			sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane, 94, SpringLayout.SOUTH, lblNewLabel);
			sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane, 91, SpringLayout.EAST, txtNamaCustomer);
			sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane, -182, SpringLayout.SOUTH, contentPane);
			sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane, -65, SpringLayout.EAST, contentPane);
			contentPane.add(scrollPane);
			
			table = new JTable();

			
			 //save data to table
			try {
				rs = con.createStatement().executeQuery(queryString);
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				System.out.println("error" + e2);
				e2.printStackTrace();
			}
			String coloms[]= {"Nomor Antri", "Nama", "Nomor Telpon", "Tanggal ", "Waktu"};
			String data[][] = new String[100][5];
			
			int i =0;
			try {
				while(rs.next()) {
					String id=rs.getString("nomorAntri");
					String nama=rs.getString("namaCustomer");
					String telp = rs.getString("nomorTelpon");
					String tanggal=rs.getString("tanggalBook");
					String waktu=rs.getString("waktuBook");
					data[i][0]=id;
					data[i][1]=nama;
					data[i][2]=telp;
					data[i][3]=tanggal;
					data[i][4]=waktu;
					i++;
					
				}
				
				model = new DefaultTableModel(data, coloms);
				JTable table = new JTable(model);
				table.setShowGrid(true);
				table.setShowVerticalLines(true);
				
				scrollPane.setViewportView(table);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("error" + e1);
				e1.printStackTrace();
			}
			
			txtJam = new JTextField();
			txtJam.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
				}
			});
			sl_contentPane.putConstraint(SpringLayout.NORTH, txtJam, -2, SpringLayout.NORTH, lblNewLabel_1_1_1_1);
			sl_contentPane.putConstraint(SpringLayout.WEST, txtJam, 0, SpringLayout.WEST, txtNamaCustomer);
			sl_contentPane.putConstraint(SpringLayout.SOUTH, txtJam, 80, SpringLayout.SOUTH, dateChoose);
			sl_contentPane.putConstraint(SpringLayout.EAST, txtJam, -91, SpringLayout.WEST, scrollPane);
			contentPane.add(txtJam);
			txtJam.setColumns(10);
		
	}
	
	
	

	

	
	public void loadData() {
	
		
		//untuk merefresh data yang baru ditampilkan
		try {
			rs = con.createStatement().executeQuery(queryString);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			System.out.println("error" + e2);
			e2.printStackTrace();
			
		}
		model.setRowCount(0); // untuk merefrash hasil updatan data
		String coloms[]= {"Nomor Antri", "Nama", "Nomor Telpon", "Tanggal ", "Waktu"};
		String data[][] = new String[100][5];
		
		int i =0;
		try {
			while(rs.next()) {
				String id;
				String nama;
				String telp;
				String tanggal;
				String waktu;

				 id=rs.getString("nomorAntri");
				 nama=rs.getString("namaCustomer");
				 telp = rs.getString("nomorTelpon");
				 tanggal=rs.getString("tanggalBook");
				 waktu=rs.getString("waktuBook");
				data[i][0]=id;
				data[i][1]=nama;
				data[i][2]=telp;
				data[i][3]=tanggal;
				data[i][4]=waktu;
				model.addRow(new Object[] {id,nama,telp,tanggal,waktu});
		        
				i++;
				
			}

			 table = new JTable(model);
			 
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("error" + e1);
			e1.printStackTrace();
		}
	}
}

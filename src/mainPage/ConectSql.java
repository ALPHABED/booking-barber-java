package mainPage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


class Conek{
public Statement stat;
public ResultSet rs;
public ResultSetMetaData rsm;

	public PreparedStatement pStat;

	public Connection conn;
	public Connection getConnection() {
		
		String url = "jdbc:mysql://localhost/barber";
        String user = "root";
        String pass = "";
        
        try {
			conn=DriverManager.getConnection(url, user, pass);
			System.out.println("Koneksi Berhasil");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Koneksi gagal");
			e.printStackTrace();
		}
        
		return conn;
	}


public ResultSet execQuery(){
    try {
    	
    	String query = "SELECT * FROM tblantri";
    	stat = conn.createStatement();
        rs = stat.executeQuery(query);
     
        System.out.println("berhasil");
    } catch (Exception e) {
        // TODO Auto-generated catch block
    	System.out.println("" + e);
        e.printStackTrace();
    }
    return rs;
	}

public Integer cekdata(){
    try {
    	
    	String queryCheck = "SELECT COUNT(*)tblantri"; 
    	stat = conn.createStatement();
        rs = stat.executeQuery(queryCheck);
       System.out.println(rs);
     
        System.out.println("berhasil");
    } catch (Exception e) {
        // TODO Auto-generated catch block
    	System.out.println("" + e);
        e.printStackTrace();
    }
	return null ;
    
	}
public void insertAntri(Integer incrementInteger, String txtNamaCustomer, String txtNomorTelpon, String tgl, String txtJam) {

	try {
		pStat = conn.prepareStatement("INSERT INTO tblantri VALUES(?,?,?,?,?");
		pStat.setInt(1, incrementInteger);
		pStat.setString(2, txtNamaCustomer);
		pStat.setString(3, txtNomorTelpon);
		pStat.setString(4, tgl);
		pStat.setString(5, txtJam);
		pStat.execute();
	}catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
		
  }	
}




package mydbst1;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;


public class Mydbst1 {
	
	public static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	 
	public static final String CONN_STRING = "jdbc:mysql://localhost:3306/?user=root&password=root&useSSL=false";
	
	public static void main(String[] args) {
		
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException ex) {
			System.out.println("No MySQL driver!");
		}
		
		Enumeration<Driver> drvList =  DriverManager.getDrivers();
		while (drvList.hasMoreElements()) {
			System.out.println(drvList.nextElement());
		}
		
		Connection conn=null;
		try {
			conn = DriverManager.getConnection(CONN_STRING);
		}catch (SQLException ex) {
			System.out.println("Can't connect to MySQL");
			return;
		}
		
		try {
			ResultSet rs = conn.getMetaData().getCatalogs();
			while(rs.next()) System.out.println(rs.getString("TABLE_CAT"));
		}catch (SQLException ex) {
			System.out.println("error");
		}
		
		try {
			Statement st = conn.createStatement();
			int res = st.executeUpdate("CREATE DATABASE db");
			System.out.println("Database db created, " + res + " result");
		} catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		try {
			Statement st = conn.createStatement();
			st.executeUpdate("USE db");
		} catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		try {
			Statement st = conn.createStatement();
			//st.executeUpdate("CREATE TABLE persons (id int (11),name varchar (64),surname varchar (64),age int (6))");
			//st.executeUpdate("INSERT INTO persons (id,name,surname,age) VALUES (1005,'Name2','Surname121',66)");
			//ResultSet rs = st.executeQuery("SELECT * FROM persons");
			System.out.println(st.execute("DESCRIBE "));
			//while(rs.next()) System.out.println(rs.getString("age") +"  |  " + rs.getString("name") +"    |   " + rs.getString("id") + "  |  " + rs.getString("surname") );
		} catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
	}
}
	

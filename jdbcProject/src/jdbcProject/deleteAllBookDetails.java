package jdbcProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class deleteAllBookDetails {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/company";
		String user = "root";
		String password = "Sandip3366";
		
		
		
		
		final String DELETE_QUERY = "DELETE FROM book";


		//1. Loading Driver class
		Class.forName(driver);
		
		//2. Esatablish connection
		Connection con = DriverManager.getConnection(url, user, password);
		
		//3. Create PreparedStatement object
		Statement ps = con.createStatement();
		

		
		//4. Execute query
		int status = ps.executeUpdate(DELETE_QUERY);//to process delete update and insert
		
		if(status >= 1) {
			System.out.println("success");
		}else {
			System.out.println("failed");
		}
		
		//5. Close resources
		ps.close();
		con.close();		
	}
}

package jdbcProject;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetBoookDetails {
   public static void main(String[] args) throws ClassNotFoundException, SQLException {
	   String driver = "com.mysql.cj.jdbc.Driver";
	   String url = "jdbc:mysql://localhost:3306/company";
	   String user = "root";
	   String password = "Sandip3366";
	   
	   String sql = "select * from book";
	   
	   
	   //loading the driver
	   Class.forName(driver);
	   
	   //establish connection
	   Connection con = DriverManager.getConnection(url,user,password);
	   
	   //create preparedstatement object
	   Statement st = con.createStatement();
	   
	   //execute query
	   ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
			System.out.println(rs.getInt("bookId")+"\t"+rs.getString("bookName")+"\t"+rs.getString("bookAuthor")+"\t"+rs.getInt("bookPrice"));
		}
	   
	   //close resources
		rs.close();
		st.close();
		con.close();
	   
	   
	   
   }
}

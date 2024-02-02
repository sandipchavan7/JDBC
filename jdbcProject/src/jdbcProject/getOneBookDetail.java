package jdbcProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class getOneBookDetail {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/company";
		String user = "root";
		String password = "Sandip3366";
		String sql = "select * from book where bookid = ?";
		
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter book id: ");
		int id = in.nextInt();
		
		//1. Loading Driver class
		Class.forName(driver);
		
		//2. Esatablish connection
		Connection con = DriverManager.getConnection(url, user, password);
		
		//3. Create Statement object
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		
		//4. Execute query
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			System.out.println(rs.getInt("bookId")+"\t"+rs.getString("bookName")+"\t"+rs.getString("bookAuthor")+"\t"+rs.getInt("bookPrice"));
		}else {
			System.out.println("no data found");
		}
		
		//5. Close resources
		rs.close();
		ps.close();
		con.close();		
	}
}

package jdbcProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class updateBookDetails {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/company";
		String user = "root";
		String password = "Sandip3366";
		
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter book id: ");
		int bookId = in.nextInt();
		System.out.println("Please enter book name: ");
		String bookName = in.next();
		System.out.println("Please enter author name: ");
		String bookAuthor = in.next();
		System.out.println("Please enter book price: ");
		int bookPrice = in.nextInt();
		
		final String UPDATE_QUERY = "update book set bookName=?,bookAuthor=?,bookPrice=? where bookId=?";


		//1. Loading Driver class
		Class.forName(driver);
		
		//2. Esatablish connection
		Connection con = DriverManager.getConnection(url, user, password);
		
		//3. Create PreparedStatement object
		PreparedStatement ps = con.prepareStatement(UPDATE_QUERY);
		ps.setString(1, bookName);
		ps.setString(2, bookAuthor);
		ps.setInt(3, bookPrice);
		ps.setInt(4, bookId);

		
		//4. Execute query
		int status = ps.executeUpdate();
		
		if(status == 1) {
			System.out.println("success");
		}else {
			System.out.println("failed");
		}
		
		//5. Close resources
		ps.close();
		con.close();		
	}
}

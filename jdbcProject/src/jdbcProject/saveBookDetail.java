package jdbcProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class saveBookDetail {
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
		System.out.println("Please enter book author: ");
		String bookAuthor = in.next();
		System.out.println("Please enter book price: ");
		int bookPrice = in.nextInt();
		
		//String insert_sql = "insert into employee values(1006,'Raaj','raaj@gmail.com',65000)";
		String insert_sql = "insert into book values("+bookId+",'"+bookName+"','"+bookAuthor+"',"+bookPrice+")";


		//1. Loading Driver class
		Class.forName(driver);
		
		//2. Esatablish connection
		Connection con = DriverManager.getConnection(url, user, password);
		
		//3. Create Statement object
		Statement st = con.createStatement();
		
		//4. Execute query
		int status = st.executeUpdate(insert_sql);
		
		if(status == 1) {
			System.out.println("success");
		}else {
			System.out.println("failed");
		}
		
		//5. Close resources
		st.close();
		con.close();		
	}
}

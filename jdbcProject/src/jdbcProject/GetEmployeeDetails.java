package jdbcProject;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	public class GetEmployeeDetails {
		public static void main(String[] args) throws ClassNotFoundException, SQLException {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/company";
			String user = "root";
			String password = "Sandip3366";
			String sql = "select * from employee";
			
			//1. Loading Driver class
			Class.forName(driver);
			
			//2. Esatablish connection
			Connection con = DriverManager.getConnection(url, user, password);
			
			//3. Create Statement object
			Statement st = con.createStatement();
			
			//4. Execute query
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getInt("id")+"\t"+rs.getString("name")+"\t"+rs.getString("email")+"\t"+rs.getInt("salary"));
			}
			
			//5. Close resources
			rs.close();
			st.close();
			con.close();		
		}
	}


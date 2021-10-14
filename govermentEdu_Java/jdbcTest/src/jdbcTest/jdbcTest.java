package jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class jdbcTest {

	public static void main(String[] args) {
		try { 
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root","58545256");
			System.out.println("연결 성공");
			
			Statement stmt = conn.createStatement();
			
			//insert
			//stmt.executeUpdate("insert into student values('1234567', '왕건', '국문학과')");
			
			//update
			//stmt.executeUpdate("update student set name='홍길동' where id = '1234567'");
			
			//delete
			//stmt.executeUpdate("delete from student where id = '1234567'");
			
			ResultSet rs = stmt.executeQuery("select * from student order by name");
			while(rs.next()) {
				System.out.println(rs.getString("id")); 
				System.out.println(rs.getString("name")); 
				System.out.println(rs.getString("dept"));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) { e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		}
	}

}

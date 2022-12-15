package main.java.com.study.jdbc.main.dml;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import main.java.com.study.jdbc.util.DBConnection;

public class JdbcSelect2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("작성자 id: ");
		int writetId = sc.nextInt();
		
		Connection con = DBConnection.getinstance().getConnection();
		
		// where 조건 쓰는 방법
		String sql = "select * from board_mst where writer_id = ?"; 
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql); 
			pstmt.setInt(1, writetId); //첫 번째 ?에 writerId set하겠다 라는 의미
			ResultSet rs = pstmt.executeQuery(); // select 결과값을 담을 수 있다.
			
			while (rs.next()) {
				System.out.println("id: " + rs.getInt(1) 
				+ "\t title: " + rs.getString(2)
				+ "\t content: " + rs.getString(3)
				+ "\t read_count: " + rs.getInt(4)
				+ "\t wrier_id: " + rs.getInt(5));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}

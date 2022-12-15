package main.java.com.study.jdbc.main.dml;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import main.java.com.study.jdbc.util.DBConnection;

// 테이블에 등록된 id 값을 입력 후 username을 바꾸는 코드

public class JdbcUpdate {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("수정할 계정의 id 값을 입력하세요.");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.print("수정할 아이디 입력: ");
		String username = sc.nextLine();

		Connection con = DBConnection.getinstance().getConnection();
		String sql = "update user_mst set username = ? where id = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username); // 1번 ? = username
			pstmt.setInt(2, id); // 2번 ? = id
			int successCount = pstmt.executeUpdate();
			System.out.println(successCount + "건 수정완료!");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}

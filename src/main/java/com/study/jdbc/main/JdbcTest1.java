package main.java.com.study.jdbc.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.com.study.jdbc.util.DBConnection;

public class JdbcTest1 {

	public static void main(String[] args) {
		Connection connection = DBConnection.getinstance().getConnection(); // DB연결
		
		String sql = " select * from score_mst "; 

		try {
			PreparedStatement pstmt = connection.prepareStatement(sql); // prepareStatement 쿼리를 받아들일 수 있는 공간
			ResultSet rs = pstmt.executeQuery(); // pstmt.executeQuery()가 호출이 되면 쿼리 실행
			// ResultSet 결과를 가지고 있는 Set
			
			System.out.println("id\tname\t\tsocre");

			while (rs.next()) { // rs.next가 거짓일 때는 행을 다 출력, 비었을 때는 false가 된다.
				System.out.println("id: " + rs.getInt(1) // rs.getInt(1) 괄호안에 들어있는 건 컬럼 번호다. 1번 부터 시작
				+ "\t name: " + rs.getString(2)
				+ "\t score: " + rs.getInt(3));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}

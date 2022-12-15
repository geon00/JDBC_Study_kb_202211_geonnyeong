package main.java.com.study.jdbc.main.dml;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.java.com.study.jdbc.util.DBConnection;

public class JdbcInsert2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> usernameList = new ArrayList<>();

		while (true) {
			System.out.print("등록할 아이디 입력: ");
			usernameList.add(sc.nextLine()); // 입력받는 값을 바로 add한다.
			System.out.print("아이디를 추가로 등록하시겠습니까? Y/y, 취소하려면 아무키나 입력하세요.");
			String selected = sc.nextLine();
			if (!"yY".contains(sc.nextLine().isBlank() ? "n" : selected)) { // isBalnk가 비었는지 확인
				break; // !not을 포함시켜 y/Y가 아니면 멈춰라 라는 실행문
			}

		}
		// 입력한 여러개의 아이디들을 등록하는 코드
		Connection con = DBConnection.getinstance().getConnection();
		String prefixSql = "insert into user_mst values"; // 쿼리문을 delete로 바꾸면 delete가 된다.
		String valuesBoby = "";
		String suffixSql = ";";

		for (int i = 0; i < usernameList.size(); i++) {
			valuesBoby += "(0, ?)";
			if (i < usernameList.size() - 1) { // -1한 것보다 작아야 ,가 찍힌다.
				valuesBoby += ",";
			}
		}
//		System.out.println(valuesBoby);

		try {
			PreparedStatement pstmt = con.prepareStatement(prefixSql + valuesBoby + suffixSql);
			for (int i = 0; i < usernameList.size(); i++) { // ?에 입력받은 값들을 넣는다.
				pstmt.setString(i + 1, usernameList.get(i));
			}
			int successCount = pstmt.executeUpdate();
			System.out.println(successCount + "건 등록완료!");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
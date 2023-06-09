package com.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestJdbc {
/*
 * JDBC(Java Database Connectivity)
 * 1. Driver loading
 * 	> Class.forName();
 * 2. Driver 등록 -> 관리자(DriverManager)
 * 3. Connection 얻기
 * 	> conn = DriverManager.getConnection(url, user, pwd)
 * 4. 명령문(Statement) 만들기
 * 	> stmt = conn.createStatement();
 * 	> String sql = "SELECT * FROM employees";
 * 5. 실행(executeOoo)
 * 	> result = stmt.executeQuery(sql);
 * 6. 5번 중 SELECT 구문일 경우 -> ResultRecordSet
 * 7. next() -> getOoo()을 통해 데이터를 가져옴
 * 		ex) result.next();
 * 			String data = result.getString(0);
 * 	> result.next();
 * 	> String data = result.getString(0);
 * 8. 6,4,3 -> 순서대로 close()
 * 	> result.close();
 * 	> stmt.close();
 * 
 */
	public static void main(String[] args) {
		Class.forName("");
		String url = "";
		String user = "hr";
		String pwd = "hr";
		Connection conn = DriverManager.getConnection(url, user, pwd);
		Statement stmt = conn.createStatement();
		String sql = "SELECT * FROM employees";
		ResultSet result = stmt.executeQuery(sql);
		result.next();
		String data = result.getString(0);
		result.close();
		stmt.close();
		conn.close();

	}

}

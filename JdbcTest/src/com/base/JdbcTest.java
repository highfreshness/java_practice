package com.base;

import java.sql.Connection;

public class JdbcTest {

	public static void main(String[] args) {
		Connection conn = DBConn.getConnection();
		
		if(conn==null) {
			System.out.println("데이터베이스 연결 실패");
			System.exit(0);
		}
		
		System.out.println("데이터베이스 연결 성공");
		DBConn.close();
	}

}

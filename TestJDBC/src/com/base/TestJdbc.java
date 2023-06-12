package com.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	public static void main(String[] args){
		
//	    Class.forName("oracle.jdbc.driver.OracleDriver");
//		String url = "jdbc:oracle:thin@localhost:1521:xe";
//		String user = "hr";
//		String pwd = "hr";
//		Connection conn = DriverManager.getConnection(url, user, pwd);
//		Statement stmt = conn.createStatement();
//		String sql = "SELECT * FROM employees";
//		ResultSet result = stmt.executeQuery(sql);
//		result.next();
//		String data = result.getString(0);
//		System.out.println(data);
//		result.close();
//		stmt.close();
//		conn.close();
		 
		
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";  // JDBC URL
        String username = "hr";
        String password = "hr";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");  // JDBC 드라이버 클래스 로딩
            conn = DriverManager.getConnection(jdbcUrl, username, password);  // Connection 생성
            stmt = conn.createStatement();  // Statement 생성
            rs = stmt.executeQuery("SELECT * FROM employees");  // SELECT 쿼리 실행

            while (rs.next()) {  // 결과 출력
                System.out.println(rs.getInt("employee_id") + ", " + rs.getString("first_name"));
            }

        } 
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        } 
        catch (SQLException e) {
            e.printStackTrace();
        } 
        finally {
            try { rs.close(); } catch (Exception e) {}
            try { stmt.close(); } catch (Exception e) {}
            try { conn.close(); } catch (Exception e) {}
        }
    }
}



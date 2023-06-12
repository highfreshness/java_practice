package com.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateJdbc {

	public static void main(String[] args){
		
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";  // JDBC URL
        String username = "hr";
        String password = "hr";

        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = null;
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");  // JDBC 드라이버 클래스 로딩
            conn = DriverManager.getConnection(jdbcUrl, username, password);  // Connection 생성
            Scanner sc = new Scanner(System.in);
            System.out.print("가격을 입력해주세요 : ");
            int price = sc.nextInt();
            System.out.print("타이틀 번호를 입력해주세요 : ");
            int title_id = sc.nextInt();
            sql = "Update title SET price=? WHERE title_id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, price);
            pstmt.setInt(2, title_id);
            int result = pstmt.executeUpdate();
            
            if (result == 1)
            	System.out.println("수정 성공 " + result);

        } 
        catch (ClassNotFoundException e) {
        	/*
        	 *  JDBC 드라이버 클래스가 로드되지 않았을 때 발생
        	 *  이 예외가 발생하면 JDBC 드라이버 클래스가 로드되지 않은 것이므로, 
        	 *  이 예외를 잡아내서 드라이버 클래스를 로드해줘야 합니다.
        	 */
            e.printStackTrace();
        } 
        catch (SQLException e) {
        	/*
        	 * 데이터베이스에 대한 연결 또는 쿼리 실행 과정에서 발생할 수 있는 예외
        	 * 데이터베이스와의 연결이 끊어졌거나 쿼리 실행에 실패하면 SQLException이 발생
        	 */
            e.printStackTrace();
        } 
        try {
            if (pstmt != null)
                pstmt.close();
            if (conn != null)
                conn.close();
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
	}
}




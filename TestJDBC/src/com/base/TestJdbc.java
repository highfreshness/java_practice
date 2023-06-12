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
                // System.out.println(rs); 그냥 rs만으로는 내용을 확인할 수 없음.
                
               /*
                * 전체 결과 출력
                * for (int i = 1; i <= columnsNumber; i++) {
                    String columnValue = rs.getString(i);
                    System.out.print(columnValue + " ");
                  }
                System.out.println();
                */
            }

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
        finally {
        	/*
        	 * 사용한 ResultSet, Statement, Connection 등의 자원들은 
        	 * 연결을 해제하는데 시간이 오래 걸려서, 사용하고 난 후 반드시 닫아주어야 한다. 
        	 * 그렇지 않으면, 자원 누수(memory leak)가 발생하여 불필요한 자원이 낭비될 수 있기 때문,
        	 * 자원을 닫는 close() 메소드를 호출하여, 사용한 자원을 release 해준다.
        	 */
            try { rs.close(); } catch (Exception e) {}
            try { stmt.close(); } catch (Exception e) {}
            try { conn.close(); } catch (Exception e) {}
        }
    }
}



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class App {

	public static void main(String[] args){
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        
        try {
            Class.forName("oracle.jdbc.OracleDriver"); 
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
            System.out.println("연결성공");
            
            Scanner sc = new Scanner(System.in);
            System.out.println("확인하고 싶은 사원의 사번을 입력해 주세요 :");
            String tab = sc.next();
            sc.close();
            
            //그러난 이는 옛날 구식의 방법으로 값을 입력받아 넣는방법이다.
           //    String sql = "insert into cost values("+num +"," + name +"," + email +"," + ","+tel+")" ;
            
            //아래가 요즘방식
            String sql = "SELECT * FROM employees WHERE employee_id = ?"; // ?는 prepareStatement 가 알아봐요
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, tab); // 테이블의 데이터 타입에 뭦춰주는것 잊지마.
            rs = pstmt.executeQuery();
            while(rs.next()){
                String emp_id = rs.getString("employee_id");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                System.out.printf("%s %s %s", emp_id, first_name, last_name);
                System.out.println();
            }
        } 
        catch (SQLException e) {
            System.out.println("DB 연결 실패, SQL 오류");
            e.printStackTrace();
        } 
        catch (ClassNotFoundException e) {
            System.out.println("DB 연결 실패, 드라이버 클래스 파일 오류");
            e.printStackTrace();
        }
        catch (Exception e) {
            System.out.println("어떤 이유로 연결 실패");
            e.printStackTrace();   
        }
        try {//con!= null 열린다.
                if(rs != null) rs.close();
                if(pstmt != null)pstmt.close();
                if(conn != null)conn.close();
                System.out.println("데이터베이스가 잘 종료되었다.");
        } 
        catch (SQLException e) {
        }
    }
}



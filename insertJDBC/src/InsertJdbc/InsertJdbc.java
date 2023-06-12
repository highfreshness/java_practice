package InsertJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertJdbc {

	public static void main(String[] args){
		
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";  // JDBC URL
        String username = "hr";
        String password = "hr";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        String querybag = 
        		"INSERT INTO title(title_id, title, description, rating, category, release_date)"
        		+ "VALUES (title_id_seq.NEXTVAL, 'Willie and Christmas Too', 'All of Willie''s friends make a Christmas list for Santa, but Willie has yet to add his own wish list.', 'G', 'CHILD', TO_DATE('05-10-1995','DD-MM-YYYY'))\n" 
        		
        		+ "INSERT INTO title(title_id , title, description, rating, category, release_date)"
        		+ "VALUES (title_id_seq.NEXTVAL, 'Alien Again', 'Yet another installment of science fiction history. Can the heroine save the planet from the alien life form?', 'R', 'SCIFI', TO_DATE('19-05-1995','DD-MM-YYYY'))\n"
        		
        		+ "INSERT INTO title(title_id, title, description, rating, category, release_date)"
        		+ "VALUES (title_id_seq.NEXTVAL, 'The Glob', 'A meteor crashes near a small American town and unleashes carnivorous goo in this classic.', 'NR', 'SCIFI', TO_DATE('12-08-1995','DD-MM-YYYY'))\n"
        		
        		+ "INSERT INTO title(title_id, title, description, rating, category, release_date)"
        		+ "VALUES (title_id_seq.NEXTVAL, 'My Day Off', 'With a little luck and a lot ingenuity, a teenager skips school for a day in New York.', 'PG', 'COMEDY', TO_DATE('12-07-1995','DD-MM-YYYY'))\n"

        		+ "INSERT INTO title(title_id, title, description, rating, category, release_date)"
        		+ "VALUES (title_id_seq.NEXTVAL, 'Miracles on Ice', 'A sixyear-old has doubts about Santa Claus, but she discovers that miracles really do exist.', 'PG', 'DRAMA', TO_DATE('12-09-1995','DD-MM-YYYY'))\n"

        		+ "INSERT INTO title(title_id, title, description, rating, category, release_date)"
        		+ "VALUES (title_id_seq.NEXTVAL, 'Soda Gang', 'After discovering a cache of drugs, a young couple find themselves pitted against a vicious gang.', 'NR', 'ACTION', TO_DATE('01-06-1995','DD-MM-YYYY'))\n";
        
        String[] queries = querybag.split("\n");
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");  // JDBC 드라이버 클래스 로딩
            conn = DriverManager.getConnection(jdbcUrl, username, password);  // Connection 생성
            stmt = conn.createStatement();  // Statement 생성
            int affectedRows = 0;
            
            for (String query : queries) {
            	affectedRows += stmt.executeUpdate(query);
            }

            System.out.println("Affected rows: " + affectedRows);

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



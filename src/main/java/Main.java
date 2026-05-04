import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws Exception {

        Connection conn = DriverManager.getConnection(
                "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1", "sa", "");

        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT 1 AS result");

        while (rs.next()) {
            System.out.println("Result: " + rs.getInt("result"));
        }

        rs.close();
        stmt.close();
        conn.close();
        System.out.println("Connection closed.");
    }
}

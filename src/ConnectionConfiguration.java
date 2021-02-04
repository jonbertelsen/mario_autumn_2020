import java.sql.Connection;
import java.sql.DriverManager;

    public class ConnectionConfiguration {
        public static Connection getConnection() {
            Connection connection = null;
            String url = "jdbc:mysql://localhost:3306/mario_db?serverTimezone=UTC&useSSL=false";
            String user = "root";
            String password = "root";
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, user, password);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return connection;
        }

    }

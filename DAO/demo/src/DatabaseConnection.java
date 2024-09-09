import java.sql.*;

public class DatabaseConnection {


    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/?user=root";
    static final String USER = "root";
    static final String PASS = "666666";

    public static void databaseconnection(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {

            Class.forName(JDBC_DRIVER);


            System.out.println("connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);


            String sql = "SELECT customer_id, customer_name FROM customer";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();


            while (rs.next()) {
                int id = rs.getInt("customer_id");
                String name = rs.getString("customer_name");
                System.out.println("customer_id: " + id + ", customer_name: " + name);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {

            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
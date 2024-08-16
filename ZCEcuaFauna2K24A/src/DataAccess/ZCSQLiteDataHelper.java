// Clase ZCSQLiteDataHelper.java
package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class ZCSQLiteDataHelper {
    private static String DBPathConnection = "jdbc:sqlite:C:/Users/pc/Desktop/ZCEcuaFauna2K24A/database/ZCEcuaFauna2k24A.sqlite"; 
    
    private static Connection conn = null;

    protected static synchronized Connection openConnection() throws SQLException {
        if(conn == null || conn.isClosed()) {
            conn = DriverManager.getConnection(DBPathConnection);
        }
        return conn;
    }

    protected static void closeConnection() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
            conn = null;
        }
    }
}

package ro.teamnet.zth.api.database;

import java.sql.*;

/**
 * Created by Alexandra.Soare on 7/13/2017.
 */
public class DBManager implements DBProperties {
    static String CONNECTION_STRING= "jdbc:oracle:thin:@" + DBProperties.IP + ":" + DBProperties.PORT + ":xe";

    private DBManager() {
        throw new UnsupportedOperationException();
    }

    private static void registerDriver() {
        try {
            Class.forName(DBProperties.DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            //Driver myDriver = new oracle.jdbc.driver.OracleDriver();
            //DriverManager.registerDriver(myDriver);
            registerDriver();
            conn =  DriverManager.getConnection(CONNECTION_STRING, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static Boolean checkConnection(Connection connection) {
        Boolean ret = false;
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT 1 FROM DUAL";

            ret = stmt.execute(query);
//            System.out.println("Return value is : " + ret.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }
}

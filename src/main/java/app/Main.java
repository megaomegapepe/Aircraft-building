package app;

import java.sql.*;
import java.util.Locale;
import java.util.Properties;
import java.util.TimeZone;

public class Main {
    public static void main(String[] args) throws SQLException {
        MyApplication.launch(args);
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Oracle jdbc driver found!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //  Change IP, user and password
        String url = "jdbc:oracle:thin:@84.237.50.81:1521:";
        Properties props = new Properties();
        props.setProperty("user", "***");
        props.setProperty("password", "***");

        TimeZone timeZone = TimeZone.getTimeZone("GMT+7");
        TimeZone.setDefault(timeZone);
        Locale.setDefault(Locale.ENGLISH);

        Connection conn = DriverManager.getConnection(url, props);

        String sql = "select count(*) from accouns";
        PreparedStatement preStatement = conn.prepareStatement(sql);
        ResultSet result = preStatement.executeQuery();
        while (result.next()) {
            int count = result.getInt(1);
            System.out.println("Total number of records in EMP table: " + count);
        }
        System.out.println("!!!");
        conn.close();
    }
}


import java.sql.*;
import javax.swing.*;


public class CoinDeduction extends LoginPage2 {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String URL = "jdbc:mysql://localhost/Hotel";
    static final String USER = "root";
    static final String PASS = "";


    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement ps = null;

        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("MySql Driver Loaded");
            conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Connection Successful");

            String enteredusername = usertextf.getText();
           System.out.println(OldCoinsAmountInDatabase.dbcoin);
           int newblisscoin = OldCoinsAmountInDatabase.dbcoin - HotelBilling.t;
            System.out.println("Balance = " + newblisscoin);


            String updatesql = "UPDATE userdata SET blisscoin = ? WHERE username = ?";
            ps = conn.prepareStatement(updatesql);
            ps.setInt(1,newblisscoin);
            ps.setString(2, enteredusername);


            int rowsUpdated = ps.executeUpdate();


            if (rowsUpdated > 0) {

                JOptionPane.showMessageDialog(null, "Payment Successful!");

            } else {

                JOptionPane.showMessageDialog(null, "Failed");
            }



            ps.close();


        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
            System.out.println("BYE");
        }
    }
}


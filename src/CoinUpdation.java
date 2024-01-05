import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class CoinUpdation extends CoinInformation {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String URL = "jdbc:mysql://localhost/hotel";
    static final String USER = "root";
    static final String PASS = "";
    public static boolean isUser = true;
    public static int balance;

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement ps = null;

        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("MySql Driver Loaded");
            conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Connection Successful");

        String enteredusername = LoginPage2.usertextf.getText();
        String enteredamount = addbalanceamttf.getText();
        String enteredpin = new String(pintf.getPassword());
        System.out.println(enteredamount);

        int intenteredamount = Integer.parseInt(enteredamount);

        balance = OldCoinsAmountInDatabase.dbcoin + intenteredamount;
        String stringbalance = Integer.toString(balance);

        
        String update =  "UPDATE userdata set blisscoin = ?  where username = ?";
        ps = conn.prepareStatement(update);
        ps.setInt(1,balance);
        ps.setString(2,enteredusername);




            int rowsUpdated = ps.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Coins after updation : " +balance);

            } else {
                // No rows were updated, username not found
                JOptionPane.showMessageDialog(null, "Incorrect Username");
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


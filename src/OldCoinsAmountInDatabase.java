import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class OldCoinsAmountInDatabase extends LoginPage2 {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String URL = "jdbc:mysql://localhost/hotel";
    static final String USER = "root";
    static final String PASS = "";
    public static boolean isUser = false;
    public static int dbcoin;
    PreparedStatement ps = null;

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        JFrame frame = new JFrame("User Authentication");

        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("MySql Driver Loaded");
            conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Connection Successful");


            String enteredusername = usertextf.getText();


            System.out.println("Entered username " +enteredusername);





            System.out.println("Creating statement");


            String updatesql = "SELECT blisscoin FROM userdata WHERE username = ?";
            ps = conn.prepareStatement(updatesql);
            ps.setString(1, enteredusername);
            ps.executeQuery();
            ResultSet rs = ps.executeQuery(); // Execute the query and get the result set

            if (rs.next()) {
                dbcoin = rs.getInt("blisscoin"); // Retrieve the "blisscoin" value from the result set
                // Do something with the blisscoin value, for example, print it
                System.out.println("Blisscoin value for " + enteredusername + " is: " + dbcoin);
            } else {

                System.out.println("No data found for the username: " + enteredusername);
            }









            rs.close();


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

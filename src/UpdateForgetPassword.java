import java.sql.*;
import javax.swing.*;


public class UpdateForgetPassword extends ForgotPassword {

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

            // Replace with your GUI component names where the user enters username and password
            String enteredusername = checkusertextf.getText();
            String enterednewpassword = new String(newpasswordpassf.getPassword());
            String re_enterednewpassword = new String(re_enter_passwordpassf.getPassword());


            String updatesql = "UPDATE userdata SET password = ? WHERE username = ?";
            ps = conn.prepareStatement(updatesql);
            ps.setString(1, enterednewpassword);
            ps.setString(2, enteredusername);

            // Execute the update statement
            int rowsUpdated = ps.executeUpdate();

            if (rowsUpdated > 0) {
                // Password updated successfully\
                JOptionPane.showMessageDialog(null, "Password Changed!");

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

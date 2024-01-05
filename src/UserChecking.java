import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class UserChecking extends LoginPage2 {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String URL = "jdbc:mysql://localhost/hotel";
    static final String USER = "root";
    static final String PASS = "";
    public static boolean isUser = false;

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        JFrame frame = new JFrame("User Authentication");

        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("MySql Driver Loaded");
            conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Connection Successful");


            String enteredusername = usertextf.getText();
           String enteredpassword = new String(passtextf.getPassword());

            System.out.println("Entered username " +enteredusername);
            System.out.println("Entered password " +enteredpassword);




            System.out.println("Creating statement");



            stmt = conn.createStatement();
            String sql = "SELECT username, password FROM userdata";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String u = rs.getString("username");
                String p = rs.getString("password");


                if (u.equals(enteredusername) && p.equals(enteredpassword)) {
                    Welcome w = new Welcome();
//                    w.setVisible(true);
                   isUser = true;
                   break;



                }

            }if(!isUser)
            {
                JOptionPane.showMessageDialog(null,"Incorrect Details");
            }


            rs.close();






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

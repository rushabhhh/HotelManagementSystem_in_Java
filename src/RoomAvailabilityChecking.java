import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class RoomAvailabilityChecking extends LoginPage2 {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String URL = "jdbc:mysql://localhost/hotel";
    static final String USER = "root";
    static final String PASS = "";
    public static boolean isUser = false;
            RoomAvailabilityChecking(Date sqlCheckoutDate)
            {
                Connection conn = null;
                Statement stmt = null;


                try {
                    Class.forName(JDBC_DRIVER);
                    System.out.println("MySql Driver Loaded");
                    conn = DriverManager.getConnection(URL, USER, PASS);
                    System.out.println("Connection Successful");
                    String selectedroomtype =  HotelBooking.selectedroom;
                    System.out.println(selectedroomtype);




                    System.out.println("Creating statement");
                    String query = "SELECT status, checkout from rooms where roomtype = ?";
                    PreparedStatement ps = conn.prepareStatement(query);
                    ps.setString(1,selectedroomtype);
                    ps.executeQuery();
                    ResultSet rs = ps.executeQuery();

                    if (rs.next()) {

                        int status = rs.getInt("status");
                        Date cdate = rs.getDate("checkout");
                        System.out.println(cdate);
                        System.out.println(HotelBooking.sqlCheckoutDate);
                        if (status == 0 )
                        {
                            JOptionPane.showMessageDialog(null,"RoomNotAvaiilable");
                            new HotelBooking();
                            return;

//
//                        } else {
//
//                               OldCoinsAmountInDatabase.main(new String[0]);
//

                        }
                        HotelBilling hb = new HotelBilling(HotelBooking.selectedroom);

                    }

//
//            stmt = conn.createStatement();
//            String sql = "SELECT username, password FROM userdata";
//            ResultSet rs = stmt.executeQuery(sql);
//            while (rs.next()) {
//                String u = rs.getString("username");
//                String p = rs.getString("password");
//
//
//                if (u.equals(enteredusername) && p.equals(enteredpassword)) {
//                    Welcome w = new Welcome();
////                    w.setVisible(true);
//                    isUser = true;
//                    break;
//
//
//
//                }
//
//            }if(!isUser)
//            {
//                JOptionPane.showMessageDialog(null,"Incorrect Details");
//            }
//
//
//            rs.close();






//


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

    public static void main(String[] args) {

    }
}



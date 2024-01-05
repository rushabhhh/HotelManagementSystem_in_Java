import java.sql.*;
import javax.swing.*;


 class RoomAvailabilityUpdation extends HotelBilling {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String URL = "jdbc:mysql://localhost/Hotel";
    static final String USER = "root";
    static final String PASS = "";


     public RoomAvailabilityUpdation(String selectedRoomType) {
         super(selectedRoomType);
         Connection conn = null;
         Statement stmt = null;
         PreparedStatement ps = null;

         try {
             Class.forName(JDBC_DRIVER);
             System.out.println("MySql Driver Loaded");
             conn = DriverManager.getConnection(URL, USER, PASS);
             System.out.println("Connection Successful");

             // Replace with your GUI component names where the user enters username and password
             String enteredusername = billusernametf.getText();
//            int status = 1;
             java.sql.Date sqlCheckoutDate = new java.sql.Date(HotelBooking.sqlCheckoutDate.getTime());

             String updatesql = "UPDATE rooms SET status = ? , checkout = ? WHERE roomtype = ?";
             ps = conn.prepareStatement(updatesql);

             ps.setInt(1,0);

             ps.setDate(2, sqlCheckoutDate);
             ps.setString(3,HotelBilling.roomtypetf.getText());

             // Execute the update statement
             int rowsUpdated = ps.executeUpdate();

             if (rowsUpdated > 0) {
                 // Password updated successfully\
                 JOptionPane.showMessageDialog(null, "Please fill your details to confirm your booking!");

             } else {

                 JOptionPane.showMessageDialog(null, "Error");
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



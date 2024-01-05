import java.sql.*;
import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class RoomBookingUpdation extends LoginPage2 {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String URL = "jdbc:mysql://localhost/Hotel";
    static final String USER = "root";
    static final String PASS = "";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("MySql Driver Loaded");
            conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Connection Successful");

            String enteredusername = usertextf.getText();
            String enteredpassword = new String(passtextf.getPassword());
            String selectedroomtype = HotelBilling.roomtypetf.getText();
            System.out.println("Entered username " + enteredusername);

            System.out.println("Selected Room " + selectedroomtype);

            String cindate = HotelBilling.checkindatetf.getText();
            System.out.println("Checkin date " + cindate);

            String coutdate = HotelBilling.checkoutdatetf.getText();
            System.out.println("Checkout date " + coutdate);

            SimpleDateFormat inputFormat = new SimpleDateFormat("MMM dd, yyyy");

            // Wrap date parsing in a try-catch block to handle ParseException
            try {
                Date checkinDate = new Date(inputFormat.parse(cindate).getTime());
                Date checkoutDate = new Date(inputFormat.parse(coutdate).getTime());

                // Prepare the SQL statement using a PreparedStatement
                String sql = "INSERT INTO roombookings (guestname, checkin, checkout, roomtype) VALUES (?, ?, ?, ?)";
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, enteredusername);
                preparedStatement.setDate(2, checkinDate);
                preparedStatement.setDate(3, checkoutDate);
                preparedStatement.setString(4, selectedroomtype);

                // Execute the SQL statement
                preparedStatement.executeUpdate();

            } catch (ParseException ex) {
                ex.printStackTrace();
                // Handle the date parsing exception as needed
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
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

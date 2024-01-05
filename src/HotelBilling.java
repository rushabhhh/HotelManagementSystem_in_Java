import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;




public class HotelBilling extends JFrame {
    Container c;
    public static JButton  confirmbtn,usericonbtn,bookhotelbtn,coinbtn;
    public static JLabel backlbl, usernamelbl, checkindate, checkoutdate, checkintime, totallbl, billlbl, roomtype, roomprice,blisscoininfolbl,terms_conditionlbl,billamtlbl;

    public static JTextField totaltf, billusernametf, roomtypetf, roompricetf,checkintimetf,blisscoinamt,checkindatetf,checkoutdatetf;



    public static int selectedvalue,t;


    public HotelBilling(String selectedRoomType) {
        c = getContentPane();
        c.setLayout(null);
        setTitle("Your Bill Invoice");
        setResizable(false);
        Image blisslogo = new ImageIcon("C:\\JavaMiniProject\\HotelMgm2\\images\\ICON.png").getImage();
        setIconImage(blisslogo);
        setSize(700, 500);
        setLocation(400, 150);

        billlbl = new JLabel("Bill Invoice");
        billlbl.setBounds(230, 20, 300, 50);
        billlbl.setFont(new Font("SERIF", Font.BOLD, 40));

        c.add(billlbl);


        usernamelbl = new JLabel("Username");
        usernamelbl.setBounds(76, 115, 100, 20);
        usernamelbl.setFont(new Font("", Font.PLAIN, 15));
        c.add(usernamelbl);


     String enteredusername = LoginPage2.usertextf.getText();
//        String enteredusername = "Rushabh";
        billusernametf = new JTextField();
        billusernametf.setText(enteredusername);
        billusernametf.setBounds(160, 115, 130, 25);
        billusernametf.setFont(new Font("", 1, 15));
        billusernametf.setEditable(false);
        billusernametf.setHorizontalAlignment(JTextField.CENTER);
        c.add(billusernametf);


        checkindate = new JLabel("Check in Date");
        checkindate.setBounds(70, 160, 100, 20);
        checkindate.setFont(new Font("", Font.PLAIN, 15));
        c.add(checkindate);

        checkoutdate = new JLabel("Check out Date");
        checkoutdate.setBounds(70, 215, 110, 20);
        checkoutdate.setFont(new Font("", Font.PLAIN, 15));
        c.add(checkoutdate);


        checkintime = new JLabel("Check in Time");
        checkintime.setBounds(335, 115, 100, 20);
        checkintime.setFont(new Font("", Font.PLAIN, 15));
        c.add(checkintime);

        checkintimetf = new JTextField("12:00AM");
        checkintimetf.setBounds(448, 114, 130, 25);
        checkintimetf.setFont(new Font("", 1, 15));
        checkintimetf.setEditable(false);
        checkintimetf.setHorizontalAlignment(JTextField.CENTER);
        c.add(checkintimetf);




        checkindatetf = new JTextField();
        checkindatetf.setBounds(180,160,130,25);
        Date selectedDate = HotelBooking.checkindate.getDate();

        SimpleDateFormat dateformat = new SimpleDateFormat("MMM dd, yyyy");
        String datestring = dateformat.format(selectedDate);
        checkindatetf.setFont(new Font("", 1, 15));
        checkindatetf.setText(datestring);
        checkindatetf.setEditable(false);
        checkindatetf.setHorizontalAlignment(JTextField.CENTER);
        c.add(checkindatetf);



        String checkoutdatestr = dateformat.format(HotelBooking.checkoutdate);

        checkoutdatetf = new JTextField();
        checkoutdatetf.setBounds(180,210,130,25);
        checkoutdatetf.setFont(new Font("", 1, 15));
        checkoutdatetf.setText(checkoutdatestr);
        checkoutdatetf.setEditable(false);
        checkoutdatetf.setHorizontalAlignment(JTextField.CENTER);
        c.add(checkoutdatetf);





        roomtype = new JLabel("Room Type");
        roomtype.setBounds(343, 160, 100, 20);
        roomtype.setFont(new Font("", Font.PLAIN, 15));
        c.add(roomtype);

        roomtypetf = new JTextField();
        roomtypetf.setText(selectedRoomType);
        roomtypetf.setBounds(450, 158, 80, 25);
        roomtypetf.setFont(new Font("", 1, 15));
        roomtypetf.setEditable(false);
        roomtypetf.setHorizontalAlignment(JTextField.CENTER);
        c.add(roomtypetf);


        roomprice = new JLabel("Room Price");
        roomprice.setBounds(343, 215, 100, 20);
        roomprice.setFont(new Font("", Font.PLAIN, 15));
        c.add(roomprice);


        roompricetf = new JTextField();
        roompricetf.setBounds(450, 210, 80, 25);
        roompricetf.setFont(new Font("", 1, 15));
        roompricetf.setEditable(false);
        roompricetf.setHorizontalAlignment(JTextField.CENTER);
        c.add(roompricetf);



        int roomPrice = 0;
        switch (selectedRoomType) {
            case "Normal":
                roomPrice = 1499;
                break;
            case "Ac":
                roomPrice = 1799;
                break;
            case "Deluxe":
                roomPrice = 2399;
                break;
            case "Dorm":
                roomPrice = 799;
                break;

        }
        roompricetf.setText(Integer.toString(roomPrice));





        totallbl = new JLabel("Total Bill");
        totallbl.setBounds(70, 320, 100, 20);
        totallbl.setFont(new Font("", Font.PLAIN, 15));
        totallbl.setHorizontalAlignment(JTextField.CENTER);
        c.add(totallbl);

        terms_conditionlbl = new JLabel("Terms and Condition");
        terms_conditionlbl.setBounds(60, 410, 100, 20);
        terms_conditionlbl.setFont(new Font("", Font.PLAIN, 10));
        terms_conditionlbl.setForeground(Color.blue);
        c.add(terms_conditionlbl);
        terms_conditionlbl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new TermsAndCondition();
                dispose();
            }
        });

       selectedvalue = (int) HotelBooking.no_ofdayscb.getSelectedItem();


        if ("Normal".equals(selectedRoomType)) {
            t = (1499 *selectedvalue) +180 ; // 180rs GST as per Govt
            totaltf = new JTextField();
            String total = Integer.toString(t);
            totaltf.setText(total);
            totaltf.setBounds(210, 320, 100, 25);
            totaltf.setFont(new Font("", 1, 15));
            totaltf.setHorizontalAlignment(JTextField.CENTER);
            totaltf.setEditable(false);
            add(totaltf);


        } else if ("Ac".equals(selectedRoomType)) {
            t = (1799 * selectedvalue)+ 216;       //216rs GST as per Govt
            totaltf = new JTextField();
            String total = Integer.toString(t);
            totaltf.setText(total);
            totaltf.setBounds(210, 320, 100, 25);
            totaltf.setFont(new Font("", 1, 15));
            totaltf.setHorizontalAlignment(JTextField.CENTER);
            totaltf.setEditable(false);
            add(totaltf);
        } else if ("Deluxe".equals(selectedRoomType)) {
            t = (2399 * selectedvalue)+ 288;       //288rs GST as per Govt
            totaltf = new JTextField();
            String total = Integer.toString(t);
            totaltf.setText(total);
            totaltf.setBounds(210, 320, 100, 25);
            totaltf.setFont(new Font("", 1, 15));
            totaltf.setHorizontalAlignment(JTextField.CENTER);
            totaltf.setEditable(false);
            add(totaltf);

        } else if ("Dorm".equals(selectedRoomType)) {
             t = (799 * selectedvalue)+ 96;       //96rs GST as per Govt
            totaltf = new JTextField();
            String total = Integer.toString(t);
            totaltf.setText(total);
            totaltf.setBounds(210, 320, 100, 25);
            totaltf.setFont(new Font("", 1, 15));
            totaltf.setHorizontalAlignment(JTextField.CENTER);
            totaltf.setEditable(false);
            add(totaltf);

        }


        backlbl = new JLabel();
        backlbl.setText("<--");
        backlbl.setFont(new Font("Arial", Font.PLAIN, 20));


        backlbl.setBounds(10, 10, 50, 30);
        add(backlbl);
//
        backlbl.setForeground(Color.black);
        backlbl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new HotelBooking();
                dispose();
            }
        });

        blisscoininfolbl = new JLabel("Bliss Coins ");
        blisscoininfolbl.setBounds(90,360,80,20);
        blisscoininfolbl.setFont(new Font("", Font.PLAIN, 15));
        c.add(blisscoininfolbl);

        blisscoinamt = new JTextField();
        blisscoinamt.setBounds(207,360,100,25);
        String blissbalance =  Integer.toString(OldCoinsAmountInDatabase.dbcoin);
        blisscoinamt.setText(blissbalance);
        blisscoinamt.setHorizontalAlignment(JTextField.CENTER);
        blisscoinamt.setFont(new Font("", 1, 15));
        blisscoinamt.setEditable(false);
        c.add( blisscoinamt);

        billamtlbl = new JLabel("Payment Details");
        billamtlbl.setBounds(235,260,300,40);
        billamtlbl.setFont(new Font("SERIF", Font.BOLD,30));
        c.add(billamtlbl);

        confirmbtn = new JButton("Confirm Room");

        confirmbtn.setBounds(400, 337, 150, 30);
        confirmbtn.setBackground(Color.RED);
        confirmbtn.setForeground(Color.white);
        c.add(confirmbtn);
        confirmbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int pin = Integer.parseInt(JOptionPane.showInputDialog("Enter pin"));
                PinInformation.main(new String[0]);
                if(pin != PinInformation.pin)
                {
                    JOptionPane.showMessageDialog(null, "Incorrect pin");

                }
                else if(OldCoinsAmountInDatabase.dbcoin < t)
                {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                }
                else {


                    RoomBookingUpdation.main(new String[0]);
                    CoinDeduction.main(new String[0]);
                    setVisible(false);
                    dispose();
                    new RoomAvailabilityUpdation(HotelBooking.selectedroom);
                    RoomAvailabilityChecking.main(new String[0]);
                    new UserDetail();


                }
            }
        });

        JPanel navpanel = new JPanel();
        navpanel.setLayout(null);
        navpanel.setBounds(0,90,60,300);
        navpanel.setBackground(Color.white);
        c.add(navpanel);



        ImageIcon usericon = new ImageIcon("C:\\JavaMiniProject\\HotelMgm2\\images\\usericon.gif");
//
        usericonbtn = new JButton(usericon);
        usericonbtn.setBounds(10, 15,40,55);
        usericonbtn.setBorderPainted(false);
        navpanel.add(usericonbtn);
        usericonbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Welcome();
                dispose();
            }
        });

        ImageIcon coinicon = new ImageIcon("C:\\JavaMiniProject\\HotelMgm2\\images\\coin.gif");
        coinbtn = new JButton(coinicon);
        coinbtn.setBounds(10, 80,40, 50);
        coinbtn.setBorderPainted(false);
        navpanel.add(coinbtn);
        coinbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OldCoinsAmountInDatabase.main(new String[0]);
                new CoinInformation();
                dispose();
            }
        });
        ImageIcon bookhotel= new ImageIcon("C:\\JavaMiniProject\\HotelMgm2\\images\\bookfinal.gif");
        bookhotelbtn = new JButton(bookhotel);
        bookhotelbtn.setBounds(10, 150,40, 50);
        bookhotelbtn.setBorderPainted(false);
        navpanel.add(bookhotelbtn);
        bookhotelbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                new HotelBooking();
                dispose();
            }
        });


        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



}

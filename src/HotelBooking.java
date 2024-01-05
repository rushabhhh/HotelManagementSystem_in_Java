


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;


public class HotelBooking extends JFrame implements ActionListener{


     Container c;
    public static JButton logoutbtn,backbtn,booknowbtn,coinbtn,usericonbtn,bookhotelbtn;

    public static JRadioButton normal_roombtn, ac_roombtn, deluxe_roombtn, dorm_roombtn;
    public static JLabel backlbl,booklbl,checkinlbl,checkoutlbl,motolbl,no_ofdays,mainbglbl,bookpanellbl;
    public static String selectedroom;

    public static JDateChooser checkindate;

    public static JComboBox no_ofdayscb;
    public static java.sql.Date sqlCheckoutDate;
  public static   ButtonGroup roomGroup;
    public static Date checkoutdate;





    HotelBooking()
    {
        setTitle("Book Your Hotel");
        setResizable(false);
        setSize(700, 500);
        setLocation(400, 150);
        Image blisslogo = new ImageIcon("C:\\JavaMiniProject\\HotelMgm2\\images\\ICON.png").getImage();
        setIconImage(blisslogo);


        c = getContentPane();
        c.setLayout(null);


        logoutbtn = new JButton("Logout");
        logoutbtn.setBounds(570,10,70,20);
        logoutbtn.setFont(new Font("Arial", Font.BOLD, 9));
        logoutbtn.setForeground(Color.white);
        logoutbtn.setBackground(Color.red);
        logoutbtn.setFocusPainted(false);
        c.add(logoutbtn);

        logoutbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginPage2();
                dispose();
            }
        });


        backlbl= new JLabel();
        backlbl.setText("<--");
        backlbl.setFont(new Font("Arial", Font.PLAIN,20));


        backlbl.setBounds(10,10,50,30);
        add(backlbl);
//
        backlbl.setForeground(Color.white);
        backlbl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new Welcome();
                dispose();

            }
        });

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(170,90,300,300);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        panel.setLayout(null);
        add(panel);




        booklbl = new JLabel("Rooms, we Offer!");
        booklbl.setBounds(80,10,200,30);
        booklbl.setFont(new Font("", Font.BOLD, 16));
        panel.add(booklbl);

        motolbl = new JLabel("Book.Relax.Enjoy!");
        motolbl.setBounds(210,30,300,50);
        motolbl.setFont(new Font("", Font.BOLD | Font.ITALIC , 25));
        motolbl.setForeground(Color.PINK);

        c.add(motolbl);

        roomGroup = new ButtonGroup();

        normal_roombtn = new JRadioButton("Normal");
        normal_roombtn.setBounds(40, 60, 60, 20);// Set position (x=20, y=20) and size (width=100, height=20)
        normal_roombtn.setFont(new Font("", Font.PLAIN,10));
        panel.add(normal_roombtn);
        roomGroup.add(normal_roombtn);

         normal_roombtn.addMouseListener(new MouseAdapter() {
             @Override
             public void mouseClicked(MouseEvent e) {
                selectedroom = "Normal";

                 JOptionPane.showMessageDialog(null,"Room Details:\nPrice: 1499/- per night\nCapacity: 2 persons\nFacilities : 2 Meals + Balcony + DJ Night + TV");
             }
         });




        ac_roombtn = new JRadioButton("AC");
        ac_roombtn.setBounds(180, 60, 60, 20);// Set position (x=20, y=20) and size (width=100, height=20)
        ac_roombtn.setFont(new Font("", Font.PLAIN,10));
        panel.add(ac_roombtn);
        roomGroup.add(ac_roombtn);
        ac_roombtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectedroom = "Ac";
                JOptionPane.showMessageDialog(null, "Room Details:\nPrice: 1799/- per night\nCapacity: 2 persons\nFacilities : 2 Meals + Balcony + DJ Night + AC + TV\n+ Common Swimming Pool and Indoor games");

            }
        });



        deluxe_roombtn = new JRadioButton("Deluxe");
        deluxe_roombtn.setBounds(40, 100, 60, 20);// Set position (x=20, y=20) and size (width=100, height=20)
        deluxe_roombtn.setFont(new Font("", Font.PLAIN,10));
        panel.add(deluxe_roombtn);
        roomGroup.add(deluxe_roombtn);

        deluxe_roombtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectedroom = "Deluxe";
                JOptionPane.showMessageDialog(null, "Room Details:\nPrice: 2399/- per night\nCapacity: 4 persons\nFacilities : 3 Meals + Sea View + DJ Night + Jacuzzi + AC +\n TV + Live Food Counters\n");

            }
        });


        dorm_roombtn = new JRadioButton("Dorm");
        dorm_roombtn.setBounds(180, 100, 60, 20);// Set position (x=20, y=20) and size (width=100, height=20)
        dorm_roombtn.setFont(new Font("", Font.PLAIN,10));
        panel.add(dorm_roombtn);
        roomGroup.add(dorm_roombtn);

        dorm_roombtn.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
              selectedroom = "Dorm";

                JOptionPane.showMessageDialog(null, "Room Details :\nPrice: 799/- per night\nCapacity: 1 person\nFacilities : 2 Meals + Common Bed + DJ Night + AC\n");
            }
       });


        checkinlbl = new JLabel("Check-in");
        checkinlbl.setBounds(30,160,150,80);
        panel.add(checkinlbl);


        checkindate = new JDateChooser();
        checkindate.setBounds(100, 190, 120, 20);
        panel.add(checkindate);



            no_ofdays = new JLabel("No.of days");
            no_ofdays.setBounds(30,145,200,20);
            panel.add(no_ofdays);


        no_ofdayscb = new JComboBox();
        no_ofdayscb.setBounds(100,145,100,20);
        no_ofdayscb.addItem(1);
        no_ofdayscb.addItem(2);
        no_ofdayscb.addItem(3);
        no_ofdayscb.addItem(4);
        panel.add(no_ofdayscb);


        JPanel navpanel = new JPanel();
        navpanel.setLayout(null);
        navpanel.setBounds(0,90,60,300);
        navpanel.setBackground(Color.white);
        c.add(navpanel);





        ImageIcon usericon = new ImageIcon("C:\\JavaMiniProject\\HotelMgm2\\images\\usericon.gif");
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





        booknowbtn = new JButton("Book Noww!");
            booknowbtn.setBounds(75,240,150,30);
            booknowbtn.setBackground(Color.RED);
            booknowbtn.setForeground(Color.white);
            panel.add(booknowbtn);
            booknowbtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Date checkinDate;
                    checkinDate = checkindate.getDate();

                    // Get the selected number of days from the JComboBox
                    int numberOfDays = (int) no_ofdayscb.getSelectedItem();
                    System.out.println(numberOfDays);

                    // Calculate the checkout date by adding the selected number of days to the check-in date
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(checkinDate);
                    calendar.add(Calendar.DAY_OF_MONTH, numberOfDays);
                    checkoutdate = calendar.getTime();


                    sqlCheckoutDate = new java.sql.Date(checkoutdate.getTime());
                    System.out.println(sqlCheckoutDate);



//                 RoomAvailabilityChecking rm =  new RoomAvailabilityChecking(sqlCheckoutDate);
                  HotelBilling hb = new HotelBilling(selectedroom);

                    setVisible(false);


                }
            });



        ImageIcon mainbgicon = new ImageIcon("C:\\JavaMiniProject\\HotelMgm2\\images\\hotelbooking.png");
        mainbglbl = new JLabel(mainbgicon);
        mainbglbl.setBounds(0, 0,getWidth(),getHeight());
        c.add(mainbglbl);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}


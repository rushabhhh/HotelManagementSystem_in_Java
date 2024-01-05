import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ExploreBliss extends JFrame {

    Container c;
    public static JLabel backlbl,explorelbl,servicelbl,amentieslbl,amentieslbl2,amentieslbl3,amentieslbl4;
    public static JButton logoutbtn,usericonbtn,coinbtn,bookhotelbtn;
    ExploreBliss()
    {
        setSize(700, 500);
        setLocation(400, 150);
        c = getContentPane();
        c.setLayout(null);


        logoutbtn = new JButton("Logout");
        logoutbtn.setBounds(580,10,70,20);
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
        c.add(backlbl);

        backlbl.setForeground(Color.black);
        backlbl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new Welcome();
                dispose();


            }
        });

        explorelbl = new JLabel("About Bliss!");
        explorelbl.setBounds(220, 28, 300, 50);
        explorelbl.setFont(new Font("SERIF", Font.BOLD, 40));
        explorelbl.setForeground(Color.darkGray);
        c.add(explorelbl);




        JTextArea aboutUsTextArea = new JTextArea(
                "Welcome to Bliss Hotel, where your comfort and satisfaction are our top priorities. " +
                        "We are dedicated to creating an unparalleled experience for our guests. " +
                        "Nestled in a world of elegance and tranquility, Bliss Hotel is your perfect " +
                        "retreat from the ordinary. " +
                        "Our commitment is to offer you exceptional hospitality, " +
                        "meticulously designed rooms, and a range of amenities that cater to " +
                        "your every need. " +
                        "Whether you're visiting for business or leisure, we invite you to experience " +
                        "the serenity and luxury that Bliss Hotel has to offer. " +
                        " We are known for our services, amazing and cozy rooms with all facilities to cheer your mood up! And how can we forget the delicious foooddd!!"

        );
        aboutUsTextArea.setFont(new Font("Arial", Font.PLAIN, 17));
        aboutUsTextArea.setLineWrap(true);
        aboutUsTextArea.setWrapStyleWord(true);
        aboutUsTextArea.setEditable(false);
        aboutUsTextArea.setBackground(new Color(240, 240, 240));
        aboutUsTextArea.setBounds(73, 100, 600, 200);
        c.add(aboutUsTextArea);


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



        JPanel infoicons = new JPanel();
        infoicons.setLayout(null);
        infoicons.setBounds(100,340,490,100);
        infoicons.setBackground(Color.gray);
        c.add(infoicons);


        ImageIcon service = new ImageIcon("C:\\JavaMiniProject\\HotelMgm2\\images\\a2.png");
        servicelbl = new JLabel(service);
        servicelbl.setBounds(30, 10,80,80);
        servicelbl.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
        infoicons.add(servicelbl);

        ImageIcon amenties = new ImageIcon("C:\\JavaMiniProject\\HotelMgm2\\images\\a6.png");
        amentieslbl = new JLabel(amenties);
        amentieslbl.setBounds(150, 10,80,80);
        amentieslbl.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
        infoicons.add(amentieslbl);

        ImageIcon amenties2 = new ImageIcon("C:\\JavaMiniProject\\HotelMgm2\\images\\a8.png");
        amentieslbl2 = new JLabel(amenties2);
        amentieslbl2.setBounds(270, 10,80,80);
        amentieslbl2.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
        infoicons.add(amentieslbl2);

        ImageIcon amenties3 = new ImageIcon("C:\\JavaMiniProject\\HotelMgm2\\images\\a10.png");
        amentieslbl3 = new JLabel(amenties3);
        amentieslbl3.setBounds(390, 10,80,80);
        amentieslbl3.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
        infoicons.add(amentieslbl3);


        amentieslbl4 = new JLabel("24/7 SERVICE            COZY ROOMS           BEST SERVICES         TASTY FOOD     ");
        amentieslbl4.setBounds(120,310,500,30);
        c.add(amentieslbl4);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }




}

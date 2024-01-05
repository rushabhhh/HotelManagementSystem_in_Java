
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;




public class CoinInformation extends JFrame implements ActionListener
{
    public static JLabel backlbl,usernamelbl,balancelbl,balanceamtlbl,addbalancelbl,pinlbl,blisslbl,coinslbl,contactlbl,changepinlbl;
    public static JButton logoutbtn,usericonbtn,coinbtn,bookhotelbtn,addmoneybtn;
    public static JTextField addbalanceamttf;
    public static JPasswordField pintf;

    public static String currentcoin;
    Container c;
    CoinInformation()
    {
        super("Your Coins Details");
        setResizable(false);
        setSize(700, 500);
        setLocation(400, 150);
        setBackground(Color.white);
        Image blisslogo = new ImageIcon("C:\\JavaMiniProject\\HotelMgm2\\images\\ICON.png").getImage();
        setIconImage(blisslogo);

        c = getContentPane();
        c.setLayout(null);

        backlbl= new JLabel();
        backlbl.setText("<--");
        backlbl.setFont(new Font("Arial", Font.PLAIN,20));
        backlbl.setForeground(Color.white);


        backlbl.setBounds(10,10,50,30);
        add(backlbl);
//

        backlbl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new HotelBooking();
                dispose();
            }
        });
        contactlbl = new JLabel("Contact: info@blisshotel.com | Phone: +91920019302");
        contactlbl.setBounds(190, 420, 400, 20);
        contactlbl.setFont(new Font("Arial", Font.PLAIN, 12));
        contactlbl.setForeground(Color.gray);
        c.add(contactlbl);


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
                OldCoinsAmountInDatabase.main(new String[0]);
                new HotelBooking();
                dispose();
            }
        });


        JPanel coininfopanel = new JPanel();
        coininfopanel.setBounds(95,90,550,250);
//        coininfopanel.setBackground(Color.decode("#797d7c"));
        coininfopanel.setBackground(Color.gray);
        coininfopanel.setLayout(null);
        c.add(coininfopanel);

   String username = LoginPage2.usertextf.getText();
//        String username = "Rushabh";

        usernamelbl = new JLabel();
        usernamelbl.setText( "Hello, " + username );
        usernamelbl.setBounds(15,5,190,40);
        usernamelbl.setForeground(Color.white);
        usernamelbl.setFont(new Font("",Font.BOLD,19));
        coininfopanel.add(usernamelbl);


        balancelbl = new JLabel("Your Current Balance : ");
        balancelbl.setBounds(20,60,200,40);
        balancelbl.setForeground(Color.white);
        balancelbl.setFont(new Font("",2,15));
        coininfopanel.add(balancelbl);

        balanceamtlbl = new JLabel();
        currentcoin = Integer.toString(OldCoinsAmountInDatabase.dbcoin);
        balanceamtlbl.setText(currentcoin);
        balanceamtlbl.setBounds(190,60,160,40);
        balanceamtlbl.setForeground(Color.white);
        balanceamtlbl.setFont(new Font("",2,15));
        coininfopanel.add(balanceamtlbl);


        addbalancelbl = new JLabel("Enter amount to Add : ");
        addbalancelbl.setBounds(20,120,190,30);
        addbalancelbl.setForeground(Color.white);
        addbalancelbl.setFont(new Font("",2,15));
        coininfopanel.add(addbalancelbl);


        addbalanceamttf = new JTextField();
        addbalanceamttf.setBounds(180,126,120,20);
        coininfopanel.add(addbalanceamttf);

        addmoneybtn = new JButton("Add Coins");
        addmoneybtn.setBounds(400,200,100,30);
        addmoneybtn.setForeground(Color.white);
        addmoneybtn.setBackground(Color.black);
        coininfopanel.add(addmoneybtn);
        addmoneybtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                PinInformation.main(new String[0]);
                int pin = Integer.parseInt(JOptionPane.showInputDialog("Confirm Pin"));
                PinInformation.main(new String[0]);
                if(pin != PinInformation.pin)
                {
                    JOptionPane.showMessageDialog(null, "Incorrect pin");

                }
                else {
                    JOptionPane.showMessageDialog(null, "Coins added");

                    CoinUpdation.main(new String[0]);
                }

                

            }
        });


        pinlbl = new JLabel("Enter pin : ");
        pinlbl.setBounds(20,165,80,30);
        pinlbl.setFont(new Font("",2,15));
        pinlbl.setForeground(Color.white);
        coininfopanel.add(pinlbl);

        pintf = new JPasswordField();
        pintf.setBounds(100,175,120,20);
        coininfopanel.add(pintf);

        changepinlbl = new JLabel("Change pin?");
        changepinlbl.setBounds(168,192,100,20);
        changepinlbl.setForeground(Color.black);
        changepinlbl.setFont(new Font("",2,11));
        changepinlbl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new ChangePin();
                dispose();
            }
        });
        coininfopanel.add(changepinlbl);


        blisslbl = new JLabel("BLISS");
        blisslbl.setBounds(372,35,250,50);
        blisslbl.setFont(new Font("Helvetica", Font.BOLD,43));
        blisslbl.setForeground(Color.black);
        coininfopanel.add(blisslbl);

        coinslbl = new JLabel("C   O   I   N   S");
        coinslbl.setBounds(389,81,120,30);
        coinslbl.setFont(new Font("Calibri",Font.HANGING_BASELINE |Font.BOLD,18));
        coinslbl.setForeground(Color.decode("#f76565"));
        coininfopanel.add(coinslbl);

        JLabel infolbl = new JLabel("Securely deposit your Money!");
        infolbl.setBounds(180,40,400,30);
        infolbl.setForeground(Color.gray);
        infolbl.setFont(new Font("Georgia",Font.BOLD | Font.ITALIC,20));
        c.add(infolbl);


        ImageIcon moneyimg = new ImageIcon("C:\\JavaMiniProject\\HotelMgm2\\images\\img43.jpg");
        JLabel moneylbl = new JLabel(moneyimg);
        moneylbl.setBounds(0,0,getWidth(),getHeight());
        c.add(moneylbl);





        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }



}


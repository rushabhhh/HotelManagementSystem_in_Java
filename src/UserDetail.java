import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class UserDetail extends JFrame {
    public static JTextField fullNameField, phoneField, aadharField;
    public static JTextArea addressArea;
    public static JLabel headerlbl,backlbl;
    public static JButton confirmbtn,logoutbtn;
    public static JTextField emailtf;

    public UserDetail() {
        setResizable(false);
        setSize(700, 500);
        setLocation(330, 150);
        setTitle("Your Info");
        Image blisslogo = new ImageIcon("C:\\JavaMiniProject\\HotelMgm2\\images\\ICON.png").getImage();
        setIconImage(blisslogo);

        Container c = getContentPane();
        c.setLayout(null);

        backlbl= new JLabel();
        backlbl.setText("<--");
        backlbl.setFont(new Font("Arial", Font.PLAIN,20));


        backlbl.setBounds(10,10,50,30);
        add(backlbl);
//
        backlbl.setForeground(Color.black);
        backlbl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new HotelBilling("ac");
                dispose();
            }
        });


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


        headerlbl = new JLabel("Enter your details");
        headerlbl.setFont(new Font("Arial", Font.BOLD, 26));
        headerlbl.setBounds(210, 10, 300, 40);
        c.add(headerlbl);


        JLabel fullNameLabel = new JLabel("Full Name:");
        fullNameLabel.setBounds(40, 80, 150, 30);
        c.add(fullNameLabel);

        fullNameField = new JTextField(20);
        fullNameField.setBounds(200, 80, 200, 30);
        c.add(fullNameField);

        JLabel addressLabel = new JLabel("Email :");
        addressLabel.setBounds(40, 135, 150, 30);
        c.add(addressLabel);

        emailtf = new JTextField();
        emailtf.setBounds(200, 135, 200, 30);
        c.add( emailtf);

        JLabel phoneLabel = new JLabel("Phone Number:");
        phoneLabel.setBounds(40, 190, 150, 30);
        c.add(phoneLabel);

        phoneField = new JTextField(20);
        phoneField.setBounds(200, 190, 200, 30);
        c.add(phoneField);

        JLabel aadharLabel = new JLabel("Aadhar Card Number:");
        aadharLabel.setBounds(40, 240, 150, 30);
        c.add(aadharLabel);

        aadharField = new JTextField(20);
        aadharField.setBounds(200, 240, 200, 30);
        c.add(aadharField);

        confirmbtn = new JButton("Confirm");
        confirmbtn.setBackground(Color.black);
        confirmbtn.setForeground(Color.white);
        confirmbtn.setBounds(250,420,100,23);
        c.add(confirmbtn);
        JLabel feedbacklbl = new JLabel("Feedback : ");
        feedbacklbl.setBounds(40,320,100,20);
        c.add(feedbacklbl);
        confirmbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SendEmail();
                new ThankyouPage();
                setVisible(false);
                dispose();
            }
        });

        JTextArea feedback = new JTextArea(5,20);
        feedback.setBounds(200,290,300,100);
        c.add(feedback);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThankyouPage extends JFrame {
    Container c;
    JLabel thankyoulbl,contactus, contactLbl,orlbl;
    JButton contactButton, canclebtn;
    JTextArea thankyouta;

    ThankyouPage() {
        setResizable(false);
        setSize(700, 500);
        setLocation(330, 150);
        setTitle("Your Info");

        c = getContentPane();
        c.setLayout(null);

        // Add an icon above the "Thank You" text
        ImageIcon icon = new ImageIcon("C:\\JavaMiniProject\\HotelMgm2\\images\\trial5.png");
        JLabel iconLabel = new JLabel(icon);
        iconLabel.setBounds(300, 20, 60,60); // Adjust the size and position as needed
        c.add(iconLabel);

        ImageIcon instagramIcon = new ImageIcon("C:\\JavaMiniProject\\HotelMgm2\\images\\c2.png");
        JLabel instagramLabel = new JLabel(instagramIcon);
        instagramLabel.setBounds(250, 360, 100, 50);
        c.add(instagramLabel);

        orlbl = new JLabel("----OR----");
        orlbl.setBounds(262,408,100,20);
        orlbl.setFont(new Font("",1|2,16));
        orlbl.setForeground(Color.gray);
        c.add(orlbl);

        contactLbl = new JLabel("Contact: info@blisshotel.com | Phone: +919200000000");
        contactLbl.setBounds(170, 432, 400, 20);
        contactLbl.setFont(new Font("Arial", 1, 12));
        contactLbl.setForeground(Color.black);

        c.add(contactLbl);



        thankyoulbl = new JLabel("Thank You!");
        thankyoulbl.setBounds(210, 100, 300, 50);
        thankyoulbl.setFont(new Font("SERIF", Font.BOLD, 45));
        thankyoulbl.setForeground(Color.darkGray);
        c.add(thankyoulbl);

        // Add a JLabel with a big thanking message
        thankyouta  = new JTextArea(
                        "       We appreciate your business and trust in our services. Your support allows us "+"\n           to continue providing the best hospitality experience to all our guests." +
                        "If you " +"\n                have any suggestions, or concerns, please feel free to contact us. "+"\n                          We look forward to serving you again in the future!\n\n"

        );
        thankyouta.setFont(new Font("Arial", Font.PLAIN, 14));
        thankyouta.setLineWrap(true);
        thankyouta.setWrapStyleWord(true);
        thankyouta.setEditable(false);
        thankyouta.setFocusable(false);
        thankyouta.setForeground(Color.BLACK);
        thankyouta.setBackground(new Color(240, 240, 240));
        thankyouta.setFont(new Font("Sans Serif",2,14));
        thankyouta.setBounds(70, 160, 600, 100); // Adjust the vertical position
        c.add(thankyouta);







        canclebtn = new JButton("Cancel Booking?");
        canclebtn.setBounds(250, 270, 150, 30);
        canclebtn.setForeground(Color.white);
        canclebtn.setBackground(Color.black);
        canclebtn.setFocusPainted(false);
        c.add(canclebtn);

        canclebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement your code to delete bookings here
            }
        });

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


}

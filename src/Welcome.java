import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Welcome extends JFrame implements ActionListener {
    Container c;
    JButton  reservationsbtn, exploreBtn,logoutbtn;
    JLabel hotelnamelbl, quotelbl, contactLbl, backlbl,imglbl;

    JLabel imageLabel;
    int currentImageIndex = 0;
    JTextArea descriptionTextArea;
    private String[] imagePaths = {
            "C:\\JavaMiniProject\\HotelMgm2\\images\\welcome.jpg",
            "C:\\JavaMiniProject\\HotelMgm2\\images\\img2.jpg",
            "C:\\JavaMiniProject\\HotelMgm2\\images\\img11.jpg",
            "C:\\JavaMiniProject\\HotelMgm2\\images\\img15.jpg",
            "C:\\JavaMiniProject\\HotelMgm2\\images\\img18.jpg",
            "C:\\JavaMiniProject\\HotelMgm2\\images\\img5.jpg",
            "C:\\JavaMiniProject\\HotelMgm2\\images\\img19.jpg"
    };

    Welcome() {
        super("Welcome to Bliss.");
        setSize(800, 600);
        setLocation(330,110);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Image blisslogo = new ImageIcon("C:\\JavaMiniProject\\HotelMgm2\\images\\ICON.png").getImage();
        setIconImage(blisslogo);

        c = getContentPane();
        c.setLayout(null);


        logoutbtn = new JButton("Logout");
        logoutbtn.setBounds(620,10,70,20);
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
//
        backlbl.setForeground(Color.black);
        backlbl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new Welcome();
                dispose();

            }
        });
        hotelnamelbl = new JLabel("B L I S S ");
        hotelnamelbl.setBounds(70, 50, 300, 70);
        hotelnamelbl.setFont(new Font("Georgia", Font.BOLD, 50));
        hotelnamelbl.setForeground(Color.black);
        c.add(hotelnamelbl);


        quotelbl = new JLabel("~ Your new HOME ");
        quotelbl.setBounds(185, 100, 300, 30);
        quotelbl.setFont(new Font("Arial", Font.ITALIC, 15));
        quotelbl.setForeground(Color.decode("#333333"));
        c.add(quotelbl);

        reservationsbtn = new JButton("Make a Reservation");
        reservationsbtn.setBounds(330, 460, 200, 30);
        reservationsbtn.setBackground(Color.WHITE); // Blue color
        reservationsbtn.setForeground(Color.black);
        reservationsbtn.setFont(new Font("Arial", Font.BOLD, 16));
        reservationsbtn.setFocusPainted(false);
        c.add(reservationsbtn);
        reservationsbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HotelBooking();
                dispose();
                setVisible(false);
            }
        });


        exploreBtn = new JButton("Explore Bliss");
        exploreBtn.setBounds(550, 460, 200, 30);
        exploreBtn.setBackground(Color.DARK_GRAY); // Green color
        exploreBtn.setForeground(Color.WHITE);
        exploreBtn.setFont(new Font("Arial", Font.BOLD, 16));
        c.add(exploreBtn);
        exploreBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ExploreBliss();
                dispose();
            }
        });


        descriptionTextArea = new JTextArea();
        descriptionTextArea.setBounds(20, 150, 400, 370);
        descriptionTextArea.setFont(new Font("Arial",Font.BOLD, 15));
        descriptionTextArea.setText("Bliss Hotel is a luxurious destination for your \n" + "perfect getaway. " +
                "With stunning views and \n" + "exceptional services, we ensure your stay " +
                "is \n" +"nothing short of perfection.\n\n" +
                "Our hotel features:\n" +
                "- Spacious & comfortable rooms with modern \n" + " amenities\n" +
                "- Breathtaking ocean views from every room\n" +
                "- Fine dining restaurants serving a variety of \n" + "cuisines\n" +
                "- Relaxing spa and wellness center\n" +
                "- Outdoor pool and beach access\n" +
                "- Professional and friendly staff dedicated to \n" + "your comfort \n" +
                "- Whether you're on a business \n" + " trip or a leisure"+ " vacation, Bliss Hotel is your \n" + " home away" + "from home.");
        descriptionTextArea.setWrapStyleWord(true);
        descriptionTextArea.setLineWrap(true);
        descriptionTextArea.setOpaque(false);
        descriptionTextArea.setEditable(false);
        descriptionTextArea.setForeground(Color.decode("#E0DCDE"));
        c.add(descriptionTextArea);

        // Contact information label
        contactLbl = new JLabel("Contact: info@blisshotel.com | Phone: +91920019302");
        contactLbl.setBounds(250, 520, 400, 20);
        contactLbl.setFont(new Font("Arial", Font.PLAIN, 12));
        contactLbl.setForeground(Color.gray);
        c.add(contactLbl);


        imageLabel = new JLabel();
        imageLabel.setBounds(350, 55, 430, 390);
        c.add(imageLabel);


        Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentImageIndex < imagePaths.length - 1) {
                    currentImageIndex++;
                } else {
                    currentImageIndex = 0;
                }
                updateImage();
            }
        });
        timer.start();
        updateImage();
        ImageIcon img = new ImageIcon("C:\\JavaMiniProject\\HotelMgm2\\images\\img37.jpg");
        imglbl = new JLabel(img);
        imglbl.setBounds(0, 0,getWidth(), getHeight());
        c.add(imglbl);

        setVisible(true);
    }

    private void updateImage() {
        ImageIcon imageIcon = new ImageIcon(imagePaths[currentImageIndex]);
        imageLabel.setIcon(imageIcon);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }


}

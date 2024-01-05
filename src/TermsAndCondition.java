import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TermsAndCondition  extends JFrame{
    Container c;
    JButton nextbtn,logoutbtn,bookhotelbtn,usericonbtn,coinbtn;
    JLabel backlbl,backgroundlbl,tandc;
    JTextArea termsandcondta;

    TermsAndCondition()
    {
        setTitle("Terms and Condition");

        setResizable(false);
        setSize(700, 500);
        setLocation(330, 150);

        c = getContentPane();
        c.setLayout(null);
        tandc = new JLabel("TERMS AND CONDITION : ");
        tandc.setBounds(190,10,270,20);

        tandc.setFont(new Font("SERIF", Font.BOLD,20 ));
        c.add(tandc);

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
                new HotelBilling(HotelBooking.selectedroom);
                dispose();
            }
        });


        termsandcondta = new JTextArea();
        termsandcondta.setEditable(false);
        termsandcondta.setLineWrap(true);
        termsandcondta.setWrapStyleWord(true);



        String termsAndConditionsText = "\n\n\n"+"  Check-In and Check-Out:\n" +
                "  Check-in: 12:00 PM\n" +
                "  Check-out: 11:00 AM\n" +
                "  Early check-in and late check-out available (subject to availability, charges may apply)\n" +
                "\n" +
                "  Cancellation Policy:\n" +
                "  24-hour notice required for cancellation to avoid charges\n" +
                "  Late cancellations and no-shows will be charged one night's stay\n" +
                "\n" +
                "  Damage and Loss:\n" +
                "  Guests responsible for property damage or loss\n" +
                "\n" +
                "  Privacy Policy:\n" +
                "  Personal information used solely for hotel operations (not shared with third parties)\n" +
                "\n" +
                "  Code of Conduct:\n" +
                "  Respect other guests; disruptive behavior may result in eviction without refund\n" +
                "\n" +
                "  Liability:\n" +
                "  Hotel not responsible for personal property loss or damage\n" +
                "\n" +
                "  By staying at Hotel Bliss, you agree to these terms and conditions. We wish you a pleasant stay. For assistance, contact our " +
                " \n  friendly staff. Thank you for choosing Hotel Bliss!";

        termsandcondta.setText(termsAndConditionsText);
        c.add(termsandcondta);
        termsandcondta.setBounds(0,0,700,500);


        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChangePin extends JFrame {

    Container c;
  public static JLabel usernamelbl,backlbl,newpin,re_enter_pin;
  public static JTextField checkusertextf;
    public static  JPasswordField newpintf,re_enter_pintf;
    public static JButton confirmpinbtn;
    ChangePin()
    {
        super("Change Pin");
        setResizable(false);
        setSize(700, 500);
        setLocation(330, 150);

        Image blisslogo = new ImageIcon("C:\\JavaMiniProject\\HotelMgm2\\images\\ICON.png").getImage();
        setIconImage(blisslogo);
        c = getContentPane();
        c.setLayout(null);


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
                new CoinInformation();
            }
        });


        usernamelbl = new JLabel("Username");
        usernamelbl.setBounds(140,103,100,40);
        usernamelbl.setForeground(Color.BLACK);
        usernamelbl.setFont(new Font("", Font.PLAIN, 15));
        c.add(usernamelbl);

        checkusertextf = new JTextField();
        checkusertextf.setBounds(260,110,170,23);
        c.add(checkusertextf);


        newpin = new JLabel("New Pin");
        newpin.setBounds(130,150,150,40);
        newpin.setForeground(Color.gray);
        newpin.setForeground(Color.BLACK);
        newpin.setFont(new Font("", Font.PLAIN, 15));
        c.add(newpin);

        newpintf = new JPasswordField();
//        String defaultUserText = "";
//        newpasswordpassf.setText(defaultUserText);
        newpintf.setBounds(260,160,170,23);
        c.add(newpintf);




        re_enter_pin = new JLabel(" Re-Enter Pin");
        re_enter_pin.setBounds(100,200,150,40);
        re_enter_pin.setForeground(Color.gray);
        re_enter_pin.setForeground(Color.BLACK);
        re_enter_pin.setFont(new Font("", Font.PLAIN, 15));
        c.add(re_enter_pin);

        re_enter_pintf = new JPasswordField();
//        String defaultPassText = "";
//        re_enter_passwordpassf.setText(defaultPassText);
        re_enter_pintf.setBounds(260,210,170,23);
        c.add(re_enter_pintf);

        confirmpinbtn = new JButton("Confirm");
        confirmpinbtn.setBackground(Color.black);
        confirmpinbtn.setForeground(Color.WHITE);
        confirmpinbtn.setBounds(230,280, 120,40);
        c.add(confirmpinbtn);
        confirmpinbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String checknewpin = newpintf.getText();
                String checkre_enteredpin = re_enter_pintf.getText();

                if (checknewpin.isEmpty() || checkre_enteredpin.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Pin fields cannot be empty");
                } else if (!checknewpin.equals(checkre_enteredpin)) {
                    JOptionPane.showMessageDialog(null, "Pins do not match");
                } else {

                    UpdatePin.main(new String[0]);

                    new CoinInformation();
                    dispose();
                }
            }
        });
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


}

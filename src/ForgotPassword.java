import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ForgotPassword extends JFrame {
    Container c;

    public static JLabel newpassword, re_enter_password, checkusernamelbl, forgotpasswordlbl,backlbl;
    public static JPasswordField newpasswordpassf, re_enter_passwordpassf;
    public static JButton confirmpasswordbtn;
    public static JTextField checkusertextf;

    ForgotPassword()
    {
        super("Forgot Password");
        setResizable(false);
        setSize(700, 500);
        setLocation(330, 150);
        setVisible(true);
        c = getContentPane();
        c.setLayout(null);
        Image blisslogo = new ImageIcon("C:\\JavaMiniProject\\HotelMgm2\\images\\ICON.png").getImage();
        setIconImage(blisslogo);


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
                new LoginPage2();
            }
        });

        forgotpasswordlbl = new JLabel("Change Password");
       forgotpasswordlbl.setBounds(200,10,300,100);
       forgotpasswordlbl.setFont(new Font("SERIF", Font.BOLD,30 ));

        c.add(forgotpasswordlbl);

        checkusernamelbl = new JLabel("Username");
        checkusernamelbl.setBounds(140,103,100,40);
        checkusernamelbl.setForeground(Color.gray);
        checkusernamelbl.setFont(new Font("", Font.PLAIN, 15));
        c.add(checkusernamelbl);

        checkusertextf = new JTextField();
        checkusertextf.setBounds(260,110,170,23);
        c.add(checkusertextf);

        newpassword = new JLabel("New Password");
        newpassword.setBounds(130,150,150,40);
        newpassword.setForeground(Color.gray);
        newpassword.setFont(new Font("", Font.PLAIN, 15));
        c.add(newpassword);

        newpasswordpassf = new JPasswordField();
//        String defaultUserText = "";
//        newpasswordpassf.setText(defaultUserText);
        newpasswordpassf.setBounds(260,160,170,23);
        c.add(newpasswordpassf);




        re_enter_password = new JLabel(" Re-Enter Password");
        re_enter_password.setBounds(100,200,150,40);
        re_enter_password.setForeground(Color.gray);
        re_enter_password.setFont(new Font("", Font.PLAIN, 15));
        c.add(re_enter_password);

        re_enter_passwordpassf = new JPasswordField();
//        String defaultPassText = "";
//        re_enter_passwordpassf.setText(defaultPassText);
        re_enter_passwordpassf.setBounds(260,210,170,23);
        c.add(re_enter_passwordpassf);


        confirmpasswordbtn = new JButton("Confirm");
        confirmpasswordbtn.setBackground(Color.black);
        confirmpasswordbtn.setForeground(Color.WHITE);
        confirmpasswordbtn.setBounds(230,280, 120,40);
        c.add(confirmpasswordbtn);
        confirmpasswordbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String checknewpassword = newpasswordpassf.getText();
                String checkre_enteredpassword = re_enter_passwordpassf.getText();

                if (checknewpassword.isEmpty() || checkre_enteredpassword.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Password fields cannot be empty");
                } else if (! checknewpassword.equals(checkre_enteredpassword)) {
                    JOptionPane.showMessageDialog(null, "Passwords do not match");
                } else {

                    UpdateForgetPassword.main(new String[0]);

                    new LoginPage2();
                    dispose();
                }
            }
        });

    }
}

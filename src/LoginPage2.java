import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class LoginPage2 extends JFrame implements ActionListener {
    Container c;
    public static JLabel usernamelbl, passwordlbl, loginlbl, imglbl, forgetpasswordtextf;
    public static JTextField usertextf;
    public static JPasswordField passtextf;
    public static JButton btn;

    LoginPage2() {
        setTitle("Bliss. Your new HOME");
        setResizable(false);
        setSize(800, 600); // Increase the frame size
        setLocation(330, 110);
        Image blisslogo = new ImageIcon("C:\\Rushabh\\JavaMiniProject\\HotelManagementSystem\\images\\ICON.png").getImage();
        setIconImage(blisslogo);

        c = getContentPane();
        c.setLayout(null);

        loginlbl = new JLabel("Welcome Back!");
        loginlbl.setBounds(220, 100, 300, 50);
        loginlbl.setFont(new Font("SERIF", Font.BOLD, 40));
        loginlbl.setForeground(Color.darkGray);
        c.add(loginlbl);

        usernamelbl = new JLabel("Username");
        usernamelbl.setBounds(170, 200, 110, 40);
        usernamelbl.setForeground(Color.pink);
        usernamelbl.setFont(new Font("", Font.BOLD, 15));
        c.add(usernamelbl);

        passwordlbl = new JLabel("Password");
        passwordlbl.setBounds(170, 250, 110, 40);
        passwordlbl.setForeground(Color.pink);
        passwordlbl.setFont(new Font("", Font.BOLD, 15));
        c.add(passwordlbl);

        usertextf = new JTextField();
        usertextf.setBounds(280, 210, 170, 23);
        usertextf.setBorder(new LineBorder(Color.white));
        c.add(usertextf);


        passtextf = new JPasswordField();
        passtextf.setBounds(280, 260, 170, 23);
        passtextf.setBorder(new LineBorder(Color.white));
        c.add(passtextf);

        forgetpasswordtextf = new JLabel();
        forgetpasswordtextf.setText("Forgot Password?");
        forgetpasswordtextf.setBounds(400, 280, 100, 20);
        forgetpasswordtextf.setFont(new Font("", Font.ITALIC | Font.BOLD, 10));
        forgetpasswordtextf.setForeground(Color.black);
        forgetpasswordtextf.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new ForgotPassword();
            }
        });
        c.add(forgetpasswordtextf);

        btn = new JButton(BorderLayout.CENTER);
        btn.setText("Login");
        btn.setBackground(Color.darkGray);
        btn.setForeground(Color.white);
        btn.setBounds(320, 330, 120, 40);
        c.add(btn);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String u = usertextf.getText();
                String p = passtextf.getText();
                if (u.isEmpty() || p.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Username and Password fields cannot be empty");
                } else {
                    UserChecking.main(new String[0]);
                    OldCoinsAmountInDatabase.main(new String[0]);
dispose();
                }
            }
        });

        ImageIcon backgroundimg = new ImageIcon("C:\\JavaMiniProject\\HotelMgm2\\images\\loginbg.jpg");
        imglbl = new JLabel(backgroundimg);
        imglbl.setBounds(0, 0, getWidth(), getHeight());
        c.add(imglbl);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
    }
}

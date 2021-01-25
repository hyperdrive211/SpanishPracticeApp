import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created By Jonathon on 25/01/2021
 * Update Comments About Program Here
 **/
public class Login  extends JFrame implements ActionListener {
    User user;
    JLabel passwordLabel;
    JTextField passWordTextfield;
    JButton ckBtn, cancelBtn;
    IntroPanel ip;

    Login(User user, IntroPanel ip){
        this.user = user;
        this.ip = ip;

        passwordLabel = new JLabel("Enter Password");
        passwordLabel.setBounds(20, 20, 50, 50);

        this.add(passwordLabel);

        this.setLayout(null);
        this.setSize(300, 300);
        this.setTitle("Login");
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

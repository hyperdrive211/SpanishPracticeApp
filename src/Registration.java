import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created By Jonathon on 25/01/2021
 * Update Comments About Program Here
 **/
public class Registration extends JFrame implements ActionListener {
    UserMap uMap;
    IntroPanel ip; 
    User user;
    JLabel usernameLabel, confirmUsernameLabel;
    JLabel passwordLabel, confirmPasswordLabel;
    JTextField usernameText, confirmUsernameText;
    JTextField passwordText, confirmPasswordText;


    JButton saveBtn, cancelBtn;


    Registration(UserMap uMap, User user, IntroPanel ip){
        this.uMap = uMap;
        this.user = user;
        this.setLayout(null);
        this.setSize(550, 550);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

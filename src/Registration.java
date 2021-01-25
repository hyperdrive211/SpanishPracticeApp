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
    JLabel usernameLabel, confirmUsernameLabel, name,  passwordLabel, confirmPasswordLabel;
    JTextField usernameText, confirmUsernameText, passwordText, confirmPasswordText;
    JButton saveBtn, cancelBtn;

    Registration(UserMap uMap, User user, IntroPanel ip){
        //bring in the Intro Panel se we can set components within it with information provided in this
        this.ip = ip;
        this.uMap = uMap;
        this.user = user;

        //Labels
        usernameLabel = new JLabel("Username");

        confirmUsernameLabel = new JLabel("Please confirm Username");

        passwordLabel = new JLabel("Password");

        confirmPasswordLabel = new JLabel("Please confirm password");


        //Textfields


        usernameText = new JTextField(user.getUsername());

        confirmUsernameText = new JTextField();

        passwordText = new JTextField();

        confirmPasswordText = new JTextField();

        //Buttons
        saveBtn = new JButton("Save");
        cancelBtn = new JButton("Cancel");

        
        this.setTitle("Registration");
        this.setLayout(null);
        this.setSize(550, 550);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created By Jonathon on 25/01/2021
 * Update Comments About Program Here
 **/
public class Registration extends JFrame implements ActionListener {
    String font = "Sans-serif";
    UserMap uMap;
    IntroPanel ip;
    User user;
    JLabel registrationTitle, usernameLabel, confirmUsernameLabel, name,  passwordLabel, confirmPasswordLabel;
    JTextField usernameText, confirmUsernameText, passwordText, confirmPasswordText;
    JButton saveBtn, cancelBtn;

    Registration(UserMap uMap, User user, IntroPanel ip){
        //bring in the Intro Panel se we can set components within it with information provided in this
        this.ip = ip;
        this.uMap = uMap;
        this.user = user;

        this.getContentPane().setBackground(new Color(110,192,248));

        //Labels

        registrationTitle = new JLabel("Registration");
        registrationTitle.setForeground(Color.white);
        registrationTitle.setFont(new Font(font, Font.BOLD, 35));


        usernameLabel = new JLabel("Username:");
        usernameLabel.setForeground(Color.white);
        usernameLabel.setFont(new Font(font, Font.BOLD, 25));

        confirmUsernameLabel = new JLabel("Please confirm Username:");
        confirmUsernameLabel.setForeground(Color.white);
        confirmUsernameLabel.setFont(new Font(font, Font.BOLD, 25));

        passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.white);
        passwordLabel.setFont(new Font(font, Font.BOLD, 25));

        confirmPasswordLabel = new JLabel("Please confirm password:");
        confirmPasswordLabel.setForeground(Color.white);
        confirmPasswordLabel.setFont(new Font(font, Font.BOLD, 25));

        //Textfields


        usernameText = new JTextField(user.getUsername());

        confirmUsernameText = new JTextField();

        passwordText = new JTextField();

        confirmPasswordText = new JTextField();

        //Buttons
        saveBtn = new JButton("Save");
        saveBtn.setForeground(Color.white);
        saveBtn.setBackground(Color.green);
        saveBtn.addActionListener(this);

        cancelBtn = new JButton("Cancel");
        cancelBtn.setForeground(Color.white);
        cancelBtn.setBackground(Color.green);
        cancelBtn.addActionListener(this);


        this.setTitle("Registration");
        this.setLayout(null);
        this.setSize(550, 550);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == saveBtn){

        }
        if(e.getSource() == cancelBtn){
            this.dispose();
        }

    }

    public String valiationText(){
        return ""; 
    }
}

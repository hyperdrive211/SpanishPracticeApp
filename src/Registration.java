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
    JTextField usernameText, confirmUsernameText;
    JPasswordField passwordText, confirmPasswordText;
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
        registrationTitle.setBounds(20, 20, 200, 50);


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

        passwordText = new JPasswordField();

        confirmPasswordText = new JPasswordField();

        //Buttons
        saveBtn = new JButton("Save");
        saveBtn.setForeground(Color.white);
        saveBtn.setBackground(Color.green);
        saveBtn.addActionListener(this);

        cancelBtn = new JButton("Cancel");
        cancelBtn.setForeground(Color.white);
        cancelBtn.setBackground(Color.green);
        cancelBtn.addActionListener(this);

        this.add(registrationTitle);


        this.setTitle("Registration");
        this.setLayout(null);
        this.setSize(550, 550);
        this.setResizable(false);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String validation;
        if(e.getSource() == saveBtn){
            validation = validationText(usernameText.getText(), confirmUsernameText.getText(), passwordText.getText(), confirmPasswordText.getText());
            if(validation != ""){
                JOptionPane.showMessageDialog(null, validation);
            }
            else {
                User newUser = new User();
                newUser.setUsername(confirmUsernameText.getText());
                newUser.setPassword(confirmPasswordText.getText());

            }
        }
        if(e.getSource() == cancelBtn){
            this.dispose();
        }

    }

    public String validationText(String username, String confirmUsername, String password, String confirmPassword){
        String returnString = "";
        if(!username.equals(confirmUsername)){
            returnString += "Username and Confirm Username must be the same value. \n";
        }
        if(!password.equals(confirmPassword)){
            returnString += "Password and Confirm Password must be thr same value. ";
        }
        return returnString;
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created By Jonathon on 25/01/2021
 * Update Comments About Program Here
 **/
public class Registration extends JFrame implements ActionListener {
    UserMap uMap;
    Display display;
    ChoicePanel ch;
    User user;
    JLabel registrationTitle, usernameLabel, confirmUsernameLabel, nameLabel,  passwordLabel, confirmPasswordLabel;
    JTextField usernameText, confirmUsernameText, nameText;
    JPasswordField passwordText, confirmPasswordText;
    DisplayBtn saveBtn, cancelBtn;
    Design design = new Design();


    Registration(UserMap uMap, Display display){
        //bring in the Intro Panel se we can set components within it with information provided in this
        this.uMap = uMap;
        this.display = display;

        this.getContentPane().setBackground(design.bgColor);

        //Labels

        registrationTitle = new JLabel("Registration");
        registrationTitle.setForeground(design.text);
        registrationTitle.setFont(new Font(design.fontName, Font.BOLD, 45));
        registrationTitle.setBounds(20, 15, 280, 55);


        usernameLabel = new JLabel("Username:");
        usernameLabel.setForeground(design.text);
        usernameLabel.setFont(new Font(design.fontName, Font.BOLD, 25));
        usernameLabel.setBounds(20, 85, 200, 30);

        confirmUsernameLabel = new JLabel("Confirm Username:");
        confirmUsernameLabel.setForeground(design.text);
        confirmUsernameLabel.setFont(new Font(design.fontName, Font.BOLD, 25));
        confirmUsernameLabel.setBounds(20, 180, 300, 30);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(design.text);
        passwordLabel.setFont(new Font(design.fontName, Font.BOLD, 25));
        passwordLabel.setBounds(20,265, 200, 30);

        confirmPasswordLabel = new JLabel("Confirm password:");
        confirmPasswordLabel.setForeground(design.text);
        confirmPasswordLabel.setFont(new Font(design.fontName, Font.BOLD, 25));
        confirmPasswordLabel.setBounds(20, 355, 300, 30);

        nameLabel = new JLabel("Full Name:");
        nameLabel.setFont(new Font(design.fontName, Font.BOLD, 25));
        nameLabel.setForeground(design.text);
        nameLabel.setBounds(20, 440, 300, 30);


        //Textfields
        usernameText = new JTextField();
        usernameText.setFont(new Font(design.fontName, Font.PLAIN, 25));
        usernameText.setBounds(20, 120, 400, 50);

        confirmUsernameText = new JTextField();
        confirmUsernameText.setFont(new Font(design.fontName, Font.PLAIN, 25));
        confirmUsernameText.setBounds(20, 210, 400, 50);

        passwordText = new JPasswordField();
        passwordText.setFont(new Font(design.fontName, Font.PLAIN, 25));
        passwordText.setBounds(20, 300, 400, 50);


        confirmPasswordText = new JPasswordField();
        confirmPasswordText.setFont(new Font(design.fontName, Font.PLAIN, 25));
        confirmPasswordText.setBounds(20, 390, 400, 50);

        nameText = new JTextField();
        nameText.setFont(new Font(design.fontName, Font.BOLD, 25));
        nameText.setBounds(20, 480, 400, 50);


        //Buttons
        saveBtn = new DisplayBtn(design.success, 15, "Save");
        saveBtn.addActionListener(this);
        saveBtn.setBounds(50, 540, 100, 50);

        cancelBtn = new DisplayBtn(design.failure, 15, "Cancel");
        cancelBtn.addActionListener(this);
        cancelBtn.setBounds(170, 540, 100, 50);


        //adding components
        this.add(registrationTitle); this.add(usernameLabel); this.add(usernameText);
        this.add(confirmUsernameLabel); this.add(confirmUsernameText); this.add(passwordLabel);
        this.add(passwordText); this.add(confirmPasswordLabel); this.add(confirmPasswordText);
        this.add(nameLabel); this.add(nameText);

        this.add(saveBtn); this.add(cancelBtn);

        this.setTitle("Registration");
        this.setLayout(null);
        this.setSize(530, 650);
        this.setResizable(false);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String validation;
        if(e.getSource() == saveBtn){
            validation = validationText(usernameText.getText(), confirmUsernameText.getText(), String.valueOf(passwordText.getPassword()), String.valueOf(confirmPasswordText.getPassword()), nameText.getText());
            if(validation != ""){
                JOptionPane.showMessageDialog(null, validation);
            }
            else {
                User newUser = new User();
                newUser.setUsername(confirmUsernameText.getText());
                newUser.setPassword(String.valueOf(confirmPasswordText.getPassword()));
                newUser.setName(nameText.getText());
                System.out.println(newUser.getPassword());
                uMap.addUser(newUser);
                uMap.saveData();
                ch = new ChoicePanel(user);
                display.setIPVisible();
                display.add(ch);
                this.dispose();
            }
        }
        if(e.getSource() == cancelBtn){
            this.dispose();
        }

    }

    public String validationText(String username, String confirmUsername, String password, String confirmPassword, String name){
        String returnString = "";
        if(username.trim().equals("") || confirmPassword.trim().equals("")
                || password.trim().equals("") || confirmPassword.trim().equals("") || name.trim().equals("")){
            returnString += "Some values have missing values, please enter all.";
        }
        if(!username.equals(confirmUsername)){
            returnString += "Username and Confirm Username must be the same value. \n";
        }
        if(!password.equals(confirmPassword)){
            returnString += "Password and Confirm Password must be thr same value. ";
        }
        return returnString;
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

/**
 * Created By Jonathon on 17/12/2020
 * Update Comments About Program Here
 **/
public class IntroPanel extends JPanel implements ActionListener {
    Design design = new Design();
    Registration reg;
    ChoicePanel choicePanel;
    JTextField username;
    JPasswordField passwordField;
    DisplayBtn saveAndStart, registerButton;
    User user;
    JLabel flagHolder, appName, usernameLabel, passwordLabel;
    boolean visible = true;
    HashMap<String, User> userList = new HashMap<String, User>();
    UserMap uMap;
    Display display;
    IntroPanel(Display display){
        this.display = display;
        appName = new JLabel("Spanish Noun Project");
        appName.setForeground(design.text);
        appName.setFont(new Font(design.fontName, Font.BOLD, 35));
        appName.setHorizontalAlignment(JLabel.CENTER);
        appName.setBorder(BorderFactory.createMatteBorder(0,0,2,0, design.underLine));
        appName.setBounds(50, 20, 400, 70);
        //Flag Component
        ImageIcon flag = new ImageIcon("./img/flag.png");
        flagHolder = new JLabel();
        flagHolder.setBounds(100, 90, 300,200);
        flagHolder.setIcon(flag);
        flagHolder.setHorizontalAlignment(JLabel.CENTER);


        usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font(design.fontName, Font.BOLD, 15));
        usernameLabel.setForeground(design.text);
        usernameLabel.setBounds(50, 300, 150, 30);

        //Username TextField
        username = new JTextField();
        username.setFont(new Font(design.fontName, Font.PLAIN, 20));
        username.setBounds(50, 330, 400, 40);

        //PasswordLabel
        passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font(design.fontName, Font.BOLD, 15));
        passwordLabel.setForeground(design.text);
        passwordLabel.setBounds(50, 385, 400, 30);

        //Password Field
        passwordField = new JPasswordField();
        passwordField.setFont(new Font(design.fontName, Font.BOLD, 20));
        passwordField.setBounds(50, 410, 400, 40);


        //save and continue btn
        saveAndStart = new DisplayBtn(design.success, 15, "Login");
        saveAndStart.setBounds(50, 470, 150, 50);
        saveAndStart.addActionListener(this);

        registerButton = new DisplayBtn(design.underLine, 15, "Register");
        registerButton.setBounds(250, 470, 150, 50);
        registerButton.addActionListener(this);

        //get list of users to check for log in
        uMap = new UserMap();
        uMap.getData();
        userList = uMap.getUserMap();
        System.out.println(userList);
        System.out.println(userList.size());


        this.setLayout(null);
        this.setBackground(design.bgColor); this.add(flagHolder); this.add(appName);
        this.add(passwordLabel); this.add(passwordField);
        this.add(usernameLabel); this.add(username); this.add(saveAndStart); this.add(registerButton);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String password = "";
        if(e.getSource() == saveAndStart){
            user = new User();
            visible = false;
            //search the map for a username
            if(userList.get(username.getText()) == null){
                JOptionPane.showMessageDialog(null, "Username does not exist");
            } else {
                user = userList.get(username.getText());
                if(user.getPassword().equals(String.valueOf(passwordField.getPassword()))){
                    choicePanel = new ChoicePanel(user);
                    this.setVisible(false);
                    display.add(choicePanel);
                }
            }
        }

        if(e.getSource() == registerButton){
            reg = new Registration(uMap, display);
        }
    }
}

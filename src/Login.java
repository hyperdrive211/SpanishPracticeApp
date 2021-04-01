import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created By Jonathon on 25/01/2021
 * Update Comments About Program Here
 **/
public class Login  extends JFrame implements ActionListener {
    private Design design = new Design();
    private User user;
    private JLabel loginLabel, passwordLabel;
    private JPasswordField passWordTextfield;
    private DisplayBtn btnLogin, cancelButton;
    private Display display;
    private IntroPanel introPanel;
    private ChoicePanel chPanel;

    Login(User user, Display display){
        this.user = user;
        this.getContentPane().setBackground(design.bgColor);
        this.display = display;
        this.introPanel = display.getIp();

        loginLabel = new JLabel("Login");
        loginLabel.setForeground(Color.white);
        loginLabel.setFont(new Font(design.fontName, Font.BOLD, 35));
        loginLabel.setBounds(100, 50, 100, 75);

        passwordLabel = new JLabel("Enter Password:");
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setFont(new Font(design.fontName, Font.BOLD, 20));
        passwordLabel.setBounds(50, 100, 200, 50);

        passWordTextfield = new JPasswordField();
        passWordTextfield.setBounds(50, 170, 200, 50);


        //Button styling and placement
        btnLogin = new DisplayBtn(design.success, 15, "Login");
        btnLogin.setBounds(50, 250, 90, 50);
        btnLogin.addActionListener(this);

        cancelButton = new DisplayBtn(design.failure, 15,"Cancel");
        cancelButton.setBounds(160, 250, 90, 50);
        cancelButton.addActionListener(this);

        this.add(loginLabel); this.add(passWordTextfield); this.add(passwordLabel);
        this.add(loginLabel); this.add(cancelButton); this.add(btnLogin);

        this.setLayout(null);
        this.setSize(300, 500);
        this.setTitle("Login");
        this.setResizable(false);
        this.setVisible(true);

        System.out.println(user.getPassword());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == cancelButton){
            this.dispose();
        }
        if(e.getSource() == btnLogin){
            if(String.valueOf(passWordTextfield.getPassword()).equals(user.getPassword()))
            {
               chPanel = new ChoicePanel(user);
               introPanel.setVisible(false);
               display.add(chPanel);
               this.dispose();
            }
        }

    }
}

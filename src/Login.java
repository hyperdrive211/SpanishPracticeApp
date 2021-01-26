import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created By Jonathon on 25/01/2021
 * Update Comments About Program Here
 **/
public class Login  extends JFrame implements ActionListener {
    String font = "Sans-serif";
    User user;
    JLabel loginLabel, passwordLabel;
    JTextField passWordTextfield;
    JButton ckBtn, cancelBtn;
    Display display;
    IntroPanel introPanel;

    Login(User user, IntroPanel ip){
        this.user = user;
        this.introPanel = ip;

        this.getContentPane().setBackground(new Color(110,192,248));

        loginLabel = new JLabel("Login");
        loginLabel.setForeground(Color.white);
        loginLabel.setFont(new Font(font, Font.BOLD, 35));
        loginLabel.setBounds(100, 50, 100, 75);

        passwordLabel = new JLabel("Enter Password:");
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setFont(new Font(font, Font.BOLD, 20));
        passwordLabel.setBounds(50, 100, 200, 50);

        passWordTextfield = new JTextField();
        passWordTextfield.setBounds(50, 170, 200, 50);


        //Button styling and placement
        ckBtn = new JButton("Login");
        ckBtn.setForeground(Color.white);
        ckBtn.setBackground(Color.green);
        ckBtn.setBounds(50, 250, 90, 50);
        ckBtn.addActionListener(this);

        cancelBtn = new JButton("Cancel");
        cancelBtn.setBackground(Color.green);
        cancelBtn.setForeground(Color.white);
        cancelBtn.setBounds(160, 250, 90, 50);
        cancelBtn.addActionListener(this);



        this.add(loginLabel);
        this.add(passWordTextfield);
        this.add(passwordLabel);
        this.add(ckBtn);
        this.add(cancelBtn);

        this.setLayout(null);
        this.setSize(300, 400);
        this.setTitle("Login");
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == cancelBtn){
            this.dispose();
        }
        if(e.getSource() == ckBtn){
            user.setPassword("Password");
            if(passWordTextfield.getText().equals(user.getPassword()))
            {
               introPanel.setVisible(false);
               this.dispose();

            }
        }

    }
}

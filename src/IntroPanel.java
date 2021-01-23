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
    ChoicePanel chPanel;
    JFrame currentFrame;
    JTextField username;
    JButton saveAndStart;
    User user;
    JLabel flagHolder;
    JLabel appName;
    boolean visible = true;
    HashMap<String, User> userList = new HashMap<String, User>();
    UserMap uMap;
    IntroPanel(JFrame parameterFrame){
        currentFrame = parameterFrame;
        //Flag Component
        ImageIcon flag = new ImageIcon("./img/flag.png");
        flagHolder = new JLabel();
        flagHolder.setBounds(55, 0, 300,200);
        flagHolder.setIcon(flag);
        flagHolder.setHorizontalAlignment(JLabel.CENTER);

        //App Name Label
        appName = new JLabel("Spanish Nouns");
        appName.setFont(new Font("Monospaced", Font.BOLD, 25));
        appName.setHorizontalAlignment(JLabel.CENTER);
        appName.setBounds(70, 200, 200, 70);

        //Username TextField
        username = new JTextField("Enter Username");
        username.setSize(400, 50 );
        username.setBounds(70, 270, 250, 50);


        //save and continue btn
        saveAndStart= new JButton();
        saveAndStart.setBounds(80, 350, 150, 50);
        saveAndStart.setText("Let's Begin!");
        saveAndStart.addActionListener(this);

        //get list of users to check for log in
        uMap = new UserMap();
        uMap.getData();
        userList = uMap.getUserMap();
        System.out.println(userList);
        System.out.println(userList.size());
        this.setLayout(null);
        this.setBackground(new Color(110,192,248));
        this.add(flagHolder);
        this.add(appName);
        this.add(username);
        this.add(saveAndStart);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == saveAndStart){
            user = new User();
            visible = false;
            if(userList.get(username.getText()) == null){
                user.setUsername(username.getText());
                uMap.addUser(user);
                uMap.saveData();
            }

            this.setVisible(false);
            chPanel = new ChoicePanel(user);
            currentFrame.add(chPanel);
        }
    }
}

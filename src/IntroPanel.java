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
    Color bgColor = new Color(110,192,248);
    String font = "Sans-serif";
    Registration reg;
    Login login;
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
        appName = new JLabel("Spanish Noun Project");
        appName.setForeground(Color.WHITE);
        appName.setFont(new Font(font, Font.BOLD, 35));
        appName.setHorizontalAlignment(JLabel.CENTER);
        appName.setBounds(15, 200, 370, 70);

        //Username TextField
        username = new JTextField();
        username.setSize(400, 50 );
        username.setFont(new Font(font, Font.PLAIN, 25));
        username.setBounds(70, 270, 250, 50);

        //save and continue btn
        saveAndStart= new JButton();
        saveAndStart.setBounds(100, 350, 150, 50);
        saveAndStart.setText("Let's Begin!");
        saveAndStart.setBackground(Color.green);
        saveAndStart.setForeground(Color.white);
        saveAndStart.addActionListener(this);

        //get list of users to check for log in
        uMap = new UserMap();
        uMap.getData();
        userList = uMap.getUserMap();
        System.out.println(userList);
        System.out.println(userList.size());
        this.setLayout(null);
        this.setBackground(bgColor);
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
            //search the map for a username
            if(userList.get(username.getText()) == null){
                reg = new Registration(uMap, user, this);
            } else {
                login = new Login(user, this);
            }
        }
    }
}

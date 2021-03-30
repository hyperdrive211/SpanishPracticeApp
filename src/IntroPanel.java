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
    JTextField username;
    JButton saveAndStart;
    User user;
    JLabel flagHolder, appName, usernameLabel;
    boolean visible = true;
    HashMap<String, User> userList = new HashMap<String, User>();
    UserMap uMap;
    Display display;
    IntroPanel(Display display){
        this.display = display;

        appName = new JLabel("Spanish Noun Project");
        appName.setForeground(Color.WHITE);
        appName.setFont(new Font(font, Font.BOLD, 35));
        appName.setHorizontalAlignment(JLabel.CENTER);
        appName.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.red));
        appName.setBounds(50, 20, 400, 70);
        //Flag Component
        ImageIcon flag = new ImageIcon("./img/flag.png");
        flagHolder = new JLabel();
        flagHolder.setBounds(100, 90, 300,200);
        flagHolder.setIcon(flag);
        flagHolder.setHorizontalAlignment(JLabel.CENTER);


        usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font(font, Font.BOLD, 15));
        usernameLabel.setForeground(Color.WHITE);
        usernameLabel.setBounds(50, 300, 150, 30);

        //Username TextField
        username = new JTextField();
        username.setFont(new Font(font, Font.PLAIN, 25));
        username.setBounds(50, 330, 400, 40);

        //save and continue btn
        saveAndStart= new JButton();
        saveAndStart.setBounds(100, 400, 300, 50);
        saveAndStart.setText("Let's Begin!");
        saveAndStart.setBackground(new Color(1, 138, 15));
        saveAndStart.setForeground(Color.white);
        saveAndStart.addActionListener(this);

        //get list of users to check for log in
        uMap = new UserMap();
        uMap.getData();
        userList = uMap.getUserMap();
        System.out.println(userList);
        System.out.println(userList.size());


        this.setLayout(null);
        this.setBackground(bgColor); this.add(flagHolder); this.add(appName);
        this.add(usernameLabel); this.add(username); this.add(saveAndStart);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == saveAndStart){
            user = new User();
            visible = false;
            //search the map for a username
            if(userList.get(username.getText()) == null){
                user.setUsername(username.getText());
                reg = new Registration(uMap, user, display);
            } else {
                user = userList.get(username.getText());
                login = new Login(user, display);
            }
        }
    }
}

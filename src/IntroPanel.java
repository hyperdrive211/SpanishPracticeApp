import javax.swing.*;
import java.awt.*;

/**
 * Created By Jonathon on 17/12/2020
 * Update Comments About Program Here
 **/
public class IntroPanel extends JPanel {
    JTextField username;
    JButton saveAndStart;
    User user;
    IntroPanel(){
        username = new JTextField();
        saveAndStart = new JButton();
        this.add(username);
        this.add(saveAndStart);
        this.setSize(new Dimension(400, 400));


    }
}

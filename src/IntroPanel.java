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
    JLabel flagHolder;
    IntroPanel(){
        ImageIcon flag = new ImageIcon("./img/flag.png");
        flagHolder = new JLabel();
        flagHolder.setBounds(new Rectangle(200, 200) );
        flagHolder.setIcon(flag);
        flagHolder.setHorizontalAlignment(JLabel.CENTER);
        this.setLayout(new GridLayout(3, 1, 30, 30));
        this.setBackground(new Color(110,192,248));

        this.add(flagHolder);


    }
}

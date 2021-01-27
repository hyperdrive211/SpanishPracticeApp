import javax.swing.*;
import java.awt.*;

/**
 * Created By Jonathon on 21/12/2020
 * Update Comments About Program Here
 **/
public class InfoPanel extends JPanel {

    String name;
    JLabel nameLabel, welcomeLabel;
    Color bgColor = new Color(110,192,248);

    InfoPanel(){

    }

    InfoPanel(String name){
        this.name = name;
        this.setLayout(new GridLayout(2,1));
        this.setBackground(bgColor);
        nameLabel = new JLabel("Name:" + this.name);
        nameLabel.setForeground(Color.white);
        nameLabel.setFont(new Font("Sans-serif", Font.BOLD, 30));
        welcomeLabel = new JLabel("Welcome!\nToday we are gonna learn some Spanish!");
        welcomeLabel.setForeground(Color.white);
        welcomeLabel.setFont(new Font("Sans-serif", Font.BOLD, 20));
        this.add(nameLabel);
        this.add(welcomeLabel);
        this.setSize(new Dimension(400,100));
    }

}

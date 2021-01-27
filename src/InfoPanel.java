import javax.swing.*;
import java.awt.*;

/**
 * Created By Jonathon on 21/12/2020
 * Update Comments About Program Here
 **/
public class InfoPanel extends JPanel {

    String name;
    int score;
    JLabel nameLabel, welcomeLabel;

    Color bgColor = new Color(110,192,248);

    InfoPanel(){

    }

    InfoPanel(String name){
        this.name = name;
        this.score=score;
        this.setLayout(new GridLayout(2,1, 20,20));
        this.setBackground(bgColor);
        nameLabel = new JLabel("Name:" + this.name);

        welcomeLabel = new JLabel("Welcome! Today we are gonna learn some Spanish!");

        this.add(nameLabel);
        this.setSize(new Dimension(400,100));
    }

}

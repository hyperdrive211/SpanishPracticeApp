import javax.swing.*;
import java.awt.*;

/**
 * Created By Jonathon on 21/12/2020
 * Update Comments About Program Here
 **/
public class InfoPanel extends JPanel {

    String name;
    int score;
    JLabel nameLabel;
    JLabel scoreLabel;

    Color bgColor = new Color(110,192,248);

    InfoPanel(){

    }

    InfoPanel(String name, int score){
        this.name = name;
        this.score=score;
        this.setLayout(new GridLayout(2,1, 20,20));
        this.setBackground(bgColor);
        nameLabel = new JLabel("Name:" + this.name);
        scoreLabel = new JLabel("Score: " + String.format("%d", this.score));

        this.add(nameLabel);
        this.add(scoreLabel);
        this.setSize(new Dimension(400,100));
    }

}

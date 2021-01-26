import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created By Jonathon on 25/11/2020
 * Update Comments About Program Here
 **/
public class Display extends JFrame {
    IntroPanel ip;

    public Display(){
        this.setTitle("Johnny Spanish Noun Project");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(new Rectangle(500, 600));
        this.setLayout(new BorderLayout());
        ip = new IntroPanel(this);
        this.getContentPane().add(ip, BorderLayout.CENTER);
        this.setResizable(false);
        this.setVisible(true);

    }

}

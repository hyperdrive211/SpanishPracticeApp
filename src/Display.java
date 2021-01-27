import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created By Jonathon on 25/11/2020
 * Update Comments About Program Here
 **/
public class Display extends JFrame {
    private IntroPanel ip;
    private Color bgColor = new Color(110,192,248);
    public Display(){
        this.setTitle("Johnny Spanish Noun Project");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(bgColor);
        this.setBounds(new Rectangle(500, 600));
        this.setLayout(new BorderLayout());
        ip = new IntroPanel(this);
        this.getContentPane().add(ip, BorderLayout.CENTER);
        this.setResizable(false);
        this.setVisible(true);
    }

    public IntroPanel getIp() {
        return ip;
    }

    public void setIp(IntroPanel ip) {
        this.ip = ip;
    }

    public void setIPVisible(){
        ip.setVisible(false);
    }
}

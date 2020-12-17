import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created By Jonathon on 25/11/2020
 * Update Comments About Program Here
 **/
public class Display extends JFrame implements ActionListener {
    JTextField username;
    JButton btnGo;
    Color bgBlue = new Color(0,164,228,0);

    IntroPanel ip;

    public Display(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setBounds(new Rectangle(500, 500));
        this.setVisible(true);
        this.setLayout(new BorderLayout());
        this.getContentPane().setBackground(new Color(0, 142, 204));
        ip = new IntroPanel();
       this.getContentPane().add(ip, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnGo){
            System.out.println("Here we go!");
        }
    }
}

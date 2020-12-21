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
    JPanel top;

    public Display(){
        top = new JPanel();
        top.setPreferredSize(new Dimension(100, 10));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(new Rectangle(500, 550));
        this.setLayout(new BorderLayout());
        ip = new IntroPanel();
        this.getContentPane().add(top, BorderLayout.NORTH);
        this.getContentPane().add(ip, BorderLayout.CENTER);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnGo){
            System.out.println("Here we go!");
        }
    }
}

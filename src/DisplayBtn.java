import javax.swing.*;
import java.awt.*;

/**
 * Created By Jonathon on 07/02/2021
 * Update Comments About Program Here
 **/
public class DisplayBtn extends JButton {

    DisplayBtn(int x, int y, int height, int width, int fontSize, String text){
        this.setText(text);
        this.setBackground(Color.green);
        this.setFont(new Font("Sans-serif", Font.BOLD, fontSize));
        this.setForeground(Color.white);
        this.setBounds(x, y, width, height);
    }

}

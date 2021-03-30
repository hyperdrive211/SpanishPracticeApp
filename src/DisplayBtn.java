import javax.swing.*;
import java.awt.*;

/**
 * Created By Jonathon on 07/02/2021
 * Update Comments About Program Here
 **/
public class DisplayBtn extends JButton {

    DisplayBtn(int fontSize, String text){
        this.setText(text);
        this.setBackground(new Color(2, 138, 15));
        this.setFont(new Font("Sans-serif", Font.BOLD, fontSize));
        this.setForeground(Color.white);
    }

}

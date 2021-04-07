import javax.swing.*;
import java.awt.*;

/**
 * Created By Jonathon on 07/02/2021
 * Update Comments About Program Here
 **/
public class DisplayBtn extends JButton {

    Design design = new Design();

    DisplayBtn(Color buttonColor,int fontSize, String text){
        this.setText(text);
        this.setBackground(buttonColor);
        this.setFont(new Font("Sans-serif", Font.BOLD, fontSize));
        this.setForeground(design.text);
        this.setFocusPainted(false);
    }

}

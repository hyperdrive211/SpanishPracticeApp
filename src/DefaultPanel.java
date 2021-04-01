import javax.swing.*;

/**
 * Created By Jonathon on 31/03/2021
 * Update Comments About Program Here
 **/
public class DefaultPanel extends JPanel {
    private Design design = new Design();

    DefaultPanel(){
        this.setBackground(design.bgColor);
    }
}

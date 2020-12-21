import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created By Jonathon on 21/12/2020
 * Update Comments About Program Here
 **/
public class ChoicePanel extends JPanel {
    BtnPanel btnPanel;

    ChoicePanel(){
        this.setLayout(new BorderLayout(10, 0));
        btnPanel = new BtnPanel();
        this.add(btnPanel, BorderLayout.CENTER);


    }

}

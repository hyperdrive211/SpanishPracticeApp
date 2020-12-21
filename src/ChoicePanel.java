import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created By Jonathon on 21/12/2020
 * Update Comments About Program Here
 **/
public class ChoicePanel extends JPanel {
    BtnPanel btnPanel;
    InfoPanel infoPanel;
    User user;

    ChoicePanel(User user){
        this.user = user;
        this.setLayout(new BorderLayout(50, 50));
        infoPanel= new InfoPanel(this.user.getUsername(), this.user.getNumberVerbsCorrect());
        btnPanel = new BtnPanel();
        this.add(infoPanel, BorderLayout.NORTH);
        this.add(btnPanel, BorderLayout.CENTER);
    }

}

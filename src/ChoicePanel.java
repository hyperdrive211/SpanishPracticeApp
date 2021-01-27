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
    Color bgColor = new Color(110,192,248);

    ChoicePanel(User user){
        this.user = user;
        this.setLayout(new BorderLayout());
        infoPanel= new InfoPanel(user.getName());
        btnPanel = new BtnPanel(this, user);
        this.add(infoPanel, BorderLayout.NORTH);
        this.add(btnPanel, BorderLayout.CENTER);
    }

}

import javax.swing.*;
import java.awt.*;

/**
 * Created By Jonathon on 21/12/2020
 * Update Comments About Program Here
 **/
public class InfoPanel extends JPanel {

    User user;
    JLabel nameLabel, welcomeLabel, nameText, welcomeMessage, scoreLabel;
    DefaultPanel namePanel;
    private Design design = new Design();

    InfoPanel(User user){
        this.user = user;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(design.bgColor);
        this.setAlignmentX(JPanel.LEFT_ALIGNMENT);
        namePanel = new DefaultPanel();
        namePanel.setAlignmentX(JPanel.LEFT_ALIGNMENT);
        BoxLayout boxLayout = new BoxLayout(namePanel, BoxLayout.X_AXIS);
        namePanel.setLayout(boxLayout);
        nameLabel = new JLabel("Name:" , JLabel.LEFT);
        nameLabel.setForeground(design.underLine);
        nameLabel.setFont(new Font(design.fontName, Font.BOLD, 30));
        namePanel.add(nameLabel);

        nameText = new JLabel(user.getName(), JLabel.LEFT);
        nameText.setForeground(Color.WHITE);
        nameText.setFont(new Font(design.fontName, Font.BOLD, 30));
        namePanel.add(nameText);

        this.add(namePanel);

        welcomeLabel = new JLabel("Welcome!", JLabel.LEFT);
        welcomeLabel.setForeground(Color.white);
        welcomeLabel.setFont(new Font("Sans-serif", Font.BOLD, 20));

        this.add(welcomeLabel);
    }

}

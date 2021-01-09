import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created By Jonathon on 21/12/2020
 * Update Comments About Program Here
 **/
public class BtnPanel extends JPanel implements ActionListener {

    //in this class we get the Array lists of nouns and create a new question panel on the basis of the noun list.
    ArrayList<PracticeQuestion> questions = new ArrayList<PracticeQuestion>();
    ChoicePanel choicePanel;
    JButton btnClothing, btnTravel, btnKitchen, btnFurniture;
    String [] btnNames = {"Clothing","Furniture", "Kitchen", "Travel"};
    User user;


    BtnPanel(ChoicePanel choicePanel, User user){
        this.user = user;
        this.choicePanel = new ChoicePanel(user);
        this.setLayout(new GridLayout(2,2));
        btnClothing = new JButton(btnNames[0]);
        btnFurniture = new JButton(btnNames[1]);
        btnKitchen = new JButton(btnNames[2]);
        btnTravel = new JButton(btnNames[3]);

        this.add(btnClothing);
        this.add(btnFurniture);
        this.add(btnKitchen);
        this.add(btnTravel);
    }
}

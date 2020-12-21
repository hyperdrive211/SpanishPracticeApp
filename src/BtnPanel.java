import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created By Jonathon on 21/12/2020
 * Update Comments About Program Here
 **/
public class BtnPanel extends JPanel {

    //in this class we get the Array lists of nouns and create a new question panel on the basis of the noun list.
    ArrayList<PracticeQuestion> questions = new ArrayList<PracticeQuestion>();

    JButton btnClothing, btnTravel, btnKitchen, btnFurniture;
    String [] btnNames = {"Clothing","Furniture", "Kitchen", "Travel"};


    BtnPanel(){
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

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

    JButton btn [];
    String [] btnNames = {"Clothing","Furniture", "Kithcen", "Travel"};


    BtnPanel(){
        this.setLayout(new GridLayout(2,2));

    }
}

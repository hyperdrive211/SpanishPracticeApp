import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created By Jonathon on 21/12/2020
 * Update Comments About Program Here
 **/
public class BtnPanel extends JPanel implements ActionListener {

    //in this class we get the Array lists of nouns and create a new question panel on the basis of the noun list.
    ChoicePanel choicePanel;
    JButton btnClothing, btnTravel, btnKitchen, btnFurniture;
    String [] btnNames = {"Clothing","Furniture", "Kitchen", "Travel"};
    User user;
    QuestionPanel qPanel;
    QuestionList questionList;



    BtnPanel(ChoicePanel choicePanel, User user){
        this.user = user;
        this.choicePanel = choicePanel;
        this.setLayout(new GridLayout(2,2));
        btnClothing = new JButton(btnNames[0]);
        btnFurniture = new JButton(btnNames[1]);
        btnKitchen = new JButton(btnNames[2]);
        btnTravel = new JButton(btnNames[3]);
        btnClothing.addActionListener(this);
        this.add(btnClothing);
        this.add(btnFurniture);
        this.add(btnKitchen);
        this.add(btnTravel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == btnClothing){
            System.out.println("Clothing");
            changePanels(questionList.clothingList());

            for(int i = 0; i < questionList.clothingList().size(); i++){
                System.out.println(questionList.clothingList());
            }

        }
    }

    public void changePanels(ArrayList<PracticeQuestion> questions){
        System.out.println("Button has been pressed!");
        qPanel = new QuestionPanel(user, questions, choicePanel);
        choicePanel.remove(choicePanel.btnPanel);
        choicePanel.add(qPanel, BorderLayout.CENTER);

    }
}

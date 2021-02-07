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
    Color bgColor = new Color(110,192,248);
    DisplayBtn btnClothing, btnTravel, btnKitchen, btnFurniture;
    String questionDef = "";
    User user;
    QuestionPanel qPanel;
    QuestionList questionList = new QuestionList();


    BtnPanel(ChoicePanel choicePanel, User user){
        this.user = user;
        this.choicePanel = choicePanel;
        this.setLayout(null);

        btnClothing = new DisplayBtn(20, 50, 50, 150, 24, "Clothing");
        btnClothing.addActionListener(this);
        this.add(btnClothing);

        btnFurniture = new DisplayBtn(20, 120, 50, 150, 24, "Furniture");
        btnFurniture.addActionListener(this);
        this.add(btnFurniture);

        btnKitchen = new DisplayBtn(200, 50, 50, 150, 24,"Kitchen");
        btnKitchen.addActionListener(this);
        this.add(btnKitchen);

        btnTravel = new DisplayBtn(200, 170, 50, 170, 24, "Travel");
        btnTravel.addActionListener(this);
        this.add(btnTravel);


        this.setBackground(bgColor);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnClothing){
            System.out.println("Clothing");
            changePanels(questionList.clothingList(), "Clothing");
        }
    }

    public void changePanels(ArrayList<PracticeQuestion> questions, String questionDef){
        System.out.println("Button has been pressed!");
        qPanel = new QuestionPanel(user, questions, choicePanel, questionDef);
        choicePanel.add(qPanel, BorderLayout.CENTER);
        choicePanel.btnPanel.setVisible(false);
    }
}

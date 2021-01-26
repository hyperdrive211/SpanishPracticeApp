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
    JButton btnClothing, btnTravel, btnKitchen, btnFurniture;
    String [] btnNames = {"Clothing","Furniture", "Kitchen", "Travel"};
    User user;
    QuestionPanel qPanel;
    QuestionList questionList = new QuestionList();



    BtnPanel(ChoicePanel choicePanel, User user){
        this.user = user;
        this.choicePanel = choicePanel;
        this.setLayout(null);


        btnClothing = new JButton("Clothing");
        btnFurniture = new JButton("Furniture");
        btnKitchen = new JButton("Kitchen");
        btnTravel = new JButton("Travel");



        btnClothing.addActionListener(this);
        btnFurniture.addActionListener(this);
        btnKitchen.addActionListener(this);
        btnTravel.addActionListener(this);
        this.add(btnClothing);
        this.add(btnFurniture);
        this.add(btnKitchen);
        this.add(btnTravel);
        this.setBackground(bgColor);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == btnClothing){
            System.out.println("Clothing");
            changePanels(questionList.clothingList());

        }
    }

    public void changePanels(ArrayList<PracticeQuestion> questions){
        System.out.println("Button has been pressed!");
        qPanel = new QuestionPanel(user, questions, choicePanel);
        choicePanel.add(qPanel, BorderLayout.CENTER);
        choicePanel.btnPanel.setVisible(false);

    }
}

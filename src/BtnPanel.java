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
    DisplayBtn btnClothing, btnTravel, btnKitchen, btnFurniture;
    User user;
    QuestionPanel qPanel;
    QuestionList questionList = new QuestionList();
    Design design = new Design();
    JPanel buttonContainer, fillerLeft, fillerRight, fillerSouth;
    JLabel topicChoice;


    BtnPanel(ChoicePanel choicePanel, User user){
        this.user = user;
        this.choicePanel = choicePanel;
        this.setLayout(new BorderLayout(70, 70));

        topicChoice = new JLabel("Select a Topic!", JLabel.CENTER);
        topicChoice.setFont(new Font(design.fontName, Font.BOLD, 25));
        topicChoice.setForeground(design.text);
        topicChoice.setBorder(BorderFactory.createMatteBorder(0,0,2,0, design.underLine));
        this.add(topicChoice, BorderLayout.NORTH);


        buttonContainer = new JPanel();
        buttonContainer.setLayout(new GridLayout(2,2,  20, 20));
        buttonContainer.setBorder(BorderFactory.createLineBorder(design.text, 2));
        buttonContainer.setBackground(design.bgColor);


        btnClothing = new DisplayBtn( design.success,24, "Clothing");
        btnClothing.addActionListener(this);
        buttonContainer.add(btnClothing);

        btnFurniture = new DisplayBtn( design.success,24, "Furniture");
        btnFurniture.addActionListener(this);
        buttonContainer.add(btnFurniture);

        btnKitchen = new DisplayBtn( design.success, 24,"Kitchen");
        btnKitchen.addActionListener(this);
        buttonContainer.add(btnKitchen);

        btnTravel = new DisplayBtn( design.success, 24, "Travel");
        btnTravel.addActionListener(this);
        buttonContainer.add(btnTravel);

        //filler components
        fillerLeft = new JPanel();
        fillerLeft.setBackground(design.bgColor);
        this.add(fillerLeft, BorderLayout.WEST);

        fillerRight = new JPanel();
        fillerRight.setBackground(design.bgColor);
        this.add(fillerRight, BorderLayout.EAST);

        fillerSouth  = new JPanel();
        fillerSouth.setBackground(design.bgColor);
        this.add(fillerSouth, BorderLayout.SOUTH);


        this.add(buttonContainer, BorderLayout.CENTER);
        this.setBackground(design.bgColor);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnClothing){
            changePanels(questionList.clothingList(), "Clothing");
        }
        if(e.getSource() == btnFurniture){
            changePanels(questionList.furnitureList(), "Furniture");
        }
    }

    public void changePanels(ArrayList<PracticeQuestion> questions, String questionDef){
        System.out.println("Button has been pressed!");
        qPanel = new QuestionPanel(user, questions, choicePanel, questionDef);
        choicePanel.add(qPanel, BorderLayout.CENTER);
        choicePanel.btnPanel.setVisible(false);
    }
}

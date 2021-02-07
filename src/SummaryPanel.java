import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created By Jonathon on 04/02/2021
 * Update Comments About Program Here
 **/
public class SummaryPanel extends JPanel implements ActionListener {
    User user;
    UserMap uMap;
    ArrayList<PracticeQuestion> feedBackList;
    JLabel resultImage, userInfo;
    JPanel firstDisplay, leaderBoardPanel, resultsPanel;
    JLabel [] eachAnswerResult, leaderBoard;
    JButton showLeaderBoard;
    String section;


    SummaryPanel(User user, ArrayList<PracticeQuestion> returnList, String section){
        this.user = user;
        this.feedBackList = returnList;
        this.section = section;

        //Set the progress image with an emoji!
        resultImage = new JLabel();
        eachAnswerResult = new JLabel [10];
        resultsPanel = new JPanel();
        returnFeedBack(returnList, resultsPanel);
        resultsPanel.setBounds(20, 50, 400, 400);
        this.add(resultsPanel);
        this.setBounds(20, 20, 500, 500);

    }

    public JLabel [] returnFeedBack(ArrayList<PracticeQuestion> fbList, JPanel panel){
        //loop the list and use it make a table like list of the results
        //set an image for if the answer was correct or not and then question and
        //the answer provided,
        int x = 20, y = 10;
        JLabel [] labelList = new JLabel[10];
        for(int i = 0; i < fbList.size(); i++){
            System.out.println(fbList.get(i).feedbackString());
            labelList[i] = new JLabel(fbList.get(i).feedbackString());
            labelList[i].setBounds(x, y, 200, 40);
            panel.add(labelList[i]);
            y += 20;
        }

        return labelList;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

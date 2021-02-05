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
    ArrayList<QuestionList> feedBackList;
    JLabel resultImage, userInfo;
    JPanel firstDisplay, leaderBoardPanel, resultsPanel;
    JLabel [] eachAnswerResult, leaderBoard;
    JButton showLeaderBoard;
    String section;


    SummaryPanel(User user, ArrayList<QuestionList> returnList, String section){
        this.user = user;
        this.feedBackList = returnList;
        this.section = section;

        //Set the progress image with an emoji!
        resultImage = new JLabel();
        eachAnswerResult = returnFeedBack(this.feedBackList);
        resultsPanel = new JPanel();
        resultsPanel.setBounds(20, 50, 300, 300);
        insertList(resultsPanel, eachAnswerResult);
        this.add(resultsPanel);

    }

    public JLabel [] returnFeedBack(ArrayList<QuestionList> fbList){
        //loop the list and use it make a table like list of the results
        //set an image for if the answer was correct or not and then question and
        //the answer provided,
        JLabel [] labelList = new JLabel[10];
        for(int i = 0; i < fbList.size(); i++){
            labelList[i].setText(fbList.get(i).toString());
            labelList[i].setBounds(0, 0, 200, 100);
        }

        return labelList;
    }

    public void insertList(JPanel panel, JLabel [] labelList){
        int i=0;
        while(i < labelList.length){
            panel.add(labelList[i]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created By Jonathon on 17/12/2020
 * Update Comments About Program Here
 **/
public class QuestionPanel extends JPanel {
    QuestionList qList;
    User user;


    QuestionPanel(User user, ArrayList<PracticeQuestion> questions, ChoicePanel choicePanel){
        this.user = user;

    }

}

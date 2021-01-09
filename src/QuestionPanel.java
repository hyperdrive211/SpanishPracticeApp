import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created By Jonathon on 17/12/2020
 * Update Comments About Program Here
 **/
public class QuestionPanel extends JPanel implements ActionListener {
    PracticeQuestion pq = new PracticeQuestion();
    User user;
    ImageIcon img;
    JLabel holdIMG;
    JTextField input;
    JButton btnCheck;


    QuestionPanel(User user, ArrayList<PracticeQuestion> questions, ChoicePanel choicePanel){
        pq = questions.get(0);
        this.user = user;
        img = new ImageIcon(pq.getImgURL());
        holdIMG = new JLabel();
        holdIMG.setIcon(img);
        


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

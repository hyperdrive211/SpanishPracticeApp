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
    ArrayList<PracticeQuestion> pqList = new ArrayList<PracticeQuestion>();
    User user;
    ImageIcon img;
    JLabel holdIMG;
    JTextField input;
    JButton btnCheck;
    JLabel feedBack;
    int questionCount = 0;


    QuestionPanel(User user, ArrayList<PracticeQuestion> questions, ChoicePanel choicePanel){
        pqList = questions;
        pq = pqList.get(questionCount);

        this.user = user;
        img = new ImageIcon(pq.getImgURL());
        holdIMG = new JLabel();
        holdIMG.setIcon(img);
        input = new JTextField();
        btnCheck = new JButton("Check Answer!");
        feedBack = new JLabel();
        feedBack.setForeground(Color.WHITE);


        //Layout Components
        this.setLayout(null);

        holdIMG.setBounds(100, 0, 200, 200);

        holdIMG.setBorder(BorderFactory.createLineBorder(Color.black));
        input.setBounds(100, 250, 200, 50);
        btnCheck.setBounds(100, 350, 150, 50);

        btnCheck.addActionListener(this);

        this.add(holdIMG);
        this.add(input);
        this.add(btnCheck);
    }

    private void answerDisplay(boolean correct){
        if(correct) {
            this.setBackground(Color.GREEN);
            feedBack.setText("Correct!");
        }
        else {
            this.setBackground(Color.RED);
            feedBack.setText("Incorrect");
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnCheck){
            System.out.println(input.getText());
            System.out.println(pq.getNounAnswer());
            if(input.getText().toLowerCase() != pq.getNounAnswer()){

              answerDisplay(false);
            }
            else{
               answerDisplay(true);
                questionCount++;

                if(questionCount != pqList.size()){

                }
            }
        }

    }
}

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
    //2 second delay for
    int elapsedTime = 3000;

    Timer timer = new Timer(1000, new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent e) {
         elapsedTime -= 1000;
         if(elapsedTime == 0){
             timer.stop();
         }
        }
    });

    QuestionPanel(User user, ArrayList<PracticeQuestion> questions, ChoicePanel choicePanel){
        pqList = questions;
        pq = pqList.get(questionCount);
        this.user = user;
        System.out.println(pq.getImgURL());
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
            timer.start();
            JOptionPane.showMessageDialog(null, "Correct");
            feedBack.setText("Correct!");
        }
        else {
            this.setBackground(Color.RED);
            feedBack.setText("Incorrect");
            timer.start();
        }
    }

    void getNextQuestion(){

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String answer;
        if(e.getSource() == btnCheck){
            answer = input.getText().toLowerCase();

            if(pq.getNounAnswer().equalsIgnoreCase(answer)){
                answerDisplay(true);
                questionCount++;
                timer.start();
            }
            else{
                answerDisplay(false);
            }
        }

    }
}

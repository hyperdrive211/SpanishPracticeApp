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
    int elapsedTime = 2000;
    Color bgColor = new Color(110,192,248);

    Timer timer = new Timer(1000, new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
         elapsedTime -= 1000;
            System.out.println(elapsedTime);
         if(elapsedTime == 0){
             getNextQuestion(questionCount);
             timer.stop();
         }
        }
    });

    QuestionPanel(User user, ArrayList<PracticeQuestion> questions, ChoicePanel choicePanel){
        pqList = questions;
        pq = pqList.get(questionCount);
        this.user = user;
        img = new ImageIcon(pq.getImgURL());
        holdIMG = new JLabel();
        holdIMG.setIcon(img);
        this.setBackground(bgColor);
        input = new JTextField();
        btnCheck = new JButton("Check Answer!");

        feedBack = new JLabel("");
        feedBack.setForeground(Color.WHITE);

        //Layout Components
        this.setLayout(null);

        holdIMG.setBounds(100, 20, 200, 200);

        holdIMG.setBorder(BorderFactory.createLineBorder(Color.black));
        input.setBounds(100, 250, 200, 50);
        feedBack.setBounds(100, 310, 150, 50);
        btnCheck.setBounds(100, 370, 150, 50);

        btnCheck.addActionListener(this);

        this.add(holdIMG);
        this.add(input);
        this.add(feedBack);
        this.add(btnCheck);
    }

    private void answerDisplay(boolean correct){
        if(correct) {
            elapsedTime = 2000;
            timer.start();
            this.setBackground(Color.green);
            feedBack.setText("Correct!");
        }
        else {
            this.setBackground(Color.RED);
            feedBack.setText("Incorrect");
            timer.start();
        }
    }

    void getNextQuestion(int questionCount){
        System.out.println(questionCount);
      if(questionCount == pqList.size()){
          //here we take the feedback screen
          System.out.println("You have reached the end.");
      }
      else{
          this.setBackground(bgColor);
          input.setText("");
          pq = pqList.get(questionCount);
          holdIMG.setIcon(new ImageIcon(pq.getImgURL()));
      }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String answer;
        if(e.getSource() == btnCheck){
            answer = input.getText().toLowerCase();
            System.out.println(pq.getNounAnswer());
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

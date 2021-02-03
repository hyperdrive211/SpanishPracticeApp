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
    //this is the question list that we take in from the the each of the lists
    ArrayList<PracticeQuestion> pqList = new ArrayList<PracticeQuestion>();

    //on each correct question answer this will be added to a new list for the display on the next screen.
    ArrayList<PracticeQuestion> returnPQList = new ArrayList<PracticeQuestion>();
    User user;
    ImageIcon img;
    JLabel holdIMG;
    JTextField input;
    JButton btnCheck;
    JLabel feedBack;
    String questionDef;
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

    QuestionPanel(User user, ArrayList<PracticeQuestion> questions, ChoicePanel choicePanel, String questionDef){
        this.questionDef = questionDef;
        pqList = questions;
        pq = pqList.get(questionCount);
        this.user = user;
        img = new ImageIcon(pq.getImgURL());
        holdIMG = new JLabel();
        holdIMG.setIcon(img);
        this.setBackground(bgColor);
        input = new JTextField();
        btnCheck = new JButton("Check Answer!");
        btnCheck.setBackground(Color.green);
        btnCheck.setForeground(Color.white);

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
        elapsedTime = 2000;
        if(correct) {
            timer.start();
            this.setBackground(Color.green);
            returnPQList.add(new PracticeQuestion(pq.getNounAnswer(), pq.getNounQuestion(), input.getText(), true));
            feedBack.setText("Correct!");
        }
        else {
            this.setBackground(Color.RED);
            feedBack.setText("Incorrect");
            timer.start();
        }
    }

    void reset(){
        this.setBackground(bgColor);
        feedBack.setText("");
        input.setText("");
    }

    void getNextQuestion(int questionCount){
        System.out.println(questionCount);
      if(questionCount == pqList.size()){
          //here we take the feedback screen
          System.out.println("You have reached the end.");


      }
      else{
          reset();
          pq = pqList.get(questionCount);
          holdIMG.setIcon(new ImageIcon(pq.getImgURL()));
      }
    }

    //At the end of the question list we will set the value and date of the last time the test was complete.
    //we will then update the list with the values and save the result.
    void endTask(){
        int score = 0;
        for(int i = 0; i < returnPQList.size(); i++){
            System.out.println(returnPQList.get(i).getNounAnswer());
            if(returnPQList.get(i).getCorrect()){
                score++;
            }
        }
        //use th switch to update the
        switch(questionDef){
            case "Clothing":
                user.setMarkClothing(score);
                break;
            default:
                break;
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

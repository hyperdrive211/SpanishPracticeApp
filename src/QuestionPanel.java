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
    UserMap userMap;
    User user;
    private ImageIcon img;
    private JLabel holdIMG;
    private JTextField input;
    private DisplayBtn btnCheck, btnSkip;
    private JPanel feedbackPanel;
    private JLabel feedBack;
    private String questionDef;
    private int questionCount = 0;
    //2 second delay for
    int elapsedTime = 2000;
    ChoicePanel choicePanel;
    private Design design = new Design();
    Timer timer = new Timer(1000, new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
         elapsedTime -= 1000;
         if(elapsedTime == 0){
             getNextQuestion();
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
        this.setBackground(design.bgColor);
        input = new JTextField();
        this.choicePanel = choicePanel;
        btnCheck = new DisplayBtn(design.success, 15, "Check Answer");
        btnCheck.addActionListener(this);

        btnSkip = new DisplayBtn(design.failure, 15, "Skip Question");
        btnSkip.addActionListener(this);

        feedBack = new JLabel("", JLabel.CENTER);
        feedBack.setFont(new Font(design.fontName,  Font.BOLD, 20));
        feedBack.setForeground(design.text);

        //Layout Components
        this.setLayout(null);

        holdIMG.setBounds(150, 20, 200, 200);

        holdIMG.setBorder(BorderFactory.createLineBorder(Color.black));
        input.setBounds(125, 250, 250, 50);
        feedbackPanel = new JPanel();
        feedbackPanel.setLayout(new BorderLayout());
        feedbackPanel.setBackground(design.bgColor);
        feedbackPanel.setBounds(125, 310, 250, 50);
        feedbackPanel.add(feedBack, BorderLayout.CENTER);

        btnCheck.setBounds(150, 370, 200, 50);

        btnSkip.setBounds(150, 430, 200, 50);
        btnSkip.setVisible(false);
        this.add(holdIMG); this.add(input);
        this.add(feedbackPanel); this.add(btnCheck); this.add(btnSkip);
    }

    private void answerDisplay(String context, String answer){
        elapsedTime = 2000;
        if(context.equals("Skipped!") || context.equals("Correct!")) {
            PracticeQuestion practiceQuestion = new PracticeQuestion(pq.getNounAnswer(), pq.getNounQuestion(), answer);
            if (context.equals("Skipped")) {
                practiceQuestion.setCorrect(false);
                feedbackPanel.setBackground(design.failure);
            } else{
                practiceQuestion.setCorrect(true);
                feedbackPanel.setBackground(design.success);
            }
            returnPQList.add(practiceQuestion);
            questionCount++;
        }
        else {
            feedbackPanel.setBackground(design.failure);
            btnSkip.setVisible(true);
        }
        btnCheck.setEnabled(false);
        feedBack.setText(context);
        timer.start();
    }

    void reset(){
        feedbackPanel.setBackground(design.bgColor);
        feedBack.setText("");
        input.setText("");
        btnCheck.setEnabled(true);
    }

    void getNextQuestion(){
      if(questionCount == pqList.size()){
            endTask();
            clearPanelAddSummary();
      }
      else{
          reset();
          pq = pqList.get(questionCount);
          holdIMG.setIcon(new ImageIcon(pq.getImgURL()));
          btnSkip.setVisible(false);
      }
      timer.stop();
    }

    //At the end of the question list we will set the value and date of the last time the test was complete.
    //we will then update the list with the values and save the result.
    void endTask(){
        int score = getScore();
        //once score and date have been set, send the user the results list and the score and date to the end screen
        userMap = new UserMap();
        updateScore(questionDef, user, score);
    }

     int getScore(){
        int score = 0;
        for(int i = 0; i < returnPQList.size(); i++){
            System.out.println(returnPQList.get(i).getNounAnswer());
            if(returnPQList.get(i).getCorrect()){
                score++;
            }
        }
        return score;
    }

    void updateScore(String question, User user, int score){
        //use th switch to update the score of the different sections
        switch(question){
            case "Clothing":
                user.setMarkClothing(score);
                break;

            default:
                break;
        }
    }

    void clearPanelAddSummary(){
        this.setVisible(false);
        System.out.println(getScore());
        SummaryPanel summaryPanel = new SummaryPanel(user, returnPQList, questionDef);
        choicePanel.add(summaryPanel);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String answer;
        answer = input.getText().toLowerCase();
        if(e.getSource() == btnCheck){
            if(pq.getNounAnswer().equalsIgnoreCase(answer)){
                answerDisplay("Correct!", answer);
            }
            else{
                answerDisplay("Incorrect!", answer);
            }
        }
        if(e.getSource() == btnSkip){
            answerDisplay("Skipped!", answer);
        }
    }
}

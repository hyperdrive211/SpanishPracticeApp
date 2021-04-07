import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created By Jonathon on 17/12/2020
 * Update Comments About Program Here
 **/
public class QuestionPanel extends JPanel implements ActionListener {
    PracticeQuestion pq;
    //this is the question list that we take in from the the each of the lists
    ArrayList<PracticeQuestion> pqList = new ArrayList<PracticeQuestion>();
    //on each correct question answer this will be added to a new list for the display on the next screen.
    ArrayList<PracticeQuestion> returnPQList = new ArrayList<PracticeQuestion>();
    UserMap userMap;
    User user;
    private ImageIcon img;
    private JLabel holdIMG;
    private JTextField input;
    private DisplayBtn btnCheck, btnSkip, btnExit;
    private JPanel feedbackPanel;
    private JLabel feedBack;
    private String questionDef;
    private int questionCount = 0;
    //2 second delay for
    int elapsedTime = 2000;
    ChoicePanel choicePanel;
    private Design design = new Design();
    private UserRecordList userRecordList = new UserRecordList();
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

        btnExit = new DisplayBtn(design.failure, 12, "Exit");
        btnExit.addActionListener(l -> exitToChoicePanel());
        btnExit.setBounds(370, 10, 100, 25);
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
        this.add(btnExit);
    }

    private void answerDisplay(String context, String answer){
        elapsedTime = 2000;
        if(context.equals("Skipped!") || context.equals("Correct!")) {
            PracticeQuestion practiceQuestion = new PracticeQuestion();
            practiceQuestion.setNounQuestion(pq.getNounQuestion());
            practiceQuestion.setNounAnswer(pq.getNounAnswer());
            practiceQuestion.setUserAnswer(answer);
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
        //once score and date have been set, send the user the results list and the score and date to the end screen
        UserRecord userRecord = new UserRecord(user.getUsername(), new Date(), questionDef, getScore());
        userRecordList.getData();
        userRecordList.addRecord(userRecord);
        userRecordList.saveData();
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


    void clearPanelAddSummary(){
        this.setVisible(false);
        SummaryPanel summaryPanel = new SummaryPanel(user, returnPQList, questionDef);
        choicePanel.btnPanel.setVisible(false);
        choicePanel.add(summaryPanel);
    }

    public void exitToChoicePanel(){
        int result = JOptionPane.showConfirmDialog(this,
                "If you exit you will lose your progress, sure you want to exit?", "Exit " + this.questionDef,
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            choicePanel.btnPanel.setVisible(true);
            choicePanel.remove(this);
        }
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

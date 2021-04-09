import javax.swing.*;
import java.awt.*;
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
    Design design = new Design();
    JLabel resultImage, userInfo, header, topicHeader, sectionHeader, scoreHeader, scoreLabel;
    JPanel leaderBoardPanel, resultsPanel, buttonPanel, historyPanel;
    JLabel [] eachAnswerResult, leaderBoard;
    DisplayBtn historyBtn, summaryButton, leaderBoardButton;
    String section;
    GridBagLayout gridBagLayout = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    UserRecordList userRecordList = new UserRecordList();
    ArrayList<UserRecord> userRecords = new ArrayList<UserRecord>();


    SummaryPanel(User user, ArrayList<PracticeQuestion> returnList, String section, int score){
        this.user = user;
        this.feedBackList = returnList;
        this.section = section;
        this.setBackground(design.bgColor);
        this.setLayout(null);
        userRecordList.getData();

        header = new JLabel("Result Summary", JLabel.CENTER);
        header.setFont(new Font(design.fontName, Font.BOLD, 20));
        header.setForeground(design.underLine);
        header.setBorder(BorderFactory.createMatteBorder(0,0,2,0,design.text));
        header.setBounds(75, 20, 350, 25);

        topicHeader = new JLabel("Topic: ", JLabel.LEFT);
        topicHeader.setFont(new Font(design.fontName, Font.BOLD, 17));
        topicHeader.setForeground(design.underLine);
        topicHeader.setBounds(75, 50, 60, 20);

        sectionHeader = new JLabel(section, JLabel.LEFT);
        sectionHeader.setFont(new Font(design.fontName, Font.BOLD, 17));
        sectionHeader.setForeground(design.text);
        sectionHeader.setBounds(130, 50, 90, 20);

        scoreHeader = new JLabel("Score: ", JLabel.LEFT);
        scoreHeader.setFont(new Font(design.fontName, Font.BOLD, 17));
        scoreHeader.setForeground(design.underLine);
        scoreHeader.setBounds(230, 50, 60, 20);

        scoreLabel = new JLabel(String.valueOf(score), JLabel.LEFT);
        scoreLabel.setFont(new Font(design.fontName, Font.BOLD, 17));
        scoreLabel.setForeground(design.text);
        scoreLabel.setBounds(290, 50, 50, 20);

        //Set the progress image with a correct/incorrect emoji!
        resultImage = new JLabel();
        eachAnswerResult = new JLabel [returnList.size()];
        resultsPanel = new JPanel();
        resultsPanel.setLayout(gridBagLayout);

        buttonPanel = new JPanel();
        buttonPanel.setBackground(design.bgColor);

        buttonPanel.setLayout(new GridLayout(1,3, 10,0));
        buttonPanel.setBounds(75, 410, 350, 30);

        summaryButton = new DisplayBtn(design.success, 9, "Summary");
        summaryButton.setEnabled(false);
        buttonPanel.add(summaryButton);
        summaryButton.addActionListener(this);

        historyBtn = new DisplayBtn(design.underLine, 9, " History");
        buttonPanel.add(historyBtn);
        historyBtn.addActionListener(this);

        leaderBoardButton = new DisplayBtn(design.underLine, 9, "Leader board");
        buttonPanel.add(leaderBoardButton);
        returnFeedBack(returnList);
        resultsPanel.setBounds(75, 90, 350, 300);
        resultsPanel.setBorder(BorderFactory.createLineBorder(design.underLine, 2));

        historyPanel = new JPanel();
        historyPanel.setLayout(new GridBagLayout());
        historyPanel.setBounds(75, 90, 350, 300);
        historyPanel.setBorder(BorderFactory.createLineBorder(design.underLine, 2));
        historyPanel.setVisible(false);
        setHistoryPanel();


        this.add(header); this.add(resultsPanel); this.add(header); this.add(topicHeader);
        this.add(sectionHeader); this.add(buttonPanel); this.add(historyPanel); this.add(scoreHeader);
        this.add(scoreLabel);
    }

    public void returnFeedBack(ArrayList<PracticeQuestion> fbList){
        gbc.insets = new Insets(0, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        for(int i = 0; i < fbList.size(); i++){
            System.out.println(fbList.get(i).toString());
            gbc.gridy = i;
            gbc.gridx = 0; gbc.gridwidth = 1;
            JLabel questionNumber = new JLabel(String.valueOf(i+1), JLabel.LEFT);
            resultsPanel.add(questionNumber, gbc);

            gbc.gridx = 2; gbc.gridwidth = 5;
            JLabel labelEnglish = new JLabel(fbList.get(i).getNounQuestion(), JLabel.LEFT);
            resultsPanel.add(labelEnglish, gbc);

            gbc.gridx = 7; gbc.gridwidth = 5;
            JLabel labelSpanish = new JLabel(fbList.get(i).getNounAnswer(), JLabel.LEFT);
            resultsPanel.add(labelSpanish, gbc);

            gbc.gridx= 12; gbc.gridwidth = 5;
            JLabel labelAnswer = new JLabel((!fbList.get(i).getUserAnswer().equals("")) ?
                    fbList.get(i).getUserAnswer() : "N/A", JLabel.LEFT);
            resultsPanel.add(labelAnswer, gbc);
        }
    }

    public void setHistoryPanel(){
        userRecords = userRecordList.getRecordByUsername(user.getUsername());
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0,5,5,0);

        for(int i  = 0; i < userRecords.size(); i++){
            System.out.println(userRecords.get(i).toString());
            gbc.gridy = i;
            JLabel dateComplete = new JLabel(userRecords.get(i).getDateCompleteString(), JLabel.LEFT);
            gbc.gridx = 0; gbc.gridwidth = 4;
            historyPanel.add(dateComplete, gbc);

            JLabel topic = new JLabel(userRecords.get(i).getTopic(), JLabel.LEFT);
            gbc.gridx = 4; gbc.gridwidth = 4;
            historyPanel.add(topic, gbc);

            JLabel score = new JLabel(String.valueOf(userRecords.get(i).getScore()), JLabel.LEFT);
            gbc.gridx = 8;  gbc.gridwidth = 4;
            historyPanel.add(score, gbc);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == historyBtn){
            resultsPanel.setVisible(false);
            historyPanel.setVisible(true);
            historyBtn.setBackground(design.success);
            historyBtn.setEnabled(false);
            summaryButton.setEnabled(true);
            summaryButton.setBackground(design.underLine);
        }
        if(e.getSource() == summaryButton){
            historyPanel.setVisible(true);
            resultsPanel.setVisible(false);
            summaryButton.setEnabled(false);
            summaryButton.setEnabled(true);
            summaryButton.setBackground(design.success);
        }

    }
}

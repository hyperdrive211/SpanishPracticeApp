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
    JLabel resultImage, userInfo, header, topicHeader, sectionHeader;
    JPanel leaderBoardPanel, resultsPanel, buttonPanel, historyPanel;
    JLabel [] eachAnswerResult, leaderBoard;
    DisplayBtn historyBtn, summaryButton, leaderBoardButton;
    String section;
    GridBagLayout gridBagLayout = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    UserRecordList userRecordList = new UserRecordList();
    ArrayList<UserRecord> userRecords = new ArrayList<UserRecord>();


    SummaryPanel(User user, ArrayList<PracticeQuestion> returnList, String section){
        this.user = user;
        this.feedBackList = returnList;
        this.section = section;
        this.setBackground(design.bgColor);
        this.setLayout(null);
        System.out.println(section);
        userRecordList.getData();

        header = new JLabel("Result Summary", JLabel.CENTER);
        header.setFont(new Font(design.fontName, Font.BOLD, 20));
        header.setForeground(design.underLine);
        header.setBorder(BorderFactory.createMatteBorder(0,0,2,0,design.text));
        header.setBounds(75, 20, 350, 25);

        topicHeader = new JLabel("Topic: ", JLabel.LEFT);
        topicHeader.setFont(new Font(design.fontName, Font.BOLD, 17));
        topicHeader.setForeground(design.underLine);
        topicHeader.setBounds(75, 50, 70, 20);

        sectionHeader = new JLabel(section, JLabel.LEFT);
        sectionHeader.setFont(new Font(design.fontName, Font.BOLD, 17));
        sectionHeader.setForeground(design.text);
        sectionHeader.setBounds(145, 50, 90, 20);

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

        historyBtn = new DisplayBtn(design.underLine, 9, " History");
        buttonPanel.add(historyBtn);

        leaderBoardButton = new DisplayBtn(design.underLine, 9, "Leader board");
        buttonPanel.add(leaderBoardButton);
        returnFeedBack(returnList, resultsPanel);
        resultsPanel.setBounds(75, 90, 350, 300);
        resultsPanel.setBorder(BorderFactory.createLineBorder(design.underLine, 2));
        this.add(header); this.add(resultsPanel); this.add(header); this.add(topicHeader);
        this.add(sectionHeader); this.add(buttonPanel);
    }

    public void returnFeedBack(ArrayList<PracticeQuestion> fbList, JPanel panel){
        gbc.insets = new Insets(0, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        for(int i = 0; i < fbList.size(); i++){
            System.out.println(fbList.get(i).toString());
            gbc.gridy = i; gbc.gridx = 0; gbc.gridwidth = 1;
            JLabel questionNumber = new JLabel(String.valueOf(i+1), JLabel.LEFT);
            resultsPanel.add(questionNumber, gbc);

            gbc.gridy = i; gbc.gridx = 2; gbc.gridwidth = 5;
            JLabel labelEnglish = new JLabel(fbList.get(i).getNounQuestion(), JLabel.LEFT);
            resultsPanel.add(labelEnglish, gbc);

            gbc.gridy= i; gbc.gridx = 7; gbc.gridwidth = 5;
            JLabel labelSpanish = new JLabel(fbList.get(i).getNounAnswer(), JLabel.LEFT);
            resultsPanel.add(labelSpanish, gbc);

            gbc.gridy = i; gbc.gridx= 12; gbc.gridwidth = 5;
            JLabel labelAnswer = new JLabel((!fbList.get(i).getUserAnswer().equals("")) ?
                    fbList.get(i).getUserAnswer() : "N/A", JLabel.LEFT);
            resultsPanel.add(labelAnswer, gbc);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

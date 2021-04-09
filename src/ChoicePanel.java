import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created By Jonathon on 21/12/2020
 * Update Comments About Program Here
 **/
public class ChoicePanel extends JPanel {
    BtnPanel btnPanel;
    InfoPanel infoPanel;
    User user;
    UserRecordList userRecordList;
    ArrayList<UserRecord> uList = new ArrayList<UserRecord>();

    ChoicePanel(User user){
        userRecordList = new UserRecordList();
        userRecordList.getData();
        uList = userRecordList.getUserRecords();
        for(UserRecord rec: uList){
            System.out.println(rec.toString());
        }
        this.user = user;
        this.setLayout(new BorderLayout(20, 0));
        infoPanel= new InfoPanel(user);
        btnPanel = new BtnPanel(this, user);
        this.add(infoPanel, BorderLayout.NORTH);
        this.add(btnPanel, BorderLayout.CENTER);
    }

}

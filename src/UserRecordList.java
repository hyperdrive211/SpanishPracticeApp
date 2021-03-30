import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * Created By Jonathon on 30/03/2021
 * Update Comments About Program Here
 **/
public class UserRecordList {
    private ArrayList<UserRecord> recordList = new ArrayList<UserRecord>();
    private String filename = "Records/UserRecords";


    public void getData(){
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);

            this.recordList = (ArrayList<UserRecord>) ois.readObject();
        } catch( IOException ioe){
            ioe.printStackTrace();
            return;
        } catch (ClassNotFoundException cnfe){
            cnfe.printStackTrace();
            return;
        }
    }

    public void addRecord(UserRecord record){
        this.recordList.add(record);
    }




    public ArrayList<UserRecord> getRecordByUsername(String username){
        ArrayList<UserRecord> recordByNameList = new ArrayList<UserRecord>();
        for(UserRecord rec : this.recordList){
            if(rec.getUsername().equals(username)){
                recordByNameList.add(rec);
            }
        }

        return recordByNameList;
    }

}

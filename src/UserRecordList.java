import java.io.*;
import java.util.ArrayList;
import java.util.Map;


/**
 * Created By Jonathon on 30/03/2021
 * Update Comments About Program Here
 **/
public class UserRecordList {
    private ArrayList<UserRecord> recordList = new ArrayList<UserRecord>();
    private String filename = "Records/UserRecords";

    UserRecordList(){

    }


    public void getData(){
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);

            this.recordList = (ArrayList<UserRecord>) ois.readObject();
        } catch( IOException | ClassNotFoundException ioe){
            ioe.printStackTrace();
            return;
        }
    }

    public ArrayList<UserRecord> getUserRecords(){
        return this.recordList;
    }

    public void saveData(){
        try{
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(this.recordList);
            oos.close();
            fos.close();
        } catch(IOException ioe){
            ioe.printStackTrace();
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

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created By Jonathon on 30/03/2021
 * Update Comments About Program Here
 **/
public class UserRecord {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    private String username,  topic;
    private Date dateComplete;
    private int score;

    UserRecord(){

    }

    UserRecord(String username, Date dateComplete, String topic, int score){
        this.username = username;
        this.dateComplete = dateComplete;
        this.topic = topic;
        this.score = score;
    }

    public String getUsername() {
        return username;
    }
    public String toString(){
        return String.format("%s %s %s %d", this.username, sdf.format(this.dateComplete), this.topic, this.score);
    }
}

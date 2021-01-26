import java.io.Serializable;
import java.util.Date;

/**
 * Created By Jonathon on 25/11/2020
 * Update Comments About Program Here
 **/
public class User implements Serializable {

    private static final long serialVersionUID = 3517273589099160013L;
    private String username;
    private String name;
    private String password;
    private int  markClothing, markBody, markTravel;
    private Date  dateClothingComplete, dateBodyComplete, dateTravelComplete;

    public User(){

    }

    public User(String username, String password, int mClothing,  int mBody, int markTravel){
        this.username = username;
        this.password = password;
        this.markClothing = mClothing;
        this.markBody = mBody;
        this.markTravel = markTravel;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

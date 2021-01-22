import java.util.Date;

/**
 * Created By Jonathon on 25/11/2020
 * Update Comments About Program Here
 **/
public class User {

    private String username;
    private String password;
    private int markClothing, markBody, markTravel;
    private Date dateClothingComplete, dateBodyComplete, dateTravelComplete;

    public User(){
        
    }

    public User(String username, int mClothing, int mBody, int markTravel){
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

    public int getNumberVerbsCorrect() {
        return numberVerbsCorrect;
    }

    public void setNumberVerbsCorrect(int numberVerbsCorrect) {
        this.numberVerbsCorrect = numberVerbsCorrect;
    }
}

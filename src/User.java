/**
 * Created By Jonathon on 25/11/2020
 * Update Comments About Program Here
 **/
public class User {

    private String username;
    private int numberVerbsCorrect;

    public User(String username, int numberVerbsCorrect){
        this.username = username;
        this.numberVerbsCorrect = 0;
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

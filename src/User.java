import java.io.Serializable;
import java.util.Date;

/**
 * Created By Jonathon on 25/11/2020
 * Update Comments About Program Here
 **/
public class User implements Serializable {

    private static final long serialVersionUID = 3517273589099160013L;
    private String username;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private String password;
    private int  markClothing, markBody, markTravel;
    private Date  dateClothingComplete, dateBodyComplete, dateTravelComplete;

    public User(){

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

    public void setMarkClothing(int mark){
        this.markClothing = mark;
    }

    public int getMarkClothing(){
        return this.markClothing;
    }

    public int getTotalScores(){
        return this.markBody + this.markTravel + this.markClothing;
    }

    //using this as a chance to practice method overloading by having several toString string methods
    //but with several parameters


}

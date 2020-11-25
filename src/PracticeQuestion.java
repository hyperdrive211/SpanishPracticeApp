/**
 * Created By Jonathon on 25/11/2020
 * Update Comments About Program Here
 **/
public class PracticeQuestion {
    private String verb;
    private String pastTense;
    private String futureTense;

    public PracticeQuestion(String verb, String pastTense, String futureTense){
        this.verb = verb;
        this.pastTense = pastTense;
        this.futureTense = futureTense;
    }

    public String getPastTense() {
        return pastTense;
    }

    public void setPastTense(String pastTense) {
        this.pastTense = pastTense;
    }

    public String getFutureTense() {
        return futureTense;
    }

    public void setFutureTense(String futureTense) {
        this.futureTense = futureTense;
    }

    public String getVerb() {
        return verb;
    }

    public void setVerb(String verb) {
        this.verb = verb;
    }
}

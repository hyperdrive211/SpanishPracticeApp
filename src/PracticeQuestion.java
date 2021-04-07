import java.lang.String.*;
/**
 * Created By Jonathon on 25/11/2020
 * Update Comments About Program Here
 **/
public class PracticeQuestion {
    private String imgURL, nounQuestion, nounAnswer, userAnswer, audioFileName;
    private boolean isCorrect;

    //Default constructor
    PracticeQuestion(){

    }

    PracticeQuestion(String url, String nounQ, String nounA){
        this.imgURL = url;
        this.nounQuestion = nounQ;
        this.nounAnswer = nounA;
    }

    public String getNounQuestion() {
        return nounQuestion;
    }

    public void setNounQuestion(String nounQuestion) {
        this.nounQuestion = nounQuestion;
    }

    public String getNounAnswer() {
        return nounAnswer;
    }

    public void setNounAnswer(String nounAnswer) {
        this.nounAnswer = nounAnswer;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public boolean getCorrect(){
        return this.isCorrect;
    }

    public void setCorrect(boolean correct){
        this.isCorrect = correct;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    public String getAudioFileName(){
        return this.audioFileName;
    }

    public void setAudioFileName(String audioFileName){
        this.audioFileName = audioFileName;
    }

    public String toString(){
        return String.format("Noun Question: %s\n Noun Answer: %s \nUser Answer: %s",
                this.nounQuestion, this.nounAnswer, this.userAnswer);
    }
}

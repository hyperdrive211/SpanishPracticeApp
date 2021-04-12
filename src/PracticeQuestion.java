import java.lang.String.*;
/**
 * Created By Jonathon on 25/11/2020
 * Update Comments About Program Here
 **/
public class PracticeQuestion {
    private String imgPath, nounQuestion, nounAnswer, userAnswer, audioFileName, audioPath;
    private boolean isCorrect;

    //Default constructor
    PracticeQuestion(){

    }

    PracticeQuestion(String imagePath, String nounQ, String nounA){
        this.imgPath = imagePath;
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

    public boolean getCorrect(){
        return this.isCorrect;
    }

    public void setCorrect(boolean correct){
        this.isCorrect = correct;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    public String getImgPath(){
        return this.imgPath;
    }
    public String toString(){
        return String.format("Noun Question: %s\n Noun Answer: %s \nUser Answer: %s",
                this.nounQuestion, this.nounAnswer, this.userAnswer);
    }
}

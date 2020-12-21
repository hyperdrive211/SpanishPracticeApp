/**
 * Created By Jonathon on 25/11/2020
 * Update Comments About Program Here
 **/
public class PracticeQuestion {
    private String imgURL;
    private String nounQuestion;
    private String nounAnswer;

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
}

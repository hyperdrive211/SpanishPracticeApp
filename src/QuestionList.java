import java.util.ArrayList;

/**
 * Created By Jonathon on 25/11/2020
 * Update Comments About Program Here
 **/
public class QuestionList {
    private ArrayList<PracticeQuestion> practiceQuestions;


    public QuestionList(){
    }

    public void setPracticeQuestions(ArrayList<PracticeQuestion> practiceQuestions) {
        practiceQuestions.add(new PracticeQuestion("Comer", "Comi", "Comera"));
        this.practiceQuestions = practiceQuestions;
    }

    public ArrayList<PracticeQuestion> getPracticeQuestions(){
        return this.practiceQuestions;
    }

}

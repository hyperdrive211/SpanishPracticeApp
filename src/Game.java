import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created By Jonathon on 25/11/2020
 * Update Comments About Program Here
 **/
public class Game {
    static PracticeQuestion question;
    static User user;
    static int score = 0;
    static Scanner input = new Scanner(System.in);
    public static void main(String [] args){

        ArrayList<PracticeQuestion> practiceQuestions = new ArrayList<PracticeQuestion>();
        practiceQuestions.add(new PracticeQuestion("Comer", "Comi", "Comera"));
        practiceQuestions.add(new PracticeQuestion("beber", "bebi", "bebera"));

        System.out.println("Please answer the following");
        System.out.println("What is the past tense and future tense of the following verb");
        for(int i = 0; i < practiceQuestions.size(); i++){
           PracticeQuestion pq;
           pq = practiceQuestions.get(i);
           displayQuestion(pq, i+1);
        }

        System.out.println("The score is as follows: " + score);

    }


    public static void displayQuestion(PracticeQuestion question, int questionNUmber){

        System.out.println(question.getVerb());
        System.out.print("Past tense: ");
        String pastTense = input.nextLine();
        System.out.print("Future Tense: ");
        String futureTense = input.nextLine();
        if(pastTense.toLowerCase().equals(question.getPastTense().toLowerCase())
                && futureTense.toLowerCase().equals(question.getFutureTense().toLowerCase())){
            System.out.println("Correct!");
            score++;
        }
        else {
            System.out.println("Not Correct!");
        }
    }
}

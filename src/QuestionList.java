import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created By Jonathon on 25/11/2020
 * Update Comments About Program Here
 **/
public class QuestionList {

    ArrayList<PracticeQuestion> clothing = new ArrayList<PracticeQuestion>();
    public ArrayList<PracticeQuestion> clothingList(){
      clothing.add(new PracticeQuestion("img/clothing/coat_200X200.jpg", "Coat", "Abrigo"));
      clothing.add(new PracticeQuestion("img/clothing/gloves_200x200.png", "Gloves", "Guantes"));
      return clothing;
    }

    public ArrayList<PracticeQuestion> furnitureList(){
      ArrayList<PracticeQuestion> furniture = new ArrayList<PracticeQuestion>();
      return furniture;
    }

    public ArrayList<PracticeQuestion> kitchList(){
      ArrayList<PracticeQuestion> kitchen = new ArrayList<PracticeQuestion>();
      return kitchen;
    }

    public ArrayList<PracticeQuestion> travelList(){
      ArrayList<PracticeQuestion> travel = new ArrayList<PracticeQuestion>();
      return travel;
    }

}

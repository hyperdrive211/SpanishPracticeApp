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
      clothing.add(new PracticeQuestion("img/clothing/shirt_200x200.jpg", "Shirt", "Camisa"));
      clothing.add(new PracticeQuestion("img/clothing/trousers_200x200.jpg", "Trousers", "Pantalones"));
      clothing.add(new PracticeQuestion("img/clothing/glasses_200x200.jpg", "Glasses", "Lentes"));
      clothing.add(new PracticeQuestion("img/clothing/hat_200x200.jpg", "Hat", "Sombrero"));
      clothing.add(new PracticeQuestion("img/clothing/t-shirt_200x200.png", "T-Shirt", "Camiseta"));
      clothing.add(new PracticeQuestion("img/clothing/tie_200x200.jpg", "Tie", "Corbatta"));
      clothing.add(new PracticeQuestion("img/clothing/shoes_200x200.jpeg", "Shoes", "Zapatoes"));
      clothing.add(new PracticeQuestion("img/clothing/skirt_200x200.jpeg", "Skirt", "Falda"));
      return clothing;
    }

    public ArrayList<PracticeQuestion> furnitureList(){
      ArrayList<PracticeQuestion> furniture = new ArrayList<PracticeQuestion>();
      return furniture;
    }

    public ArrayList<PracticeQuestion> kitchenList(){
      ArrayList<PracticeQuestion> kitchen = new ArrayList<PracticeQuestion>();
      return kitchen;
    }

    public ArrayList<PracticeQuestion> travelList(){
      ArrayList<PracticeQuestion> travel = new ArrayList<PracticeQuestion>();
      return travel;
    }

}

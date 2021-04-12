import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created By Jonathon on 25/11/2020
 * Update Comments About Program Here
 **/
public class QuestionList {


    public ArrayList<PracticeQuestion> clothingList(){
        ArrayList<PracticeQuestion> clothing = new ArrayList<PracticeQuestion>();
      clothing.add(new PracticeQuestion("img/clothing/coat_200X200.jpg", "Coat", "el abrigo"));
      clothing.add(new PracticeQuestion("img/clothing/gloves_200x200.png", "Gloves", "los guantes"));
      clothing.add(new PracticeQuestion("img/clothing/shirt_200x200.jpg", "Shirt", "la camisa"));
      clothing.add(new PracticeQuestion("img/clothing/trousers_200x200.jpg", "Trousers", "los pantalones"));
      clothing.add(new PracticeQuestion("img/clothing/glasses_200x200.jpg", "Glasses", "los lentes"));
      clothing.add(new PracticeQuestion("img/clothing/hat_200x200.jpg", "Hat", "el sombrero"));
      clothing.add(new PracticeQuestion("img/clothing/t-shirt_200x200.png", "T-Shirt", "la camiseta"));
      clothing.add(new PracticeQuestion("img/clothing/tie_200x200.jpg", "Tie", "la corbatta"));
      clothing.add(new PracticeQuestion("img/clothing/shoes_200x200.jpeg", "Shoes", "los zapatoes"));
      clothing.add(new PracticeQuestion("img/clothing/skirt_200x200.jpeg", "Skirt", "la falda"));
      return clothing;
    }

    public ArrayList<PracticeQuestion> furnitureList(){
      ArrayList<PracticeQuestion> furniture = new ArrayList<PracticeQuestion>();
      furniture.add(new PracticeQuestion("img/furniture/coffee-table-cartoon.jpg", "Table", "la mesa"));
      furniture.add(new PracticeQuestion("img/furniture/sofa-icon-cartoon.jpg", "Sofa", "el sofa"));
      furniture.add(new PracticeQuestion("img/furniture/cartoon-lamp.png", "Lamp", "la lampara"));
      furniture.add(new PracticeQuestion("img/furniture/bookcase-cartoon.jpg", "Bookshelf", "la estantaria"));
      furniture.add(new PracticeQuestion("img/furniture/cartoon_closet.jpg", "Closet", "el armario"));
      furniture.add(new PracticeQuestion("img/furniture/"))


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

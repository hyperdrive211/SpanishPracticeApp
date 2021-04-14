import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created By Jonathon on 25/11/2020
 * Update Comments About Program Here
 **/
public class QuestionList {


    public ArrayList<PracticeQuestion> clothingList(){
        ArrayList<PracticeQuestion> clothing = new ArrayList<PracticeQuestion>();
      clothing.add(new PracticeQuestion("img/clothing/coat.jpg", "Coat", "el abrigo"));
      clothing.add(new PracticeQuestion("img/clothing/gloves.png", "Gloves", "los guantes"));
      clothing.add(new PracticeQuestion("img/clothing/shirt.jpg", "Shirt", "la camisa"));
      clothing.add(new PracticeQuestion("img/clothing/trousers.jpg", "Trousers", "los pantalones"));
      clothing.add(new PracticeQuestion("img/clothing/glasses.jpg", "Glasses", "los lentes"));
      clothing.add(new PracticeQuestion("img/clothing/hat.jpg", "Hat", "el sombrero"));
      clothing.add(new PracticeQuestion("img/clothing/t-shirt.png", "T-Shirt", "la camiseta"));
      clothing.add(new PracticeQuestion("img/clothing/tie.jpg", "Tie", "la corbatta"));
      clothing.add(new PracticeQuestion("img/clothing/shoes.jpeg", "Shoes", "los zapatoes"));
      clothing.add(new PracticeQuestion("img/clothing/skirt.jpeg", "Skirt", "la falda"));
      return clothing;
    }

    public ArrayList<PracticeQuestion> furnitureList(){
      ArrayList<PracticeQuestion> furniture = new ArrayList<PracticeQuestion>();
      furniture.add(new PracticeQuestion("img/furniture/coffee-table-cartoon.jpg", "Table", "la mesa"));
      furniture.add(new PracticeQuestion("img/furniture/sofa-icon-cartoon.jpg", "Sofa", "el sofa"));
      furniture.add(new PracticeQuestion("img/furniture/cartoon-lamp.png", "Lamp", "la lampara"));
      furniture.add(new PracticeQuestion("img/furniture/bookcase-cartoon.jpg", "Bookshelf", "la estantaria"));
      furniture.add(new PracticeQuestion("img/furniture/cartoon_clock.jpg", "Clock", "el reloj"));
      furniture.add(new PracticeQuestion("img/furniture/cushions-cartoon.jpg", "Cushions", "los cojines"));
      furniture.add(new PracticeQuestion("img/furniture/curtains-cartoon.jpg", "Curtains", "las cortinas"));
      furniture.add(new PracticeQuestion("img/furniture/cartoon-desk.jpg", "Desk", "el escritorio"));
      furniture.add(new PracticeQuestion("img/furniture/cartoon-chair.png", "Chair", "la silla"));
      furniture.add(new PracticeQuestion("img/furniture/cartoon-tv.png", "Television", "la tele"));
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

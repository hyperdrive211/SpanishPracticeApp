import java.io.*;
import java.util.HashMap;

/**
 * Created By Jonathon on 22/01/2021
 * Update Comments About Program Here
 **/
public class UserMap {
    HashMap<String, User> userMap = new HashMap<String, User>();

    UserMap(){

    }
    public void getData(){
          try {

              FileInputStream fis = new FileInputStream("Users/UserData");
              ObjectInputStream ois = new ObjectInputStream(fis);

              this.userMap = (HashMap) ois.readObject();

              ois.close();
              fis.close();
          }
          catch(IOException ioe){
              ioe.printStackTrace();
              return;
          }
          catch(ClassNotFoundException c){
              System.out.println("Class not found");
              c.printStackTrace();
              return;
          }
    }

    public HashMap<String, User> getUserMap(){
        return this.userMap;
    }

    public void saveData(){
        System.out.println(this.userMap);
        try {
            
            FileOutputStream fos = new FileOutputStream("Users/UserData");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(this.userMap);
            oos.close();
            fos.close();
        }  catch(IOException ioe){
            ioe.printStackTrace();
        }
    }

    public void addUser(User u){
        this.userMap.put(u.getUsername(), u);
    }

    public User getUser(String username){
        return this.userMap.get(username);
    }

}

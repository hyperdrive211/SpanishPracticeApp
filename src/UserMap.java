import java.io.*;
import java.util.HashMap;

/**
 * Created By Jonathon on 22/01/2021
 * Update Comments About Program Here
 **/
public class UserMap {
    HashMap<String, User> userMap = new HashMap<String, User>();

    UserMap(HashMap<String, User> uMap){
        this.userMap = uMap;
    }
    public void getData(){
          try {

              FileInputStream fis = new FileInputStream("UserData");
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

    public void saveData(){
        try {
            FileOutputStream fos = new FileOutputStream("UserData");
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

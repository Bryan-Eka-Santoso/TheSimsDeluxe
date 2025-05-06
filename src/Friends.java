import java.util.*;

public class Friends {
    ArrayList<Sim> listFriends = new ArrayList<>();
    ArrayList<Integer> listFriendshipPoint = new ArrayList<>();
    ArrayList<String> listLevelFriends = new ArrayList<>();

    public Friends(Sim sim){

    }

    public void viewSimFriends(Sim sim){
        if(listFriends.size() == 0){
            System.out.println("No friends yet.");
        } else {
            for(int i = 0; i < listFriends.size(); i++){
                System.out.println("- " + listFriends.get(i).name + " (" + listLevelFriends.get(i) + ")");
            }
        }
    }
}

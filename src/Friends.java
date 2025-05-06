import java.util.*;

public class Friends {
    ArrayList<Sim> listFriends = new ArrayList<>();
    ArrayList<Integer> listFriendshipPoint = new ArrayList<>();
    ArrayList<String> listLevelFriends = new ArrayList<>();

    public Friends(Sim sim){

    }

    public void cekFriendShip(){
        for(int i = 0; i < listFriendshipPoint.size(); i++){
            if(listFriendshipPoint.get(i) >= 0){
                listLevelFriends.set(i, "Acquaintance");
            } else if(listFriendshipPoint.get(i) >= 50){
                listLevelFriends.set(i, "Friend");
            } else if(listFriendshipPoint.get(i) >= 75){
                listLevelFriends.set(i, "Good Friend");
            } else if(listFriendshipPoint.get(i) >= 100){
                listLevelFriends.set(i, "Best Friend");
            }
        }
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

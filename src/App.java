import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanI = new Scanner(System.in);
        Scanner scanS = new Scanner(System.in);
        Random rand = new Random();

        int menu1;
        char[][] mapSim = {
            {'+', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '+'},
            {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
            {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
            {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
            {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
            {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
            {'+', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '+'}
        };

        ArrayList<Sim> listWillowCreek = new ArrayList<>();
        ArrayList<Sim> listOasisSprings = new ArrayList<>();
        ArrayList<Sim> listNewcrest = new ArrayList<>();

        do {            
            System.out.println("+===================+");
            System.out.println("|  The Sims Deluxe  |");
            System.out.println("+===================+");
            System.out.println("| 1. Play           |");
            System.out.println("| 2. Exit           |");
            System.out.println("+===================+");
            do {                
                System.out.print(">> ");
                menu1 = scanI.nextInt();
            } while (menu1 < 1 || menu1 > 2);
            switch (menu1) {
                case 1:
                    int menu2;
                    do {                        
                        System.out.println("+============== SIMS ===============+");
                        System.out.println("|      NEIGHBORHOOD HOUSEHOLDS      |");
                        System.out.println("+-----------------------------------+");
                        System.out.println("| 1. Willow Creek - Residents: " + listWillowCreek.size() + "    |");
                        System.out.println("| 2. Oasis Springs - Residents: " + listOasisSprings.size() + "   |");
                        System.out.println("| 3. Newcrest - Residents: " + listNewcrest.size() + "        |");
                        System.out.println("+===================================+");
                        System.out.println("| 1. Create a Sim                   |");
                        System.out.println("| 2. Manage a Household             |");
                        System.out.println("| 3. Exit Game                      |");
                        System.out.println("+===================================+");
                        do {                            
                            System.out.print(">> ");
                            menu2 = scanI.nextInt();
                        } while (menu2 < 1 || menu2 > 3);
                        switch (menu2) {
                            case 1:
                                int menuHoousehold1;
                                System.out.println("+=================+");
                                System.out.println("Select a household:");
                                System.out.println("1. Willow Creek");
                                System.out.println("2. Oasis Springs");
                                System.out.println("3. Newcrest");
                                System.out.println("+=================+");
                                do {                                    
                                    System.out.print(">> ");
                                    menuHoousehold1 = scanI.nextInt();
                                } while (menuHoousehold1 < 1 || menuHoousehold1 > 3);

                                int pilih;
                                System.out.println("Choose Sim: ");
                                System.out.println("1. Human");
                                System.out.println("2. Vampire");
                                System.out.println("3. Alien");
                                System.out.print(">> ");
                                pilih = scanI.nextInt();
                                if(pilih == 1){
                                    String nama;
                                    Boolean isNotDup;
                                    if(menuHoousehold1 == 1){
                                        do {
                                            isNotDup = true;
                                            System.out.print("Enter the name your Human Sim: ");
                                            nama = scanS.nextLine();
                                            for(int i = 0; i < listWillowCreek.size(); i++){
                                                if(listWillowCreek.get(i).name.equals(nama)){
                                                    isNotDup = false;
                                                    break;
                                                }
                                            }
                                        } while (!isNotDup);
                                        listWillowCreek.add(new HumanSim(nama, "Human", "Fine", 50, 50));
                                        System.out.println(nama + " joined the Willow Creek Household.");
                                        System.out.println(nama + " feels fine.");
                                        } else if(menuHoousehold1 == 2){
                                        do {
                                            isNotDup = true;
                                            System.out.print("Enter the name your Human Sim: ");
                                            nama = scanS.nextLine();
                                            for(int i = 0; i < listOasisSprings.size(); i++){
                                                if(listOasisSprings.get(i).name.equals(nama)){
                                                    isNotDup = false;
                                                    break;
                                                }
                                            }
                                        } while (!isNotDup);
                                        listOasisSprings.add(new HumanSim(nama, "Human", "Fine", 50, 50));
                                        System.out.println(nama + " joined the Oasis Springs Household.");
                                        System.out.println(nama + " feels fine.");
                                    } else {
                                        do {
                                            isNotDup = true;
                                            System.out.print("Enter the name your Human Sim: ");
                                            nama = scanS.nextLine();
                                            for(int i = 0; i < listNewcrest.size(); i++){
                                                if(listNewcrest.get(i).name.equals(nama)){
                                                    isNotDup = false;
                                                    break;
                                                }
                                            }
                                        } while (!isNotDup);
                                        listNewcrest.add(new HumanSim(nama, "Human", "Fine", 50, 50));
                                        System.out.println(nama + " joined the Newcrest Household.");
                                        System.out.println(nama + " feels fine.");
                                    }
                                } else if(pilih == 2){
                                    String nama;
                                    Boolean isNotDup;
                                    if(menuHoousehold1 == 1){
                                        do {
                                            isNotDup = true;
                                            System.out.print("Enter the name your Vampire Sim: ");
                                            nama = scanS.nextLine();
                                            for(int i = 0; i < listWillowCreek.size(); i++){
                                                if(listWillowCreek.get(i).name.equals(nama)){
                                                    isNotDup = false;
                                                    break;
                                                }
                                            }
                                        } while (!isNotDup);
                                        listWillowCreek.add(new VampireSim(nama, "Vampire", "Fine", 50, 50));
                                        System.out.println(nama + " joined the Willow Creek Household.");
                                        System.out.println(nama + " feels fine.");
                                    } else if(menuHoousehold1 == 2){
                                        do {
                                            isNotDup = true;
                                            System.out.print("Enter the name your Vampire Sim: ");
                                            nama = scanS.nextLine();
                                            for(int i = 0; i < listOasisSprings.size(); i++){
                                                if(listOasisSprings.get(i).name.equals(nama)){
                                                    isNotDup = false;
                                                    break;
                                                }
                                            }
                                        } while (!isNotDup);
                                        listOasisSprings.add(new VampireSim(nama, "Vampire", "Fine", 50, 50));
                                        System.out.println(nama + " joined the Oasis Springs Household.");
                                        System.out.println(nama + " feels fine.");
                                    } else {
                                        do {
                                            isNotDup = true;
                                            System.out.print("Enter the name your Vampire Sim: ");
                                            nama = scanS.nextLine();
                                            for(int i = 0; i < listNewcrest.size(); i++){
                                                if(listNewcrest.get(i).name.equals(nama)){
                                                    isNotDup = false;
                                                    break;
                                                }
                                            }
                                        } while (!isNotDup);
                                        listNewcrest.add(new VampireSim(nama, "Vampire", "Fine", 50, 50));
                                        System.out.println(nama + " joined the Newcrest Household.");
                                        System.out.println(nama + " feels fine.");
                                    }
                                } else if (pilih == 3) {
                                    String nama;
                                    Boolean isNotDup;
                                    if(menuHoousehold1 == 1){
                                        do {
                                            isNotDup = true;
                                            System.out.print("Enter the name your Alien Sim: ");
                                            nama = scanS.nextLine();
                                            for(int i = 0; i < listWillowCreek.size(); i++){
                                                if(listWillowCreek.get(i).name.equals(nama)){
                                                    isNotDup = false;
                                                    break;
                                                }
                                            }
                                        } while (!isNotDup);
                                        listWillowCreek.add(new AlienSim(nama, "Alien", "Fine", 50, 50));
                                        System.out.println(nama + " joined the Willow Creek Household.");
                                        System.out.println(nama + " feels fine.");
                                    } else if(menuHoousehold1 == 2){
                                        do {
                                            isNotDup = true;
                                            System.out.print("Enter the name your Alien Sim: ");
                                            nama = scanS.nextLine();
                                            for(int i = 0; i < listOasisSprings.size(); i++){
                                                if(listOasisSprings.get(i).name.equals(nama)){
                                                    isNotDup = false;
                                                    break;
                                                }
                                            }
                                        } while (!isNotDup);
                                        listOasisSprings.add(new AlienSim(nama, "Alien", "Fine", 50, 50));
                                        System.out.println(nama + " joined the Oasis Springs Household.");
                                        System.out.println(nama + " feels fine.");
                                    } else {
                                        do {
                                            isNotDup = true;
                                            System.out.print("Enter the name your Alien Sim: ");
                                            nama = scanS.nextLine();
                                            for(int i = 0; i < listNewcrest.size(); i++){
                                                if(listNewcrest.get(i).name.equals(nama)){
                                                    isNotDup = false;
                                                    break;
                                                }
                                            }
                                        } while (!isNotDup);
                                        listNewcrest.add(new AlienSim(nama, "Alien", "Fine", 50, 50));
                                        System.out.println(nama + " joined the Newcrest Household.");
                                        System.out.println(nama + " feels fine.");
                                    }
                                }
                                break;
                            case 2:
                                int menuHoousehold2;
                                System.out.println("+=================+");
                                System.out.println("Select a household:");
                                System.out.println("1. Willow Creek");
                                System.out.println("2. Oasis Springs");
                                System.out.println("3. Newcrest");
                                System.out.println("+=================+");
                                do {                                    
                                    System.out.print(">> ");
                                    menuHoousehold2 = scanI.nextInt();
                                } while (menuHoousehold2 < 1 || menuHoousehold2 > 3);

                                switch (menuHoousehold2) {
                                    case 1:
                                        int menuWillow;
                                        do {                                            
                                            System.out.println("+======================+");
                                            System.out.println("WILLOW CREEK            ");
                                            System.out.println("+======================+");
                                            if(listWillowCreek.size() <= 0){
                                                System.out.println("Residents: 0");
                                                System.out.println("- No residents");
                                            } else {
                                                System.out.println("Residents: " + listWillowCreek.size());
                                                for(int i = 0; i < listWillowCreek.size(); i++){
                                                    System.out.println("- " + listWillowCreek.get(i).name + " | " + listWillowCreek.get(i).jenis);
                                                }
                                            }
                                            System.out.println("+======================+");
                                            System.out.println("| 1. See Sim Details   |");
                                            System.out.println("| 2. View Map          |");
                                            System.out.println("| 0. Exit              |");
                                            System.out.println("+======================+");
                                            do {
                                                
                                                System.out.print(">> ");
                                                menuWillow = scanI.nextInt();
                                            } while (menuWillow < 0 || menuWillow > 2);

                                            switch (menuWillow) {
                                                case 1:
                                                    int selectViewDetails;
                                                    System.out.println("Select a Sim to View Details: ");
                                                    for(int i = 0; i < listWillowCreek.size(); i++){
                                                        System.out.println((i + 1) + ". " + listWillowCreek.get(i).name);
                                                    }
                                                    do {                                                        
                                                        System.out.print(">> ");
                                                        selectViewDetails = scanI.nextInt();
                                                    } while (selectViewDetails < 1 || selectViewDetails > listWillowCreek.size());
                                                    System.out.println("+=====================+");
                                                    System.out.println("Name: " + listWillowCreek.get(selectViewDetails-1).name);
                                                    System.out.println("Type: " + listWillowCreek.get(selectViewDetails-1).jenis);
                                                    System.out.println("+---------------------+");
                                                    System.out.println("Energy: " + listWillowCreek.get(selectViewDetails-1).energy);
                                                    System.out.println("Hunger: " + listWillowCreek.get(selectViewDetails-1).hunger);
                                                    System.out.println("Mood: " + listWillowCreek.get(selectViewDetails-1).mood);
                                                    System.out.println("+---------------------+");
                                                    System.out.println("Skills: ");
                                                    listWillowCreek.get(selectViewDetails-1).viewSkills();
                                                    System.out.println("+---------------------+");
                                                    System.out.println("Friends: ");
                                                    listWillowCreek.get(selectViewDetails-1).viewFriends();
                                                    System.out.println("+=====================+");
                                                    break;
                                                case 2:
                                                    int selectControl;
                                                    int[] ySim = new int[listWillowCreek.size()];
                                                    int[] xSim = new int[listWillowCreek.size()];                                                    
                                                    System.out.println("Select a Sim to control: ");
                                                    for(int i = 0; i < listWillowCreek.size(); i++){
                                                        System.out.println((i + 1) + ". " + listWillowCreek.get(i).name);
                                                    }
                                                    do {                                                        
                                                        System.out.print(">> ");
                                                        selectControl = scanI.nextInt();
                                                    } while (selectControl < 1 || selectControl > listWillowCreek.size());
                                                    char[][] currentMap = new char[7][15];
                                                    for(int i = 0; i < mapSim.length; i++){
                                                        for(int j = 0; j < mapSim[0].length; j++){
                                                            currentMap[i][j] = mapSim[i][j];
                                                        }
                                                    }
                                                    String inputPlay;
                                                    for(int i = 0; i < listWillowCreek.size(); i++){
                                                        int randY, randX;
                                                        Boolean isKosong = false;
                                                        do {
                                                            randY = rand.nextInt(5) + 1;
                                                            randX = rand.nextInt(13) + 1;

                                                            if(currentMap[randY][randX] == ' '){
                                                                isKosong = true;
                                                            }
                                                        } while (!isKosong);
                                                        ySim[i] = randY;
                                                        xSim[i] = randX;
                                                        currentMap[ySim[i]][xSim[i]] = '.';
                                                    }
                                                    do {
                                                        for(int i = 0; i < listWillowCreek.size(); i++){
                                                            currentMap[ySim[i]][xSim[i]] = listWillowCreek.get(i).name.charAt(0);
                                                        }
                                                        for(int i = 0; i < currentMap.length; i++){
                                                            for(int j = 0; j < currentMap[0].length; j++){
                                                                System.out.print(currentMap[i][j]);
                                                            }
                                                            System.out.println();
                                                        }
                                                        System.out.println("Moving " + listWillowCreek.get(selectControl-1).name + "...");
                                                        System.out.println("[wasd] - Move Sim");
                                                        System.out.println("[e] - Eat");
                                                        System.out.println("[l] - Sleep");
                                                        System.out.println("[i] - Learn New Skill");
                                                        if(listWillowCreek.get(selectControl-1) instanceof VampireSim){
                                                            System.out.println("[r] - Drink Blood");
                                                        }
                                                        System.out.println("[x] - Exit View Map");
                                                        System.out.print(">> ");
                                                        inputPlay = scanS.nextLine();
                                                        if(inputPlay.equals("w") && currentMap[ySim[selectControl-1]-1][xSim[selectControl-1]] == ' '){
                                                            currentMap[ySim[selectControl-1]][xSim[selectControl-1]] = ' ';
                                                            ySim[selectControl-1]--;
                                                        } else if(inputPlay.equals("a") && currentMap[ySim[selectControl-1]][xSim[selectControl-1]-1] == ' '){
                                                            currentMap[ySim[selectControl-1]][xSim[selectControl-1]] = ' ';
                                                            xSim[selectControl-1]--;
                                                        } else if(inputPlay.equals("s") && currentMap[ySim[selectControl-1]+1][xSim[selectControl-1]] == ' '){
                                                            currentMap[ySim[selectControl-1]][xSim[selectControl-1]] = ' ';
                                                            ySim[selectControl-1]++;
                                                        } else if(inputPlay.equals("d") && currentMap[ySim[selectControl-1]][xSim[selectControl-1]+1] == ' '){
                                                            currentMap[ySim[selectControl-1]][xSim[selectControl-1]] = ' ';
                                                            xSim[selectControl-1]++;
                                                        } else if(inputPlay.equals("e")){
                                                            listWillowCreek.get(selectControl-1).eat();
                                                        } else if(inputPlay.equals("l")){
                                                            listWillowCreek.get(selectControl-1).sleep();
                                                        } else if(inputPlay.equals("i")){
                                                            int chooseSkill;
                                                            System.out.println("Choose a skill to enhance: ");
                                                            System.out.println("1. Cooking Skill");
                                                            System.out.println("2. Logic Skill");
                                                            System.out.println("3. Charisma Skill");
                                                            do {                                                                
                                                                System.out.print(">> ");
                                                                chooseSkill = scanI.nextInt();
                                                            } while (chooseSkill < 1 || chooseSkill > 3);
                                                            switch (chooseSkill) {
                                                                case 1:
                                                                    listWillowCreek.get(selectControl-1).cooking();
                                                                    break;
                                                                case 2:
                                                                    listWillowCreek.get(selectControl-1).logic();
                                                                    break;
                                                                case 3:
                                                                    listWillowCreek.get(selectControl-1).charisma();
                                                                    break;
                                                                default:
                                                                    break;
                                                            }
                                                        } else if(listWillowCreek.get(selectControl-1) instanceof VampireSim && inputPlay.equals("r")){
                                                            ((VampireSim) listWillowCreek.get(selectControl-1)).drink();
                                                        }
                                                    } while (!inputPlay.equals("x"));
                                                    break;
                                                default:
                                                    break;
                                            }
                                            switch (menuWillow) {
                                                case 1:
                                                    // 
                                                    break;
                                                case 2:
                                                    // 
                                                    break;
                                                default:
                                                    break;
                                            }
                                            } while (menuWillow != 0);
                                        break;
                                    case 2:
                                    int menuOasis;
                                    do {                                            
                                        System.out.println("+======================+");
                                        System.out.println("OASIS SPRINGS           ");
                                        System.out.println("+======================+");
                                        if(listOasisSprings.size() <= 0){
                                            System.out.println("Residents: 0");
                                            System.out.println("- No residents");
                                        } else {
                                            System.out.println("Residents: " + listOasisSprings.size());
                                            for(int i = 0; i < listOasisSprings.size(); i++){
                                                System.out.println("- " + listOasisSprings.get(i).name + " | " + listOasisSprings.get(i).jenis);
                                            }
                                        }
                                        System.out.println("+======================+");
                                        System.out.println("| 1. See Sim Details   |");
                                        System.out.println("| 2. View Map          |");
                                        System.out.println("| 0. Exit              |");
                                        System.out.println("+======================+");
                                        do {
                                            
                                            System.out.print(">> ");
                                            menuOasis = scanI.nextInt();
                                        } while (menuOasis < 0 || menuOasis > 2);

                                        switch (menuOasis) {
                                            case 1:
                                                // 
                                                break;
                                            case 2:
                                                // 
                                                break;
                                            default:
                                                break;
                                        }
                                        } while (menuOasis != 0);
                                        break;
                                    case 3:
                                    int menuNewcrest;
                                    do {                                            
                                        System.out.println("+======================+");
                                        System.out.println("NEWCREST                ");
                                        System.out.println("+======================+");
                                        if(listNewcrest.size() <= 0){
                                            System.out.println("Residents: 0");
                                            System.out.println("- No residents");
                                        } else {
                                            System.out.println("Residents: " + listNewcrest.size());
                                            for(int i = 0; i < listNewcrest.size(); i++){
                                                System.out.println("- " + listNewcrest.get(i).name + " | " + listNewcrest.get(i).jenis);
                                            }
                                        }
                                        System.out.println("+======================+");
                                        System.out.println("| 1. See Sim Details   |");
                                        System.out.println("| 2. View Map          |");
                                        System.out.println("| 0. Exit              |");
                                        System.out.println("+======================+");
                                        do {
                                            System.out.print(">> ");
                                            menuNewcrest = scanI.nextInt();
                                        } while (menuNewcrest < 0 || menuNewcrest > 2);

                                        switch (menuNewcrest) {
                                            case 1:
                                                // 
                                                break;
                                            case 2:
                                                // 
                                                break;
                                            default:
                                                break;
                                        }
                                        } while (menuNewcrest != 0);
                                        break;
                                    default:
                                        break;
                                }
                                break;
                            default:
                                break;
                        }
                    } while (menu2 != 3);
                    break;
                default:
                    break;
            }
        } while (menu1 != 2);
    }
}

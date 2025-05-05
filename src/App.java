import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanI = new Scanner(System.in);
        Scanner scanS = new Scanner(System.in);

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
                                    System.out.print(">>");
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
                                    System.out.print("Enter the name: ");
                                    nama = scanS.nextLine();
                                    if(menuHoousehold1 == 1){
                                        listWillowCreek.add(new HumanSim(nama, "Human", "Fine", 50, 50, 0, 0));
                                        System.out.println(nama + " joined the Willow Creek Household.");
                                        System.out.println(nama + " feels fine.");
                                    } else if(menuHoousehold1 == 2){
                                        listOasisSprings.add(new HumanSim(nama, "Human", "Fine", 50, 50, 0, 0));
                                        System.out.println(nama + " joined the Oasis Springs Household.");
                                        System.out.println(nama + " feels fine.");
                                    } else {
                                        listNewcrest.add(new HumanSim(nama, "Human", "Fine", 50, 50, 0, 0));
                                        System.out.println(nama + " joined the Newcrest Household.");
                                        System.out.println(nama + " feels fine.");
                                    }
                                } else if(pilih == 2){
                                    String nama;
                                    System.out.print("Enter the name: ");
                                    nama = scanS.nextLine();
                                    if(menuHoousehold1 == 1){
                                        listWillowCreek.add(new VampireSim(nama, "Vampire", "Fine", 50, 50, 0, 0));
                                        System.out.println(nama + " joined the Willow Creek Household.");
                                        System.out.println(nama + " feels fine.");
                                    } else if(menuHoousehold1 == 2){
                                        listOasisSprings.add(new VampireSim(nama, "Vampire", "Fine", 50, 50, 0, 0));
                                        System.out.println(nama + " joined the Oasis Springs Household.");
                                        System.out.println(nama + " feels fine.");
                                    } else {
                                        listNewcrest.add(new VampireSim(nama, "Vampire", "Fine", 50, 50, 0, 0));
                                        System.out.println(nama + " joined the Newcrest Household.");
                                        System.out.println(nama + " feels fine.");
                                    }
                                } else if (pilih == 3) {
                                    String nama;
                                    System.out.print("Enter the name: ");
                                    nama = scanS.nextLine();
                                    if(menuHoousehold1 == 1){
                                        listWillowCreek.add(new AlienSim(nama, "Alien", "Fine", 50, 50, 0, 0));
                                        System.out.println(nama + " joined the Willow Creek Household.");
                                        System.out.println(nama + " feels fine.");
                                    } else if(menuHoousehold1 == 2){
                                        listOasisSprings.add(new AlienSim(nama, "Alien", "Fine", 50, 50, 0, 0));
                                        System.out.println(nama + " joined the Oasis Springs Household.");
                                        System.out.println(nama + " feels fine.");
                                    } else {
                                        listNewcrest.add(new AlienSim(nama, "Alien", "Fine", 50, 50, 0, 0));
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
                                    System.out.print(">>");
                                    menuHoousehold2 = scanI.nextInt();
                                } while (menuHoousehold2 < 1 || menuHoousehold2 > 3);

                                switch (menuHoousehold2) {
                                    case 1:
                                        int menuWillow;
                                        do {                                            
                                            System.out.println("+======================+");
                                            System.out.println("WILLOW CREEK            ");
                                            System.out.println("+======================+");
                                            System.out.println("Residents: 0");
                                            System.out.println("- No residents");
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
                                                    
                                                    break;
                                                case 2:
                                                    
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
                                        System.out.println("Residents: 0");
                                        System.out.println("- No residents");
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
                                                
                                                break;
                                            case 2:
                                                
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
                                        System.out.println("Residents: 0");
                                        System.out.println("- No residents");
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
                                                
                                                break;
                                            case 2:
                                                
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

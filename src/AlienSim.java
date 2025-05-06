import java.util.*;

public class AlienSim extends Sim {
    Random rand = new Random();

    public AlienSim(String name, String jenis, String mood, int energy, int hunger){
        super(name, jenis, mood, energy, hunger);
    }

    @Override
    public void viewSkills() {
        this.skills.viewSimSkills(this);
    } 

    @Override
    public void viewFriends(){
        this.friends.viewSimFriends(this);
    }

    @Override
    public void interact(Sim sim){
        int minEnergySim = 0;
        int minEnergyThis = 0;
        if(sim instanceof AlienSim){
            minEnergySim = 10;
        } else {
            minEnergySim = 20;
        }
        if(sim instanceof HumanSim){
            minEnergyThis = 30;
        } else if(sim instanceof VampireSim){
            minEnergyThis = 20;
        } else {
            minEnergyThis = 10;
        }
        if(this.energy - minEnergyThis < 0 || sim.energy - minEnergySim < 0){
            System.out.println("Failed interact.");
        } else {
            int thisFriendship = this.friends.listFriends.indexOf(sim);
            int simFriendship = sim.friends.listFriends.indexOf(this);
    
            if(thisFriendship == -1){
                this.friends.listFriends.add(sim);
                this.friends.listFriendshipPoint.add(0);
                this.friends.listLevelFriends.add("Acquaintance");
    
                sim.friends.listFriends.add(this);
                sim.friends.listFriendshipPoint.add(0);
                sim.friends.listLevelFriends.add("Acquaintance");
    
                thisFriendship = this.friends.listFriends.size() - 1;
                simFriendship = sim.friends.listFriends.size() - 1;
            }
    
            int getPoint1 = this.friends.listFriendshipPoint.get(thisFriendship) + 10 + (this.skills.levelSkill[2] * 2);
    
            if (sim instanceof HumanSim) {
                sim.energy -= 20 - this.skills.levelSkill[1];
                this.energy -= 30 - sim.skills.levelSkill[1];
                sim.mood = "Happy";
                this.mood = "Curious";
                System.out.println(this.name + " and " + sim.name + " interacted.");
                System.out.println(this.name + " interacts with " + sim.name + " and feels " + this.mood + ".");
                System.out.println(this.name + " is curious about human behavior");
                System.out.println(sim.name + " interacts with " + this.name + " and feels " + sim.mood + ".");
                System.out.println(sim.name + " friendship points increased by " + getPoint1);
            } else if (sim instanceof VampireSim) {
                sim.energy -= 20 - this.skills.levelSkill[1];
                this.energy -= 20 - sim.skills.levelSkill[1];
                sim.mood = "Happy";
                this.mood = "Intrigued";
                System.out.println(this.name + " and " + sim.name + " interacted.");
                System.out.println(this.name + " interacts with " + sim.name + " and feels " + this.mood + ".");
                System.out.println(this.name + " is intrigued by the vampire's abilities.");
                System.out.println(sim.name + " interacts with " + this.name + " and feels " + sim.mood + ".");
                System.out.println(sim.name + " friendship points increased by " + getPoint1);
            } else if (sim instanceof AlienSim) {
                this.energy -= 10 - this.skills.levelSkill[1];
                sim.energy -= 10 - sim.skills.levelSkill[1];
                this.mood = "Happy";
                sim.mood = "Happy";
                System.out.println(this.name + " and " + sim.name + " interacted.");
                System.out.println(this.name + " interacts with " + sim.name + " and feels " + this.mood + ".");
                System.out.println(this.name + " is happy to see another alien.");
                System.out.println(sim.name + " interacts with " + this.name + " and feels " + sim.mood + ".");
                System.out.println(sim.name + " is happy to see another alien.");
                System.out.println(sim.name + " friendship points increased by " + getPoint1);
            }
    
            this.friends.listFriendshipPoint.set(thisFriendship, getPoint1);
            sim.friends.listFriendshipPoint.set(simFriendship, getPoint1);
    
            this.friends.cekFriendShip();
        }
    }

    @Override
    public void eat() {
        if (this.hunger + 20 <= 50) {
            this.hunger += 20 + (this.skills.levelSkill[0] * 2);
            this.mood = "Satisfied";
            System.out.println(this.name + " eats.");
            System.out.println(this.name + " now has a hunger level of " + this.hunger + ".");
        } else {
            System.out.println(this.name + " is not hungry enough to eat. Failed to eat.");
        }
    }

    @Override
    public void sleep() {
        if (this.energy < 50) {
            this.energy = 50;
            this.hunger -= 30;
            if (this.hunger < 0) this.hunger = 0;
            this.mood = "Rested";
            System.out.println(this.name + " sleeps in a spaceship to recharge energy.");
            System.out.println(this.name + " now has energy: " + this.energy + " and hunger: " + this.hunger + ".");
        } else {
            System.out.println(this.name + " is not tired enough to sleep.");
        }
    }

    public void cooking(){
        int getRand = this.rand.nextInt(2);
        if(getRand == 0){
            this.skills.levelSkill[0] += 0;
            this.mood = "Confused";
            System.out.println(this.name + " tries a new recipe and feels confused.");
        } else {
            this.skills.levelSkill[0] += 2;
            this.mood = "Inspired";
            System.out.println(this.name + " blends strange ingredients and feels inspired.");
        }
    }

    public void logic(){
        if(!this.mood.equals("Focused")){
            this.skills.levelSkill[1] += 2;
            System.out.println(this.name + " deciphers complex patterns and feels focused.");
        } else {
            this.skills.levelSkill[1] += 3;
            System.out.println(this.name + " deciphers complex patterns and feels focused.");
            System.out.println(this.name + "'s interstellar brain lights up.");
        }
        this.mood = "Focused";
    }

    public void charisma(){
        if(this.friends.listFriends.size() >= 2){
            this.skills.levelSkill[2] += 2;
            System.out.println(this.name + " observes human interaction and trains charisma");
            System.out.println(this.name + " learns something new about human behavior.");
        } else {
            this.skills.levelSkill[2] += 1;
            System.out.println(this.name + " observes human interaction and trains charisma");
        }
        this.mood = "Curious";
    }
}

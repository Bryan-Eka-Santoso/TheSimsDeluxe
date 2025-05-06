import java.util.*;
public class AlienSim extends Sim {
    Random rand = new Random();
    public AlienSim(String name, String jenis, String mood, int energy, int hunger){
        super(name, jenis, mood, energy, hunger);
    }
    
    @Override
    public void viewSkills() {
        skills.viewSimSkills(this);
    } 
    @Override
    public void viewFriends(){
        friends.viewSimFriends(this);
    }
    @Override
    public void interact(Sim sim){
        if (sim instanceof HumanSim) {
            sim.energy -= 20 - skills.levelSkill[1];
            this.energy -= 30 - sim.skills.levelSkill[1];
            sim.mood = "Happy";
            this.mood = "Curious";
            System.out.println(this.name + " and " + sim.name + " interacted.");
            System.out.println(this.name + " interacts with " + sim.name + " and feels " + this.mood + ".");
            System.out.println(this.name + " is curious about human behavior");
            System.out.println(sim.name + " interacts with " + this.name + " and feels " + sim.mood + ".");
        } else if (sim instanceof VampireSim) {
            sim.energy -= 20 - skills.levelSkill[1];
            this.energy -= 20 - sim.skills.levelSkill[1];
            sim.mood = "Happy";
            this.mood = "Intrigued";
            System.out.println(this.name + " and " + sim.name + " interacted.");
            System.out.println(this.name + " interacts with " + sim.name + " and feels " + this.mood + ".");
            System.out.println(this.name + " is intrigued by the vampire's abilities.");
            System.out.println(sim.name + " interacts with " + this.name + " and feels " + sim.mood + ".");
        } else if (sim instanceof AlienSim) {
            this.energy -= 10 - skills.levelSkill[1];
            sim.energy -= 10 - sim.skills.levelSkill[1];
            this.mood = "Happy";
            sim.mood = "Happy";
            System.out.println(this.name + " and " + sim.name + " interacted.");
            System.out.println(this.name + " interacts with " + sim.name + " and feels " + this.mood + ".");
            System.out.println(this.name + " is happy to see another alien.");
            System.out.println(sim.name + " interacts with " + this.name + " and feels " + sim.mood + ".");
            System.out.println(sim.name + " is happy to see another alien.");
        }        
    };
    @Override
    public void eat() {
        if (this.hunger + 20 <= 50) {
            this.hunger += 20;
            this.hunger += skills.levelSkill[0] * 2;
            this.mood = "Satisfied";
            System.out.println(name + " eats.");
            System.out.println(name + " now has a hunger level of " + hunger + ".");
        } else {
            System.out.println(name + " is not hungry enough to eat. Failed to eat.");
        }
    }
    
    @Override
    public void sleep() {
        if (this.energy < 50) {
            this.energy = 50;
            this.hunger -= 30;
            if (this.hunger < 0) this.hunger = 0;
            this.mood = "Rested";
            System.out.println(name + " sleeps in a spaceship to recharge energy.");
            System.out.println(name + " now has energy: " + energy + " and hunger: " + hunger + ".");
        } else {
            System.out.println(name + " is not tired enough to sleep.");
        }
    }
    public void cooking(){
        int getRand = rand.nextInt(2);

        if(getRand == 0){
            skills.levelSkill[0] += 0;
            this.mood = "Confused";
            System.out.println(this.name + " tries a new recipe and feels confused.");
        } else {
            skills.levelSkill[0] += 2;
            this.mood = "Inspired";
            System.out.println(this.name + " blends strange ingredients and feels inspired.");
        }
    };
    public void logic(){
        if(this.mood != "Focused"){
            skills.levelSkill[1] += 2;
            System.out.println(this.name + " deciphers complex patterns and feels focused.");
        } else {
            skills.levelSkill[1] += 3;
            System.out.println(this.name + " deciphers complex patterns and feels focused.");
            System.out.println(this.name + "'s interstellar brain lights up.");
        }
        this.mood = "Focused";
    };
    public void charisma(){
        if(friends.listFriends.size() >= 2){
            skills.levelSkill[2] += 2;
            System.out.println(this.name + " observes human interaction and trains charisma");
            System.out.println(this.name + " learns something new about human behavior.");
        } else {
            skills.levelSkill[2] += 1;
            System.out.println(this.name + " observes human interaction and trains charisma");
        }
        this.mood = "Corious";
    };
}
public class VampireSim extends Sim {
    int thirst;
    public VampireSim(String name, String jenis, String mood, int energy, int hunger){
        super(name, jenis, mood, energy, hunger);
        this.thirst = 40;
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
            this.energy -= 20 - skills.levelSkill[1];
            sim.energy -= 20 - sim.skills.levelSkill[1];
            this.mood = "Happy";
            sim.mood = "Happy";
            System.out.println(this.name + " and " + sim.name + " interacted.");
            System.out.println(this.name + " interacts with " + sim.name + " and feels " + this.mood + ".");
            System.out.println(sim.name + " interacts with " + this.name + " and feels " + sim.mood + ".");
        } else if (sim instanceof VampireSim) {
            this.energy -= 20 - skills.levelSkill[1];
            sim.energy -= 20 - sim.skills.levelSkill[1];
            this.mood = "Happy";
            sim.mood = "Happy";
            System.out.println(this.name + " and " + sim.name + " interacted.");
            System.out.println(this.name + " interacts with " + sim.name + " and feels " + this.mood + ".");
            System.out.println(sim.name + " interacts with " + this.name + " and feels " + sim.mood + ".");
        } else if (sim instanceof AlienSim) {
            this.energy -= 20 - skills.levelSkill[1];
            sim.energy -= 20 - sim.skills.levelSkill[1];
            this.mood = "Happy";
            sim.mood = "Intrigued";
            System.out.println(this.name + " and " + sim.name + " interacted.");
            System.out.println(this.name + " interacts with " + sim.name + " and feels " + this.mood + ".");
            System.out.println(sim.name + " interacts with " + this.name + " and feels " + sim.mood + ".");
            System.out.println(sim.name + " is intrigued by the vampire's abilities.");
        }          
    };
    @Override
    public void eat() {
        if (hunger <= 50 && thirst >= 20) {
            hunger += 20;
            this.hunger += skills.levelSkill[0] * 2;
            thirst -= 20;
            this.mood = "Thirsty";
            System.out.println(name + " eats and starts to feel thirsty.");
            System.out.println(name + " now has a hunger level of " + hunger + " and thirst level of " + thirst + ".");
        } else {
            System.out.println(name + " failed to eat. Hunger or thirst levels are not suitable.");
        }
    }

    @Override
    public void sleep() {
        if (energy < 50) {
            this.energy = 50;
            this.hunger -= 30;
            this.thirst -= 30;
            this.mood = "Rested";

            if (hunger < 0) hunger = 0;
            if (thirst < 0) thirst = 0;

            System.out.println(name + " sleeps in a coffin to recharge energy.");
            System.out.println(name + " now has energy: " + energy + ", hunger: " + hunger + ", thirst: " + thirst + ".");
        } else {
            System.out.println(name + " is not tired enough to sleep.");
        }
    }

    public void drink() {
        if (thirst < 50) {
            int increaseAmount = Math.min(30, 50 - thirst);
            thirst += increaseAmount;
            this.mood = "Satisfied";
            System.out.println(name + " drinks blood and now has a thirst level of " + thirst + ".");
        } else {
            System.out.println(name + " is not thirsty right now. Failed to drink.");
        }
    }

    public void cooking(){
        if(this.mood != "Uncomfortable"){
            skills.levelSkill[0] += 1;
        }
        this.mood = "Uncomfortable";
        System.out.println(this.name + " reluctantly practices cooking and feels uncomfortable.");
    };
    public void logic(){
        if(this.hunger < 30){
            skills.levelSkill[1] += 2;
            System.out.println(this.name + " studies ancient knowledge and feels focused.");
            System.out.println(this.name + "'s thirst fuels their intellect.");
        } else {
            skills.levelSkill[1] += 1;
            System.out.println(this.name + " studies ancient knowledge and feels focused.");
        }
        this.mood = "Focused";
    };
    public void charisma(){
        skills.levelSkill[2] += 2;
        this.mood = "Confident";
        System.out.println(this.name + " charms everyone effortlessly and feels confident.");
    };
}
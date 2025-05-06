public class HumanSim extends Sim {
    public HumanSim(String name, String jenis, String mood, int energy, int hunger){
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
        if(this.energy - 20 < 0){
            System.out.println("Failed interact.");
        } else {
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
                sim.energy -= 30 - sim.skills.levelSkill[1];
                this.mood = "Happy";
                sim.mood = "Curious";
                System.out.println(this.name + " and " + sim.name + " interacted.");
                System.out.println(this.name + " interacts with " + sim.name + " and feels " + this.mood + ".");
                System.out.println(sim.name + " interacts with " + this.name + " and feels " + sim.mood + ".");
                System.out.println(sim.name + " is curious about human behavior.");
            }            
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
            System.out.println(name + " sleeps in a bed to recharge energy.");
            System.out.println(name + " now has energy: " + energy + " and hunger: " + hunger + ".");
        } else {
            System.out.println(name + " is not tired enough to sleep.");
        }
    }
    public void cooking(){
        if(this.mood != "Inspired"){
            skills.levelSkill[0] += 1;
            System.out.println(this.name + " learns to cook and feels inspired.");
        } else {
            skills.levelSkill[0] += 2;
            System.out.println(this.name + " learns to cook and feels inspired.");
            System.out.println(this.name + " feels creative in the kitchen.");
        }
        this.mood = "Inspired";
    };
    public void logic(){
        if(this.mood != "Focused"){
            skills.levelSkill[1] += 1;
            System.out.println(this.name + " learns to solve problems and feels focused.");
        } else {
            skills.levelSkill[1] += 2;
            System.out.println(this.name + " learns to solve problems and feels focused.");
            System.out.println(this.name + "'s mind sharpens with every challenge.");
        }
        this.mood = "Focused";
    };
    public void charisma(){
        if(this.mood != "Inspired"){
            skills.levelSkill[2] += 1;
            System.out.println(this.name + " trains their charisma skill and feels confident");
        } else {
            skills.levelSkill[2] += 2;
            System.out.println(this.name + " trains their charisma skill and feels confident");
            System.out.println(this.name + " shines brightly in social situations.");
        }
        this.mood = "Confident";
    };
    
}
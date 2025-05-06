public class HumanSim extends Sim {

    public HumanSim(String name, String jenis, String mood, int energy, int hunger){
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
        int minEnergy = 0;
        if(sim instanceof AlienSim){
            minEnergy = 30;
        } else {
            minEnergy = 20;
        }
        if(this.energy - 20 < 0 && sim.energy - minEnergy < 0){
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
                this.energy -= 20 - this.skills.levelSkill[1];
                sim.energy -= 20 - sim.skills.levelSkill[1];
                this.mood = "Happy";
                sim.mood = "Happy";
                System.out.println(this.name + " and " + sim.name + " interacted.");
                System.out.println(this.name + " interacts with " + sim.name + " and feels " + this.mood + ".");
                System.out.println(sim.name + " interacts with " + this.name + " and feels " + sim.mood + ".");
                System.out.println(sim.name + " friendship points increased by " + getPoint1);
            } else if (sim instanceof VampireSim) {
                this.energy -= 20 - this.skills.levelSkill[1];
                sim.energy -= 20 - sim.skills.levelSkill[1];
                this.mood = "Happy";
                sim.mood = "Happy";
                System.out.println(this.name + " and " + sim.name + " interacted.");
                System.out.println(this.name + " interacts with " + sim.name + " and feels " + this.mood + ".");
                System.out.println(sim.name + " interacts with " + this.name + " and feels " + sim.mood + ".");
                System.out.println(sim.name + " friendship points increased by " + getPoint1);
            } else if (sim instanceof AlienSim) {
                this.energy -= 20 - this.skills.levelSkill[1];
                sim.energy -= 30 - sim.skills.levelSkill[1];
                this.mood = "Happy";
                sim.mood = "Curious";
                System.out.println(this.name + " and " + sim.name + " interacted.");
                System.out.println(this.name + " interacts with " + sim.name + " and feels " + this.mood + ".");
                System.out.println(sim.name + " interacts with " + this.name + " and feels " + sim.mood + ".");
                System.out.println(sim.name + " is curious about human behavior.");
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
            this.hunger += 20;
            this.hunger += this.skills.levelSkill[0] * 2;
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
            System.out.println(this.name + " sleeps in a bed to recharge energy.");
            System.out.println(this.name + " now has energy: " + this.energy + " and hunger: " + this.hunger + ".");
        } else {
            System.out.println(this.name + " is not tired enough to sleep.");
        }
    }

    public void cooking(){
        if(this.mood != "Inspired"){
            this.skills.levelSkill[0] += 1;
            System.out.println(this.name + " learns to cook and feels inspired.");
        } else {
            this.skills.levelSkill[0] += 2;
            System.out.println(this.name + " learns to cook and feels inspired.");
            System.out.println(this.name + " feels creative in the kitchen.");
        }
        this.mood = "Inspired";
    }

    public void logic(){
        if(this.mood != "Focused"){
            this.skills.levelSkill[1] += 1;
            System.out.println(this.name + " learns to solve problems and feels focused.");
        } else {
            this.skills.levelSkill[1] += 2;
            System.out.println(this.name + " learns to solve problems and feels focused.");
            System.out.println(this.name + "'s mind sharpens with every challenge.");
        }
        this.mood = "Focused";
    }

    public void charisma(){
        if(this.mood != "Inspired"){
            this.skills.levelSkill[2] += 1;
            System.out.println(this.name + " trains their charisma skill and feels confident");
        } else {
            this.skills.levelSkill[2] += 2;
            System.out.println(this.name + " trains their charisma skill and feels confident");
            System.out.println(this.name + " shines brightly in social situations.");
        }
        this.mood = "Confident";
    }
}

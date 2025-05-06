public class VampireSim extends Sim {
    int thirst;

    public VampireSim(String name, String jenis, String mood, int energy, int hunger){
        super(name, jenis, mood, energy, hunger);
        this.thirst = 40;
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
        if(this.energy - 20 < 0 && sim.energy - 20 < 0){
            System.out.println("Failed interact. Energy is not enough!");
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
                sim.energy -= 20 - sim.skills.levelSkill[1];
                this.mood = "Happy";
                sim.mood = "Intrigued";
                System.out.println(this.name + " and " + sim.name + " interacted.");
                System.out.println(this.name + " interacts with " + sim.name + " and feels " + this.mood + ".");
                System.out.println(sim.name + " interacts with " + this.name + " and feels " + sim.mood + ".");
                System.out.println(sim.name + " is intrigued by the vampire's abilities.");
                System.out.println(sim.name + " friendship points increased by " + getPoint1);
            }

            this.friends.listFriendshipPoint.set(thisFriendship, getPoint1);
            sim.friends.listFriendshipPoint.set(simFriendship, getPoint1);
    
            this.friends.cekFriendShip();
        }
    }

    @Override
    public void eat() {
        if (this.hunger <= 50 && this.thirst >= 20) {
            this.hunger += 20;
            this.hunger += this.skills.levelSkill[0] * 2;
            this.thirst -= 20;
            this.mood = "Thirsty";
            System.out.println(this.name + " eats and starts to feel thirsty.");
            System.out.println(this.name + " now has a hunger level of " + this.hunger + " and thirst level of " + this.thirst + ".");
        } else {
            System.out.println(this.name + " failed to eat. Hunger or thirst levels are not suitable.");
        }
    }

    @Override
    public void sleep() {
        if (this.energy < 50) {
            this.energy = 50;
            this.hunger -= 30;
            this.thirst -= 30;
            this.mood = "Rested";

            if (this.hunger < 0) this.hunger = 0;
            if (this.thirst < 0) this.thirst = 0;

            System.out.println(this.name + " sleeps in a coffin to recharge energy.");
            System.out.println(this.name + " now has energy: " + this.energy + ", hunger: " + this.hunger + ", thirst: " + this.thirst + ".");
        } else {
            System.out.println(this.name + " is not tired enough to sleep.");
        }
    }

    public void drink() {
        if (this.thirst < 50) {
            int increaseAmount = 30;
            if (this.thirst + increaseAmount > 50) {
                increaseAmount = 50 - this.thirst;
            }
            this.thirst += increaseAmount;
            this.mood = "Satisfied";
            System.out.println(this.name + " drinks blood and now has a thirst level of " + this.thirst + ".");
        } else {
            System.out.println(this.name + " is not thirsty right now. Failed to drink.");
        }
    }

    public void cooking(){
        if(this.mood != "Uncomfortable"){
            this.skills.levelSkill[0] += 1;
        }
        this.mood = "Uncomfortable";
        System.out.println(this.name + " reluctantly practices cooking and feels uncomfortable.");
    }

    public void logic(){
        if(this.hunger < 30){
            this.skills.levelSkill[1] += 2;
            System.out.println(this.name + " studies ancient knowledge and feels focused.");
            System.out.println(this.name + "'s thirst fuels their intellect.");
        } else {
            this.skills.levelSkill[1] += 1;
            System.out.println(this.name + " studies ancient knowledge and feels focused.");
        }
        this.mood = "Focused";
    }

    public void charisma(){
        this.skills.levelSkill[2] += 2;
        this.mood = "Confident";
        System.out.println(this.name + " charms everyone effortlessly and feels confident.");
    }
}

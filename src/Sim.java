public abstract class Sim implements SimAction {
    String name;
    String jenis;
    String mood;
    int energy;
    int hunger;
    Skills skills;
    Friends friends;
    
    public Sim(String name, String jenis, String mood, int energy, int hunger) {
        this.name = name;
        this.jenis = jenis;
        this.mood = mood;
        this.energy = energy;
        this.hunger = hunger;
        this.skills = new Skills(this);
        this.friends = new Friends(this);
    }

    public void viewSkills() {
        skills.viewSimSkills(this);
    }

    public void viewFriends(){
        friends.viewSimFriends(this);
    }
}
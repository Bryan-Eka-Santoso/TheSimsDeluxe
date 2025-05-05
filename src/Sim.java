public abstract class Sim implements SimAction {
    String name;
    String jenis;
    String mood;
    int energy;
    int hunger;
    int skills;
    int friends;
    
    public Sim(String name, String jenis, String mood, int energy, int hunger, int skills, int friends) {
        this.name = name;
        this.jenis = jenis;
        this.mood = mood;
        this.energy = energy;
        this.hunger = hunger;
        this.skills = skills;
        this.friends = friends;
    }
}
public class Skills {
    String[] listSkill = {"Cooking Skill", "Logic Skill", "Charisma Skill"};
    int[] levelSkill = {0, 0, 0};

    public Skills(Sim sim){

    }

    public void viewSimSkills(Sim sim){
        int ctr = 0;
        for(int i = 0; i < 3; i++){
            if(levelSkill[i] == 0){
                ctr++;
            }
        }
        if(ctr != 3){
            for(int i = 0; i < 3; i++){
                System.out.println("- " + listSkill[i] + " (" + levelSkill[i] + "/10)");
            }
        } else {
            System.out.println("No skills yet.");
        }
    }
}

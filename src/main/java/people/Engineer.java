package people;

public abstract class Engineer {

    private int skill;

    public Engineer(int skill) {
        this.skill = skill;
    }

    public int getSkill() {
        return skill;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }
}

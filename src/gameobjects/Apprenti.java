package gameobjects;

public class Apprenti extends Thing {

    private Level level; // CB- room or the level the apprenti is at present
    public Apprenti(String aName, String aDescription, Level aLevel) {
        super(aName, aDescription);  //CB- init super class
        this.level = aLevel;

    }

    public void setLevel(Level aLevel) {

        this.level = aLevel;
    }

    public Level getLevel() {

        return this.level;
    }
}

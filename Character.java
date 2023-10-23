
public class Character {
    private String name;
    private int str;
    private int dex;
    private int intel;
    private int playerLevel;
    private int experienceBar;
    private Spell[] spells;

    public Character(String name, int str, int dex, int intel, Spell[] spells) {
        this.name = name;
        this.str = str;
        this.dex = dex;
        this.intel = intel;
        this.playerLevel = 1;
        this.experienceBar = 0;
        this.spells = spells;
    }

    public void levelUp() {
        playerLevel++;
    }

    public String getName() {
        return name;
    }

    public Spell[] getSpells() {
        return spells;
    }

    public int getStr() {
        return str;
    }

    public int getDex() {
        return dex;
    }

    public int getIntel() {
        return intel;
    }
}
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Spell[] warriorSpells = {
                new Spell("Fireball", 10, 10),
                new Spell("Wind Slice", 15, 10)
        };

        Character[] characters = {
                new Character("Warrior", 15, 5, 5, warriorSpells),
                new Character("Wizard", 5, 5, 15, null), // Wizards have no spells for now
                new Character("Rogue", 10, 15, 5, null) // Rogues have no spells for now
        };

        Enemy enemy = new Enemy("Boss", 20, 10, 10);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a character:");
        for (int i = 0; i < characters.length; i++) {
            System.out.println((i + 1) + ". " + characters[i].getName());
        }

        int choice = scanner.nextInt();
        if (choice >= 1 && choice <= characters.length) {
            Character selectedCharacter = characters[choice - 1];
            System.out.println("You've selected " + selectedCharacter.getName());

            System.out.println("Fight or quit? (1. Fight, 2. Quit):");
            int choice2 = scanner.nextInt();

            if (choice2 == 1) {
                System.out.println("You've encountered " + enemy.getName() + ". Stat: "
                        + enemy.getStat("str") + " " + enemy.getStat("dex") + " " + enemy.getStat("intel"));
                System.out.println("Your stats: " + selectedCharacter.getStr() + " " +
                        selectedCharacter.getDex() + " " + selectedCharacter.getIntel());

                if (selectedCharacter.getSpells() != null) {
                    System.out.println("Select a spell:");
                    Spell[] spells = selectedCharacter.getSpells();
                    for (int i = 0; i < spells.length; i++) {
                        System.out.println((i + 1) + ". " + spells[i].getName());
                    }

                    int spellChoice = scanner.nextInt();
                    if (spellChoice >= 1 && spellChoice <= spells.length) {
                        Spell selectedSpell = spells[spellChoice - 1];
                        System.out.println("You've cast " + selectedSpell.getName());
                        // Implement battle logic, including enemy's health reduction.
                    } else {
                        System.out.println("Invalid spell choice.");
                    }
                } else {
                    System.out.println("You have no spells.");
                }
            } else if (choice2 == 2) {
                System.out.println("You've quit the game.");
            } else {
                System.out.println("Invalid choice.");
            }
        } else {
            System.out.println("Invalid character choice.");
        }
    }
}

class Character {
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

class Spell {
    private String name;
    private int damage;
    private int energyCost;

    public Spell(String name, int damage, int energyCost) {
        this.name = name;
        this.damage = damage;
        this.energyCost = energyCost;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getEnergyCost() {
        return energyCost;
    }
}

class Enemy {
    private String name;
    private int str;
    private int dex;
    private int intel;

    public Enemy(String name, int str, int dex, int intel) {
        this.name = name;
        this.str = str;
        this.dex = dex;
        this.intel = intel;
    }

    public String getName() {
        return name;
    }

    public int getStat(String statName) {
        switch (statName) {
            case "str":
                return str;
            case "dex":
                return dex;
            case "intel":
                return intel;
            default:
                throw new IllegalArgumentException("Invalid stat name: " + statName);
        }
    }
}

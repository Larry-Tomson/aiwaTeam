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

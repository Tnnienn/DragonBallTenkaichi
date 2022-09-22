package it.develhope.dragonball.entities.attacks;

public class Makankosappo implements Attack {

    private final String name;
        private final int strength;
    private final double successRate;

    public Makankosappo() {
        this.name = "Makankosappo";
        this.strength = 150;
        this.successRate = 0.4;
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public double getSuccessRate() {
        return successRate;
    }

}

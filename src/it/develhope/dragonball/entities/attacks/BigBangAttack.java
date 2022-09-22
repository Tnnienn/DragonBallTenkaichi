package it.develhope.dragonball.entities.attacks;

public class BigBangAttack implements Attack {

    private final String name;
        private final int strength;
    private final double successRate;

    public BigBangAttack() {
        this.name = "Big Bang Attack";
        this.strength = 110;
        this.successRate = 0.8;
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

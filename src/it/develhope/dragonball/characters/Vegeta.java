package it.develhope.dragonball.characters;

import it.develhope.dragonball.attacks.*;

public class Vegeta extends Character{

    public Vegeta() {
        this.name = "Vegeta";
        this.race = Races.Sayan;
        this.lifePoint = 850;
        this.defenceRate = 0.5;
        this.dodgeRate = 0.6;
        this.strength = 85;
        this.attackList.add(new PhysicalAttack(this.strength, this.dodgeRate));
        this.attackList.add(new BigBangAttack());
        this.attackList.add(new GalickCannon());
        this.attackList.add(new FinalFlash());
    }
}

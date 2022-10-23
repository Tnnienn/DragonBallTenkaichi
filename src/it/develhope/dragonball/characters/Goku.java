package it.develhope.dragonball.characters;

import it.develhope.dragonball.attacks.Genkidama;
import it.develhope.dragonball.attacks.Kaioken;
import it.develhope.dragonball.attacks.Kamehameha;
import it.develhope.dragonball.attacks.PhysicalAttack;

public class Goku extends Character{

    public Goku() {
        this.name = "Goku";
        this.race = Races.Sayan;
        this.lifePoint = 900;
        this.defenceRate = 0.4;
        this.dodgeRate = 0.7;
        this.strength = 90;
        this.attackList.add(new PhysicalAttack(this.strength, this.dodgeRate));
        this.attackList.add(new Kamehameha());
        this.attackList.add(new Kaioken());
        this.attackList.add(new Genkidama());
    }
}

package it.develhope.dragonball.characters;

import it.develhope.dragonball.attacks.*;

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
        this.attackList.add(new Taioken());
    }
}

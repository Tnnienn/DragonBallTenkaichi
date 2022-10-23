package it.develhope.dragonball.characters;

import it.develhope.dragonball.attacks.*;

public class Gohan extends Character{

    public Gohan() {
        this.name = "Gohan";
        this.race = Races.Sayan;
        this.lifePoint = 800;
        this.defenceRate = 0.55;
        this.dodgeRate = 0.65;
        this.strength = 85;
        this.attackList.add(new PhysicalAttack(this.strength, this.dodgeRate));
        this.attackList.add(new Kamehameha());
        this.attackList.add(new Masenko());
        this.attackList.add(new Taioken());
    }
}

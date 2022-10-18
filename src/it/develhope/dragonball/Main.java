package it.develhope.dragonball;

import it.develhope.dragonball.entities.Races;
import it.develhope.dragonball.entities.attacks.*;
import it.develhope.dragonball.entities.Character;
import it.develhope.dragonball.entities.Combat;

public class Main {

    public static void main(String[] args) throws RuntimeException{
        Character goku = new Character("Goku", Races.Sayan, 1000, 100, 0.3, 0.7);
        goku.getAttackList().add(new Kaioken());
        goku.getAttackList().add(new Kamehameha());
        goku.getAttackList().add(new Genkidama());
        goku.getAttackList().add(new Taioken());

        Character vegeta = new Character("Vegeta", Races.Sayan, 999, 99, 0.31, 0.69);
        vegeta.getAttackList().add(new Kaioken());
        vegeta.getAttackList().add(new Kamehameha());
        vegeta.getAttackList().add(new Genkidama());
        vegeta.getAttackList().add(new BigBangAttack());

        Character piccolo = new Character("Piccolo", Races.Nameccian, 870, 85, 0.4, 0.65);
        piccolo.getAttackList().add(new Kaioken());
        piccolo.getAttackList().add(new Makankosappo());
        piccolo.getAttackList().add(new Taioken());
        piccolo.getAttackList().add(new BigBangAttack());

        Character krilin = new Character("Krilin", Races.Human, 600, 60, 0.50, 0.55);
        krilin.getAttackList().add(new Kaioken());
        krilin.getAttackList().add(new Kamehameha());
        krilin.getAttackList().add(new Genkidama());
        krilin.getAttackList().add(new Taioken());

        Combat combat1 = new Combat(goku, vegeta, "results/goku-vegeta.txt");
        Combat combat2 = new Combat(goku, krilin, "results/goku-krilin.txt");
        Combat combat3 = new Combat(goku, piccolo, "results/goku-piccolo.txt");
        Combat combat4 = new Combat(vegeta, piccolo, "results/vegeta-piccolo.txt");
        Combat combat5 = new Combat(vegeta, krilin, "results/vegeta-krilin.txt");
        Combat combat6 = new Combat(piccolo, krilin, "results/piccolo-krilin.txt");

        new Thread(combat1::fight).start();
        new Thread(combat2::fight).start();
        new Thread(combat3::fight).start();
        new Thread(combat4::fight).start();
        new Thread(combat5::fight).start();
        new Thread(combat6::fight).start();

    }
}

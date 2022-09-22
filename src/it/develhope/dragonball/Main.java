package it.develhope.dragonball;

import it.develhope.dragonball.entities.Races;
import it.develhope.dragonball.entities.attacks.*;
import it.develhope.dragonball.entities.Character;
import it.develhope.dragonball.entities.Combat;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws RuntimeException{
        Character goku = new Character("Goku", Races.Sayan, 1000, 100, 0.3, 0.7);
        goku.getAttackList().add(new Kaioken());
        goku.getAttackList().add(new Kamehameha());
        goku.getAttackList().add(new Genkidama());
        goku.getAttackList().add(new Taioken());

        Character vegeta = new Character("Vegeta", Races.Sayan, 999, 99, 0.31, 0.69);
        goku.getAttackList().add(new Kaioken());
        goku.getAttackList().add(new Kamehameha());
        goku.getAttackList().add(new Genkidama());
        goku.getAttackList().add(new BigBangAttack());

        Character piccolo = new Character("Piccolo", Races.Nameccian, 870, 85, 0.4, 0.65);
        goku.getAttackList().add(new Kaioken());
        goku.getAttackList().add(new Makankosappo());
        goku.getAttackList().add(new Taioken());
        goku.getAttackList().add(new BigBangAttack());

        Character krilin = new Character("Krilin", Races.Human, 600, 60, 0.50, 0.55);
        goku.getAttackList().add(new Kaioken());
        goku.getAttackList().add(new Kamehameha());
        goku.getAttackList().add(new Genkidama());
        goku.getAttackList().add(new Taioken());

        Combat combat1 = new Combat(goku, vegeta);
        Combat combat2 = new Combat(goku, krilin);
        Combat combat3 = new Combat(goku, piccolo);
        Combat combat4 = new Combat(vegeta, piccolo);
        Combat combat5 = new Combat(vegeta, krilin);
        Combat combat6 = new Combat(piccolo, krilin);

        new Thread(combat1::fight).start();
        new Thread(combat2::fight).start();
        new Thread(combat3::fight).start();
        new Thread(combat4::fight).start();
        new Thread(combat5::fight).start();
        new Thread(combat6::fight).start();

    }
}

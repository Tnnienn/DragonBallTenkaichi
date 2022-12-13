package it.develhope.dragonball;

import it.develhope.dragonball.characters.CharacterSelector;
import it.develhope.dragonball.combat.Combat;
import it.unibas.utilita.Console;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        CharacterSelector characterSelector = CharacterSelector.getInstance();
        Combat combat = null;
        while (true) {
            int choice = menu();
            if (choice == 0) {
                System.out.println("It's been a pleasure!!");
                return;
            }
            if (choice == 1) {
               combat = selectCharacter(characterSelector);
            }
            if (choice == 2) {
                characterSelector.printCharacterList();
            }
            if (choice == 3) {
                listSelectedCharacters(combat);
            }
            if (choice == 4) {
                startBattle(combat);
            }
            if (choice == 5) {
                combat = null;
                System.out.println("***Battle Successfully Reset***");
            }
        }
    }

    private int menu() {
        System.out.println("|-------Dragon Ball Tenkaichi Tournament-------|");
        System.out.println("| 1. Select Characters                         |");
        System.out.println("| 2. List All Characters                       |");
        System.out.println("| 3. List Selected Characters                  |");
        System.out.println("| 4. Start  Battle                             |");
        System.out.println("| 5. Reset Battle                              |");
        System.out.println("|                                              |");
        System.out.println("| 0. Exit                                      |");
        System.out.println("|----------------------------------------------|");
        return readLimitedInteger(0, 5, "Insert your choice --> ");
    }

    private void startBattle(Combat combat) {
        if (combatIsEmpty(combat)) {
            System.out.println("***Error Select Characters first***");
            return;
        }
        combat.fight();
    }

    private void listSelectedCharacters(Combat combat) {
        if (combatIsEmpty(combat)) {
            System.out.println("***Error Select Characters first***");
            return;
        }
        System.out.println(combat);
    }

    private boolean combatIsEmpty(Combat combat) {
        return combat == null;
    }

    private Combat selectCharacter(CharacterSelector characterSelector) {
        characterSelector.printCharacterList();
        int firstCharacter = readLimitedInteger(0, characterSelector.size(), "Insert your choice --> ");
        System.out.println();
        characterSelector.printCharacterList();
        int secondCharacter = readLimitedInteger(0, characterSelector.size(), "Insert your choice --> ");
        System.out.println("Do you want to save the battle log?");
        String choice = readChoice();
        if (choice.equals("y")) {
            String path = readPath();
            return new Combat(characterSelector.getCharacter(firstCharacter), characterSelector.getCharacter(secondCharacter), path);
        }
        return new Combat(characterSelector.getCharacter(firstCharacter), characterSelector.getCharacter(secondCharacter));
    }

    private String readChoice() {
        System.out.print("Insert your choice [Y/n] ---> ");
        String choice = Console.leggiStringa().toLowerCase();
        if(choice.equals("") || choice.equals("y")) {
            return "y";
        }
        return "n";
    }

    private String readPath() {
        System.out.print("Name the file where the battle log is saved --> ");
        String path = Console.leggiStringa();
        StringBuilder fullPath = new StringBuilder("results/" + path + ".txt");
        if (Objects.equals(path, "")) {
            fullPath.replace(0, fullPath.length(), "results/default.txt");
        }
        if (Files.exists(Path.of(fullPath.toString()))) {
            fullPath.insert(fullPath.indexOf(".txt"), "-copy");
        }
        return fullPath.toString().trim();
    }


    private int readLimitedInteger(int min, int max, String msg) {
        System.out.print(msg);
        int value = Console.leggiIntero();
        while (value < min || value > max) {
            System.out.printf("***Error insert a number between %d and %d***%n", min, max);
            System.out.print(msg);
            value = Console.leggiIntero();
        }
        return value;
    }
}

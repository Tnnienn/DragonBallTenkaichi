package it.develhope.dragonball;

import it.unibas.utilita.Console;

public class Main {

    public static void main(String[] args) throws RuntimeException{
        new Main().run();
    }

    private void run() {
        while (true) {
            int choice = menu();
            if (choice == 0) {
                System.out.println("It's been a pleasure!!");
                return;
            }
        }
    }


    private int menu() {
        System.out.println("|-------Dragon Ball Tenkaichi Tournament-------|");
        System.out.println("| 1. Create Character                          |");
        System.out.println("| 2. List Characters                           |");
        System.out.println("| 3. Delete Character                          |");
        System.out.println("| 4. 1 Vs 1 Battle                             |");
        System.out.println("| 5. Save Characters on file                   |");
        System.out.println("| 6. Load Characters from file                 |");
        System.out.println("|                                              |");
        System.out.println("| 0. Exit                                      |");
        System.out.println("|----------------------------------------------|");
        return readLimitedInteger(0, 6, "Insert your choice --> ");
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

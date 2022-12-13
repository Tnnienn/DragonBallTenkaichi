package it.develhope.dragonball.characters;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CharacterSelector {

    private List<Character> characterList;
    private static CharacterSelector characterSelector = null;

    private CharacterSelector() {
        characterList = new ArrayList<>();
        this.characterList.add(new Goku());
        this.characterList.add(new Vegeta());
        this.characterList.add(new Gohan());

    }

    public static CharacterSelector getInstance() {
        if (characterSelector == null) {
            characterSelector = new CharacterSelector();
        }
        return characterSelector;
    }

    public void printCharacterList() {
        System.out.println("-------Characters-------");
        AtomicInteger i = new AtomicInteger();
        this.characterList.forEach(c -> {
            System.out.printf("Number: %d%n", i.get());
            System.out.println(c);
            System.out.println("------------------------");
            i.getAndIncrement();
        });
    }

    public Character getCharacter(int i) {
        return this.characterList.get(i);
    }

    public int size() {
        return this.characterList.size();
    }
}

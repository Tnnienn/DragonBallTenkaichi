package it.develhope.dragonball.attacks;

import lombok.Data;

@Data
public abstract class Skill implements Attack {

    protected String name;
    protected int strength;
    protected double successRate;

}

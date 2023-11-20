package de.uniks.se.model;

public class Slime extends Enemy {
    public Slime(String name) {
        super(name, 10, 2);
    }

    public Slime(String name, int health, int attack) {
        super(name, health, attack);
    }
}

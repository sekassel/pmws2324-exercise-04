package de.uniks.se.model;

public class Goblin extends Enemy {
    public Goblin(String name) {
        super(name, 12, 3);
    }

    public Goblin(String name, int attack) {
        super(name, 12, attack);
    }

    public Goblin(String name, int health, int attack) {
        super(name, health, attack);
    }
}

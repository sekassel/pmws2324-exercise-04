package de.uniks.se.model;

public class Oger extends Enemy{
    public Oger(String name) {
        super(name,  20, 3);
    }

    public Oger(String name, int health, int attack) {
        super(name, health, attack);
    }
}

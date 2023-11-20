package de.uniks.se.model;

public class Humanoid {

    private String name;

    public String getName() {
        return name;
    }

    public Humanoid setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

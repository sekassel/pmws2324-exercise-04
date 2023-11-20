package de.uniks.se.model;

public class Enemy extends Humanoid {

    private int maxHealth;
    private int health;
    private int attack;

    public Enemy(String name, int health, int attack) {
        this.setName(name);
        this.health = health;
        this.attack = attack;
        this.maxHealth = health;
    }

    public int getHealth() {
        return this.health;
    }

    public void getsDamagedFor(int heroAttack) {
        this.health -= heroAttack;
    }

    public int getAttack() {
        return this.attack;
    }

    public int getMaxHealth() {
        return maxHealth;
    }
}

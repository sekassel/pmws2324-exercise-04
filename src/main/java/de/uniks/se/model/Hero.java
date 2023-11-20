package de.uniks.se.model;

public class Hero extends Humanoid {

    private int health = 20;

    private int attack = 5;

    public Hero(String name) {
        this.setName(name);
    }

    public Hero(String name, int health, int attack) {
        this.setName(name);
        this.health = health;
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void getsDamagedFor(int enemyAttack) {
        this.health -= enemyAttack;

    }
}

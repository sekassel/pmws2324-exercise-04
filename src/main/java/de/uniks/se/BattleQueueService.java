package de.uniks.se;

import de.uniks.se.model.*;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class BattleQueueService {

    private Hero hero = new Hero("Sir Slay'alot", 20, 5);

    private Deque<Enemy> dungeonQueue = new ArrayDeque<>();

    private int encounterCounter = 0;

    public void simulateBattle() throws InterruptedException {
        // init dungeonQueue content
        dungeonQueue.add(new Slime("Glibbi-Bob", 10, 2));
        dungeonQueue.add(new Goblin("Duke Pebbles", 12, 2));
        dungeonQueue.add(new Oger("Florence", 20, 3));

        // loop
        while (hero.getHealth() > 0 && Objects.nonNull(dungeonQueue.peekFirst())) {

            // get opponent
            Enemy opponent = dungeonQueue.pollFirst();
            encounterCounter++;
            System.out.println("A new opponent approaches! But what is it?");
            System.out.printf("%s: Ah! Foul %s, get ready to face your creator!\n", hero.getName(), opponent.getClass().getSimpleName());


            // handle battle
            // until one of them is dead
            while (hero.getHealth() > 0 && opponent.getHealth() > 0) {
                // hero deals damage
                opponent.getsDamagedFor(hero.getAttack());
                System.out.printf("%s: Taste my sword!  (%s takes %s damage, %s HP left)\n", hero.getName(), opponent.getName(), hero.getAttack(), opponent.getHealth());
                // if opponent is still alive
                if (opponent.getHealth() > 0) {
                    // opponent deals damage
                    hero.getsDamagedFor(opponent.getAttack());
                    System.out.printf("%s: Ahrg, curse you! (%s damage taken, %s HP left)\n", hero.getName(), opponent.getAttack(), hero.getHealth());
                } else {
                    System.out.printf("- %s flew the battle-sight -\n", opponent.getName());
                }
            }

            // if won, update opponent and store back
            String newName = createNameIteration(opponent.getName());
            if (opponent instanceof Slime) {
                dungeonQueue.add(new Slime(newName));
            } else if (opponent instanceof Goblin goblin) {
                dungeonQueue.add(new Goblin(newName, goblin.getAttack() + 1));
            } else if (opponent instanceof Oger oger) {
                dungeonQueue.add(new Oger(newName, oger.getMaxHealth() + 1, oger.getAttack() + 1));
            }


            // heal hero
            if (hero.getHealth() <= 0) {
                System.out.printf("\n\n%s: The last sword was swung, the last foe slain, the last breath taken. Farewell cruel world!\n", hero.getName());
                continue;
            }
            hero.setHealth(hero.getHealth() + 5);
            System.out.printf("%s: Time for a good potion! (%s HP + 5 HP = %s HP)\n\n", hero.getName(), hero.getHealth() - 5, hero.getHealth());
        }

        // Summarize Battle
        System.out.printf("%s Fought %s battles. He got a place at the eternal round table!\n", hero.getName(), encounterCounter);
    }

    private String createNameIteration(String name) {
        if (name.matches("^.+?\\d$")) {
            String iterationNumber = name.substring(name.length() - 1, name.length());
            int number = Integer.parseInt(iterationNumber);
            number++;
            name = name.substring(0, name.length() - 1) + number;
        } else {
            name += " 2";
        }
        return name;
    }
}

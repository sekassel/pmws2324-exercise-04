package de.uniks.se;

public class Main {
    public static void main(String[] args) {
//        new StorageService().sortAndStoreExample();
        try {
            new BattleQueueService().simulateBattle();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

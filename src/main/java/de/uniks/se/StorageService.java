package de.uniks.se;

import java.util.*;

public class StorageService {

    private String[] nameList = {"Harry", "Ron", "Hermine", "Snape", "Dumbledore"};

    private ArrayList<String> dynamicNameList = new ArrayList<>();

    private Queue<String> handleList = new LinkedList<>();

    private Deque<String> alreadyHandledList = new ArrayDeque<>();


    public void sortAndStoreExample() {
        sortAndStoreDynamiscList();
        sortAndStoreQueue();
        sortAndStoreDeQueue();
    }

    private void sortAndStoreDynamiscList() {
        System.out.println("\n======================================================================");
        dynamicNameList.addAll(Arrays.asList(nameList));
        printListInOrder("List", dynamicNameList);
        dynamicNameList.add(0, "Dobby");
        printListInOrder("List", dynamicNameList);
    }


    private void sortAndStoreQueue() {
        System.out.println("\n======================================================================");
        handleList.addAll(Arrays.asList(nameList));
        printListInOrder("Queue", handleList);
        handleList.add("Dobby");
        printListInOrder("Queue", handleList);
    }


    private void sortAndStoreDeQueue() {
        System.out.println("\n======================================================================");
        alreadyHandledList.addAll(Arrays.asList(nameList));
        printListInOrder("Deque", alreadyHandledList);
        System.out.printf("First: %s\n", alreadyHandledList.peekFirst());
        System.out.printf("Last: %s\n", alreadyHandledList.peekLast());
        printListInOrder("Deque", alreadyHandledList);

        System.out.printf("First: %s\n", alreadyHandledList.pollFirst());
        System.out.printf("Last: %s\n", alreadyHandledList.pollLast());
        printListInOrder("Deque", alreadyHandledList);
    }

    public void printListInOrder(String type, Iterable list) {
        System.out.printf("%s:\t", type);
        list.forEach(s -> System.out.printf("%s | ", s));
        System.out.println();
    }
}

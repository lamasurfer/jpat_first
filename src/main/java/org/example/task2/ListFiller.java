package org.example.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListFiller {

    private final int size;
    private final int bound;
    private final List<Integer> list;

    public ListFiller(int size, int bound) {
        this.size = size;
        this.bound = bound;
        this.list = new ArrayList<>(size);
        fillList();
    }

    public ListFiller(int size) {
        this.size = size;
        this.bound = Integer.MAX_VALUE;
        this.list = new ArrayList<>(size);
        fillList();
    }

    private void fillList() {
        Logger logger = Logger.getInstance();
        logger.log("Создаём и наполняем список");
        for (int i = 0; i < size; i++) {
            list.add(new Random().nextInt(bound));
        }

    }

    public List<Integer> getList() {
        return list;
    }

    public void printList() {
        System.out.print("Вот случайный список: ");
        for (Integer integer : list) {
            System.out.printf("%s ", integer);
        }
        System.out.println();
    }
}

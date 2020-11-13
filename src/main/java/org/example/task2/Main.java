package org.example.task2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Logger logger = Logger.getInstance();
        logger.log("Запускаем программу");

        UserInteraction userInteraction = new UserInteraction(scanner);

        logger.log("Просим пользователя ввести входные данные для списка");
        int listSize = userInteraction.getListSize();
        int bound = userInteraction.getBound();

        ListFiller listFiller = new ListFiller(listSize, bound);
        listFiller.printList();

        logger.log("Просим пользователя ввести входные данные для фильтрации");
        int threshold = userInteraction.getThreshold();

        Filter filter = new Filter(threshold);
        filter.filterOut(listFiller.getList());
        filter.showResult();

        logger.log("Завершаем программу");
    }
}

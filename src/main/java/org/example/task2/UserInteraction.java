package org.example.task2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInteraction {

    private final Scanner scanner;

    public UserInteraction(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getListSize() {
        int listMinSize = 1;
        int listMaxSize = 1_000;
        return getListSize(listMinSize, listMaxSize);
    }

    public int getBound() {
        int minValue = 2;
        int maxValue = Integer.MAX_VALUE;
        return getBound(minValue, maxValue);
    }

    public int getThreshold() {
        int maxValue = Integer.MAX_VALUE;
        return getThreshold(maxValue);
    }

    public int getListSize(int listMinSize, int listMaxSize) {
        System.out.println("Введите размер списка:");
        return parseInput(listMinSize, listMaxSize);
    }

    public int getBound(int minValue, int maxValue) {
        System.out.println("Введите верхнюю границу для значений:");
        return parseInput(minValue, maxValue);
    }

    public int getThreshold(int maxValue) {
        System.out.println("Введите порог для фильтра:");
        int minValue = 0;
        return parseInput(minValue, maxValue);
    }

    private int parseInput(int min, int max) {
        int number = 0;
        String input;
        Logger logger = Logger.getInstance();
        do {
            input = scanner.nextLine().trim();
            if (validateInput(input) || input.isEmpty()) {
                System.out.println("Используйте цифры.");
                logger.log("При вводе использованы некорректные символы");
                continue;
            }
            number = Integer.parseInt(input);
            if (number < min || number > max) {
                System.out.printf("Введите целое число от %s до %s.%n", min, max);
                logger.log("Введенное число не входит в установленные пределы");
                number = 0;
            }
        } while (number == 0);
        return number;
    }

    private boolean validateInput(String input) {
        Pattern pattern = Pattern.compile("\\D+");
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
}

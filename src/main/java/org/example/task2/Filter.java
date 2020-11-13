package org.example.task2;

import java.util.ArrayList;
import java.util.List;

public class Filter {
    private final int threshold;
    private List<Integer> result;

    public Filter(int threshold) {
        this.threshold = threshold;
    }

    public void filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        logger.log("Запускаем фильтрацию");
        result = new ArrayList<>();
        String message;
        for (Integer integer : source) {
            if (integer.compareTo(threshold) > 0) {
                message = String.format("Элемент \"%s\" проходит", integer);
                result.add(integer);
            } else {
                message = String.format("Элемент \"%s\" не проходит", integer);

            }
            logger.log(message);
        }
        message = String.format("Прошло фильтрацию %s из %s", result.size(), source.size());
        logger.log(message);
    }

    public void showResult() {
        Logger logger = Logger.getInstance();
        logger.log("Выводим результат на экран");
        System.out.print("Отфильтрованный список: ");
        for (Integer integer : result) {
            System.out.printf("%s ", integer);
        }
        System.out.println();
    }

    public List<Integer> getResult() {
        return result;
    }
}

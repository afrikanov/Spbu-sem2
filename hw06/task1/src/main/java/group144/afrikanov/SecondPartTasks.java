package group144.afrikanov;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class SecondPartTasks {

    private SecondPartTasks() {}

    // Найти строки из переданных файлов, в которых встречается указанная подстрока.
    public static List<String> findQuotes(List<String> paths, CharSequence sequence) {
        return paths.stream()
                .filter(value -> value.contains(sequence))
                .collect(Collectors.toList());
    }

    // В квадрат с длиной стороны 1 вписана мишень.
    // Стрелок атакует мишень и каждый раз попадает в произвольную точку квадрата.
    // Надо промоделировать этот процесс с помощью класса java.util.Random и посчитать, какова вероятность попасть в мишень.
    public static double piDividedBy4() {
        final int SHOTS_AMOUNT = (int)1e6;
        final Double RADIUS = 0.5;
        Random random = new Random();
        long goodShots = IntStream.rangeClosed(1, SHOTS_AMOUNT)
                .filter(value -> {
                    Double x = random.nextDouble() % 1;
                    if (x > RADIUS) {
                        x -= RADIUS;
                    }
                    Double y = random.nextDouble() % 1;
                    if (y > RADIUS) {
                        y -= RADIUS;
                    }
                    return x * x + y * y <= RADIUS * RADIUS;
                })
                .count();
        return (double)goodShots / (double)SHOTS_AMOUNT;
    }

    // Дано отображение из имени автора в список с содержанием его произведений.
    // Надо вычислить, чья общая длина произведений наибольшая.
    public static String findPrinter(Map<String, List<String>> compositions) {
        return compositions
                .entrySet()
                .stream()
                .max(Comparator.comparingInt(compositor -> compositor.getValue().stream().mapToInt(composition -> composition.length()).sum()))
                .map(Map.Entry::getKey)
                .orElse("");
    }

    // Вы крупный поставщик продуктов. Каждая торговая сеть делает вам заказ в виде Map<Товар, Количество>.
    // Необходимо вычислить, какой товар и в каком количестве надо поставить.
    public static Map<String, Integer> calculateGlobalOrder(List<Map<String, Integer>> orders) {
        return orders
                .stream()
                .flatMap(order -> order.entrySet().stream())
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.summingInt(Map.Entry::getValue)));
    }
}
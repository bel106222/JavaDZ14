package org.example;
import java.util.ArrayList;
import java.util.List;

public class IntegerSet {
    private List<Integer> numbers;

    public IntegerSet() {
        this.numbers = new ArrayList<>();
    }

    public void add(int number) {
        numbers.add(number);
    }

    public int sum() {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }

    public double average() {
        if (numbers.isEmpty()) {
            throw new IllegalStateException("Набор пуст");
        }
        return (double) sum() / numbers.size();
    }

    public int max() {
        if (numbers.isEmpty()) {
            throw new IllegalStateException("Набор пуст");
        }
        return numbers.stream().mapToInt(Integer::intValue).max().getAsInt();
    }

    public int min() {
        if (numbers.isEmpty()) {
            throw new IllegalStateException("Набор пуст");
        }
        return numbers.stream().mapToInt(Integer::intValue).min().getAsInt();
    }
}

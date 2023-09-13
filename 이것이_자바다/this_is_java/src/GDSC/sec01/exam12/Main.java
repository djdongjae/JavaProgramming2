package GDSC.sec01.exam12;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        MyFunction f = (a, b) -> a > b ? a : b;

        int[] num1 = {1, 2, 3, 4};

        List<Integer> number3 = Arrays.asList(3, 3, 4, 5, 3, 8, 2);
        Integer num3 = number3.stream()
                .filter(number -> number.equals(3))
                .mapToInt(Integer::intValue)
                .sum();

        Optional<String> optsj1 = Optional.of("135");
        Optional<String> optsj2 = Optional.ofNullable(null);

        Optional<String> emptyopt = Optional.empty();
        System.out.println(optsj1.isPresent());
        System.out.println(optsj1);
        System.out.println(optsj2.get());

        List<String> it = Arrays.asList("C", "Java", "C++", "Python", "Kotlin");
    }
}

@FunctionalInterface
interface MyFunction {
    public abstract int max(int a, int b);

}

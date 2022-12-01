package lambda;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Random;
import java.util.function.*;

public class NumberUtils {
    public static void main(String[] args) {
        //Predicate: перевірка, чи є число простим
        IntPredicate isPrime = a -> {
            if (a <= 3) {
                return true;
            }

            if (a % 2 == 0 || a % 3 == 0) {
                return false;
            }

            for (int i = 6; i * 2 < a; i += 6) {
                if (a % (i - 1) == 0 || a % (i + 1) == 0) {
                    return false;
                }
            }

            return true;
        };
        System.out.println(isPrime.test(115)); // false
        System.out.println(isPrime.test(17)); // true

        //Consumer: генерує число від 0 до заданого та виводимо в консоль.
        IntConsumer printRandom = a -> System.out.println(new Random().nextInt(a));
        printRandom.accept(10);

        //Supplier: повертає день тижня
        Supplier<DayOfWeek> dayOfWeek = () -> LocalDate.now().getDayOfWeek();
        System.out.println(dayOfWeek.get());

        //Function: округляє Double у Long за правилами математики
        DoubleToLongFunction round = a -> {
            long result = (long) a;
            if (a - result >= 0.5) {
                result++;
            }

            return result;
        };
        System.out.println(round.applyAsLong(13.4)); // 13
        System.out.println(round.applyAsLong(13.5)); // 14

        //UnaryOperator: обчислює число Фібоначчі
        IntUnaryOperator fibonacci = a -> {
            if (a < 1) {
                throw new IllegalArgumentException("Number position should be 1 or higher");
            }
            if (a == 1) {
                return 0;
            }

            int previous = 0;
            int current = 1;
            for (int i = 2; i < a; i++) {
                int result = current + previous;
                previous = current;
                current = result;
            }

            return current;
        };
        System.out.println(fibonacci.applyAsInt(10)); // 34
        System.out.println(fibonacci.applyAsInt(8)); // 13
    }
}

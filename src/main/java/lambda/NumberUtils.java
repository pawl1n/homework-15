package lambda;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Random;
import java.util.function.*;

public class NumberUtils {
    private static final Random RANDOM = new Random();
    //Predicate: перевірка, чи є число простим
    public static final IntPredicate IS_PRIME = a -> {
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
    //Consumer: генерує число від 0 до заданого та виводимо в консоль.
    public static final IntConsumer PRINT_RANDOM = a -> System.out.println(RANDOM.nextInt(a));
    //Supplier: повертає день тижня
    public static final Supplier<DayOfWeek> DAY_OF_WEEK = LocalDate.now()::getDayOfWeek;
    //Function: округляє Double у Long за правилами математики
    public static final DoubleToLongFunction ROUND = a -> {
        long result = (long) a;
        if (a - result >= 0.5) {
            result++;
        }

        return result;
    };
    //UnaryOperator: обчислює число Фібоначчі
    public static final IntUnaryOperator FIBONACCI = a -> {
        if (a < 0) {
            throw new IllegalArgumentException("Number position should be 1 or higher");
        }
        if (a == 0) {
            return 0;
        }

        int previous = 0;
        int current = 1;
        for (int i = 1; i < a; i++) {
            int result = current + previous;
            previous = current;
            current = result;
        }

        return current;
    };

    private NumberUtils() {};
}

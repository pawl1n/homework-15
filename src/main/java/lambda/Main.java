package lambda;

import static lambda.NumberUtils.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(IS_PRIME.test(115)); // false
        System.out.println(IS_PRIME.test(17)); // true

        PRINT_RANDOM.accept(10);

        System.out.println(DAY_OF_WEEK.get());

        System.out.println(ROUND.applyAsLong(13.4)); // 13
        System.out.println(ROUND.applyAsLong(13.5)); // 14

        System.out.println(FIBONACCI.applyAsInt(10)); // 34
        System.out.println(FIBONACCI.applyAsInt(8)); // 13
    }
}

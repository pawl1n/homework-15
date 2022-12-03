package lambda;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.function.*;

import static org.assertj.core.api.Assertions.*;

class NumberUtilsTest {

    @Test
    void shouldBePrime() {
        // given
        IntPredicate isPrime = NumberUtils.IS_PRIME;

        // when
        int value = 17;

        // then
        assertThat(isPrime.test(value)).isTrue();
    }

    @Test
    void shouldNotBePrime() {
        // given
        IntPredicate isPrime = NumberUtils.IS_PRIME;

        // when
        int value = 25;

        // then
        assertThat(isPrime.test(value)).isFalse();
    }

    @Test
    void shouldPrintRandom() {
        // given
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        IntConsumer printRandom = NumberUtils.PRINT_RANDOM;

        // when
        int value = 1000;
        printRandom.accept(value);

        // then
        assertThat(outContent.toString().trim()).matches("^[0-9]{1,3}$");
    }

    @Test
    void shouldReturnDayOfWeek() {
        // given
        Supplier<DayOfWeek> dayOfWeekSupplier = NumberUtils.DAY_OF_WEEK;

        // when
        DayOfWeek dayOfWeek = dayOfWeekSupplier.get();

        // then
        assertThat(dayOfWeek).isEqualTo(LocalDate.now().getDayOfWeek());
    }

    @Test
    void shouldRoundToCeil() {
        // given
        DoubleToLongFunction round = NumberUtils.ROUND;

        // when
        double value = 1.5;

        // then
        assertThat(round.applyAsLong(value)).isEqualTo((int) Math.ceil(value));
    }

    @Test
    void shouldRoundToFloor() {
        // given
        DoubleToLongFunction round = NumberUtils.ROUND;

        // when
        double value = 1.4999;

        // then
        assertThat(round.applyAsLong(value)).isEqualTo((int) Math.floor(value));
    }

    @Test
    void shouldGetFibonacci() {
        // given
        IntUnaryOperator fibonacci = NumberUtils.FIBONACCI;

        // when
        int position = 11;

        // then
        assertThat(fibonacci.applyAsInt(position)).isEqualTo(89);
    }

    @Test
    void shouldNotGetFibonacci() {
        // given
        IntUnaryOperator fibonacci = NumberUtils.FIBONACCI;

        // when
        int position = -1;

        // then
        assertThatThrownBy(() -> fibonacci.applyAsInt(position)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Number position should be 1 or higher");
    }
}
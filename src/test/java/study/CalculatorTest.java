package study;

import Calculator.Calculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp(){
        calculator = new Calculator();
    }

    @Test
    void 입력Split테스트() {
        String line = "2 + 3 * 4 / 2";
        String[] splitString = line.split(" ");
        Assertions.assertThat(splitString).hasSize(7);
    }

    @Test
    void 형변환테스트() {
        int number = Integer.parseInt("2");
        Assertions.assertThat(number).isInstanceOf(Integer.class);
        Assertions.assertThat(number).isEqualTo(2);
    }

    @Test
    void 정규식_filter_테스트(){
        String regx=  "[^0-9]";
        String[] array = new String[]{"1","+","3"};

        List<String> collect = Arrays.stream(array)
                .filter(s -> s.matches(regx))
                .collect(Collectors.toList());

        Assertions.assertThat(collect).hasSize(1);
    }

    @Test
    void 덧셈() {
        Assertions.assertThat(calculator.add(3, 4)).isEqualTo(7);
    }

    @Test
    void 뺄셈() {
        Assertions.assertThat(calculator.subtract(3, 4)).isEqualTo(-1);
    }

    @Test
    void 곱셈() {
        Assertions.assertThat(calculator.multiply(3, 4)).isEqualTo(12);
    }

    @Test
    void 나눗셈() {
        Assertions.assertThat(calculator.divide(12, 3)).isEqualTo(4);
    }
}

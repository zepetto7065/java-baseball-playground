package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("set의 크기를 확인하는 테스트")
    void 요구사항1(){
        Assertions.assertThat(numbers).hasSize(4);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("1,2,3을 포함는지 테스트")
    void 요구사항2(int input){
        Assertions.assertThat(numbers).contains(input);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true","2:true","3:true","4:false","5:false"},delimiter = ':')
    @DisplayName("1,2,3은 true, 4,5는 false 반환 테스트")
    void 요구사항3(int input,Boolean expected) {
        Assertions.assertThat(numbers).contains(input).isEqualTo(expected);
    }

}

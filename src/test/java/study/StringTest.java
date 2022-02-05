package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("1,2중 ,를 제외해서 split 테스트")
    void 요구사항1_1(){
        String[] splitByComma = "1,2".split(",");
        assertThat(splitByComma).contains("1","2");
    }

    @Test
    @DisplayName(",를 제외하여 1만 확인하는 테스트")
    void 요구사항1_2(){
        String[] splitByComma = "1".split(",");
        assertThat(splitByComma).containsExactly("1");
    }

    @Test
    @DisplayName("(,)를 제외하여 1,2만 substring 테스트")
    void 요구사항2(){
        String example = "(1,2)";
        String substringExceptBracket = example.substring(1, example.length() - 1);
        assertThat(substringExceptBracket).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정문자 가져올 때 위치 값을 벗어날 경우, Exception check")
    void 요구사항3() {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(()->{
                    "abc".charAt(5);
                }).withMessageContaining("String index out of range: 5");
    }
}

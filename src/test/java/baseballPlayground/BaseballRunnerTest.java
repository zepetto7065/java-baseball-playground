package baseballPlayground;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class BaseballRunnerTest {

    String answer;
    String input;
    String[] answerArray;
    String[] inputArray;

    @BeforeEach
    void setUp() {
        answer = "123";
        input = "345";
    }

    @Test
    @DisplayName("입력값을 배열로 만드는 test")
    void makeStringArrayTest() {
        String[] split = answer.split("");
        Assertions.assertThat(split).hasSize(3);
    }

    @Test
    @DisplayName("배열내 요소가 들어있는지")
    void containElementTest() {
        //given
        answerArray = new String[]{"1", "2", "3"};
        List<String> collect = Arrays.stream(answerArray).collect(Collectors.toList());
        String inputTarget = "3";

        //when
        boolean contains = collect.contains(inputTarget);

        //then
        Assertions.assertThat(contains).isTrue();
    }

    @Test
    @DisplayName("요소가 같은 두 배열의 스트라이크,볼 확인 테스트")
    void confirmStrikeTest() {
        //given
        answerArray = new String[]{"1", "2", "3"};
        inputArray = new String[]{"1", "3", "2"};
        Map<String, Integer> map = new HashMap<>();

        //when
        for (int i = 0; i < inputArray.length; i++) {
            if (answerArray[i] == inputArray[i]) {
                map.put("스트라이크", map.getOrDefault("스트라이크", 0) + 1);
            }
            if (answerArray[i] != inputArray[i]) {
                map.put("볼", map.getOrDefault("볼", 0) + 1);
            }
        }

        //then
        Assertions.assertThat(map.get("스트라이크")).isEqualTo(1);
        Assertions.assertThat(map.get("볼")).isEqualTo(2);
    }

    @Test
    @DisplayName("map에 모인 결과를 String 형태로 도출한다.")
    void convertMapToString() {
        //give
        Map<String, Integer> map = new HashMap<>();
        map.put("스트라이크", 2);
        map.put("볼", 1);
        StringBuilder sb = new StringBuilder();

        //when
        StringBuilder resultSb = sb.append(map.get("스트라이크") + "스트라이크")
                .append(" " + map.get("볼") + "볼");


        //then
        Assertions.assertThat(resultSb.toString()).isEqualTo("2스트라이크 1볼");
    }


    @Test
    @DisplayName("3스트라이크 출력")
    void convertMapToStringThreeStrike() {
        //give
        Map<String, Integer> map = new HashMap<>();
        map.put("스트라이크", 3);
        map.put("볼", 0);
        StringBuilder sb = new StringBuilder();

        //when
        if(map.get("볼") != 0) sb.append(map.get("볼")+"볼");
        if(map.get("스트라이크") != 0) sb.append(map.get("스트라이크") + "스트라이크");

        //then
        Assertions.assertThat(sb.toString()).isEqualTo("3스트라이크");
    }

    @Test
    @DisplayName("3볼 출력")
    void convertMapToStringThreeBall() {
        //give
        Map<String, Integer> map = new HashMap<>();
        map.put("스트라이크", 0);
        map.put("볼", 3);
        StringBuilder sb = new StringBuilder();

        //when
        if(map.get("볼") != 0) sb.append(map.get("볼")+"볼");
        if(map.get("스트라이크") != 0) sb.append(map.get("스트라이크") + "스트라이크");

        //then
        Assertions.assertThat(sb.toString()).isEqualTo("3볼");
    }

    @Test
    @DisplayName("2볼 1스트라이크 출력")
    void convertMapToStringTwoBallOneStrike() {
        //give
        Map<String, Integer> map = new HashMap<>();
        map.put("스트라이크", 1);
        map.put("볼", 2);
        String result = "";

        //when
        if(map.get("볼") != 0) result = map.get("볼")+"볼";
        if(map.get("볼") != 0 && map.get("스트라이크") != 0) result += " ";
        if(map.get("스트라이크") != 0) result += map.get("스트라이크") + "스트라이크";

        //then
        Assertions.assertThat(result).isEqualTo("2볼 1스트라이크");
    }

}
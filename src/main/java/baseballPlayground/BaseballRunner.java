package baseballPlayground;

import java.util.*;
import java.util.stream.Collectors;

public class BaseballRunner {

    public String playGame(String input, String answer) {
        String[] answerArray;
        String[] inputArray;
        Map<String, Integer> map = new HashMap<>();
        map.put("스트라이크", 0);
        map.put("볼", 0);

        //입력값과 숫자를 배열로 만든다.
        inputArray = input.split("");
        answerArray = answer.split("");
        List<String> answerList = Arrays.stream(answerArray)
                .collect(Collectors.toList());

        //입력 배열을 차례대로 위치를 확인한다.
        for (int i = 0; i < inputArray.length; i++) {
            getGameResultForTarget(answerArray, inputArray, map, answerList, i);
        }

        //결과를 도출한다.
        String result = "";
        if (map.get("스트라이크") == 0 && map.get("볼") == 0) return "낫싱";
        if (map.get("볼") != 0) result = map.get("볼") + "볼";
        if (map.get("볼") != 0 && map.get("스트라이크") != 0) result += " ";
        if (map.get("스트라이크") != 0) result += map.get("스트라이크") + "스트라이크";

        return result;
    }

    private void getGameResultForTarget(String[] answerArray, String[] inputArray, Map<String, Integer> map, List<String> answerList, int i) {
        if (answerList.contains(inputArray[i])) {
            getStrikeOrBall(answerArray, inputArray, map, i);
        }
    }

    private void getStrikeOrBall(String[] answerArray, String[] inputArray, Map<String, Integer> map, int i) {
        if (answerArray[i].equals(inputArray[i])) {
            map.put("스트라이크", map.get("스트라이크") + 1);
        }
        if (!answerArray[i].equals(inputArray[i])) {
            map.put("볼", map.get("볼") + 1);
        }
    }
}

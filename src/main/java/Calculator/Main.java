package calculator;

import java.util.Scanner;

public class Main {

    static Calculator cal = new Calculator();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(getResult(input));
    }

    private static int getResult(String input) {
        String[] splitString = input.split(" ");
        int result = Integer.parseInt(splitString[0]);
        String operator = "";
        String regx = "[^0-9]";
        for (String str : splitString) {
            if (str.matches(regx)) {
                operator = str;
                continue;
            }
            if(!operator.isEmpty()) result = getCalResult(result, Integer.parseInt(str), operator);
        }
        return result;
    }

    private static int getCalResult(int result, int nextNum, String operator) {

        if ("+".equals(operator)) result = cal.add(result, nextNum);
        if ("-".equals(operator)) result = cal.subtract(result, nextNum);
        if ("*".equals(operator)) result = cal.multiply(result, nextNum);
        if ("/".equals(operator)) result = cal.divide(result, nextNum);

        return result;
    }


}

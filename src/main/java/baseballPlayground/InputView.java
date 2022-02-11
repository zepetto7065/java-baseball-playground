package baseballPlayground;

import java.util.Scanner;

public class InputView {
    Scanner sc;

    public String scan() {
        sc = new Scanner(System.in);
        System.out.print("숫자를 입력해 주세요 : ");
        return  sc.nextLine();
    }

    public String regameScan() {
        sc = new Scanner(System.in);
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return sc.nextLine();
    }
}

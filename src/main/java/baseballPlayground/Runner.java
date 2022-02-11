package baseballPlayground;

public class Runner {

    public static void main(String[] args) {
        InputView iv = new InputView();
        ResultView rv = new ResultView();
        BaseballRunner br = new BaseballRunner();

        String answer = "123";

        while(true){
            String input = iv.scan();
            String gameResult = br.playGame(input, answer);
            rv.print(gameResult);
        }
    }
}

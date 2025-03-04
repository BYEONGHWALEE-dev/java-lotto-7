package lotto.view;

import lotto.service.Service;
import java.util.List;

public class OutputView {

    public void outputMoney(int money){
        System.out.println(money);
    }

    public int outputLottosEach(int money){

        int times = money / 1000;

        if (times == 0){
            System.out.println(money / 1000 + "를 구매하였습니다.");
        }

        return times;
    }

    public void outputWholeLotto (int times, List<List<Integer>> wholeNumbers) {

        for (List<Integer> rawNumber: wholeNumbers) {
            System.out.println(rawNumber);
        }

    }

    public void outputResult(int times, int[] rankArray) {


        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(times + "개를 구매했습니다.");
        System.out.printf("3개 일치 (5,000원) - %d개\n", rankArray[1]);
        System.out.printf("4개 일치 (50,000원) - %d개\n", rankArray[2]);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", rankArray[3]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", rankArray[4]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", rankArray[5]);
    }

    public void revenueOutput(String revenue) {

        System.out.println("총 수익률은 " + revenue + "입니다.");
    }

}

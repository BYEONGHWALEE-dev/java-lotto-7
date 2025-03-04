package lotto.controller;

import lotto.service.Service;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoProcessing {

    private InputView inputView;
    private OutputView outputview;
    private Service service;

    public LottoProcessing(InputView inputView, OutputView outputView, Service service) {
        this.inputView = inputView;
        this.outputview = outputView;
        this.service = service;
    }

    public void run() {

        // 돈 입력
        int inputMoney = inputView.inputMoney();
        outputview.outputMoney(inputMoney);

        // 몇 개 구매했는지
        int times = outputview.outputLottosEach(inputMoney);
        List<List<Integer>> wholeNumbers = service.makingWholeLotto(times);
        outputview.outputWholeLotto(times, wholeNumbers);

        // 당첨번호 입력
        String winnings = inputView.inputWinnings();
        List<Integer> winningNumbers = service.winningNumbers(winnings);

        // 보너스 번호 입력
        int bonusNumber = inputView.inputBonusNumher();

        // 당첨 결과
        int [] rankArray = validateWholeLottos(wholeNumbers, winningNumbers, bonusNumber, times);
        outputview.outputResult(times, rankArray);
        String revenue = service.calculateRevenue(inputMoney, rankArray);
        outputview.revenueOutput(revenue);
    }

    public int[] validateWholeLottos(List<List<Integer>> wholeNumbers, List<Integer> winningNumhers, int bonusNumber, int times) {

        int[] checkRank = new int[6];

        for(int i = 0; i < times; i++) {

            List<Integer> rawNumbers = wholeNumbers.get(i);
            int correspondingNumber = validateOneRaw(rawNumbers, winningNumhers);
            int rank = checkRank(rawNumbers, bonusNumber, correspondingNumber);
            checkRank[rank]++;
        }

        return checkRank;
    }

    public int validateOneRaw(List<Integer> rawNumbers, List<Integer> winningNumbers) {

        int correspondingNumber = 0;

        for(int i : rawNumbers) {
            int tempNum = validateWithWinningNumbers(i, winningNumbers);
            correspondingNumber += tempNum;
        }

        return correspondingNumber;
    }

    public int validateWithWinningNumbers(int i, List<Integer> winningNumbers) {

        for(int n : winningNumbers) {
            if(i == n) return 1;
        }
        return 0;
    }

    public boolean validateWithBonusNumbers(List<Integer> rawNumbers, int bonusNumber) {

        for(int i : rawNumbers) {
            if (i == bonusNumber) return true;
        }

        return false;
    }

    public int checkRank(List<Integer> rawNumbers, int bonusNumber, int correspondingNumber) {

        if(correspondingNumber == 3) return 1;
        if(correspondingNumber == 4) return 2;
        if(correspondingNumber == 5) {
            if (validateWithBonusNumbers(rawNumbers, bonusNumber)) return 5;
            return 4;
        }
        if(correspondingNumber == 6) return 5;

        return 0;
    }

}

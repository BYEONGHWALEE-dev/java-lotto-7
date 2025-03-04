package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Service {


    public Lotto makingLotto(){

        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Lotto lotto = new Lotto(numbers);

        return lotto;
    }

    public List<List<Integer>> makingWholeLotto(int times) {

        List<List<Integer>> wholeNumbers = new ArrayList<>();

        for (int i = 0; i < times; i++) {
            wholeNumbers.add(makingLotto().getNumbers());
        }

        return wholeNumbers;
    }

    public List<Integer> winningNumbers(String winnings) {

        List<Integer> winningNumbersArray = Arrays.stream(winnings.split(",")).map(Integer::parseInt)
                .collect(Collectors.toList());

        return winningNumbersArray;
    }

    public String calculateRevenue(int inputMoney, int[] rankArray) {

        float revenue;
        float profit = rankArray[1] * 5000 + rankArray[2] * 50000 +  rankArray[3] * 1500000 + rankArray[4] * 30000000 + rankArray[5] * 2000000000;

        revenue = profit / inputMoney * 100;

        return revenue + "%";
    }

}

package lotto.view;


import camp.nextstep.edu.missionutils.Console;
import lotto.service.Service;

import java.util.List;

public class InputView {

    public int inputMoney() {

        System.out.println("구입금액을 입력해 주세요");
        String money = Console.readLine();
        int moneyInt = Integer.parseInt(money);

        return moneyInt;
    }

    public String inputWinnings() {

        System.out.println("당첨 번호를 입력해주세요");
        String winnings = Console.readLine();

        return winnings;
    }

    public int inputBonusNumher() {

        System.out.println("보너스 번호를 입력해 주세요.");
        String number = Console.readLine();

        return Integer.parseInt(number);
    }

}

package lotto;

import lotto.controller.LottoProcessing;

public class Application {

    static AppConfig appConfig;
    static LottoProcessing lottoProcessing;

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        appConfig = new AppConfig();
        lottoProcessing = appConfig.lottoProcessing();

        lottoProcessing.run();
    }
}

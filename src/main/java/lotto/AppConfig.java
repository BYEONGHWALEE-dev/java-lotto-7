package lotto;

import lotto.controller.LottoProcessing;
import lotto.service.Service;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {

    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }

    public Service service() {
        return new Service();
    }

    public LottoProcessing lottoProcessing() {
        return new LottoProcessing(
                inputView(),
                outputView(),
                service()
        );
    }
}

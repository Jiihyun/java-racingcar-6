package racingcar.view;

import racingcar.domain.Cars;
import racingcar.domain.dto.input.CarsRequestDto;
import racingcar.io.InputReader;
import racingcar.io.OutputWriter;
import racingcar.parser.Parser;
import racingcar.validator.TryTimesValidator;

import java.util.List;

public class InputView {
    private final InputReader reader;
    private final OutputWriter writer;

    public InputView(InputReader reader, OutputWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public Cars getCars() {
        writer.writeInputNameMsg();
        String carNames = reader.readLine();
        List<String> carNameList = Parser.parseCarNames(carNames);
        CarsRequestDto carsRequestDto = new CarsRequestDto(carNameList);
        return Cars.from(carsRequestDto.carNameList());
    }

    public int getTryTimes() {
        writer.writeInputTryTimesMsg();
        String tryTimes = reader.readLine();
        TryTimesValidator.validateNumber(tryTimes);
        return Integer.parseInt(tryTimes);
    }
}

package racingcar.view;

import racingcar.domain.Cars;
import racingcar.domain.dto.CarsDto;
import racingcar.io.InputReader;
import racingcar.io.OutputWriter;

public class InputView {
    private final InputReader reader;
    private final OutputWriter writer;

    public InputView(InputReader reader, OutputWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public Cars getCarNames() {
        writer.writeInputNameMsg();
        String carNames = reader.readLine();
        CarsDto carsDto = new CarsDto(carNames);
        return carsDto.toCars();
    }
}

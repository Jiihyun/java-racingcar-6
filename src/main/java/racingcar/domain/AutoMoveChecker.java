package racingcar.domain;

public class AutoMoveChecker implements MoveChecker {
    private static final int MINIMUM_NUMBER = 4;
    private final RandomNumberGenerator randomNumberGenerator;

    public AutoMoveChecker(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    public MoveInstruction getMoveInstruction() {
        if (canMove()) {
            return MoveInstruction.FORWARD;
        }
        return MoveInstruction.STAY;
    }

    private boolean canMove() {
        return randomNumberGenerator.generate() >= MINIMUM_NUMBER;
    }
}

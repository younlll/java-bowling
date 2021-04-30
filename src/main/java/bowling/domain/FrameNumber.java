package bowling.domain;

import java.util.Objects;

public class FrameNumber {
    private final int frameNumber;

    private static final int FIRST_FRAME_NUMBER = 1;
    private static final int LAST_FRAME_NUMBER = 10;

    public FrameNumber(int frameNumber) {
        verifyFrameNumber(frameNumber);
        this.frameNumber = frameNumber;
    }

    public FrameNumber increase() {
        return new FrameNumber(frameNumber + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FrameNumber that = (FrameNumber) o;
        return frameNumber == that.frameNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(frameNumber);
    }

    private void verifyFrameNumber(int frameNumber) {
        if (frameNumber > LAST_FRAME_NUMBER) {
            throw new IllegalArgumentException("잘못된 프레임 번호");
        }

        if (frameNumber < FIRST_FRAME_NUMBER) {
            throw new IllegalArgumentException("잘못된 프레임 번호");
        }
    }
}

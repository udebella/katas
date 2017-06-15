import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class BowlingGameTest {
    private BowlingGame bowlingGame;

    @Before
    public void setUp() {
        bowlingGame = new BowlingGame();
    }

    @Test
    public void simple_case() {
        int[] frames = new int[]{1, 2};
        Arrays.stream(frames).forEach(bowlingGame::roll);
        assertEquals(3, bowlingGame.score());
    }

    @Test
    public void single_spare_case() {
        int[] frames = new int[]{1, 9, 5, 3};
        Arrays.stream(frames).forEach(bowlingGame::roll);
        assertEquals(23, bowlingGame.score());
    }

    @Test
    public void full_spare_case() {
        int[] frames = new int[]{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
        Arrays.stream(frames).forEach(bowlingGame::roll);
        assertEquals(150, bowlingGame.score());
    }

    @Test
    public void strike_case() throws Exception {
        int[] frames = new int[]{10, 5, 3};
        Arrays.stream(frames).forEach(bowlingGame::roll);
        assertEquals(26, bowlingGame.score());
    }

    @Test
    public void double_strike_case() throws Exception {
        int[] frames = new int[]{10, 10, 5, 3};
        Arrays.stream(frames).forEach(bowlingGame::roll);
        assertEquals(51, bowlingGame.score());
    }

    @Test
    public void full_strikes() throws Exception {
        int[] frames = new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        Arrays.stream(frames).forEach(bowlingGame::roll);
        assertEquals(300, bowlingGame.score());

    }
}

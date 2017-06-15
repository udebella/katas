import org.junit.Test;
import fb.FizzBuzz;

import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {
    @Test
    public void return_fizz_for_multiples_of_three() throws Exception {
        assertEquals("fizz", FizzBuzz.evaluate(3));
    }
    @Test
    public void return_buzz_for_multiples_of_five() throws Exception {
        assertEquals("buzz", FizzBuzz.evaluate(5));

    }
    @Test
    public void return_fizzbuzz_for_multiples_of_three_and_five() throws Exception {
        assertEquals("fizzbuzz", FizzBuzz.evaluate(15));

    }
    @Test
    public void return_fizzbuzz_for_multiples_of_tseven() throws Exception {
        assertEquals("toto", FizzBuzz.evaluate(7));

    }
    @Test
    public void return_numer_for_other() throws Exception {
        assertEquals("1", FizzBuzz.evaluate(1));
    }
}

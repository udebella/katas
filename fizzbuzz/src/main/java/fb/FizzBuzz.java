package fb;

import java.util.Arrays;

/**
 * Created by Ubu on 20/03/2017.
 */
public class FizzBuzz {
    public static String evaluate(int input) {
        String output;

        output = Arrays.stream(OutputSettings.values())
                .filter(outputSettings -> input % outputSettings.getValue() == 0)
                .map(OutputSettings::getOutput)
                .reduce("", (acc, i) -> acc += i);

        if (output.isEmpty()) {
            output = String.valueOf(input);
        }

        return output;
    }
}

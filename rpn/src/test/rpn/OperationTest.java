package rpn;

import org.junit.Test;
import org.mockito.Mockito;
import rpn.numbers.Number;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class OperationTest {
    @Test(expected = AssertionError.class)
    public void searching_operation_from_null_value_should_be_forbidden() throws Exception {
        Operation.of(null);
    }

    @Test
    public void searching_non_existing_operation_should_return_empty_optional() throws Exception {
        assertThat(Operation.of("non existing operation")).isEqualTo(Optional.empty());
    }

    @Test
    public void applying_operation_should_call_method_right_method_on_numbers() throws Exception {
        Number zero = Mockito.spy(Number.ZERO);

        Operation.SUM.applyOperation(zero, Number.ZERO);

        Mockito.verify(zero).add(Number.ZERO);
    }
}
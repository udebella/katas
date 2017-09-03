package rpn;

import org.junit.Test;
import org.mockito.Mockito;
import rpn.numbers.Number;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static rpn.Operations.SUM;
import static rpn.numbers.Number.ZERO;

public class OperationsTest {
    @Test(expected = AssertionError.class)
    public void searching_operation_from_null_value_should_be_forbidden() throws Exception {
        Operations.of(null);
    }

    @Test
    public void searching_non_existing_operation_should_return_empty_optional() throws Exception {
        assertThat(Operations.of("non existing operation")).isEqualTo(Optional.empty());
    }

    @Test
    public void applying_operation_should_call_method_right_method_on_numbers() throws Exception {
        Number zero = Mockito.spy(ZERO);

        SUM.applyOperation(zero, ZERO);

        Mockito.verify(zero).add(ZERO);
    }
}
package coffee;

import org.junit.Test;

public class CoffeeMachineErrorTest extends CoffeeMachineTest {
    @Test(expected = InvalidCommandException.class)
    public void should_throw_an_exception_when_drink_command_is_not_found() throws Exception {
        coffeeMachine.handle(new CustomerCommand("blabla"));
    }
}

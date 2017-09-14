package coffee;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CoffeeMachineBeverageTest extends CoffeeMachineTest {
    @Test
    public void should_send_an_email_when_not_enough_beverage() throws Exception {
        when(beverageChecker.isEmpty("H")).thenReturn(true);

        coffeeMachine.handle(new CustomerCommand("Chocolate"));

        verify(emailNotifier).notifyMissingDrink("H");
    }

    @Test
    public void should_send_a_message_to_user_when_not_enough_beverage() throws Exception {
        when(beverageChecker.isEmpty("H"))
                .thenReturn(true);

        coffeeMachine.handle(new CustomerCommand("Chocolate"));

        assertThat(coffeeMachine.handle(new CustomerCommand("Chocolate"))).isEqualTo("M:Not enough beverage");
    }
}

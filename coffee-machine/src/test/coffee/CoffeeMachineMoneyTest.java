package coffee;

import coffee.interfaces.CustomerCommand;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CoffeeMachineMoneyTest extends CoffeeMachineTest {

    @Test
    public void simple_chocolate_command_without_money() throws Exception {
        CustomerCommand customerCustomer = new CustomerCommand("Chocolate", 2, false, 0);
        assertThat(coffeeMachine.handle(customerCustomer)).isEqualTo("M:Not enough money : 50 is missing");
    }

    @Test
    public void simple_chocolate_command_without_enough_money() throws Exception {
        CustomerCommand customerCustomer = new CustomerCommand("Tea", 0, false, 10);
        assertThat(coffeeMachine.handle(customerCustomer)).isEqualTo("M:Not enough money : 30 is missing");
    }
}

package coffee;

import coffee.interfaces.CustomerCommand;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CoffeeMachineFormatTest extends CoffeeMachineTest {
    @Test
    public void simple_tea_command() throws Exception {
        CustomerCommand customerCustomer = new CustomerCommand("Tea");
        assertThat(coffeeMachine.handle(customerCustomer)).isEqualTo("T::");
    }

    @Test
    public void simple_chocolate_command() throws Exception {
        CustomerCommand customerCustomer = new CustomerCommand("Chocolate");
        assertThat(coffeeMachine.handle(customerCustomer)).isEqualTo("H::");
    }

    @Test
    public void simple_coffee_command() throws Exception {
        CustomerCommand customerCustomer = new CustomerCommand("Coffee");
        assertThat(coffeeMachine.handle(customerCustomer)).isEqualTo("C::");
    }

    @Test
    public void simple_tea_command_with_one_sugar() throws Exception {
        CustomerCommand customerCustomer = new CustomerCommand("Tea", 1);
        assertThat(coffeeMachine.handle(customerCustomer)).isEqualTo("T:1:0");
    }

    @Test
    public void simple_chocolate_command_with_one_sugar() throws Exception {
        CustomerCommand customerCustomer = new CustomerCommand("Chocolate", 1);
        assertThat(coffeeMachine.handle(customerCustomer)).isEqualTo("H:1:0");
    }

    @Test
    public void simple_chocolate_command_with_two_sugar() throws Exception {
        CustomerCommand customerCustomer = new CustomerCommand("Chocolate", 2);
        assertThat(coffeeMachine.handle(customerCustomer)).isEqualTo("H:2:0");
    }

    @Test
    public void simple_orange_juice_command() throws Exception {
        CustomerCommand customerCustomer = new CustomerCommand("Orange Juice");
        assertThat(coffeeMachine.handle(customerCustomer)).isEqualTo("O::");
    }

    @Test
    public void simple_extra_hot_chocolate_command() throws Exception {
        CustomerCommand customerCustomer = new CustomerCommand("Chocolate", 0, true);
        assertThat(coffeeMachine.handle(customerCustomer)).isEqualTo("Hh::");
    }
}

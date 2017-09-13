package coffee;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CoffeeMachineTest {
    private CoffeeMachine coffeeMachine;

    @Before
    public void setUp() throws Exception {
        coffeeMachine = new CoffeeMachine();
    }

    @Test
    public void simple_tea_command() throws Exception {
        CustomerCommand customerCustomer = new CustomerCommand("Tea", 0);
        assertThat(coffeeMachine.handle(customerCustomer)).isEqualTo("T::");
    }

    @Test
    public void simple_chocolate_command() throws Exception {
        CustomerCommand customerCustomer = new CustomerCommand("Chocolate", 0);
        assertThat(coffeeMachine.handle(customerCustomer)).isEqualTo("H::");
    }

    @Test
    public void simple_coffee_command() throws Exception {
        CustomerCommand customerCustomer = new CustomerCommand("Coffee", 0);
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
    public void simple_chocolate_command_without_enough_money() throws Exception {
        CustomerCommand customerCustomer = new CustomerCommand("Chocolate", 2, 0);
        assertThat(coffeeMachine.handle(customerCustomer)).isEqualTo("M:Not enough money");
    }
}

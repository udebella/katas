package coffee;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CoffeeMachineTest {
    private CoffeeMachine coffeeMachine;

    @Mock
    private Printer printer;

    @Mock
    private EmailNotifier emailNotifier;

    @Mock
    private BeverageQuantityChecker beverageChecker;

    @Before
    public void setUp() throws Exception {
        when(beverageChecker.isEmpty(any()))
                .thenReturn(false);
        coffeeMachine = new CoffeeMachine(beverageChecker, emailNotifier);
    }

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
    public void simple_chocolate_command_without_money() throws Exception {
        CustomerCommand customerCustomer = new CustomerCommand("Chocolate", 2, false, 0);
        assertThat(coffeeMachine.handle(customerCustomer)).isEqualTo("M:Not enough money : 50 is missing");
    }

    @Test
    public void simple_chocolate_command_without_enough_money() throws Exception {
        CustomerCommand customerCustomer = new CustomerCommand("Tea", 0, false, 10);
        assertThat(coffeeMachine.handle(customerCustomer)).isEqualTo("M:Not enough money : 30 is missing");
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

    @Test
    public void report_should_be_zero_for_each_drink_by_default() throws Exception {
        coffeeMachine.report(printer);

        verify(printer).print("Drink type   | Number sold | Money earned");
        verify(printer).print("Orange Juice | 0 | 0");
        verify(printer).print("Chocolate | 0 | 0");
        verify(printer).print("Coffee | 0 | 0");
        verify(printer).print("Tea | 0 | 0");
    }

    @Test
    public void should_print_report_for_each_drink() throws Exception {
        coffeeMachine.handle(new CustomerCommand("Chocolate"));
        coffeeMachine.handle(new CustomerCommand("Tea"));
        coffeeMachine.handle(new CustomerCommand("Orange Juice"));
        coffeeMachine.handle(new CustomerCommand("Coffee"));

        coffeeMachine.report(printer);

        verify(printer).print("Drink type   | Number sold | Money earned");
        verify(printer).print("Orange Juice | 1 | 60");
        verify(printer).print("Chocolate | 1 | 50");
        verify(printer).print("Coffee | 1 | 60");
        verify(printer).print("Tea | 1 | 40");
    }

    @Test
    public void should_print_report_when_same_drink_is_sold_twice() throws Exception {
        coffeeMachine.handle(new CustomerCommand("Chocolate"));
        coffeeMachine.handle(new CustomerCommand("Chocolate"));

        coffeeMachine.report(printer);

        verify(printer).print("Drink type   | Number sold | Money earned");
        verify(printer).print("Orange Juice | 0 | 0");
        verify(printer).print("Chocolate | 2 | 100");
        verify(printer).print("Coffee | 0 | 0");
        verify(printer).print("Tea | 0 | 0");
    }

    @Test
    public void should_send_an_email_when_not_enough_beverage() throws Exception {
        when(beverageChecker.isEmpty("H"))
                .thenReturn(true);

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

    @Test
    public void should_not_add_to_report_when_not_enough_beverage() throws Exception {
        when(beverageChecker.isEmpty("H"))
                .thenReturn(true);

        coffeeMachine.handle(new CustomerCommand("Chocolate"));

        coffeeMachine.report(printer);

        verify(printer).print("Chocolate | 0 | 0");
    }
}

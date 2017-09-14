package coffee;

import coffee.interfaces.CustomerCommand;
import coffee.interfaces.Printer;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CoffeeMachineReportTest extends CoffeeMachineTest {

    @Mock
    private Printer printer;

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
    public void should_not_add_to_report_when_not_enough_money() throws Exception {
        coffeeMachine.handle(new CustomerCommand("Chocolate", 0, false, 10));

        coffeeMachine.report(printer);

        verify(printer).print("Chocolate | 0 | 0");
    }


    @Test
    public void should_not_add_to_report_when_not_enough_beverage() throws Exception {
        when(beverageChecker.isEmpty("H")).thenReturn(true);

        coffeeMachine.handle(new CustomerCommand("Chocolate"));

        coffeeMachine.report(printer);

        verify(printer).print("Chocolate | 0 | 0");
    }
}

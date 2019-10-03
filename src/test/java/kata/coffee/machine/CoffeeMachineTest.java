package kata.coffee.machine;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(JUnitParamsRunner.class)
public class CoffeeMachineTest {

    private DrinkMaker drinkMaker;
    private CoffeeMachine coffeeMachine;

    @Before
    public void setUp() {
        drinkMaker = mock(DrinkMaker.class);
        coffeeMachine = new CoffeeMachine(drinkMaker);
    }

    @Test
    @Parameters({"TEA, T:1:0", "COFFEE, C:1:0", "CHOCOLATE, H:1:0", "ORANGE_JUICE, O:1:0", })
    public void should_send_message_to_drink_maker(Drinks drinks, String command) {
        final Order order = Order.of(new SugarDrink(drinks, 1), Amount.of(100));

        coffeeMachine.make(order);

        verify(drinkMaker).process(command);
    }

    @Test
    public void should_allow_to_order_two_sugar() {
        final Order order = Order.of(new SugarDrink(Drinks.CHOCOLATE, 2), Amount.of(100));

        coffeeMachine.make(order);

        verify(drinkMaker).process("H:2:0");
    }

    @Test
    public void should_not_ask_for_a_stick_when_no_sugar_asked() {
        final Order order = Order.of(new SugarDrink(Drinks.CHOCOLATE, 0), Amount.of(100));

        coffeeMachine.make(order);

        verify(drinkMaker).process("H::");
    }

    @Test
    public void should_refuses_order_if_insufficient_amount() {
        final Order order = Order.of(new SugarDrink(Drinks.CHOCOLATE, 0), Amount.of(0));

        coffeeMachine.make(order);

        verify(drinkMaker).process("M:Missing 50 cents");
    }
}

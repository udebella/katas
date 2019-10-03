package kata.coffee.machine;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(JUnitParamsRunner.class)
public class CoffeeMachineTest {
    @Test
    @Parameters({"TEA, T:1:0", "COFFEE, C:1:0", "CHOCOLATE, H:1:0", })
    public void should_send_message_to_drink_maker(Drink drink, String command) {
        final DrinkMaker drinkMaker = mock(DrinkMaker.class);
        final CoffeeMachine coffeeMachine = new CoffeeMachine(drinkMaker);
        final Order order = Order.of(drink, new SugarNumber(1));

        coffeeMachine.make(order);

        verify(drinkMaker).process(command);
    }

    @Test
    public void should_allow_to_order_two_sugar() {
        final DrinkMaker drinkMaker = mock(DrinkMaker.class);
        final CoffeeMachine coffeeMachine = new CoffeeMachine(drinkMaker);
        final Order order = Order.of(Drink.CHOCOLATE, new SugarNumber(2));

        coffeeMachine.make(order);

        verify(drinkMaker).process("H:2:0");
    }
}

package kata.coffee.machine;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CoffeeMachineTest {
    @Test
    public void should_send_message_to_drink_maker_for_a_tea_with_one_sugar() {
        final DrinkMaker drinkMaker = mock(DrinkMaker.class);
        final CoffeeMachine coffeeMachine = new CoffeeMachine(drinkMaker);
        final Order order = Order.of(Drink.TEA, 1);

        coffeeMachine.make(order);

        verify(drinkMaker).process("T:1:0");
    }
}

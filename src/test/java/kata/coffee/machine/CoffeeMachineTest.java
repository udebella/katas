package kata.coffee.machine;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import kata.coffee.machine.drinks.Drinks;
import kata.coffee.machine.reporting.Console;
import kata.coffee.machine.reporting.Repository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.*;

@RunWith(JUnitParamsRunner.class)
public class CoffeeMachineTest {

    private DrinkMaker drinkMaker;
    private CoffeeMachine coffeeMachine;
    private Repository repository;
    private EmailNotifier emailNotifier;
    private BeverageQuantityChecker beverageQuantityChecker;

    @Before
    public void setUp() {
        repository = new Repository();
        drinkMaker = mock(DrinkMaker.class);
        emailNotifier = mock(EmailNotifier.class);
        beverageQuantityChecker = mock(BeverageQuantityChecker.class);
        coffeeMachine = new CoffeeMachine(drinkMaker, repository, emailNotifier, beverageQuantityChecker);
    }

    @Test
    @Parameters({"TEA, T:1:0", "COFFEE, C:1:0", "CHOCOLATE, H:1:0", "ORANGE_JUICE, O:1:0", })
    public void should_send_message_to_drink_maker(Drinks drinks, String command) {
        final Order order = OrderBuilder.newBuilder()
                .withDrink(drinks)
                .withSugar(1)
                .withAmount(100)
                .build();

        coffeeMachine.make(order);

        verify(drinkMaker).process(command);
    }

    @Test
    public void should_allow_to_order_two_sugar() {
        final Order order = OrderBuilder.newBuilder()
                .withDrink(Drinks.CHOCOLATE)
                .withSugar(2)
                .withAmount(100)
                .build();

        coffeeMachine.make(order);

        verify(drinkMaker).process("H:2:0");
    }

    @Test
    public void should_not_ask_for_a_stick_when_no_sugar_asked() {
        final Order order = OrderBuilder.newBuilder()
                .withDrink(Drinks.CHOCOLATE)
                .withAmount(100)
                .build();

        coffeeMachine.make(order);

        verify(drinkMaker).process("H::");
    }

    @Test
    @Parameters({"TEA, 39", "COFFEE, 59", "CHOCOLATE, 49", "ORANGE_JUICE, 59", })
    public void should_refuses_order_if_insufficient_amount(Drinks drink, int amount) {
        final Order order = OrderBuilder.newBuilder()
                .withDrink(drink)
                .withAmount(amount)
                .build();

        coffeeMachine.make(order);

        verify(drinkMaker).process("M:Missing 1 cents");
    }

    @Test
    public void should_allow_to_ask_extra_hot_drinks() {
        final Order order = OrderBuilder.newBuilder()
                .withDrink(Drinks.TEA)
                .extraHot()
                .withSugar(2)
                .withAmount(100)
                .build();

        coffeeMachine.make(order);

        verify(drinkMaker).process("Th:2:0");
    }

    @Test
    public void should_properly_check_price_for_extra_hot_drinks() {
        final Order order = OrderBuilder.newBuilder()
                .withDrink(Drinks.TEA)
                .withSugar(2)
                .extraHot()
                .build();

        coffeeMachine.make(order);

        verify(drinkMaker).process("M:Missing 40 cents");
    }

    @Test
    public void should_allow_to_track_every_sold_drink() {
        final Console console = mock(Console.class);
        final Order order = OrderBuilder.newBuilder()
                .withDrink(Drinks.TEA)
                .withSugar(2)
                .extraHot()
                .withAmount(100)
                .build();

        coffeeMachine.make(order);
        repository.printReporting(console);

        verify(console).print("TEA: 40 cents");
    }

    @Test
    public void should_not_track_refused_order() {
        final Console console = mock(Console.class);
        final Order order = OrderBuilder.newBuilder()
                .withDrink(Drinks.TEA)
                .withSugar(2)
                .extraHot()
                .build();

        coffeeMachine.make(order);
        repository.printReporting(console);

        verifyZeroInteractions(console);
    }

    @Test
    public void should_send_an_email_when_there_is_a_shortage_in_water() {
        when(beverageQuantityChecker.isEmpty("water")).thenReturn(true);
        final Order order = OrderBuilder.newBuilder()
                .withDrink(Drinks.TEA)
                .withSugar(2)
                .extraHot()
                .build();

        coffeeMachine.make(order);

        verify(emailNotifier).notifyMissingDrink("water");
        verify(drinkMaker).process("M:Missing water, notification sent");
    }

    @Test
    public void should_send_an_email_when_there_is_a_shortage_in_milk() {
        when(beverageQuantityChecker.isEmpty("milk")).thenReturn(true);
        final Order order = OrderBuilder.newBuilder()
                .withDrink(Drinks.TEA)
                .withSugar(2)
                .extraHot()
                .build();

        coffeeMachine.make(order);

        verify(emailNotifier).notifyMissingDrink("milk");
        verify(drinkMaker).process("M:Missing milk, notification sent");
    }
}

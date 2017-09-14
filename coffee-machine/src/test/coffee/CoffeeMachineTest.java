package coffee;

import coffee.interfaces.BeverageQuantityChecker;
import coffee.interfaces.EmailNotifier;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public abstract class CoffeeMachineTest {
    protected CoffeeMachine coffeeMachine;

    @Mock
    protected EmailNotifier emailNotifier;

    @Mock
    protected BeverageQuantityChecker beverageChecker;

    @Before
    public void setUp() throws Exception {
        when(beverageChecker.isEmpty(any())).thenReturn(false);
        coffeeMachine = new CoffeeMachine(beverageChecker, emailNotifier);
    }
}

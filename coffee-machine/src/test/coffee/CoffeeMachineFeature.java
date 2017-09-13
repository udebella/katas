package coffee;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class CoffeeMachineFeature {
    private CoffeeMachine coffeeMachine;

    @Before
    public void setUp() throws Exception {
        coffeeMachine = new CoffeeMachine();
    }

    @Ignore
    @Test
    public void coffee_machine_feature() throws Exception {
        CustomerCommand customerCustomer = new CustomerCommand("Tea", 1);

        assertThat(coffeeMachine.handle(customerCustomer)).isEqualTo("T:1:0");

        customerCustomer = new CustomerCommand("Chocolate", 0);

        assertThat(coffeeMachine.handle(customerCustomer)).isEqualTo("H::");

        customerCustomer = new CustomerCommand("coffee", 2);

        assertThat(coffeeMachine.handle(customerCustomer)).isEqualTo("C:2:0");
    }
}

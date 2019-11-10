package kata.corporate.hotel.booking;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RoomTest {
    @Test
    void should_verify_equality() {
        EqualsVerifier.forClass(Room.class).verify();
    }

    @Test
    void should_forbid_null_types() {
        Assertions.assertThatThrownBy(() -> Room.of(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("Room type is mandatory");
    }
}
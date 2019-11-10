package kata.corporate.hotel.booking;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

class RoomTest {
    @Test
    void should_verify_equality() {
        EqualsVerifier.forClass(Room.class).verify();
    }
}
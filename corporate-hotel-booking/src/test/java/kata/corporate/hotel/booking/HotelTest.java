package kata.corporate.hotel.booking;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class HotelTest {
    @Test
    void should_verify_equality() {
        EqualsVerifier.forClass(Hotel.class).verify();
    }

    @Test
    void should_forbid_null_room_list() {
        Assertions.assertThatThrownBy(() -> Hotel.of(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("Room list is mandatory");
    }
}
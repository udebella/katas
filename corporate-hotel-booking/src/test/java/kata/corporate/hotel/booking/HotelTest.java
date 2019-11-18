package kata.corporate.hotel.booking;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

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

    @Test
    void should_allow_to_add_new_rooms() {
        final Hotel hotel = Hotel.of(Collections.emptyList());

        final Hotel newHotel = hotel.addRoom(Room.of("regular"));

        Assertions.assertThat(newHotel).isEqualTo(Hotel.of(Collections.singletonList(Room.of("regular"))));
    }

    @Test
    void should_keep_previous_rooms_when_adding_new_rooms_in_the_hotel() {
        final Hotel hotel = Hotel.of(Collections.singletonList(Room.of("premium")));

        final Hotel newHotel = hotel.addRoom(Room.of("regular"));

        Assertions.assertThat(newHotel).isEqualTo(Hotel.of(Arrays.asList(Room.of("premium"), Room.of("regular"))));
    }

    @Test
    void should_match_given_the_hotel_id() {
        final Hotel hotel = Hotel.of("hotelId", Collections.emptyList());

        Assertions.assertThat(hotel.matches("hotelId")).isTrue();
    }
}
package kata.corporate.hotel.booking;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HotelScenarioTest {
    @Test
    public void should_define_rooms_for_an_hotel() {
        final HotelRepository repository = new InMemoryHotelRepository();
        final HotelService hotelService = new HotelServiceImpl(repository);

        hotelService.setRoomType("testHotel", "regular", 4);
        final Hotel testHotel = hotelService.findHotelBy("testHotel");

        final Hotel expected = Hotel.of("testHotel", generateRooms("regular", 4));
        Assertions.assertThat(testHotel).isEqualTo(expected);
    }

    private List<Room> generateRooms(String roomType, int quantity) {
        return IntStream.rangeClosed(1, quantity)
                .mapToObj(number -> Room.of(roomType))
                .collect(Collectors.toList());
    }
}

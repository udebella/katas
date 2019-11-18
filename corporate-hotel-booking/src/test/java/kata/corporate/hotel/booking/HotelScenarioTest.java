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

        final List<Room> roomList = IntStream.rangeClosed(1, 4)
                .mapToObj(number -> Room.of("regular"))
                .collect(Collectors.toList());
        final Hotel expected = Hotel.of("testHotel", roomList);
        Assertions.assertThat(testHotel).isEqualTo(expected);
    }
}

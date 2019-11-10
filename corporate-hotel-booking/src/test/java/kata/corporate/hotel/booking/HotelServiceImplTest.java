package kata.corporate.hotel.booking;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class HotelServiceImplTest {
    @Test
    void should_create_hotel_when_missing() {
        final HotelRepository repository = mock(HotelRepository.class);
        final HotelServiceImpl hotelService = new HotelServiceImpl(repository);

        hotelService.setRoomType("hotelId", "regular", 1);

        verify(repository).save(Hotel.of(Collections.singletonList(Room.of("regular"))));
    }
}
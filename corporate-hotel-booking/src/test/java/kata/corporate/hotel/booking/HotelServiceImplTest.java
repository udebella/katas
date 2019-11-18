package kata.corporate.hotel.booking;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import static org.mockito.Mockito.*;

class HotelServiceImplTest {
    @Test
    void should_create_hotel_when_missing() {
        final HotelRepository repository = mock(HotelRepository.class);
        doReturn(Optional.empty()).when(repository).find("hotelId");
        final HotelServiceImpl hotelService = new HotelServiceImpl(repository);

        hotelService.setRoomType("hotelId", "regular", 1);

        verify(repository).save(Hotel.of("hotelId", Collections.singletonList(Room.of("regular"))));
    }

    @Test
    void should_update_existing_hotel() {
        final HotelRepository repository = mock(HotelRepository.class);
        doReturn(Optional.of(Hotel.of("hotelId", Collections.singletonList(Room.of("premium"))))).when(repository).find("hotelId");
        final HotelServiceImpl hotelService = new HotelServiceImpl(repository);

        hotelService.setRoomType("hotelId", "regular", 1);

        verify(repository).save(Hotel.of("hotelId", Arrays.asList(Room.of("premium"), Room.of("regular"))));
    }

    @Test
    void should_return_an_empty_hotel_when_not_found_in_the_repository() {
        final HotelRepository repository = mock(HotelRepository.class);
        doReturn(Optional.empty()).when(repository).find("hotelId");
        final HotelServiceImpl hotelService = new HotelServiceImpl(repository);

        final Hotel hotelFound = hotelService.findHotelBy("hotelId");

        Assertions.assertThat(hotelFound).isEqualTo(Hotel.of("hotelId", Collections.emptyList()));
    }

    @Test
    void should_return_matching_hotel_when_found_in_the_repository() {
        final HotelRepository repository = mock(HotelRepository.class);
        final Hotel savedHotel = Hotel.of("hotelId", Collections.singletonList(Room.of("premium")));
        doReturn(Optional.of(savedHotel)).when(repository).find("hotelId");
        final HotelServiceImpl hotelService = new HotelServiceImpl(repository);

        final Hotel hotelFound = hotelService.findHotelBy("hotelId");

        Assertions.assertThat(hotelFound).isEqualTo(savedHotel);
    }
}
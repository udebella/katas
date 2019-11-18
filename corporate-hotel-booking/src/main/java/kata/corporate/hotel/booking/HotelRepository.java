package kata.corporate.hotel.booking;

import java.util.Optional;

public interface HotelRepository {
    void save(Hotel hotel);

    Optional<Hotel> find(String hotelId);
}

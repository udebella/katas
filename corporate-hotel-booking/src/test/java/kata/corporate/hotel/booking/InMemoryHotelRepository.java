package kata.corporate.hotel.booking;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class InMemoryHotelRepository implements HotelRepository {
    private final Set<Hotel> hotels = new HashSet<>();

    @Override
    public void save(Hotel hotel) {
        hotels.add(hotel);
    }

    @Override
    public Optional<Hotel> find(String hotelId) {
        return hotels.stream()
                .filter(hotel -> hotel.matches(hotelId))
                .findAny();
    }
}

package kata.corporate.hotel.booking;

import java.util.Collections;

public class HotelServiceImpl implements HotelService {
    private final HotelRepository repository;

    public HotelServiceImpl(HotelRepository repository) {
        this.repository = repository;
    }

    // TODO use encapsulating classes instead of primitives
    @Override
    public void setRoomType(String hotelId, String roomType, int quantity) {
        Hotel hotel = findHotelBy(hotelId);
        // TODO move this loop inside hotel class
        for (int i = 0; i < quantity; i++) {
            hotel = hotel.addRoom(Room.of(roomType));
        }
        repository.save(hotel);
    }

    @Override
    public Hotel findHotelBy(String hotelId) {
        return repository.find(hotelId).orElse(Hotel.of(hotelId, Collections.emptyList()));
    }
}

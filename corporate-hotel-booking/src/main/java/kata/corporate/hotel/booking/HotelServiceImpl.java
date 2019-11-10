package kata.corporate.hotel.booking;

import java.util.Collections;

public class HotelServiceImpl implements HotelService {
    private final HotelRepository repository;

    public HotelServiceImpl(HotelRepository repository) {
        this.repository = repository;
    }

    @Override
    public void setRoomType(String hotelId, String roomType, int quantity) {
        repository.save(Hotel.of(Collections.singletonList(Room.of(roomType))));
    }

    @Override
    public Hotel findHotelBy(String hotelId) {
        return null;
    }
}

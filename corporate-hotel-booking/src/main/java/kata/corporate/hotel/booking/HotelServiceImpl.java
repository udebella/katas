package kata.corporate.hotel.booking;

public class HotelServiceImpl implements HotelService {
    private final HotelRepository repository;

    public HotelServiceImpl(HotelRepository repository) {
        this.repository = repository;
    }

    @Override
    public void setRoomType(String hotelId, String roomType, int quantity) {
        Hotel hotel = repository.find(hotelId);
        for (int i = 0; i < quantity; i++) {
            hotel = hotel.addRoom(Room.of(roomType));
        }
        repository.save(hotel);
    }

    @Override
    public Hotel findHotelBy(String hotelId) {
        return null;
    }
}

package kata.corporate.hotel.booking;

public interface HotelRepository {
    void save(Hotel hotel);

    Hotel find(String hotelId);
}

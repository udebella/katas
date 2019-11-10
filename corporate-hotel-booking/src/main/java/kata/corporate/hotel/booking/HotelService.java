package kata.corporate.hotel.booking;

public interface HotelService {
    void setRoomType(String hotelId, String roomType, int quantity);

    Hotel findHotelBy(String hotelId);
}

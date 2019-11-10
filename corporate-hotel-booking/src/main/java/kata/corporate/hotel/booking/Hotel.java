package kata.corporate.hotel.booking;

import java.util.List;
import java.util.Objects;

public final class Hotel {
    private final List<Room> roomList;

    private Hotel(List<Room> roomList) {
        this.roomList = roomList;
    }

    public static Hotel of(List<Room> roomList) {
        Objects.requireNonNull(roomList, "Room list is mandatory");
        return new Hotel(roomList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return Objects.equals(roomList, hotel.roomList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomList);
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "roomList=" + roomList +
                '}';
    }
}

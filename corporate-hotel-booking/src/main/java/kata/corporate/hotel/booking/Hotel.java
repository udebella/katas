package kata.corporate.hotel.booking;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Hotel {
    private final Collection<Room> roomList;

    private Hotel(Collection<Room> roomList) {
        this.roomList = roomList;
    }

    public static Hotel of(Collection<Room> roomList) {
        Objects.requireNonNull(roomList, "Room list is mandatory");
        return new Hotel(roomList);
    }

    public static Hotel of(String hotelId, Collection<Room> rooms) {
        return of(rooms);
    }

    public Hotel addRoom(Room addedRoom) {
        final Collection<Room> newRoomList = Stream.concat(roomList.stream(), Stream.of(addedRoom))
                .collect(Collectors.toList());
        return of(newRoomList);
    }

    public boolean matches(String hotelId) {
        return true;
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

package kata.corporate.hotel.booking;

import java.util.Objects;

public final class Room {
    private final String type;

    private Room(String type) {
        this.type = type;
    }

    public static Room of(String type) {
        Objects.requireNonNull(type, "Room type is mandatory");
        return new Room(type);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(type, room.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    @Override
    public String toString() {
        return "Room{" +
                "type='" + type + '\'' +
                '}';
    }
}

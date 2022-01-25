package model;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Hotel {

    private final TreeMap<Integer, Room> rooms = new TreeMap<>();

    public Hotel() {
        for (int i = 0; i < 10 ; i++) {
            int id = rooms.size() + 1;
            Room room = new Room(id, RoomTypeEnum.STANDARD);
            rooms.put(id, room);
        }
        for (int i = 0; i < 10 ; i++) {
            int id = rooms.size() + 1;
            Room room = new Room(id, RoomTypeEnum.PREMIUM);
            rooms.put(id, room);
        }
        for (int i = 0; i < 10 ; i++) {
            int id = rooms.size() + 1;
            Room room = new Room(id, RoomTypeEnum.SUPREME);
            rooms.put(id, room);
        }
    }

    public Book book(Guest guest, RoomTypeEnum roomType, LocalDate checkInDate, LocalDate checkOutDate) {

        LocalDate deadline = LocalDate.now().plusDays(60);

        if (!(checkOutDate.isAfter(checkInDate))) {
            throw new IllegalArgumentException("A data do check-out deve ser maior que a data do check-in.");
        }

        if (checkInDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Não é possível reservar data anterior ao dia atual.");
        }

        if(checkInDate.isAfter(deadline)) {
            throw new IllegalArgumentException("A reserva só poderá ser feita para até 60 dias apartir da data atual.");
        }

        Room result = rooms.values().stream()
                .filter(room -> room.getRoomType() == roomType)
                .filter(room -> room.isAvailable(checkInDate, checkOutDate))
                .findFirst().orElse(null);

        if (result == null) {
            throw new IllegalArgumentException("Não há nenhum quarto disponível nesta data.");
        }
        return result.book(guest, checkInDate, checkOutDate);
    }

    public List<Book> searchByDocument(String document) {
        List<Book> result = rooms.values().stream()
                .map(room -> room.getByDocument(document))
                .flatMap(List::stream)
                .collect(Collectors.toList());

        return result;
    }
}

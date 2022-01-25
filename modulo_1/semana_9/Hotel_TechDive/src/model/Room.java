package model;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Room {
    private final int id;
    private final RoomTypeEnum roomType;
    private final LinkedList<Book> books = new LinkedList<>();

    public Room(int id, RoomTypeEnum roomType) {
        this.roomType = roomType;
        this.id = id;
    }

    public RoomTypeEnum getRoomType() {
        return roomType;
    }

    public int getId() {
        return id;
    }

    public boolean isAvailable(LocalDate checkInDate, LocalDate checkOutDate) {
        boolean result = books.stream()
                .filter(book -> !book.isCancelled())
                .anyMatch(book -> book.overlap(checkInDate, checkOutDate));
        return !result;
    }

    public Book book(Guest guest, LocalDate checkInDate, LocalDate checkOutDate) {
        if (!isAvailable(checkInDate, checkOutDate)) {
            throw new IllegalArgumentException("Não foi possível encontrar uma vaga.");
        }

        Book book = new Book(guest, this, checkInDate, checkOutDate);

        books.add(book);

        return book;
    }

    public List<Book> getByDocument(String document) {
        String finalDocument = document.toLowerCase();

        List<Book> result = books.stream()
                .filter(book -> book.getGuest().getDocument().toLowerCase().contains(finalDocument))
                .collect(Collectors.toList());

        return result;
    }
}

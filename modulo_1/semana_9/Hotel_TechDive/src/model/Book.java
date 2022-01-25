package model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Book {
    private final LocalDate checkInDate;
    private final LocalDate checkOutDate;
    private final Guest guest;
    private final Room room;
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private boolean cancelled = false;

    public Book(Guest guest, Room room, LocalDate checkInDate, LocalDate checkOutDate) {
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public String getCheckInDate() {
        return dateFormatter.format(checkInDate);
    }

    public String getCheckOutDate() {
        return dateFormatter.format(checkOutDate);
    }

    public Room getRoom() {
        return room;
    }

    public Guest getGuest() {
        return guest;
    }

    public boolean overlap(LocalDate checkInDate, LocalDate checkOutDate) {

        if ((checkInDate.isAfter(this.checkInDate) || checkOutDate.isEqual(this.checkInDate)) && checkInDate.isBefore(this.checkOutDate))
            return true;

        if (checkOutDate.isAfter(this.checkInDate) && (checkOutDate.isBefore(this.checkOutDate) || checkOutDate.isEqual(this.checkOutDate)))
            return true;

        return false;
    }

    public void cancel() {
        if (this.cancelled) {
            throw new IllegalArgumentException("Esta reserva já foi cancelada.");
        }
        this.cancelled = true;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public double getPrice() {
        Period period = Period.between(this.checkInDate, this.checkOutDate);

        int days = period.getDays();

        double cost = Season.IsHighSeason(checkInDate) ? room.getRoomType().getHighCost() : room.getRoomType().getLowCost();

        return cost * days;
    }
}

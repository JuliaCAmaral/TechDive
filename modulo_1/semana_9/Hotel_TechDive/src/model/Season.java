package model;

import java.time.LocalDate;

public class Season {

    public static boolean IsHighSeason(LocalDate date){
        LocalDate startHighSeason = LocalDate.of(date.getYear(),11, 1);
        LocalDate endHighSeason =   LocalDate.of(date.getYear(), 3, 31);

        return !(date.isAfter(endHighSeason) && date.isBefore(startHighSeason));
    }
}

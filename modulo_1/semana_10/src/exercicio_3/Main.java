package exercicio_3;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class Main {
    public static void main(String[] args) {
        int currentYear = LocalDate.now().getYear();

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate begin = LocalDate.of(currentYear, 1, 1);
        TemporalAdjuster temporalAdjuster = TemporalAdjusters.next(DayOfWeek.SATURDAY);

        if (begin.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
            String beginFormat = begin.format(format);
            System.out.println(beginFormat + "\n");
        }

        while (begin.getYear() == currentYear) {
            LocalDate saturday = begin.with(temporalAdjuster);
            String satudayFormat = saturday.format(format);

            if (saturday.getYear() != currentYear) {
                break;
            }

            System.out.println(satudayFormat + "\n");
            begin = saturday;
        }
    }
}

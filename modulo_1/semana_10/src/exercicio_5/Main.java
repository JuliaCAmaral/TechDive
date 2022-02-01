package exercicio_5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Scanner;

public class Main {

    private static Scanner input = new Scanner(System.in);
    private static DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {
        System.out.print("Insira uma data (mm/aaaa): ");

        YearMonth userData = readDate();

        LocalDate begin = LocalDate.of(userData.getYear(), userData.getMonth(), 1);
        TemporalAdjuster temporalAdjuster = TemporalAdjusters.next(DayOfWeek.MONDAY);

        if (begin.getDayOfWeek().equals(DayOfWeek.MONDAY)) {
            String beginFormat = begin.format(format);
            System.out.println(beginFormat + "\n");
        }

        while (begin.getMonth() == userData.getMonth()) {
            LocalDate monday = begin.with(temporalAdjuster);
            String mondayFormat = monday.format(format);

            if (monday.getMonth() != userData.getMonth()) {
                break;
            }

            System.out.println(mondayFormat + "\n");
            begin = monday;
        }
    }

    private static YearMonth readDate() {
        while (true) {
            String entryDate = input.nextLine().trim();

            try {
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/yyyy");
                return YearMonth.parse(entryDate, dateFormatter);

            } catch (DateTimeParseException e) {
                System.out.print("\nData inválida. Digite novamente a data (mm/aaaa):");
            }
        }
    }
}

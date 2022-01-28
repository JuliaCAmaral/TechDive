package exercicio_2;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd MMM yyyy  HH:mm");

        LocalDateTime leaving = LocalDateTime.of(2022, Month.JANUARY, 29, 16, 30);
        ZoneId leavingZone = ZoneId.of("America/Sao_Paulo");
        ZonedDateTime departure = ZonedDateTime.of(leaving, leavingZone);

        String departureFormat = departure.format(format);

        System.out.printf("Saída:  %s (%s)%n", departureFormat, leavingZone);

        ZoneId arrivingZone = ZoneId.of("Africa/Cairo");
        ZonedDateTime arrival = departure.withZoneSameInstant(arrivingZone)
                .plusMinutes(1200);

        String arrivalFormat = arrival.format(format);
        System.out.printf("Chegada: %s (%s)%n", arrivalFormat, arrivingZone);

        Duration duration = Duration.between(departure, arrival);
        System.out.printf("%nO voo terá duração de %d horas.", duration.toHours());
    }
}

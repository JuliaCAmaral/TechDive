import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SaudarUsuario {

    public static void main(String[] args) {

        LocalDateTime agora = LocalDateTime.now();

        DateTimeFormatter formatterHoraAtual = DateTimeFormatter.ofPattern("HH:mm");
        String horaFormatada = formatterHoraAtual.format(agora);

        DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH");
        int hora = Integer.parseInt(formatterHora.format(agora));

        String saudacao;

        if (hora >= 6 && hora < 12) {
            saudacao = "Bom dia";
        } else if (hora >= 12 && hora < 18) {
            saudacao = "Boa tarde";
        } else {
            saudacao = "Boa noite";
        }

        System.out.printf("%s, no momento são %s.", saudacao, horaFormatada);

    }
}

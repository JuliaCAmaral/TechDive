// Crie um programa em Java que, ao executar, verifique o horário atual e escreva para o usuário uma saudação, contendo o período e o horário.
// Por exemplo: “Boa tarde, no momento são 15:08.”.


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class M1S04 {

    public static void main(String[] args) {

        // data/hora atual
        LocalDateTime agora = LocalDateTime.now();

        // formatar a data
        DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        String dataFormatada = formatterData.format(agora);

        // formatar a hora
        DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm a");
        String horaFormatada = formatterHora.format(agora);

        String saudacao;

        if (true) {
            saudacao = "Bom dia, ";
        } else if (true) {
            saudacao = "Boa tarde, ";

        } else {
            saudacao = "Boa noite, ";
        }

        System.out.println(saudacao + "no momento são " + horaFormatada + ".");




    }
}

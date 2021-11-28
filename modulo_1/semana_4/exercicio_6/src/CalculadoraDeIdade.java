import java.text.ParseException;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.Period;

public class CalculadoraDeIdade {

    public static void main(String[] args) throws ParseException {

        Scanner input = new Scanner(System.in);

        System.out.print("Digite a sua data de nascimento (dd/mm/aaaa): ");
        String dataUsuario = input.next();

        DateTimeFormatter padraoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate dataUsuarioFormatada = LocalDate.parse(dataUsuario,padraoData);
        LocalDate dataAtual = LocalDate.now();

        Period periodBetween = Period.between(dataUsuarioFormatada, dataAtual);

        int idadeDoUsuario = periodBetween.getYears();

        boolean deMaior = idadeDoUsuario >= 18;

        String maioridade = deMaior ? "maior" : "menor";

        System.out.printf("%nVocê é %s de idade.%n", maioridade);

    }
}

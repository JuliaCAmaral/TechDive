package exercicio3;

import java.util.Calendar;
import java.util.Currency;
import java.util.Locale;
import static java.util.Locale.US;

public class DominandoOBasico {

    public static void main(String[] args) {

        Locale locale = US;

        Currency currency = Currency.getInstance(US);

        String december = Calendar.getInstance().getDisplayName(Calendar.MONTH, Calendar.LONG_FORMAT, US);

        System.out.printf("%nO mês atual se chama: %s", december);
        System.out.printf("%nO locale dos EUA: %s", locale);
        System.out.printf("%nA moeda dos EUA é: %s%n", currency);

    }
}

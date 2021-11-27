import java.util.Scanner;

public class CalculaIMC {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Digite sua altura (m): ");
        double altura = input.nextDouble();

        System.out.print("Digite seu peso (kg): ");
        double peso = input.nextDouble();

        double imc = peso / (altura * altura);

        System.out.printf("Seu IMC é: %.2f", imc);
    }
}

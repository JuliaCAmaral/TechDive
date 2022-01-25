package view;

import model.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner input = new Scanner(System.in);
    private static Hotel hotel = new Hotel();

    public static void main(String[] args) {
        while (true) {
            MenuEnum option = readOption(MenuEnum.values(), "\nEscolha uma opção:");

            try {
                switch (option) {
                    case BOOK:
                        book();
                        break;

                    case CANCEL:
                        cancel();
                        break;

                    case SIMULATION:
                        simulation();
                        break;

                    case EXIT:
                        System.out.println("Encerrando...");
                        System.exit(0);
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());

            } finally {
                System.out.print("\n----------------------------\n");
                System.out.println("Digite enter para continuar.");
                System.out.print("----------------------------\n\n");
                input.nextLine();
            }
        }
    }

    private static void simulation() {
        HighLowSeason highOrLow = readOption(HighLowSeason.values(), "Gostaria de Simular as 10 reservas durante qual temporada?");

        Simulation simulationUser = new Simulation();

        int period = 5;
        double result = 0;

        switch (highOrLow) {
            case HIGH_SEASON:
                result = simulationUser.getPrice(period, HighLowSeason.HIGH_SEASON);
                break;

            case LOW_SEASON:
                result = simulationUser.getPrice(period, HighLowSeason.LOW_SEASON);
                break;
        }

        System.out.printf("Vamos simular que entre estas 10 reservas para %d dias, possua os seguintes tipos de quartos:\n", period);
        System.out.printf("\nQuartos simples: %d\n", simulationUser.getStandardRooms());
        System.out.printf("Quartos de luxo: %d\n", simulationUser.getPremiumRooms());
        System.out.printf("Suítes suprema: %d\n", simulationUser.getSupremeRooms());
        System.out.printf("\nO valor total será de R$ %.2f\n", result);
    }

    private static void cancel() {
        System.out.print("Informe o documento do cliente: ");
        String document = readString();

        List<Book> books = hotel.searchByDocument(document);

        if (books.size() == 0) {
            System.out.println("Não há nenhuma reserva cadastrada com este documento.");
            return;
        }

        System.out.println("\nInforme o código da reserva que você deseja cancelar ou 0 para voltar ao menu inicial: ");

        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);

            int idBook = i + 1;
            String status = " - Cancelada: Não";

            if (book.isCancelled()) {
                status = " - Cancelada: Sim";
            }
            System.out.printf("%s - Estadia: %s até %s - Tipo de quarto %s %s\n",
                    idBook,book.getCheckInDate(), book.getCheckOutDate(), book.getRoom().getRoomType().getDisplayName(), status);
        }

        int idBookCancel;

        while (true) {
            idBookCancel = readInt() - 1;

            if (idBookCancel == -1) {
                throw new IllegalArgumentException("\nNenhuma reserva foi cancelada.\n");
            }

            if (idBookCancel < 0 || idBookCancel >= books.size()) {
                System.out.print("Código da reserva inválido. Informe o código da reserva que você deseja cancelar: ");
                continue;
            }
            break;
        }
        Book book = books.get(idBookCancel);

        book.cancel();

        System.out.println("Cancelamento da reserva realizado com sucesso.");
    }

    private static void book() {
        RoomTypeEnum roomType = readOption(RoomTypeEnum.values(), "\nEscolha uma opção de quarto ou 0 para voltar ao menu inicial:");
        LocalDate checkInDate;
        LocalDate checkOutDate;

        if (roomType.equals(RoomTypeEnum.EXIT)) {
            throw new IllegalArgumentException("Nenhuma reserva foi realizada.");
        }

        while (true) {
            System.out.print("Escolha a data do check-in (dd/mm/aaaa): ");
            checkInDate = readDate();

            System.out.print("Escolha a data do check-out (dd/mm/aaaa): ");
            checkOutDate = readDate();

            if (!(checkOutDate.isAfter(checkInDate))) {
                System.out.println("A data do check-out deve ser maior que a data do check-in.\n");
                continue;
            }
            break;
        }

        Guest guest = registerGuest();

        Book book = hotel.book(guest, roomType, checkInDate, checkOutDate);

        System.out.println("\nAgendamento realizado com sucesso!\n");
        System.out.println("-----------------------------------");
        System.out.println("Quarto: " + book.getRoom().getId());
        System.out.println("Tipo: " + book.getRoom().getRoomType().getDisplayName());
        System.out.printf("Check-in: %s após às 17h.\n", book.getCheckInDate());
        System.out.printf("Check-out: %s até às 10h.\n", book.getCheckOutDate());
        System.out.printf("Quantidade de hóspedes: %d.\n", book.getGuest().getGuests().length + 1);
        System.out.printf("Valor total: R$ %.2f\n", book.getPrice());
        System.out.println("-----------------------------------");
    }

    private static Guest registerGuest() {
        Guest guest = readGuest();

        YesNoEnum registerMoreGuests = readOption(YesNoEnum.values(), "\nVocê deseja cadastrar um convidado? ");

        while (registerMoreGuests.equals(YesNoEnum.YES)) {
            Guest anotherGuest = readGuest();
            guest.add(anotherGuest);
            registerMoreGuests = readOption(YesNoEnum.values(), "\nVocê deseja cadastrar mais um convidado? ");
        }
        return guest;
    }

    private static Guest readGuest() {
        System.out.print("Informe o nome: ");
        String name = readString();

        System.out.print("Informe o documento: ");
        String document = readString();

        System.out.print("Informe a data de nascimento (dd/mm/aaaa): ");
        LocalDate  birthDate = readDate();

        Guest guest = new Guest();
        guest.setName(name);
        guest.setDocument(document);
        guest.setBirthDate(birthDate);

        return guest;
    }

    private static String readString() {
        while (true) {
            String userInput = input.nextLine();

            if (userInput.isEmpty() || userInput.equals(" ")) {
                System.out.println("\nO campo não pode ser em branco.");
                System.out.print("Insira novamente: ");
                continue;
            }
            return userInput;
        }
    }

    private static LocalDate readDate() {
        while (true) {
            String entryDate = input.nextLine().trim();

            try {
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                return LocalDate.parse(entryDate, dateFormatter);

            } catch (DateTimeParseException e) {
                System.out.println("Data inválida. Digite novamente a data (dd/mm/aaaa):");
            }
        }
    }

    private static <TOptions extends DisplayEnum> TOptions readOption(TOptions[] options, String text) {
        System.out.println(text);
        for (TOptions option : options) {
            System.out.println(option.getValue() + " - " + option.getDisplayName());
        }

        while (true) {
            String line = input.nextLine();

            for (TOptions option : options) {
                if (Integer.toString(option.getValue()).equals(line)) {
                    return option;
                }
            }

            System.out.println("Escolha uma opção válida.");
        }
    }

    private static int readInt() {
        while (true) {
            String userInput = input.nextLine().trim();
            try {
                return Integer.parseInt(userInput);

            } catch (NumberFormatException e) {
                System.out.println("Valor incorreto, digite novamente um número inteiro.");
            }
        }
    }
}

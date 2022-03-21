package market.application.commands;

import market.application.enums.CrudEnum;
import market.application.enums.TableEnum;
import market.model.persistence.Client;
import market.services.ClientService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ClienteUpdate extends ViewCommand {

    private final Scanner input;
    private final ClientService clientService;
    private ValidationInt validationInt;

    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public ClienteUpdate(Scanner input, ClientService clientService) {
        super(CrudEnum.UPDATE, TableEnum.CLIENT);
        this.clientService = clientService;
        this.input = input;
    }

    @Override
    public void Execute() {
        System.out.println("Digite o Id do cliente que deseja alterar.");
        long id = validationInt.readInt(input);

        System.out.print("\nNovo nome do Cliente: ");
        String name = input.nextLine();

        System.out.print("\nNova data de nascimento do Cliente [dd/MM/yyyy]: ");
        String birthDate = input.nextLine();
        LocalDate formattedDateBirth = LocalDate.parse(birthDate, dateTimeFormatter);

        Client newClient = new Client(name, formattedDateBirth);

        try {
            clientService.update(newClient, id);
        } catch (Exception e) {
            e.getMessage();
        }
    }
}

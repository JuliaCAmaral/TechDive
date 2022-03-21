package market.application.commands;

import market.application.enums.CrudEnum;
import market.application.enums.TableEnum;
import market.model.persistence.Client;
import market.services.ClientService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ClientCreate extends ViewCommand {

    private final Scanner input;
    private final ClientService clientService;

    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public ClientCreate(Scanner input, ClientService clientService) {
        super(CrudEnum.CREATE, TableEnum.CLIENT);
        this.input = input;
        this.clientService = clientService;
    }

    @Override
    public void Execute() {
        System.out.print("\nNome do Cliente: ");
        String nameClient = input.nextLine();

        System.out.print("\nCPF do Cliente: ");
        String cpf = input.nextLine();

        System.out.print("\nData de nascimento do Cliente [dd/MM/yyyy]: ");
        String birthDate = input.nextLine();
        LocalDate formattedDateBirth = LocalDate.parse(birthDate, dateTimeFormatter);

        Client client = new Client(nameClient, cpf, formattedDateBirth);
        clientService.create(client);
    }
}

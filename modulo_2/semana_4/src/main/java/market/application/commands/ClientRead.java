package market.application.commands;

import market.application.Program;
import market.application.enums.CrudEnum;
import market.application.enums.ReadDataEnum;
import market.application.enums.TableEnum;
import market.model.persistence.Client;
import market.model.persistence.Product;
import market.services.ClientService;

import java.util.List;
import java.util.Scanner;

public class ClientRead extends ViewCommand {

    private final Scanner input;
    private final ClientService clientService;

    public ClientRead(Scanner input, ClientService clientService) {
        super(CrudEnum.READ, TableEnum.CLIENT);
        this.input = input;
        this.clientService = clientService;
    }

    @Override
    public void Execute() {
        ReadDataEnum option = Program.readOption(ReadDataEnum.values(), "\nQual tipo de busca deseja? ");

        List<Client> clients = null;
        switch (option) {
            case ALL:
                clients = clientService.listAll();
                break;

            case BY_NAME:
                System.out.println("\nDigite o nome que deseja pesquisar no banco de dados: ");
                String name = input.nextLine();

                clients = clientService.listByName(name);
                break;
        }
        clients.forEach(System.out::println);
    }
}

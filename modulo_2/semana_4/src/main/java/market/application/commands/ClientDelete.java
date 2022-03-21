package market.application.commands;

import market.application.enums.CrudEnum;
import market.application.enums.TableEnum;
import market.services.ClientService;

import java.util.Scanner;

public class ClientDelete extends ViewCommand {

    private final Scanner input;
    private final ClientService clientService;
    private ValidationInt validationInt;

    public ClientDelete(Scanner input, ClientService clientService) {
        super(CrudEnum.DELETE, TableEnum.CLIENT);
        this.input = input;
        this.clientService = clientService;
    }

    @Override
    public void Execute() {
        System.out.println("Digite o Id do cliente que deseja deletar.");
        long id = validationInt.readInt(input);
        clientService.delete(id);
    }
}

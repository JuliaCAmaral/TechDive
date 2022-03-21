package market.application;

import market.application.commands.*;
import market.application.enums.CrudEnum;
import market.application.enums.DisplayEnum;
import market.application.enums.TableEnum;
import market.connection.JpaConnectionFactory;
import market.services.ClientService;
import market.services.ProductService;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Program {
	
	private static final Logger LOG = LogManager.getLogger(Program.class);
	private static final EntityManager entityManager = new JpaConnectionFactory().getEntityManager();
	private static final Scanner input = new Scanner(System.in);
	private static final ProductService productService = new ProductService(entityManager);
	private static final ClientService clientService = new ClientService(entityManager);

	private static List<ViewCommand> commands = Stream.of(
			new ProductCreate(input, productService),
			new ProductRead(input, productService),
			new ProductUpdate(input, productService),
			new ProductDelete(input, productService),
			new ClientCreate(input, clientService),
			new ClientRead(input, clientService),
			new ClienteUpdate(input, clientService),
			new ClientDelete(input, clientService)
	).collect(Collectors.toList());

	public static void main(String[] args) {
		CrudEnum crudEnum = readOption(CrudEnum.values(), "Digite o número da operação:");
		TableEnum tableEnum = readOption(TableEnum.values(), "\nQual tabela deseja?");

		ViewCommand command = commands.stream().filter(c -> c.getCrudEnum() == crudEnum && c.getTableEnum() == tableEnum).findFirst().orElse(null);

		try {
			command.Execute();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public static <TOptions extends DisplayEnum> TOptions readOption(TOptions[] options, String text) {
		System.out.println(text);
		for (TOptions option : options) {
			System.out.println(option.getValue() + " - " + option.getDisplayName());
		}
		while (true) {
			String line = input.nextLine();
			for (TOptions option : options) {
				if(Integer.toString(option.getValue()).equals(line)){
					return option;
				}
			}
			System.out.println("Escolha uma opção válida.");
		}
	}
}

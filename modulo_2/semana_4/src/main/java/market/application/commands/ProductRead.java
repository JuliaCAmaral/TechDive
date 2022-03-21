package market.application.commands;

import market.application.Program;
import market.application.enums.CrudEnum;
import market.application.enums.ReadDataEnum;
import market.application.enums.TableEnum;
import market.model.persistence.Product;
import market.services.ProductService;

import java.util.List;
import java.util.Scanner;

public class ProductRead extends ViewCommand {

    private final Scanner input;
    private final ProductService productService;

    public ProductRead(Scanner input, ProductService productService) {
        super(CrudEnum.READ, TableEnum.PRODUCT);
        this.input = input;
        this.productService = productService;
    }

    @Override
    public void Execute() {
        ReadDataEnum option = Program.readOption(ReadDataEnum.values(), "\nQual tipo de busca deseja? ");

        List<Product> products = null;
        switch (option) {
            case ALL:
                products = productService.listAll();
                break;

            case BY_NAME:
                System.out.println("\nDigite o nome que deseja pesquisar no banco de dados: ");
                String name = input.nextLine();

                products = productService.listByName(name);
                break;
        }
        products.forEach(System.out::println);
    }
}

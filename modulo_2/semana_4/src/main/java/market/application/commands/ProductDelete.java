package market.application.commands;

import market.application.enums.CrudEnum;
import market.application.enums.TableEnum;
import market.services.ProductService;

import java.util.Scanner;

public class ProductDelete extends ViewCommand {

    private final Scanner input;
    private final ProductService productService;
    private ValidationInt validationInt;

    public ProductDelete(Scanner input, ProductService productService) {
        super(CrudEnum.DELETE, TableEnum.PRODUCT);
        this.input = input;
        this.productService = productService;
    }

    @Override
    public void Execute() {
        System.out.println("Digite o Id do produto que deseja deletar.");
        long id = validationInt.readInt(input);
        productService.delete(id);
    }

}

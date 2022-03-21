package market.application.commands;

import market.application.enums.CrudEnum;
import market.application.enums.TableEnum;
import market.model.persistence.Category;
import market.model.persistence.Product;
import market.services.ProductService;

import java.math.BigDecimal;
import java.util.Scanner;

public class ProductUpdate extends ViewCommand {

    private final Scanner input;
    private final ProductService productService;
    private ValidationInt validationInt;

    public ProductUpdate(Scanner input, ProductService productService) {
        super(CrudEnum.UPDATE, TableEnum.PRODUCT);
        this.input = input;
        this.productService = productService;
    }

    @Override
    public void Execute() {
        System.out.println("Digite o Id do produto que deseja alterar.");
        long id = validationInt.readInt(input);

        System.out.print("\nNovo nome do Produto: ");
        String newName = input.nextLine();

        System.out.print("\nNova descrição do Produto: ");
        String newDescription = input.nextLine();

        System.out.print("\nNovo preço do Produto (use ponto ao invés de vírgula): ");
        BigDecimal newPrice = input.nextBigDecimal();

        System.out.print("\nNova categoria do Produto: ");
        String newCategory = input.nextLine();

        Product newProduct = new Product(newName, newDescription, newPrice, new Category(newCategory));

        try {
            productService.update(newProduct, id);
        } catch (Exception e) {
            e.getMessage();
        }
    }
}

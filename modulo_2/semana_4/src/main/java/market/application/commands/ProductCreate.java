package market.application.commands;

import market.application.enums.CrudEnum;
import market.application.enums.TableEnum;
import market.model.persistence.Category;
import market.model.persistence.Product;
import market.services.ProductService;

import java.math.BigDecimal;
import java.util.Scanner;

public class ProductCreate extends ViewCommand {

    private final Scanner input;
    private final ProductService productService;

    public ProductCreate(Scanner input, ProductService productService) {
        super(CrudEnum.CREATE, TableEnum.PRODUCT);
        this.input = input;
        this.productService = productService;
    }

    @Override
    public void Execute() {
        System.out.print("\nNome do Produto: ");
        String nameProduct = input.nextLine();

        System.out.print("\nDescrição do Produto: ");
        String description = input.nextLine();

        System.out.print("\nPreço do Produto (use ponto ao invés de vírgula): ");
        BigDecimal price = input.nextBigDecimal();

        System.out.print("\nCategoria do Produto: ");
        String categoryName = input.nextLine();

        Product product = new Product(nameProduct, description, price, new Category(categoryName));
        productService.create(product);
    }
}

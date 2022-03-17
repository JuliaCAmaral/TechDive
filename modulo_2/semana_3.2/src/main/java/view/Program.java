package view;

import connection.FactoryConnection;
import connection.User;
import entities.Category;
import entities.Manufacturer;
import entities.Product;
import repositories.CategoryDAO;
import repositories.ManufacturerDAO;
import repositories.ProductDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Program {

    private static Scanner input = new Scanner(System.in);

    private static Connection connection = null;
    private static ProductDAO productDAO = new ProductDAO(connection);
    private static CategoryDAO categoryDAO = new CategoryDAO(connection);
    private static ManufacturerDAO manufacturerDAO = new ManufacturerDAO(connection);

    public static void main(String[] args) {
        User user = readUser();

        FactoryConnection factoryConnection = new FactoryConnection(user);

        try (Connection connection = factoryConnection.openConnection()) {
            System.out.println("Conexão com o banco de dados realizada com sucesso!");

            connection.setAutoCommit(false);

            String option = readOption();

            try {
                switch (option) {
                    case "1":
                        System.out.println(create( connection));
                        break;

                    case "2":
                        getAll(connection);
                        break;

                    case "3":
                        System.out.println(getById(connection));
                        break;

                    case "4":
                        System.out.println(getByName(connection));
                        break;

                    case "5":
                        System.out.println(update(connection));
                        break;

                    case "6":
                        System.out.println(delete(connection));
                        break;

                    case "7":
                        listProductAndCategory(connection);

                    default:
                        System.out.println("Opção inválida.");

                }
            } finally {
                System.out.println("Conexão encerrada.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao se conectar ao banco de dados. Motivo: " + e.getMessage());
        }
    }

    public static String readOption() {
        System.out.println("\nDigite o número da operação:");
        System.out.println("1 - Inserir dados");
        System.out.println("2 - Listar todos dados de uma tabela");
        System.out.println("3 - Buscar um dado por id de uma tabela");
        System.out.println("4 - Buscar um dado por nome de uma tabela");
        System.out.println("5 - Atualizar dados");
        System.out.println("6 - Deletar dados");
        System.out.println("7 - Listar Produtos e Categorias");

        return input.nextLine();
    }

    private static String create(Connection connection) {
        TableEnum tableEnum = readOption(TableEnum.values(), "Qual tabela você gostaria de inserir os dados?");

        switch (tableEnum) {
            case MANUFACTURER:
                System.out.print("Nome do fornecedor: ");
                String manufacturerName = input.nextLine();

                Manufacturer manufacturer = new Manufacturer(manufacturerName);
                manufacturerDAO = new ManufacturerDAO(connection);

                return manufacturerDAO.create(manufacturer) ? "Novo fornecedor cadastrado com sucesso.": "Não foi possível cadastrar o fornecedor.";

            case CATEGORY:
                System.out.print("Nome da categoria: ");
                String categoryName = input.nextLine();

                Category category = new Category(categoryName);
                categoryDAO = new CategoryDAO(connection);

                return categoryDAO.create(category) ? "Nova categoria cadastrada com sucesso." : "Não foi possível cadastrar a categoria.";

            case PRODUCT:
                System.out.print("Nome do produto: ");
                String productName = input.nextLine();

                System.out.print("Descrição do produto: ");
                String productDescription= input.nextLine();

                Product product = new Product(productName, productDescription);
                productDAO = new ProductDAO(connection);

                return productDAO.create(product) ? "Novo produto cadastrado com sucesso." : "Não foi possível cadastrar o produto.";
        }
        return ("-------------------------------------------");
    }

    private static void getAll(Connection connection) throws SQLException {
        TableEnum tableEnum = readOption(TableEnum.values(), "Qual tabela você gostaria de listar os dados?");

        switch (tableEnum) {
            case MANUFACTURER:
                manufacturerDAO = new ManufacturerDAO(connection);
                List<Manufacturer> manufacturers = manufacturerDAO.list();
                manufacturers.forEach(m -> System.out.printf("Id: %s - Fornecedor: %s\n", m.getId(), m.getName()));
                break;

            case CATEGORY:
                categoryDAO = new CategoryDAO(connection);
                List<Category> categories = categoryDAO.list();
                categories.forEach(c -> System.out.printf("Id: %s - Categoria: %s\n", c.getId(), c.getName()));
                break;

            case PRODUCT:
                productDAO = new ProductDAO(connection);
                List<Product> products = productDAO.list();
                products.forEach(p -> System.out.printf("Id: %s - Produto: %s - %s\n", p.getId(), p.getName(), p.getDescription()));
                break;
        }
    }

    private static String getById(Connection connection) throws SQLException {
        TableEnum tableEnum = readOption(TableEnum.values(), "De qual tabela você gostaria de buscar os dados?");
        int itemId = readId();

        switch (tableEnum) {
            case MANUFACTURER:
                manufacturerDAO = new ManufacturerDAO(connection);
                Manufacturer manufacturer = manufacturerDAO.getById(itemId);

                if (!(manufacturer == null)) {
                    return manufacturer.toString();
                }

            case CATEGORY:
                categoryDAO = new CategoryDAO(connection);
                Category category = categoryDAO.getById(itemId);

                if (!(category == null)) {
                    return category.toString();
                }

            case PRODUCT:
                productDAO = new ProductDAO(connection);
                Product product = productDAO.getById(itemId);

                if (!(product == null)) {
                    return product.toString();
                }
        }
        return String.format("%s não encontrado.", tableEnum.getDisplayName());
    }

    private static String getByName(Connection connection) throws SQLException {
        TableEnum tableEnum = readOption(TableEnum.values(), "De qual tabela você gostaria de buscar os dados?");
        System.out.print("Digite o nome: ");
        String name = input.nextLine();

        switch (tableEnum) {
            case MANUFACTURER:
                manufacturerDAO = new ManufacturerDAO(connection);
                Manufacturer manufacturer = manufacturerDAO.getByName(name);

                if (!(manufacturer == null)) {
                    return manufacturer.toString();
                }

            case CATEGORY:
                categoryDAO = new CategoryDAO(connection);
                Category category = categoryDAO.getByName(name);

                if (!(category == null)) {
                    return category.toString();
                }


            case PRODUCT:
                productDAO = new ProductDAO(connection);
                Product product = productDAO.getByName(name);

                if (!(product == null)) {
                    return product.toString();
                }
        }
        return String.format("%s não encontrado.", tableEnum.getDisplayName());
    }

    private static String update(Connection connection) throws SQLException {
        TableEnum tableEnum = readOption(TableEnum.values(), "De qual tabela você gostaria de atualizar um dado?");
        int itemId = readId();

        switch (tableEnum) {
            case MANUFACTURER:
                manufacturerDAO = new ManufacturerDAO(connection);
                Manufacturer manufacturer = manufacturerDAO.getById(itemId);

                System.out.print("Digite o novo nome do Fornecedor: ");
                manufacturer.setName(input.nextLine());

                return manufacturerDAO.update(itemId, manufacturer) ? "Fornecedor atualizado com sucesso." : "Não foi possível atualizar o fornecedor.";


            case CATEGORY:
                categoryDAO = new CategoryDAO(connection);
                Category category = categoryDAO.getById(itemId);

                System.out.print("Digite o novo nome da Categoria: ");
                category.setName(input.nextLine());

                return categoryDAO.update(itemId, category) ? "Categoria atualizada com sucesso." : "Não foi possível atualizar a categoria.";

            case PRODUCT:
                productDAO = new ProductDAO(connection);
                Product product = productDAO.getById(itemId);

                System.out.print("Digite o novo nome do Produto: ");
                product.setName(input.nextLine());

                System.out.print("Digite a nova descrição do Produto: ");
                product.setDescription(input.nextLine());

                return productDAO.update(itemId, product) ? "Produto atualizado com sucesso." : "Não foi possível atualizar o produto.";
        }
        return String.format("Não foi possível atualizar o/a %s.", tableEnum.getDisplayName());
    }

    private static String delete(Connection connection) throws SQLException {
        TableEnum tableEnum = readOption(TableEnum.values(), "De qual tabela você gostaria de deletar um dado?");
        int itemId = readId();

        switch (tableEnum) {
            case MANUFACTURER:
                manufacturerDAO = new ManufacturerDAO(connection);
                return manufacturerDAO.delete(itemId) ? "Fornecedor deletado com sucesso.": "Não foi possível deletar o fornecedor.";

            case CATEGORY:
                categoryDAO = new CategoryDAO(connection);
                return categoryDAO.delete(itemId) ? "Categoria deletada com sucesso." : "Não foi possível deletar a categoria.";

            case PRODUCT:
                productDAO = new ProductDAO(connection);
                return productDAO.delete(itemId) ? "Produto deletado com sucesso." : "Não foi possível deletar o produto.";
        }
        return ("--------------------------------------------");
    }

    private static void listProductAndCategory(Connection connection) throws SQLException {
        productDAO = new ProductDAO(connection);
        List<Product> products = productDAO.listProductAndCategory();
        products.forEach(p -> System.out.printf("Categoria: %s - Produto: %s - %s\n", p.getCategory().getName(), p.getName(), p.getDescription()));
    }

    private static User readUser() {
        System.out.print("Digite o usuário do banco de dados: ");
        String name = input.nextLine();

        System.out.print("Digite a senha: ");
        String password = input.nextLine();

        return new connection.User(name, password);

    }

    private static int readId() {
        while (true) {
            System.out.print("Digite o Id do item: ");
            String userInput = input.nextLine().trim();
            try {
                return Integer.parseInt(userInput);

            } catch (NumberFormatException e) {
                System.out.println("Valor incorreto, digite novamente um número inteiro.");
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
                if(Integer.toString(option.getValue()).equals(line)){
                    return option;
                }
            }
            System.out.println("Escolha uma opção válida.");
        }
    }
}

package view;

import connetion.*;
import repositories.*;
import entities.*;

import java.sql.*;
import java.util.*;

public class Program {

    private static Scanner input = new Scanner(System.in);

    private static Connection connection = null;
    private static ProductDAO productDAO = new ProductDAO(connection);
    private static CategoryDAO categoryDAO = new CategoryDAO(connection);
    private static ManufacturerDAO manufacturerDAO = new ManufacturerDAO(connection);

    public static void main(String[] args) {

        User user = readUser();

        try (Connection connection = FactoryConnection.openConnection(user)) {
            System.out.println("Conexão com o banco de dados realizada com sucesso!");

            connection.setAutoCommit(false);

            String option = readOption();

            try {
                switch (option) {
                    case "1":
                        System.out.println(createData(connection));
                        break;

                    case "2":
                        System.out.println(readData(connection));
                        break;

                    case "3":
                        System.out.println(searchAData(connection));
                        break;

                    case "4":
                        System.out.println(updateData(connection));
                        break;

                    case "5":
                        System.out.println(deleteData(connection));
                        break;

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

    private static String updateData(Connection connection) throws SQLException {
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

    private static String searchAData(Connection connection) throws SQLException {
        TableEnum tableEnum = readOption(TableEnum.values(), "De qual tabela você gostaria de buscar os dados?");
        int itemId = readId();

        switch (tableEnum) {
            case MANUFACTURER:
                manufacturerDAO = new ManufacturerDAO(connection);
                Manufacturer manufacturer = manufacturerDAO.getById(itemId);

                if (!(manufacturer == null)) {
                    return String.format("Id: %s - Fornecedor: %s", manufacturer.getId(),manufacturer.getName());
                }

            case CATEGORY:
                categoryDAO = new CategoryDAO(connection);
                Category category = categoryDAO.getById(itemId);

                if (!(category == null)) {
                    return String.format("Id: %s - Categoria: %s", category.getId(),category.getName());
                }

            case PRODUCT:
                productDAO = new ProductDAO(connection);
                Product product = productDAO.getById(itemId);

                if (!(product == null)) {
                    return String.format("Id: %s - Produto: %s - %s", product.getId(),product.getName(), product.getDescription());
                }
        }
        return String.format("%s não encontrado.", tableEnum.getDisplayName());
    }

    private static String deleteData(Connection connection) throws SQLException {
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

    private static Object readData(Connection connection) throws SQLException {
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
        return ("--------------------------------------------");
    }

    private static String createData(Connection connection) {
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

    public static String readOption() {
        System.out.println("\nDigite o número da operação:");
        System.out.println("1 - Inserir dados");
        System.out.println("2 - Listar todos dados de uma tabela");
        System.out.println("3 - Buscar um dado de uma tabela");
        System.out.println("4 - Atualizar dados");
        System.out.println("5 - Deletar dados");

        return input.nextLine();
    }

    private static User readUser() {
        /*
        System.out.print("Digite o usuário do banco de dados: ");
        String name = input.nextLine();

        System.out.print("Digite a senha: ");
        String password = input.nextLine();

        return new connetion.User(name, password);
         */
        return new User("postgres", "postgres");
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

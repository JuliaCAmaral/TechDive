package repositories;

import entities.Product;

import java.sql.*;
import java.util.*;

public class ProductDAO {

    private Connection connection;

    public ProductDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean create(Product product) {
        String sql = "INSERT INTO market.product(name, description) values(?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());

            preparedStatement.execute();

            this.connection.commit();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir um produto. Motivo: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<Product> list() throws SQLException {
        List<Product> products = new ArrayList<Product>();

        String sql = "SELECT Id, name, description FROM market.product";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.execute();

            try (ResultSet resultSet = preparedStatement.getResultSet()) {
                while (resultSet.next()) {
                    Product product = new Product(resultSet.getString("name"), resultSet.getString("description"));
                    product.setId(resultSet.getInt("id"));
                    products.add(product);
                }
            }
            return products;
        }
    }

    public Product getById(int id) throws SQLException {
        String sql = "SELECT id, name, description FROM market.product WHERE id = ?";
        Product product = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            preparedStatement.execute();

            try (ResultSet resultSet = preparedStatement.getResultSet()){
                while (resultSet.next() ) {
                    product = new Product(resultSet.getString("name"),
                            resultSet.getString("description"));
                    product.setId(resultSet.getInt("id"));
                }
            } catch (SQLException e) {
                throw new RuntimeException("Erro ao buscar o produto. Motivo: "+ e.getMessage());
            }
        }
        return product;
    }

    public boolean update(int id, Product product) {
        String sql = "UPDATE market.product set name = ?, description = ? WHERE id = ?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setLong(3, id);

            preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar um produto. Motivo: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean delete(int id) throws SQLException {
        String sql = "DELETE FROM market.product WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            preparedStatement.execute();

            int updateCount = preparedStatement.getUpdateCount();

            if ((updateCount == 0)) {
                System.out.println("Não foi possível deletar o produto. Produto não encontrado no banco.");
                return false;
            } else {
                return true;
            }
        }
    }
}

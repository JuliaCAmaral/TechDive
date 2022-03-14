package repositories;

import entities.Category;

import java.sql.*;
import java.util.*;

public class CategoryDAO {

    private Connection connection;

    public CategoryDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean create(Category category) {
        String sql = "INSERT INTO market.category(name) values(?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, category.getName());
            preparedStatement.execute();

            this.connection.commit();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir uma categoria. Motivo: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<Category> list() throws SQLException {
        List<Category> categories = new ArrayList<Category>();

        String sql = "SELECT Id, name FROM market.category";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.execute();

            try (ResultSet resultSet = preparedStatement.getResultSet()) {
                while (resultSet.next()) {
                    Category category = new Category(resultSet.getString("name"));
                    category.setId(resultSet.getInt("id"));
                    categories.add(category);
                }
            }
            return categories;
        }
    }

    public Category getById(int id) throws SQLException {
        String sql = "SELECT id, name FROM market.category WHERE id = ?";
        Category category = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            preparedStatement.execute();

            try (ResultSet resultSet = preparedStatement.getResultSet()){
                while (resultSet.next() ) {
                    category = new Category(resultSet.getString("name"));
                    category.setId(resultSet.getInt("id"));
                }
            } catch (SQLException e) {
                throw new RuntimeException("Erro ao buscar a categoria. Motivo: "+ e.getMessage());
            }
        }
        return category;
    }

    public boolean update(int id, Category category) {
        String sql = "UPDATE market.category set name = ? WHERE id = ?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, category.getName());
            preparedStatement.setLong(2, id);

            preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar a categoria. Motivo: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public boolean delete(int id) throws SQLException {
        String sql = "DELETE FROM market.category WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            preparedStatement.execute();

            int updateCount = preparedStatement.getUpdateCount();

            if ((updateCount == 0)) {
                System.out.println("Não foi possível deletar a categoria. Categoria não encontrada no banco.");
                return false;
            } else {
                return true;
            }
        }
    }
}

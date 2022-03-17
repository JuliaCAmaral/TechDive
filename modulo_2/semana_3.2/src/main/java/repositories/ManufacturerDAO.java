package repositories;

import entities.Manufacturer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManufacturerDAO {

    private Connection connection;

    public ManufacturerDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean create(Manufacturer manufacturer) {
        String sql = "INSERT INTO market.manufacturer(name) values(?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, manufacturer.getName());
            preparedStatement.execute();

            this.connection.commit();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir um fornecedor. Motivo: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<Manufacturer> list() throws SQLException {
        List<Manufacturer> manufacturers = new ArrayList<Manufacturer>();

        String sql = "SELECT Id, name FROM market.manufacturer";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.execute();

            try (ResultSet resultSet = preparedStatement.getResultSet()) {
                while (resultSet.next()) {
                    Manufacturer manufacturer = new Manufacturer(resultSet.getString("name"));
                    manufacturer.setId(resultSet.getInt("id"));
                    manufacturers.add(manufacturer);
                }
            }
            return manufacturers;
        }
    }

    public Manufacturer getById(int id) throws SQLException {
        String sql = "SELECT id, name FROM market.manufacturer WHERE id = ?";
        Manufacturer manufacturer = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            preparedStatement.execute();

            try (ResultSet resultSet = preparedStatement.getResultSet()){
                while (resultSet.next() ) {
                    manufacturer = new Manufacturer(resultSet.getString("name"));
                    manufacturer.setId(resultSet.getInt("id"));
                }
            } catch (SQLException e) {
                throw new RuntimeException("Erro ao buscar o fornecedor. Motivo: "+ e.getMessage());
            }
        }
        return manufacturer;
    }

    public Manufacturer getByName(String name) throws SQLException {
        String sql = "SELECT id, name FROM market.manufacturer WHERE name = ?";
        Manufacturer manufacturer = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            preparedStatement.execute();

            try (ResultSet resultSet = preparedStatement.getResultSet()){
                while (resultSet.next() ) {
                    manufacturer = new Manufacturer(resultSet.getString("name"));
                    manufacturer.setId(resultSet.getInt("id"));
                }
            } catch (SQLException e) {
                throw new RuntimeException("Erro ao buscar o fornecedor. Motivo: "+ e.getMessage());
            }
        }
        return manufacturer;
    }

    public boolean update(int id, Manufacturer manufacturer) {
        String sql = "UPDATE market.manufacturer set name = ? WHERE id = ?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, manufacturer.getName());
            preparedStatement.setLong(2, id);

            preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar o fornecedor. Motivo: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean delete(int id) throws SQLException {
        String sql = "DELETE FROM market.manufacturer WHERE id = ?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            preparedStatement.execute();

            int updateCount = preparedStatement.getUpdateCount();

            if ((updateCount == 0)) {
                System.out.println("Não foi possível deletar o fornecedor. Fornecedor não encontrada no banco.");
                return false;
            } else {
                return true;
            }
        }
    }
}

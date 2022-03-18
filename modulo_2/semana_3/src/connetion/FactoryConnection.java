package connetion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FactoryConnection {

    public FactoryConnection(User user) {
        System.out.println("Iniciando...");

        try {
            openConnection(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection openConnection(User user) throws SQLException {
        String connectionString = "jdbc:postgresql://localhost/postgres?useTimezone=true&serverTimezone=UTC";
        return DriverManager.getConnection(connectionString, user.getName(), user.getPassword());
    }

}

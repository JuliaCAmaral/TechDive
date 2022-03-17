package connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class FactoryConnection {

    private DataSource dataSource;

    public FactoryConnection(User user) {
        ComboPooledDataSource source = new ComboPooledDataSource();

        source.setJdbcUrl("jdbc:postgresql://localhost/postgres?useTimezone=true&serverTimezone=UTC");
        source.setUser(user.getName());
        source.setPassword(user.getPassword());

        source.setMaxPoolSize(10);

        this.dataSource = source;
    }

    public Connection openConnection() throws SQLException {
        System.out.println("Iniciando...");
        return this.dataSource.getConnection();
    }
}

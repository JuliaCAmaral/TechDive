package market.services;

import market.application.Program;
import market.model.dao.ClientDAO;
import market.model.persistence.Client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class ClientService {

    private final Logger LOG = LogManager.getLogger(Program.class);

    private EntityManager entityManager;

    private ClientDAO clientDAO;

    public ClientService(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.clientDAO = new ClientDAO(entityManager);
    }

    public void create(Client client) {
        this.LOG.info("Preparando para cadastro de um cliente");

        validateIsNull(client);

        try {
            getBeginTransaction();
            this.clientDAO.create(client);
            comitAndCloseTransaction();

        } catch (Exception e) {
            this.LOG.error("Erro ao cadastrar um cliente. Motivo: " + e.getMessage());
            throw new RuntimeException(e);
        }
        this.LOG.info("Cliente cadastrado com sucesso.");
    }


    public List<Client> listAll() {
        List<Client> clients = this.clientDAO.listAll();

        if (clients == null) {
            this.LOG.error("Não foram encontrados cadastros de clientes");
            return new ArrayList<Client>();
        }

        this.LOG.info("Foram encontrados " + clients.size() + " cadastros de clientes.");
        return clients;
    }

    public List<Client> listByName(String name) {
        if (name == null || name.isEmpty()) {
            this.LOG.info("O parametro nome está vazio");
            throw new RuntimeException("The parameter name is null");
        }

        this.LOG.info("Preparando para buscar os clientes com o nome: " + name);
        List<Client> clients = this.clientDAO.listByName(name.toLowerCase());

        if (clients == null) {
            this.LOG.error("Não foram encontrados Clientes");
            return new ArrayList<Client>();
        }

        this.LOG.info("Foram encontrados " + clients.size() + " clientes.");
        return clients;
    }

    public void update(Client newClient, Long clientId) {
        if (newClient == null || clientId == null) {
            this.LOG.error("Um dos parametros está nulo!");
            throw new RuntimeException("The parameter is Null");
        }

        Client client = this.clientDAO.getById(clientId);
        validateIsNull(client);

        this.LOG.info("Cadastro do cliente encontrado com sucesso.");

        getBeginTransaction();
        client.setName(newClient.getName());
        client.setBirthDate(newClient.getBirthDate());

        comitAndCloseTransaction();
        this.LOG.info("Cadastro do cliente atualizado com sucesso.");
    }

    public void delete(Long id) {
        this.LOG.info("Preparando para encontra o cliente");
        if (id == null) {
            this.LOG.error("O ID do Cliente informado está nulo!");
            throw new RuntimeException("The ID is Null");
        }

        Client client = this.clientDAO.getById(id);

        validateIsNull(client);

        getBeginTransaction();
        this.clientDAO.delete(client);
        comitAndCloseTransaction();

        this.LOG.info("Cliente deletado com sucesso!");
    }

    public Client getById(long id) {
        return clientDAO.getById(id);
    }

    private void getBeginTransaction() {
        this.LOG.info("Abrindo transição com o banco de dados...");
        entityManager.getTransaction().begin();
    }

    private void comitAndCloseTransaction() {
        this.LOG.info("Commitando e Fechando transição com o banco de dados...");
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    private void validateIsNull(Client client) {
        if (client == null) {
            this.LOG.error("O Cliente não existe");
            throw new RuntimeException("Client not Found");
        }

        if (client.getName() == null || client.getName().isEmpty()) {
            this.LOG.error("Nome do cliente está nulo.");
            throw new RuntimeException("Customer name is null");
        }

        if (client.getCpf() == null || client.getCpf().isEmpty()) {
            this.LOG.error("CPF do cliente está nulo.");
            throw new RuntimeException("Customer document is null");
        }

        if (client.getBirthDate() == null) {
            this.LOG.error("Data de nascimento do cliente está nulo.");
            throw new RuntimeException("The customer's date of birth is null");
        }
    }
}


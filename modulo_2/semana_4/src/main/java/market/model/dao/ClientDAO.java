package market.model.dao;

import market.model.persistence.Client;

import javax.persistence.EntityManager;
import java.util.List;

public class ClientDAO {

    private EntityManager entityManager;

    public ClientDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(Client client) {
        this.entityManager.persist(client);
    }

    public List<Client> listAll() {
        String sql = "SELECT c FROM Client c";
        return this.entityManager.createQuery(sql, Client.class).getResultList();
    }

    public List<Client> listByName(String name) {
        String sql = "SELECT c FROM Client c WHERE c.name =:name";
        return this.entityManager.createQuery(sql, Client.class)
                .setParameter("name", name.toLowerCase())
                .getResultList();
    }

    public Client update(Client client) {
        return convertToMerge(client);
    }

    public void delete(Client client) {
        Client productMerged = convertToMerge(client);
        this.entityManager.remove(client);
    }

    private Client convertToMerge(Client client) {
        return this.entityManager.merge(client);
    }

    public Client getById(Long id) {
        return this.entityManager.find(Client.class, id);
    }

}

package market.model.dao;

import market.model.persistence.Product;

import javax.persistence.EntityManager;
import java.util.List;

public class ProductDAO {

    private EntityManager entityManager;

    public ProductDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(Product product) {
        System.out.println("criando um produto");
        this.entityManager.persist(product);
    }

    public List<Product> listAll() {
        String jpql = "SELECT p FROM Product p";
        return this.entityManager.createQuery(jpql, Product.class).getResultList();
    }

    public List<Product> listByName(String name) {
        String jpql = "SELECT p FROM Product p WHERE p.name =:name";
        return this.entityManager.createQuery(jpql, Product.class)
                .setParameter("name", name.toLowerCase())
                .getResultList();
    }

    public Product update(Product product) {
        return convertToMerge(product);
    }

    public void delete(Product product) {
        Product productMerged = convertToMerge(product);
        this.entityManager.remove(product);
    }

    private Product convertToMerge(Product product) {
        return this.entityManager.merge(product);
    }

    public Product getById(Long id) {
        return this.entityManager.find(Product.class, id);
    }

}

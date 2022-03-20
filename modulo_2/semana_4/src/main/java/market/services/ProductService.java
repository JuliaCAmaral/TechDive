package market.services;

import market.application.Program;
import market.model.dao.ProductDAO;
import market.model.persistence.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class ProductService {

    private final Logger LOG = LogManager.getLogger(Program.class);

    private EntityManager entityManager;

    private ProductDAO productDAO;

    public ProductService(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.productDAO = new ProductDAO(entityManager);
    }

    public void create(Product product) {
        this.LOG.info("Preparando para criação de um produto");

        validateProductIsNull(product);

        try {
            getBeginTransaction();
            this.productDAO.create(product);
            comitAndCloseTransaction();

        } catch (Exception e) {
            this.LOG.error("Erro ao criar um produto. Motivo: " + e.getMessage());
            throw new RuntimeException(e);
        }
        this.LOG.info("Produto criado com sucesso.");
    }

    public void delete(Long id) {
        this.LOG.info("Preparando para encontra o produto");
        if (id == null) {
            this.LOG.error("O ID do Produto informado está nulo!");
            throw new RuntimeException("The ID is Null");
        }

        Product product = this.productDAO.getById(id);

        validateProductIsNull(product);

        getBeginTransaction();
        this.productDAO.delete(product);
        comitAndCloseTransaction();

        this.LOG.info("Produto deletdo com sucesso!");
    }

    public void update(Product newProduct, Long productId) {
        if (newProduct == null || productId == null) {
            this.LOG.error("Um dos parametros está nulo!");
            throw new RuntimeException("The parameter is Null");
        }

        Product product = this.productDAO.getById(productId);
        validateProductIsNull(product);

        this.LOG.info("Produto encontrado com sucesso.");

        getBeginTransaction();
        product.setName(newProduct.getName());
        product.setDescription(newProduct.getDescription());
        product.setPrice(newProduct.getPrice());
        product.setCategory(newProduct.getCategory());

        comitAndCloseTransaction();
        this.LOG.info("Produto atualizado com sucesso.");
    }

    public List<Product> listAll() {
        List<Product> products = this.productDAO.listAll();

        if (products == null) {
            this.LOG.error("Não foram encontrados Produtos");
            return new ArrayList<Product>();
        }

        this.LOG.info("Foram encontrados " + products.size() + " produtos.");
        return products;
    }

    public List<Product> listByName(String name) {
        if (name == null || name.isEmpty()) {
            this.LOG.info("O parametro nome está vazio");
            throw new RuntimeException("The parameter name is null");
        }

        this.LOG.info("Preparando para buscar os produtos com o nome: " + name);
        List<Product> products = this.productDAO.listByName(name.toLowerCase());

        if (products == null) {
            this.LOG.error("Não foram encontrados Produtos");
            return new ArrayList<Product>();
        }

        this.LOG.info("Foram encontrados " + products.size() + " produtos.");
        return products;
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

    private void validateProductIsNull (Product product) {
        if (product == null) {
            this.LOG.error("O Produto não existe");
            throw new RuntimeException("Product not Found");
        }
    }
}


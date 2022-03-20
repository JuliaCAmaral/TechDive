package market.application;

import javax.persistence.EntityManager;

import market.model.dao.ProductDAO;
import market.model.persistence.Category;
import market.model.persistence.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import market.connection.JpaConnectionFactory;

import java.math.BigDecimal;
import java.util.List;

public class Program {
	
	private static final Logger LOG = LogManager.getLogger(Program.class);

	public static void main(String[] args) {

		EntityManager entityManager = new JpaConnectionFactory().getEntityManager();
		ProductDAO productDAO = new ProductDAO(entityManager);

		//Product product = new Product("Café", "Melita tradicional 500g", new BigDecimal(20.50), new Category("Alimento"));

		entityManager.getTransaction().begin();
		//productDAO.create(product);

		//List<Product> products = productDAO.listAll();

		//List<Product> products = productDAO.listByName("Café");
		//products.stream().forEach(p -> System.out.println(p));

		//Product product1 = productDAO.getById(1l);
		//System.out.println(product1);

		Product product = productDAO.getById(1l);
		productDAO.delete(product);

		List<Product> products = productDAO.listAll();
		products.stream().forEach(p -> System.out.println(p));

		entityManager.getTransaction().commit();
		entityManager.close();


	}

}

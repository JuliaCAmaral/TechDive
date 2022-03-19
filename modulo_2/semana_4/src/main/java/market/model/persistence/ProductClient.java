package market.model.persistence;

import javax.persistence.*;

@Entity
public class ProductClient {

    @EmbeddedId
    private ProductClientKey id;

    @ManyToOne
    @MapsId("clientId")
    private Client client;

    @ManyToOne
    @MapsId("productId")
    private Product product;

    private int request;

    public ProductClient() {
    }

    public ProductClientKey getId() {
        return id;
    }

    public void setId(ProductClientKey id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

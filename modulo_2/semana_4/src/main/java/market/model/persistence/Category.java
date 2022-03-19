package market.model.persistence;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 64)
    private String name;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "category")
    private Collection<Product> product;

    public Collection<Product> getProduct() {
        return product;
    }

    public void setProduct(Collection<Product> product) {
        this.product = product;
    }
}

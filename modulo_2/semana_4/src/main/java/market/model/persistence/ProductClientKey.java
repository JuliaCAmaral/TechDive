package market.model.persistence;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductClientKey implements Serializable {

    private long productId;

    private long clientId;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductClientKey that = (ProductClientKey) o;
        return productId == that.productId &&
                clientId == that.clientId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, clientId);
    }
}

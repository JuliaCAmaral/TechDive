package market.model.persistence;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 64)
    private String name;

    private String cpf;

    private LocalDate birthDate;

    @OneToMany(mappedBy = "client")
    private Set<ProductClient> requests;
}

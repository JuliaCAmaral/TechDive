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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Set<ProductClient> getRequests() {
        return requests;
    }

    public void setRequests(Set<ProductClient> requests) {
        this.requests = requests;
    }
}

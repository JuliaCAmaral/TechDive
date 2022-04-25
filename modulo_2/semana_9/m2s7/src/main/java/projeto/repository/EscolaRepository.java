package projeto.repository;

import projeto.dto.EscolaDTO;
import projeto.entity.Escola;

import java.util.List;

public class EscolaRepository extends GenericRepository {

    public List<EscolaDTO> consultarEscolas() {
        return entityManager
                .createNamedQuery(Escola.GET_ESCOLASDTO, EscolaDTO.class)
                .getResultList();
    }

    public Escola getById(Long id) {
        return find(Escola.class, id);
    }
}

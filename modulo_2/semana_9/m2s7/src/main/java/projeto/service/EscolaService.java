package projeto.service;

import projeto.business.EscolaBusiness;
import projeto.dto.EscolaDTO;
import projeto.repository.EscolaRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class EscolaService {

    @Inject
    private EscolaBusiness escolaBusiness;

    @Inject
    private EscolaRepository escolaRepository;

    public List<EscolaDTO> consultarEscolas() {
        return escolaRepository.consultarEscolas();
    }
}

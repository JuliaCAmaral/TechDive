package projeto.business;

import org.apache.commons.lang3.StringUtils;
import projeto.dto.EscolaDTO;
import projeto.entity.Endereco;
import projeto.entity.Escola;
import projeto.exception.BusinessException;
import projeto.repository.EscolaRepository;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class EscolaBusiness {

    @Inject
    EscolaRepository escolaRepository;

    @Inject
    EnderecoBusiness enderecoBusiness;

    public Escola inserir(EscolaDTO escola) throws BusinessException {
        validarEscola(escola);
        return cadastrarEscolaNoBanco(escola);
    }

    private Escola cadastrarEscolaNoBanco(EscolaDTO escolaDTO) throws BusinessException {
        Escola escola;
        if (escolaDTO.getId() != null) {
            escola = escolaRepository.find(Escola.class, escolaDTO.getId());
            if (escola == null) {
                throw new BusinessException("Escola não encontrada.");
            }
        } else {
            escola = new Escola();
        }

        escola.setNome(escolaDTO.getNome());
        escola.setDataDeCriacao(escolaDTO.getDataDeCriacao());

        Endereco endereco = enderecoBusiness.inserir(escolaDTO.getEndereco());
        escola.setEndereco(endereco);

        if (escola.getId() != null) {
            escolaRepository.merge(escola);
        } else {
            escolaRepository.persist(escola);
            escolaDTO.setId(escola.getId());
        }
        return escola;
    }

    public void validarEscola(EscolaDTO escolaDTO) throws BusinessException {
        List<String> erros = new ArrayList<>();

        if (StringUtils.isBlank(escolaDTO.getNome())) {
            erros.add("O Nome da Escola é inválido.");
        }

        try {
            enderecoBusiness.validarEndereco(escolaDTO.getEndereco());
        } catch (BusinessException e) {
            erros.addAll(e.getErros());
        }

        if (!erros.isEmpty()) {
            throw new BusinessException(erros);
        }
    }

    public Escola getById(Long id) {
        return escolaRepository.find(Escola.class, id);
    }
}

package projeto.business;

import org.apache.commons.lang3.StringUtils;
import projeto.dto.EscolaDTO;
import projeto.dto.TurmaDTO;
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

    @Inject
    TurmaBusiness turmaBusiness;

    public void cadastrar(EscolaDTO escola) throws BusinessException {
        validarEscola(escola);
        cadastrarEscolaNoBanco(escola);
    }

    private void cadastrarEscolaNoBanco(EscolaDTO escolaDTO) throws BusinessException {
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
    }

    public void validarEscola(EscolaDTO escolaDTO) throws BusinessException {
        List<String> erros = new ArrayList<>();

        if (StringUtils.isBlank(escolaDTO.getNome())) {
            erros.add("O Nome da Escola é inválido.");
        }

        if (escolaDTO.getDataDeCriacao() == null) {
            erros.add("A data de criação da Escola é inválida.");
        }

        if (escolaDTO.getTurmas().size() == 0) {
            erros.add("Deve cadastrar no mínimo uma turma.");
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

    public EscolaDTO consultarDadosEscola(Long id) throws BusinessException {
        Escola escola = escolaRepository.find(Escola.class, id);
        if (escola == null) {
            throw new BusinessException("Escola não encontrada.");
        }
        return new EscolaDTO(escola);
    }

    public List<TurmaDTO> consultarTurmasDisponiveis() {
        return turmaBusiness.consultarTurmas();
    }
}

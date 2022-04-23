package projeto.business;

import org.apache.commons.lang3.StringUtils;
import projeto.dto.EnderecoDTO;
import projeto.entity.Endereco;
import projeto.exception.BusinessException;
import projeto.repository.EnderecoRepository;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class EnderecoBusiness {

    @Inject
    EnderecoRepository enderecoRepository;

    public Endereco inserir(EnderecoDTO enderecoDTO) throws BusinessException {
        validarEndereco(enderecoDTO);
        Endereco endereco = cadastrarEnderecoNoBanco(enderecoDTO);

        return endereco;
    }

    public void validarEndereco(EnderecoDTO enderecoDTO) throws BusinessException {
        List<String> erros = new ArrayList<>();

        if (StringUtils.isBlank(enderecoDTO.getRua())) {
            erros.add("O campo 'Rua' do Endereço é inválido.");
        }

        if (StringUtils.isBlank(enderecoDTO.getNumero())) {
            erros.add("O campo 'Número' do Endereço é inválido.");
        }

        if (StringUtils.isBlank(enderecoDTO.getBairro())) {
            erros.add("O campo 'Bairro' do Endereço é inválido.");
        }

        if (StringUtils.isBlank(enderecoDTO.getCidade())) {
            erros.add("O campo 'Cidade' do Endereço é inválido.");
        }

        if (StringUtils.isBlank(enderecoDTO.getEstado())) {
            erros.add("O campo 'Estado' do Endereço é inválido.");
        }

        if (StringUtils.isBlank(enderecoDTO.getPais())) {
            erros.add("O campo 'País' do Endereço é inválido.");
        }

        if (!erros.isEmpty()) {
            throw new BusinessException(erros);
        }
    }

    private Endereco cadastrarEnderecoNoBanco(EnderecoDTO enderecoDTO) throws BusinessException {
        Endereco endereco;
        if (enderecoDTO.getId() != null) {
            endereco = enderecoRepository.find(Endereco.class, enderecoDTO.getId());
            if (endereco == null)
                throw new BusinessException("Endereço não encontrado");
        } else {
            endereco = new Endereco();
        }

        endereco.setRua(enderecoDTO.getRua());
        endereco.setNumero(enderecoDTO.getNumero());
        endereco.setBairro(enderecoDTO.getBairro());
        endereco.setCidade(enderecoDTO.getCidade());
        endereco.setEstado(enderecoDTO.getEstado());
        endereco.setPais(enderecoDTO.getPais());

        if (endereco.getId() != null) {
            enderecoRepository.merge(endereco);
        } else {
            enderecoRepository.persist(endereco);
            enderecoDTO.setId(endereco.getId());
        }
        return endereco;
    }

    private EnderecoDTO consultaEndereco(Long id) throws BusinessException {
        Endereco endereco = enderecoRepository.find(Endereco.class, id);
        if (endereco == null) {
            throw new BusinessException("Endereço não encontrado.");
        }
        return new EnderecoDTO(endereco);
    }
}

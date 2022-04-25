package projeto.bean;

import org.omnifaces.cdi.Param;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Faces;
import projeto.dto.EnderecoDTO;
import projeto.dto.EscolaDTO;
import projeto.dto.TurmaDTO;
import projeto.exception.BusinessException;
import projeto.service.EscolaService;
import projeto.utils.MessageUtils;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ViewScoped
@Named("escolaCadastroWebBean")
public class EscolaCadastroWebBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EscolaService escolaService;

    @Param(name = "idEscola")
    private Long idEscola;

    private EscolaDTO escolaDTO;

    private List<TurmaDTO> turmasDisponiveis = new ArrayList<>();

    private List<TurmaDTO> turmasSelecionadas = new ArrayList<>();

    public void inicializar() {
        if (idEscola != null) {
            try {
                escolaDTO = escolaService.consultarDadosEscola(idEscola);
                MessageUtils.limparMensagens();
            } catch (BusinessException e) {
                MessageUtils.returnGlobalMessageOnFail(e.getErros());
                Faces.redirect("/cadastro-escola.xhtml");
            }
        }
        escolaDTO = new EscolaDTO();
        escolaDTO.setEndereco(new EnderecoDTO());
        turmasDisponiveis = escolaService.consultarTurmasDisponiveis();
    }

    public void cadastrar(){
        try {
            escolaDTO.setTurmas(turmasSelecionadas);
            escolaService.cadastrar(escolaDTO);
            if (idEscola == null) {
                MessageUtils.returnGlobalMessageOnSuccess("Salvo com sucesso!");
                Faces.redirect("/escola.xhtml?idEscola=" + escolaDTO.getId());
            } else {
                MessageUtils.returnMessageOnSuccess("Salvo com sucesso!");
            }
        } catch (BusinessException e) {
            MessageUtils.returnMessageOnFail(e.getErros());
        } catch (Exception e) {
            MessageUtils.returnMessageOnFail("Ocorreu um erro ao salvar a escola. Por favor, entre em contato com o suporte.");
        }
    }

    public EscolaService getEscolaService() {
        return escolaService;
    }

    public void setEscolaService(EscolaService escolaService) {
        this.escolaService = escolaService;
    }

    public Long getIdEscola() {
        return idEscola;
    }

    public void setIdEscola(Long idEscola) {
        this.idEscola = idEscola;
    }

    public EscolaDTO getEscolaDTO() {
        return escolaDTO;
    }

    public void setEscolaDTO(EscolaDTO escolaDTO) {
        this.escolaDTO = escolaDTO;
    }

    public List<TurmaDTO> getTurmasDisponiveis() {
        return turmasDisponiveis;
    }

    public void setTurmasDisponiveis(List<TurmaDTO> turmasDisponiveis) {
        this.turmasDisponiveis = turmasDisponiveis;
    }

    public List<TurmaDTO> getTurmasSelecionadas() {
        return turmasSelecionadas;
    }

    public void setTurmasSelecionadas(List<TurmaDTO> turmasSelecionadas) {
        this.turmasSelecionadas = turmasSelecionadas;
    }
}

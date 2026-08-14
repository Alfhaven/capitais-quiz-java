package quiz.service;

import quiz.model.*;
import quiz.repository.*;

import java.util.List;

/**
 * Concentra as regras de negócio de cadastro de conteúdo (continente,
 * país, estado, capital) que antes estavam espalhadas dentro dos
 * handlers jbttSalvar...ActionPerformed de AdminForm, cada um
 * instanciando seu próprio DAO diretamente. Aqui a tela apenas
 * repassa os dados capturados dos campos e delega a validação e o
 * salvamento (SRP + DIP: depende das interfaces de repositório).
 */
public class ConteudoAdminService {

    private final IContinenteRepository continenteRepository;
    private final IPaisRepository paisRepository;
    private final IEstadoRepository estadoRepository;
    private final ICapitalRepository capitalRepository;

    public ConteudoAdminService(IContinenteRepository continenteRepository,
                                 IPaisRepository paisRepository,
                                 IEstadoRepository estadoRepository,
                                 ICapitalRepository capitalRepository) {
        this.continenteRepository = continenteRepository;
        this.paisRepository = paisRepository;
        this.estadoRepository = estadoRepository;
        this.capitalRepository = capitalRepository;
    }

    public Continente salvarContinente(String nome) throws CadastroInvalidoException {
        if (nome == null || nome.isBlank()) {
            throw new CadastroInvalidoException("Informe o nome do continente");
        }
        Continente continente = new Continente(nome.trim());
        continenteRepository.salvar(continente);
        return continente;
    }

    public Pais salvarPais(String nome, Continente continente) throws CadastroInvalidoException {
        if (nome == null || nome.isBlank()) {
            throw new CadastroInvalidoException("Informe o nome do país");
        }
        if (continente == null) {
            throw new CadastroInvalidoException("Selecione um continente");
        }
        Pais pais = new Pais(nome.trim(), continente);
        paisRepository.salvar(pais);
        return pais;
    }

    public Estado salvarEstado(String nome, Pais pais) throws CadastroInvalidoException {
        if (nome == null || nome.isBlank()) {
            throw new CadastroInvalidoException("Informe o nome do estado");
        }
        if (pais == null) {
            throw new CadastroInvalidoException("Selecione um país");
        }
        Estado estado = new Estado(nome.trim(), pais);
        estadoRepository.salvar(estado);
        return estado;
    }

    public Capital salvarCapital(String nome, Pais pais, TipoCapital tipo) throws CadastroInvalidoException {
        if (nome == null || nome.isBlank()) {
            throw new CadastroInvalidoException("Informe o nome da capital");
        }
        if (pais == null) {
            throw new CadastroInvalidoException("Selecione um país");
        }
        Capital capital = new Capital(nome.trim(), pais, tipo);
        capitalRepository.salvar(capital);
        return capital;
    }

    public List<Continente> listarContinentes() {
        return continenteRepository.buscarTodos();
    }

    public List<Pais> listarPaises() {
        return paisRepository.buscarTodos();
    }
}

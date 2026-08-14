package quiz.fake;

import quiz.model.Capital;
import quiz.model.Continente;
import quiz.model.Pais;
import quiz.model.TipoCapital;
import quiz.repository.ICapitalRepository;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementação em memória de ICapitalRepository, populada com alguns
 * países/capitais fictícios de exemplo, usada só em TesteMain.
 */
public class CapitalRepositoryFake implements ICapitalRepository {

    private final List<Capital> capitais = new ArrayList<>();
    private long proximoId = 1;

    public CapitalRepositoryFake() {
        Continente america = new Continente("América do Sul");
        Continente europa = new Continente("Europa");

        Pais brasil = new Pais("Brasil", america);
        Pais argentina = new Pais("Argentina", america);
        Pais franca = new Pais("França", europa);
        Pais italia = new Pais("Itália", europa);

        adicionar(new Capital("Brasília", brasil, TipoCapital.FEDERAL));
        adicionar(new Capital("Buenos Aires", argentina, TipoCapital.FEDERAL));
        adicionar(new Capital("Paris", franca, TipoCapital.FEDERAL));
        adicionar(new Capital("Roma", italia, TipoCapital.FEDERAL));
    }

    private void adicionar(Capital capital) {
        setId(capital, proximoId++);
        capitais.add(capital);
    }

    // Capital.id não tem setter público (é preenchido pelo JPA em
    // produção); via reflection apenas para simular esse preenchimento
    // dentro do repositório fake de teste.
    private void setId(Capital capital, long id) {
        try {
            Field campoId = Capital.class.getDeclaredField("id");
            campoId.setAccessible(true);
            campoId.set(capital, id);
        } catch (ReflectiveOperationException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void salvar(Capital capital) {
        adicionar(capital);
    }

    @Override
    public List<Capital> buscarTodasCapitaisFederais() {
        List<Capital> resultado = new ArrayList<>();
        for (Capital c : capitais) {
            if (c.getTipo() == TipoCapital.FEDERAL) {
                resultado.add(c);
            }
        }
        return resultado;
    }

    @Override
    public List<Capital> buscarCapitaisErradas(Long idCorreta) {
        List<Capital> resultado = new ArrayList<>();
        for (Capital c : capitais) {
            if (!c.getId().equals(idCorreta) && c.getTipo() == TipoCapital.FEDERAL) {
                resultado.add(c);
            }
        }
        return resultado;
    }

    @Override
    public List<Capital> buscarTodos() {
        return new ArrayList<>(capitais);
    }
}

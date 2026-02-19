package quiz.model;

import jakarta.persistence.*;

@Entity
@Table(name = "capitais")
public class Capital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private TipoCapital tipo;

    @ManyToOne
    private Pais pais;

    public Capital() {
    }

    public Capital(String nome, Pais pais, TipoCapital tipo) {
        this.nome = nome;
        this.pais = pais;
        this.tipo = tipo;
    }
    @Override
    public String toString() {
        return nome;
    }
    
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public TipoCapital getTipo() {
        return tipo;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}

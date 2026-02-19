package quiz.model;

import jakarta.persistence.*;

@Entity
@Table(name = "paises")
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "continente_id", nullable = false)
    private Continente continente;

    public Pais() {}

    public Pais(String nome, Continente continente) {
        this.nome = nome;
        this.continente = continente;
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


    public Continente getContinente() {
        return continente;
    }
}

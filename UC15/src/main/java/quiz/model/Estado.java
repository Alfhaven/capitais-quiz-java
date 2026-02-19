package quiz.model;

import jakarta.persistence.*;

@Entity
@Table(name = "estados")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "pais_id", nullable = false)
    private Pais pais;

    public Estado() {}

    public Estado(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
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


    public Pais getPais() {
        return pais;
    }
}

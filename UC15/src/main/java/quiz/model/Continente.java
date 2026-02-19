package quiz.model;

import jakarta.persistence.*;

@Entity
@Table(name = "continentes")
public class Continente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    public Continente() {}

    public Continente(String nome) {
        this.nome = nome;
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


    public void setNome(String nome) {
        this.nome = nome;
    }
}

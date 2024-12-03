package entrega.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Galo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int idade;
    private double peso;

    @OneToOne(mappedBy = "galo", cascade = CascadeType.ALL)
    private CondicaoFisica condicaoFisica;

    @OneToMany(mappedBy = "galo", cascade = CascadeType.ALL)
    private List<Aposta> apostas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public CondicaoFisica getCondicaoFisica() {
        return condicaoFisica;
    }

    public void setCondicaoFisica(CondicaoFisica condicaoFisica) {
        this.condicaoFisica = condicaoFisica;
    }

    public List<Aposta> getApostas() {
        return apostas;
    }

    public void setApostas(List<Aposta> apostas) {
        this.apostas = apostas;
    }
}

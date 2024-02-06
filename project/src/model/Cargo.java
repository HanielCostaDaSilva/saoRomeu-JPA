package model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String nome;

    private float salarioBase;

    @OneToMany(mappedBy ="cargos")
    private List<Funcionario> empregados;

    public Cargo(){
    }

    public Cargo(int id, String nome, float salarioBase){
        this.id = id;
        this.nome = nome;
        this.salarioBase = salarioBase;
    }

    /**
     * @return int return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return String return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return float return the salarioBase
     */
    public float getSalarioBase() {
        return salarioBase;
    }

    /**
     * @param salarioBase the salarioBase to set
     */
    public void setSalarioBase(float salarioBase) {
        this.salarioBase = salarioBase;
    }


    /**
     * @return List<Funcionario> return the empregados
     */
    public List<Funcionario> getEmpregados() {
        return empregados;
    }

    /**
     * @param empregados the empregados to set
     */
    public void setEmpregados(List<Funcionario> empregados) {
        this.empregados = empregados;
    }

}

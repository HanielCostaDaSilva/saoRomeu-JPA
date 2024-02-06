package model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Funcionario {

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String matricula;

    @Column(unique = true)
    private String cpf;

    private String nome;
    private String aniversario;
    private String dataAdmissao;

    @ManyToOne
    private Cargo cargo;

    @ManyToMany
    @JoinTable(name = "Funcionario_telefone")
    private List<Telefone> numerosTelefone;

    Funcionario() {
    }

    Funcionario(String matricula, String nome, String cpf, String aniversario, String dataAdmissao) {
        this.matricula = matricula;
        this.nome = nome;
        this.cpf = cpf;
        this.aniversario = aniversario;
        this.dataAdmissao = dataAdmissao;
    }

    /**
     * @return String return the matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * @return String return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
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
     * @return String return the aniversario
     */
    public String getAniversario() {
        return aniversario;
    }

    /**
     * @param aniversario the aniversario to set
     */
    public void setAniversario(String aniversario) {
        this.aniversario = aniversario;
    }

    /**
     * @return String return the dataAdmissao
     */
    public String getDataAdmissao() {
        return dataAdmissao;
    }

    /**
     * @param dataAdmissao the dataAdmissao to set
     */
    public void setDataAdmissao(String dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }


    /**
     * @return List<Telefone> return the numerosTelefone
     */
    public List<Telefone> getNumerosTelefone() {
        return numerosTelefone;
    }

    /**
     * @param numerosTelefone the numerosTelefone to set
     */
    public void setNumerosTelefone(List<Telefone> numerosTelefone) {
        this.numerosTelefone = numerosTelefone;
    }


    /**
     * @return Cargo return the cargo
     */
    public Cargo getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

}

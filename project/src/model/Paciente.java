package model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Paciente {

    @Id
    private String cpf;

    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    private List<Receita> prescription;

    @ManyToMany
    @JoinTable(name = "paciente_telefone")
    private List<Telefone> phoneNumbers;

    private String nome;
    //private int estadoUrgencia;
    private String dataNascimento;
    private String rua;
    private String bairro;
    private String cidade;

    public Paciente() {
    };

    public Paciente(String cpf, String nome, /* int estadoUrgencia,*/
            String dataNascimento, String rua,
            String bairro, String cidade) {
        this.cpf = cpf;
        this.nome = nome;
        //this.estadoUrgencia = estadoUrgencia;
        this.dataNascimento = dataNascimento;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
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
     * @return List<Receita> return the prescription
     */
    public List<Receita> getPrescription() {
        return prescription;
    }

    /**
     * @param prescription the prescription to set
     */
    public void setPrescription(List<Receita> prescription) {
        this.prescription = prescription;
    }

    /**
     * @return List<Telefone> return the phoneNumbers
     */
    public List<Telefone> getPhoneNumbers() {
        return phoneNumbers;
    }

    /**
     * @param phoneNumbers the phoneNumbers to set
     */
    public void setPhoneNumbers(List<Telefone> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
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
     * @return String return the dataNascimento
     */
    public String getDataNascimento() {
        return dataNascimento;
    }

    /**
     * @param dataNascimento the dataNascimento to set
     */
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * @return String return the rua
     */
    public String getRua() {
        return rua;
    }

    /**
     * @param rua the rua to set
     */
    public void setRua(String rua) {
        this.rua = rua;
    }

    /**
     * @return String return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return String return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

}

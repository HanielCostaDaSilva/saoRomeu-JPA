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

    private String name;
    private String birthday;
    private String admissionDate;

    @ManyToOne
    private Cargo office;

    @ManyToMany
    @JoinTable(name = "Funcionario_telefone")
    private List<Telefone> phoneNumbers;

    Funcionario() {
    }

    Funcionario(String matricula, String name, String cpf, String birthday, String admissionDate) {
        this.matricula = matricula;
        this.name = name;
        this.cpf = cpf;
        this.birthday = birthday;
        this.admissionDate = admissionDate;
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
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String return the birthday
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * @return String return the admissionDate
     */
    public String getAdmissionDate() {
        return admissionDate;
    }

    /**
     * @param admissionDate the admissionDate to set
     */
    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

}

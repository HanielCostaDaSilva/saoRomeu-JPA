package model;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Medico extends Funcionario {
    @Column(unique = true)
    private String crm;

    @ManyToOne
    private Especialidade speciality;

    @OneToMany(mappedBy = "doctor", fetch=FetchType.LAZY)
    private List<Receita> prescription;


    public Medico() {
    };

    public Medico(String matricula, String name, String cpf, String birthday, String admissionDate, String crm) {
        super(matricula, name, cpf, birthday, admissionDate);
        this.crm = crm;
    }

    /**
     * @return Especialidade return the especialidade
     */
    public Especialidade getSpeciality() {
        return speciality;
    }

    /**
     * @param speciality the speciality to set
     */
    public void setspeciality(Especialidade speciality) {
        this.speciality = speciality;
    }

    /**
     * @return String return the crm
     */
    public String getCrm() {
        return crm;
    }

    /**
     * @param crm the crm to set
     */
    public void setCrm(String crm) {
        this.crm = crm;
    }

}

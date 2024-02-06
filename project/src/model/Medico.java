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
    private Especialidade especialidade;

    @OneToMany(mappedBy = "doctor", fetch=FetchType.LAZY)
    private List<Receita> receitas;


    public Medico() {
    };

    public Medico(String matricula, String name, String cpf, String birthday, String admissionDate, String crm, Especialidade especialidade) {
        super(matricula, name, cpf, birthday, admissionDate);
        this.crm = crm;
        this.especialidade = especialidade;
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


    /**
     * @return Especialidade return the especialidade
     */
    public Especialidade getEspecialidade() {
        return especialidade;
    }

    /**
     * @param especialidade the especialidade to set
     */
    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    /**
     * @return List<Receita> return the receitas
     */
    public List<Receita> getReceitas() {
        return receitas;
    }

    /**
     * @param receitas the receitas to set
     */
    public void setReceitas(List<Receita> receitas) {
        this.receitas = receitas;
    }

}

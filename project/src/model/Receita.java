package model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Medico medico;

    @ManyToOne(cascade = CascadeType.ALL)
    private Paciente paciente; 
    
    @OneToMany(mappedBy = "receita")
    private List<Prescricao> prescricoes;

    private String dataRealizacao;
    private String dataExpiracao;

    public Receita() {
    };

    public Receita( String dataRealizacao, String dataExpiracao) {
        this.dataRealizacao=dataRealizacao;
        this.dataExpiracao=dataExpiracao;
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
     * @return Medico return the medico
     */
    public Medico getMedico() {
        return medico;
    }

    /**
     * @param medico the medico to set
     */
    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    /**
     * @return Paciente return the paciente
     */
    public Paciente getPaciente() {
        return paciente;
    }

    /**
     * @param paciente the paciente to set
     */
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    /**
     * @return List<Prescricao> return the prescricoes
     */
    public List<Prescricao> getPrescricoes() {
        return prescricoes;
    }

    /**
     * @param prescricoes the prescricoes to set
     */
    public void setPrescricoes(List<Prescricao> prescricoes) {
        this.prescricoes = prescricoes;
    }

    /**
     * @return String return the dataRealizacao
     */
    public String getDataRealizacao() {
        return dataRealizacao;
    }

    /**
     * @param dataRealizacao the dataRealizacao to set
     */
    public void setDataRealizacao(String dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }

    /**
     * @return String return the dataExpiracao
     */
    public String getDataExpiracao() {
        return dataExpiracao;
    }

    /**
     * @param dataExpiracao the dataExpiracao to set
     */
    public void setDataExpiracao(String dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }

}

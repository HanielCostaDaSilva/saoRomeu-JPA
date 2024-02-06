package model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Prescricao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Receita receita;

    @ManyToOne
    private Remedio remedio;

    private String descricao;

    public Prescricao() {
    }

    public Prescricao(Remedio remedio, Receita prescrition, String descricao) {
        this.receita = prescrition;
        this.remedio = remedio;
        this.descricao = descricao;
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
     * @return Receita return the receita
     */
    public Receita getReceita() {
        return receita;
    }

    /**
     * @param receita the receita to set
     */
    public void setReceita(Receita receita) {
        this.receita = receita;
    }

    /**
     * @return Remedio return the remedio
     */
    public Remedio getRemedio() {
        return remedio;
    }

    /**
     * @param remedio the remedio to set
     */
    public void setRemedio(Remedio remedio) {
        this.remedio = remedio;
    }

    /**
     * @return String return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}

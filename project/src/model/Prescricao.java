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
    private Receita prescription;

    @ManyToOne
    private Remedio remedy;

    private String description;

    public Prescricao() {
    }

    public Prescricao(Remedio remedy, Receita prescrition, String description) {
        this.prescription = prescrition;
        this.remedy = remedy;
        this.description = description;
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
     * @return Receita return the prescription
     */
    public Receita getPrescription() {
        return prescription;
    }

    /**
     * @param prescription the prescription to set
     */
    public void setPrescription(Receita prescription) {
        this.prescription = prescription;
    }

    /**
     * @return Remedio return the remedy
     */
    public Remedio getRemedy() {
        return remedy;
    }

    /**
     * @param remedy the remedy to set
     */
    public void setRemedy(Remedio remedy) {
        this.remedy = remedy;
    }

    /**
     * @return String return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

}

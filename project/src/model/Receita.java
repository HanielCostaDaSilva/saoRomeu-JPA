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
    private Medico doctor;

    @ManyToOne(cascade = CascadeType.ALL)
    private Paciente patient; 
    
    @OneToMany(mappedBy = "prescription")
    List<Prescricao> prescriptions;

    private String realizacionDateTime;
    private String expirationDate;

    public Receita() {
    };

    public Receita(String id, String realizacionDateTime, String expirationDate) {

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
     * @return String return the realizacionDateTime
     */
    public String getRealizacionDateTime() {
        return realizacionDateTime;
    }

    /**
     * @param realizacionDateTime the realizacionDateTime to set
     */
    public void setRealizacionDateTime(String realizacionDateTime) {
        this.realizacionDateTime = realizacionDateTime;
    }

    /**
     * @return String return the expirationDate
     */
    public String getExpirationDate() {
        return expirationDate;
    }

    /**
     * @param expirationDate the expirationDate to set
     */
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

}

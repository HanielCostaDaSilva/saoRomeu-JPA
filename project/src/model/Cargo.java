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
    private String name;

    private float salaryBase;

    @OneToMany(mappedBy ="office")
    private List<Funcionario> employees;

    public Cargo(){
    }

    public Cargo(int id, String name, float salaryBase){
        this.id = id;
        this.name = name;
        this.salaryBase = salaryBase;
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
     * @return float return the salaryBase
     */
    public float getSalaryBase() {
        return salaryBase;
    }

    /**
     * @param salaryBase the salaryBase to set
     */
    public void setSalaryBase(float salaryBase) {
        this.salaryBase = salaryBase;
    }

}

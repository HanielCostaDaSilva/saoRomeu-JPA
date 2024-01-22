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

    private String name;
    private int urgencyState;
    private String birthday;
    private String street;
    private String district;
    private String city;

    public Paciente() {
    };

    public Paciente(String cpf, String name, int urgencyState,
            String birthday, String street,
            String district, String city) {
        this.cpf = cpf;
        this.name = name;
        this.urgencyState = urgencyState;
        this.birthday = birthday;
        this.street = street;
        this.district = district;
        this.city = city;
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
     * @return int return the urgencyState
     */
    public int getUrgencyState() {
        return urgencyState;
    }

    /**
     * @param urgencyState the urgencyState to set
     */
    public void setUrgencyState(int urgencyState) {
        this.urgencyState = urgencyState;
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
     * @return String return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street the street to set
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @return String return the district
     */
    public String getDistrict() {
        return district;
    }

    /**
     * @param district the district to set
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * @return String return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

}

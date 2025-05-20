package cz.itnetwork.insurancerecords.data.entities;

import jakarta.persistence.*;
import cz.itnetwork.insurancerecords.data.entities.InsuranceEntity;

import java.util.List;

/**
 * Entity class representing a person who holds insurance.
 * This class is mapped to the database table storing personal details of insured people, and is linked to their insurances.
 */
@Entity
@Table(name = "Insureds")
public class InsuredEntity {

    /** Primary key of the insured person */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long insuredId;

    /** First name of the insured */
    @Column(nullable = false)
    private String name;

    /** Surname of the insured person */
    @Column(nullable = false)
    private String surname;

    /** Email address of the insured person */
    @Column(nullable = false)
    private String email;

    /** Phone number of the insured person */
    @Column(nullable = false)
    private String phoneNumber;

    /** Street address of the insured person */
    @Column(nullable = false)
    private String street;

    /** City address of the insured person */
    @Column(nullable = false)
    private String city;

    /** Zip code of the insured person's address */
    @Column(nullable = false)
    private String zipcode;

    /**List of the related insurances */
    @OneToMany(mappedBy = "insured")
    private List<InsuranceEntity> insurances;

    public long getInsuredId() {
        return insuredId;
    }

    public void setInsuredId(long insuredId) {
        this.insuredId = insuredId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public List<InsuranceEntity> getInsurances() {
        return insurances;
    }

    public void setInsurances(List<InsuranceEntity> insurances) {
        this.insurances = insurances;
    }

}

package cz.itnetwork.insurancerecords.models.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.List;

/**
 * Data Transfer Object (DTO) representing a single insured person.
 * This class is used to transfer data about the insured between the application layers, typically between the controller and service layers.
 */
public class InsuredDTO {

    /** Unique identifier of the insured person */
    private long insuredId;

    /** First name of the insured person */
    @NotBlank(message = "Vyplňte jméno")
    private String name;

    /** Surname of the insured person */
    @NotBlank(message = "Vyplňte příjmení")
    private String surname;

    /** Email address of the insured person */
    @NotBlank(message = "Vyplňte email")
    @Email(message = "Zadejte platný formát emailu")
    private String email;

    /** Phone number of the insured person */
    @NotBlank(message = "Zadejte telefonní číslo")
    @Pattern(
            regexp = "^(\\+\\d{1,4}|00\\d{1,4})?\\s?-?(\\d{3})\\s?-?(\\d{3})\\s?-?(\\d{3,4})$",
            message = "Zadejte platné telefonní číslo."
    )
    private String phoneNumber;

    /** Street address of the insured person */
    @NotBlank(message = "Vyplňte ulici a číslo popisné")
    private String street;

    /** City address of the insured person */
    @NotBlank(message = "Vyplňte ulici a číslo popisné")
    private String city;

    /** Zip code of the insured person's address */
    @NotBlank(message = "Vyplňte PSČ")
    private String zipcode;

    /**List of the related insurances IDs */
    private List<Long> insurancesIDs;

    /**List of the related incidents IDs */
    private List<Long> incidentsIds;

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

    public List<Long> getInsurancesIDs() {
        return insurancesIDs;
    }

    public void setInsurancesIDs(List<Long> insurancesIDs) {
        this.insurancesIDs = insurancesIDs;
    }

    public List<Long> getIncidentsIds() {
        return incidentsIds;
    }

    public void setIncidentsIds(List<Long> incidentsIds) {
        this.incidentsIds = incidentsIds;
    }
}

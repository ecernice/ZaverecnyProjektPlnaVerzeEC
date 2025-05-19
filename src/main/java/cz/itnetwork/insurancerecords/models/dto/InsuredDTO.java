package cz.itnetwork.insurancerecords.models.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class InsuredDTO {

    public long InsuredId;

    @NotBlank(message = "Vyplňte jméno")
    private String name;

    @NotBlank(message = "Vyplňte příjmení")
    private String surname;

    @NotBlank(message = "Vyplňte email")
    @Email(message = "Zadejte platný formát emailu")
    private String email;

    @NotBlank(message = "Zadejte telefonní číslo")
    @Pattern(
            regexp = "^(\\+\\d{1,4}|00\\d{1,4})?\\s?-?(\\d{3})\\s?-?(\\d{3})\\s?-?(\\d{3,4})$",
            message = "Zadejte platné telefonní číslo."
    )
    private String phoneNumber;

    @NotBlank(message = "Vyplňte ulici a číslo popisné")
    private String street;

    @NotBlank(message = "Vyplňte ulici a číslo popisné")
    private String city;

    @NotBlank(message = "Vyplňte PSČ")
    private String zipcode;

    public long getInsuredId() {
        return InsuredId;
    }

    public void setInsuredId(long insuredId) {
        InsuredId = insuredId;
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
}

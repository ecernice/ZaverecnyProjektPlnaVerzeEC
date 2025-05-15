package cz.itnetwork.insurancerecords.models.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class InsuredDTO {

    @NotBlank(message = "Vyplňte jméno")
    private String name;

    @NotBlank(message = "Vyplňte příjmení")
    private String surname;

    @NotBlank(message = "Vyplňte email")
    private String email;

    @NotBlank(message = "Vyplňte telefon")
    private String phone;

    @NotBlank(message = "Vyplňte ulici a číslo popisné")
    private String street;

    @NotBlank(message = "Vyplňte email")
    @Email(message = "Zadejte platný formát emailové adresy")
    private String city;

    @NotBlank(message = "Vyplňte PSČ")
    private String zipcode;


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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

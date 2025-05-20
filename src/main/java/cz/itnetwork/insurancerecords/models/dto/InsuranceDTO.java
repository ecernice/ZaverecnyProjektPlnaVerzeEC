package cz.itnetwork.insurancerecords.models.dto;

import java.time.LocalDate;

import cz.itnetwork.insurancerecords.models.enums.InsuranceType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Data Transfer Object (DTO) representing a single insurance record.
 * This class is used to transfer data about insurance between the application layers, and usually contains a reference to the insured person.
 */
public class InsuranceDTO {

    /** Unique identifier of the insurance record */
    private long insuranceId;

    /** Type of insurance (e.g. life, property, etc.) */
    @NotNull(message = "Vyberte typ pojištění")
    private InsuranceType insuranceType;

    /** Amount covered by the insurance */
    @Positive(message = "Vyplňte částku - kladné celé číslo")
    private int amount;

    /**Subject covered by insurance*/
    @NotBlank(message = "Vyplňte předmět pojištění")
    private String insuranceSubject;

    /**Effective date*/
    @NotNull(message = "Vyplňte datum začátku platnosti")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate validFrom;

    /**Expiration date*/
    @NotNull(message = "Vyplňte datum konce platnosti")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate validTo;

    /** ID of the insured person the policy is assigned to */
    private long insuredId;

    public long getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(long insuranceId) {
        this.insuranceId = insuranceId;
    }

    public InsuranceType getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(InsuranceType insuranceType) {
        this.insuranceType = insuranceType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getInsuranceSubject() {
        return insuranceSubject;
    }

    public void setInsuranceSubject(String insuranceSubject) {
        this.insuranceSubject = insuranceSubject;
    }

    public LocalDate getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDate validFrom) {
        this.validFrom = validFrom;
    }

    public LocalDate getValidTo() {
        return validTo;
    }

    public void setValidTo(LocalDate validTo) {
        this.validTo = validTo;
    }

    public long getInsuredId() {
        return insuredId;
    }

    public void setInsuredId(long insuredId) {
        this.insuredId = insuredId;
    }
}

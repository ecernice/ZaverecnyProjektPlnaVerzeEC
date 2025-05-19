package cz.itnetwork.insurancerecords.models.dto;

import java.time.LocalDate;

import cz.itnetwork.insurancerecords.models.enums.InsuranceType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class InsuranceDTO {

    public long InsuranceId;

    @NotNull(message = "Vyberte typ pojištění")
    private InsuranceType insuranceType;

    @Positive(message = "Vyplňte částku - kladné celé číslo")
    private int amount;

    @NotBlank(message = "Vyplňte předmět pojištění")
    private String insuranceSubject;

    @NotNull(message = "Vyplňte datum začátku platnosti")
    private LocalDate validFrom;

    @NotNull(message = "Vyplňte datum konce platnosti")
    private LocalDate validTo;

    public long getInsuranceId() {
        return InsuranceId;
    }

    public void setInsuranceId(long insuranceId) {
        InsuranceId = insuranceId;
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
}

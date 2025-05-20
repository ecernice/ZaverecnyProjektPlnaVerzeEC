package cz.itnetwork.insurancerecords.models.dto;

import java.time.LocalDate;

import cz.itnetwork.insurancerecords.models.enums.InsuranceType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.format.annotation.DateTimeFormat;

public class InsuranceDTO {

    private long insuranceId;

    @NotNull(message = "Vyberte typ pojištění")
    private InsuranceType insuranceType;

    @Positive(message = "Vyplňte částku - kladné celé číslo")
    private int amount;

    @NotBlank(message = "Vyplňte předmět pojištění")
    private String insuranceSubject;

    @NotNull(message = "Vyplňte datum začátku platnosti")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate validFrom;

    @NotNull(message = "Vyplňte datum konce platnosti")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate validTo;

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

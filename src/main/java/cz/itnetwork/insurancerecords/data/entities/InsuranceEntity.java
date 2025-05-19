package cz.itnetwork.insurancerecords.data.entities;

import cz.itnetwork.insurancerecords.models.enums.InsuranceType;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

import cz.itnetwork.insurancerecords.data.entities.InsuredEntity;

@Entity
@Table(name = "Insurances")
@Inheritance(strategy = InheritanceType.JOINED)
public class InsuranceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long insuranceId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private InsuranceType insuranceType;

    @Column(nullable = false)
    private int amount;

    @Column(nullable = false)
    private String insuranceSubject;

    @Column(nullable = false)
    private LocalDate validFrom;

    @Column(nullable = false)
    private LocalDate validTo;

    @ManyToOne
    @JoinColumn(name= "insured_id", nullable = false)
    private InsuredEntity insured;

    @OneToMany(mappedBy = "insurance")
    private List<IncidentEntity> incidents;

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

    public InsuredEntity getInsured() {
        return insured;
    }

    public void setInsured(InsuredEntity insured) {
        this.insured = insured;
    }

    public List<IncidentEntity> getIncidents() {
        return incidents;
    }

    public void setIncidents(List<IncidentEntity> incidents) {
        this.incidents = incidents;
    }
}

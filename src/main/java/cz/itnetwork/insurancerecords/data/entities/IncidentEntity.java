package cz.itnetwork.insurancerecords.data.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * Entity class representing a reported insurance incident stored in the database.
 * Each incident is linked to a specific insurance record.
 */
@Entity
@Table(name = "Incidents")
public class IncidentEntity {

    /** Primary key of the incident */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long incidentId;

    /** Short title of the incident */
    @Column(nullable = false)
    private String title;

    /** Detailed description of the incident */
    @Column(nullable = false)
    private String description;

    /**Date, when the incident was happened*/
    @Column(nullable = false)
    private LocalDate incidentDate;

    /**An amount to be paid in case of insurance incident*/
    @Column(nullable = false)
    private int insuranceAmount;

    /** ID of the related insurance */
    @ManyToOne
    @JoinColumn(name = "insurance_id", nullable = false)
    private InsuranceEntity insurance;

    public long getIncidentId() {
        return incidentId;
    }

    public void setIncidentId(long incidentId) {
        this.incidentId = incidentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getIncidentDate() {
        return incidentDate;
    }

    public void setIncidentDate(LocalDate incidentDate) {
        this.incidentDate = incidentDate;
    }

    public int getInsuranceAmount() {
        return insuranceAmount;
    }

    public void setInsuranceAmount(int insuranceAmount) {
        this.insuranceAmount = insuranceAmount;
    }

    public InsuranceEntity getInsurance() {
        return insurance;
    }

    public void setInsurance(InsuranceEntity insurance) {
        this.insurance = insurance;
    }
}

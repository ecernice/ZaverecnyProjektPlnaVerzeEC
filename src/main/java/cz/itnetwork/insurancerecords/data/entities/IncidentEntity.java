package cz.itnetwork.insurancerecords.data.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Incidents")
public class IncidentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long incidentId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private int description;

    @Column(nullable = false)
    private LocalDate incidentDate;

    @Column(nullable = false)
    private int insuranceAmount;

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

    public int getDescription() {
        return description;
    }

    public void setDescription(int description) {
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
}

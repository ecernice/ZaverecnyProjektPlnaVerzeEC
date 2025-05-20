package cz.itnetwork.insurancerecords.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * Data Transfer Object (DTO) representing a single insurance incident.
 * This class is used to transfer incident data between layers of the application, typically between the service and presentation layers.
 */
public class IncidentDTO {

    /** Unique identifier of the incident */
    private long incidentId;

    /** Short title or summary of the incident */
    @NotBlank (message = "Vyplňte název události")
    private String title;

    /** Detailed description of the incident */
    @NotBlank (message = "Vyplňte stručný popis události")
    private String description;

    /**Date, when the incident was happened*/
    @NotNull (message = "Vyplňte datum události")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate incidentDate;

    /**An amount to be paid in case of insurance incident*/
    @NotNull (message = "Uvěďte částku pojistného plnění")
    private int insuranceAmount;

    /** ID of the related insurance */
    private long insuranceId;

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

    public long getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(long insuranceId) {
        this.insuranceId = insuranceId;
    }

}

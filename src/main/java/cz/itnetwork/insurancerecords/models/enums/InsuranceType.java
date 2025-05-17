package cz.itnetwork.insurancerecords.models.enums;

public enum InsuranceType {

    PROPERTY("Pojištění majetku"),
    ACCIDENT("Havarijní pojištění"),
    INJURY("Úrazové pojištění"),
    TRAVEL("Cestovní pojištění"),
    LIFE("Životní pojištění");

    private final String label;

    InsuranceType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}


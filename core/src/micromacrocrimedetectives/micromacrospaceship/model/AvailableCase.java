package micromacrocrimedetectives.micromacrospaceship.model;

public enum AvailableCase {
    CYLINDER("Der Zylinder"),
    CAR_ACCIDENT("Der Autounfall"),
    BANK_ROBBERY("Der Bankraub");

    public final String description;

    AvailableCase(String description) {
        this.description = description;
    }
}

package pl.krzysiek.domain.enums;

public enum CalorieAmount {

    PROTINS(4.0),
    CARBS(4.0),
    FATS(9.0);

    private final Double value;

    CalorieAmount(final Double newValue) {
        value = newValue;
    }

    public Double getValue() { return value; }
}

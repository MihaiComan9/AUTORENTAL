package itschool.entity;

public enum Type {
    CONVERTIBLE("convertible"),
    COUPE("coupe"),
    SEDAN("sedan"),
    SUV("SUV"),
    VAN("van"),
    SPORTSCAR("sportcar"),
    HATCHBACK("hatchback"),
    SPORTBACK("sportback");

    private final String displayEnum;

    Type(String displayEnum) {
        this.displayEnum = displayEnum;
    }

    public String getDisplayEnum() {
        return displayEnum;
    }
}

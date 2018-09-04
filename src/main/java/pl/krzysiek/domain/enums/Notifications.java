package pl.krzysiek.domain.enums;

public enum Notifications {

    SUCCESS_ADDED_MEAL("Nowy posiłek został zapisany w bazie danych"),
    FAILED_ADDED_MEAL ("Przepraszamy, ale posiłek nie został zapisany"),
    SUCCESS_REGISTER_ACCOUNT ("Potwierdzamy rejestracje konta"),
    FAILED_REGISTER_ACCOUNT("Wprowadzony adres e-mail jest już zarejestrowany w systemie"),
    SUCCESS_ADDED_NEW_INGREDIENT ("Potwierdzamy zapisanie nowego składnika spożywczego w bazie danycyh"),
    SUCCESS_ADDED_NEW_INGREDIENTS ("Potwierdzamy zapisanie składników w bazie danych");

    private final String name;

    public String toString() {
        return this.name;
    }

    Notifications(String name) {
        this.name = name;
    }
}

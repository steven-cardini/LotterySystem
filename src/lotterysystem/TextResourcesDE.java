package lotterysystem;

import java.util.ListResourceBundle;

public class TextResourcesDE extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		return new Object[][] {
				{ "welcome", "Willkommen zu EuroMillions!" },
				{ "error", "Fehler:" },
				{ "warning", "Achtung:" },
				{ "success", "Erfolgreich:" },
				{ "unknown_error", "Ein unbekannter Fehler ist aufgetreten. Bitte versuchen Sie es nochmals!" },
				{ "console_main_menu", "A: Zahlen eingeben, B: Neue Gewinnerzahlen ziehen, H: Sprache �ndern, Q: Programm beenden" },
				{ "console_language_selection", "Press E for English, tippen Sie D f�r Deutsch" },
				{ "invalid_input", "Ung�ltige Eingabe! Bitte versuchen Sie es erneut." },
				{ "enter_numbers", "Bitte geben Sie Ihre Zahlen ein." },
				{ "enter_main_numbers", "Bitte geben Sie Ihre Hauptzahlen, getrennt durch Leerzeichen, ein." },
				{ "enter_star_numbers", "Bitte geben Sie Ihre Sternzahlen, getrennt durch Leerzeichen, ein." },
				{ "only_numbers_accepted", "Es werden nur Zahlen akzeptiert!" },
				{ "only_numbers_accepted_range", "Nur Zahlen aus dem folgenden Bereich sind erlaubt:" },
				{ "amount_matching_numbers", "Anzahl �bereinstimmende Zahlen:" },
				{ "winning_numbers", "Die aktuellen Gewinnerzahlen sind:" },
				{ "your_numbers", "Ihre Zahlen sind:" }
		};
	}

}

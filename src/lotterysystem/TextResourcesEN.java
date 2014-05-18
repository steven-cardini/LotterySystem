package lotterysystem;

import java.util.ListResourceBundle;

public class TextResourcesEN extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		return new Object[][] {
				{ "welcome", "Welcome to EuroMillions!" },
				{ "error", "Error:" },
				{ "warning", "Warning:" },
				{ "success", "Success:" },
				{ "unknown_error", "An unknown error occurred. Please try again!" },
				{ "console_main_menu", "A: Input numbers, B: Draw New Winning Numbers, H: Change Language, Q: End Program" },
				{ "console_language_selection", "Press E for English, tippen Sie D f�r Deutsch" },
				{ "invalid_input", "Invalid input! Please try again." },
				{ "enter_numbers", "Please enter your numbers." },
				{ "enter_main_numbers", "Please enter your main numbers, separated by a space." },
				{ "enter_star_numbers", "Please enter your star numbers, separated by a space." },
				{ "only_numbers_accepted", "Only numbers are accepted!" },
				{ "only_numbers_accepted_range", "Only numbers in the following range are accepted:" },
				{ "amount_matching_numbers", "Amount of matching numbers:" },
				{ "winning_numbers", "The current winning numbers are:" },
				{ "your_numbers", "Your numbers are:" }
				
		};
	}

}

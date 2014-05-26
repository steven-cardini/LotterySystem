package lotterysystem;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

public class LanguageHandler {
	
	enum Language {
		ENGLISH, GERMAN;
	}
	
	private final String resourceBaseName = "messages";
	private final Language defaultLanguage = Language.ENGLISH;
	
	private HashMap<Language, Locale> languageMap;
	private ResourceBundle messages;
	private Language currentLanguage;
	
	LanguageHandler () {
		languageMap = new HashMap<>();
		languageMap.put(Language.ENGLISH, Locale.ENGLISH);
		languageMap.put(Language.GERMAN, Locale.GERMAN);
		
		setLanguage(defaultLanguage);
	}
	
	void setLanguage (Language lang) {
		messages = ResourceBundle.getBundle (resourceBaseName, languageMap.get(lang));
		currentLanguage = lang;
	}
	
	String getMessage (String key) {
		return messages.getString(key);
	}
	
	Locale getCurrentLocale () {
		return languageMap.get(currentLanguage);
	}
	
	static String formatDate (Date date, Locale locale) {
		DateFormat df = DateFormat.getDateInstance(0, locale);
		return df.format(date);
	}
}

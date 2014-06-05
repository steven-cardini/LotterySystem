package lotterysystem;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

public class LanguageHandler {
	
	public enum Language {
		ENGLISH, GERMAN;
	}
	
	private final String resourceBaseName = "messages";
	private final Language defaultLanguage = Language.ENGLISH;
	
	private HashMap<Language, Locale> languageMap;
	private ResourceBundle messages;
	private Language currentLanguage;
	
	public LanguageHandler () {
		languageMap = new HashMap<>();
		languageMap.put(Language.ENGLISH, Locale.ENGLISH);
		languageMap.put(Language.GERMAN, Locale.GERMAN);
		
		setLanguage(defaultLanguage);
	}
	
	public LanguageHandler (ResourceBundle resources) {
		this();
	}
	
	public void setLanguage (Language lang) {
		messages = ResourceBundle.getBundle (resourceBaseName, languageMap.get(lang));
		currentLanguage = lang;
	}
	
	public String getMessage (String key) {
		return messages.getString(key);
	}
	
	public Locale getCurrentLocale () {
		return languageMap.get(currentLanguage);
	}
	
	public static String formatDate (Date date, Locale locale) {
		DateFormat df = DateFormat.getDateInstance(0, locale);
		return df.format(date);
	}
}

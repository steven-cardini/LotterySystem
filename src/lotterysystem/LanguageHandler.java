package lotterysystem;

import gui.*;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class LanguageHandler {
	
	public enum Language {
		ENGLISH ("en"), GERMAN ("de");
		private String code;
		private Locale locale;
		
		Language (String code) {
			this.code = code;
			this.locale = new Locale (code);
		}
		
		public String getCode () {
			return this.code;
		}
		
		public Locale getLocale () {
			return this.locale;
		}
	}
	
	private final String resourceBaseName = "messages";
	
	private ResourceBundle messages;
	private Language currentLanguage;
	
	public LanguageHandler (Language language) {
		this.currentLanguage = language;
		this.messages = ResourceBundle.getBundle (resourceBaseName, this.currentLanguage.getLocale());
	}
	
	public void setLanguage (Language lang) {
		this.messages = ResourceBundle.getBundle (resourceBaseName, lang.getLocale());
		System.out.println(lang.getLocale());
		this.currentLanguage = lang;
		Main.getInstance().setLanguage(lang);
	}
	
	public String getMessage (String key) {
		return this.messages.getString(key);
	}
	
	public Locale getCurrentLocale () {
		return this.currentLanguage.getLocale();
	}
	
	public String formatDate (Date date) {
		DateFormat df = DateFormat.getDateInstance(0, this.currentLanguage.getLocale());
		return df.format(date);
	}
}

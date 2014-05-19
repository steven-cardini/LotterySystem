package lotterysystem;

public interface IInputOutputHandler {
	
	public static enum menuSelection {
		CHANGE_LANGUAGE, DRAW_NUMBERS, INPUT_NUMBERS, QUIT;
	}
	
	public static enum language {
		ENGLISH, GERMAN;
	}
	
	public void printMessage (String text);
	
	public void printWarning (String text);
	
	public void printError (String text);
	
	public void printSuccess (String text);
	
	public String scanInput ();
	
	public int[] getNumbers (int amount, int max, int min);

}

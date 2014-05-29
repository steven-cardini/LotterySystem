package lotterysystem;

public interface IInputOutputHandler {
	
	public static enum MenuSelection {
		CHANGE_LANGUAGE, DRAW_NUMBERS, INPUT_NUMBERS, CLEAR_ALL, QUIT;
	}
	
	public void printMessage (String text);
	
	public void printWarning (String text);
	
	public void printError (String text);
	
	public void printSuccess (String text);
	
	public String scanInput ();
	
	public int[] getNumbers (int amount, int max, int min);

}

package lotterysystem;

public interface IInputOutputHandler {
	
	public void printMessage (String text);
	
	public void printWarning (String text);
	
	public void printError (String text);
	
	public void printSuccess (String text);
	
	public String scanInput ();
	
	public int[] scanNumbers (int amount, int max, int min);

}

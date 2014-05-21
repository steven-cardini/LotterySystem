package lotterysystem;

import java.io.Serializable;
import java.util.Date;

public class WinningNumbersSet implements Serializable {

	private static final long serialVersionUID = 8782292429331517694L;
	
	private int[] winningMainNumbers;
	private int[] winningStarNumbers;
	private String winningSuperStar;
	private Date drawingDate;
	
	public WinningNumbersSet(int[] winningMainNumbers, int[] winningStarNumbers, String winningSuperStar, Date drawingDate) {
		this.winningMainNumbers = winningMainNumbers;
		this.winningStarNumbers = winningStarNumbers;
		this.winningSuperStar = winningSuperStar;
		this.drawingDate = drawingDate;
	}

	public int[] getWinningMainNumbers() {
		return winningMainNumbers;
	}

	public int[] getWinningStarNumbers() {
		return winningStarNumbers;
	}

	public String getWinningSuperStar() {
		return winningSuperStar;
	}

	public Date getDrawingDate() {
		return drawingDate;
	}
	
	
}

import javax.swing.*;

// this class contains the check if the game is over
public class result 
{
	private boolean resultGameFinished;
	private JButton resultB[];

	public result(boolean getIsGameFinished, JButton getB[]) 
	{
		resultB = getB;
		resultGameFinished = getIsGameFinished;
	}

	public boolean preWin() 
	{
		for (int i = 1; i <= 7; i++) 
		{
			if (resultGameFinished == false) 
			{
				if (i == 1) {
					// checking for diagonal win
					checkWin(i, i + 4, i + 8);
				}
				if (i <= 3) {
					// checking for column win
					checkWin(i, i + 3, i + 6);
				}
				if (i == 1 || i == 4 || i == 7) 
				{
					// checking for row win
					checkWin(i, i + 1, i + 2);
				}
				if (i == 3) {
					// checking for inverse diagonal win
					checkWin(i, i + 2, i + 4);
				}
			}
		}
		return resultGameFinished;
	}

	public void checkWin(int x, int y, int z) 
	{
		// checking if X wins
		if (resultB[x].getText().equals("X")) 
		{
			if (resultB[y].getText().equals("X")) 
			{
				if (resultB[z].getText().equals("X"))
				{
					declareResult("X");
				}
			}
		}
		// checking if O wins
		if (resultB[x].getText().equals("O")) 
		{
			if (resultB[y].getText().equals("O")) 
			{
				if (resultB[z].getText().equals("O")) 
				{
					declareResult("O");
				}
			}
		}
	}

	public void declareResult(String i) 
	{
		if (resultGameFinished == false) 
		{
			JOptionPane.showMessageDialog(null, i + " wins!");
			for (int j = 1; j < 10; j++) 
			{
				resultB[j].setEnabled(false);
			}
			resultGameFinished = true;
		}
	}

	// when game is draw
	public void declareDraw() 
	{
		JOptionPane.showMessageDialog(null, "Draw!");
		resultGameFinished = true;
	}

	// mode selection: against AI, another human, or cancel
	public int selectMode() 
	{
		Object[] options = { "Play with Computer", "Player with Another Human",
				"Cancel" };
		int n = JOptionPane.showOptionDialog(null,
				"Please select a game mode:", "Game Mode",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.INFORMATION_MESSAGE, null, options, options[2]);
		return n;
	}
}
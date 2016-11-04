import javax.swing.*;

public class pcMove 
{
	private boolean cpuMovesFirst;

	// the AI behavior is merely a random selection of a cell/box to mark
	public int moveAI() 
	{
		int a;
		for (;;)
		{
			a = (int) (Math.random() * 10);
			if (a > 0 && a < 10) 
			{
				break;
			}
		}
		return a;
	}

	// called when the AI is the first to move.
	// this is just the same as the method above
	public boolean ifCPUMovesFirst() 
	{
		int a = (int) (Math.random() * 10);
		if (a % 2 == 0) {
			cpuMovesFirst = true;
		}
		else
		{
			cpuMovesFirst = false;
		}
		return cpuMovesFirst;
	}
}
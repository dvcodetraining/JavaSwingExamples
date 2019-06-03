package MouseAdapter;

import javax.swing.JFrame;

public class MouseClick 
{
	public static void main(String[] args) 
	{
		MouseDetailsFrame mouseDetailsFrame = new MouseDetailsFrame();
		mouseDetailsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mouseDetailsFrame.setSize(300, 100);
		mouseDetailsFrame.setVisible(true);
	}
}

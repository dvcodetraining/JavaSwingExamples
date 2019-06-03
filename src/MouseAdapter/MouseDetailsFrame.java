package MouseAdapter;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseDetailsFrame extends JFrame
{
	
	private String details; // String to show in statusBar
	private JLabel statusBar; 
	
	public MouseDetailsFrame()
	{
		super("MouseButton Clicks Example by Damian Vaz");
		statusBar = new JLabel("Click on mouse!");
		add(statusBar, BorderLayout.SOUTH);
		MouseClickHandler handler = new MouseClickHandler();
		addMouseListener(handler);
	}
	
	// intern class to handle mouse events
	private class MouseClickHandler extends MouseAdapter
	{
		
		public void mouseClicked(MouseEvent event) 
		{
			int x = event.getX();
			int y = event.getY();
			
			details = String.format("Clicked %d times", event.getClickCount());
			if (event.isMetaDown()) // right Button is pressed
			{
				details += "with right button";
			}
			else if (event.isAltDown()) // middle button 
			{
				details += "with middle button";
			}
			else // left button
			{
				details += "with left button";
			}
			statusBar.setText(details);
		}
	}
}

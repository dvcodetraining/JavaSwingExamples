package MouseTracker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MouseTrackerFrame extends JFrame 
{
	private JPanel mousePanel; // panel that mouse events will occur
	private JLabel statusBar;  // label that shows events info
	
	public MouseTrackerFrame()
	{
		super("MouseTracker Example by Damian Vaz");
		
		mousePanel = new JPanel();
		mousePanel.setBackground(Color.WHITE);
		add(mousePanel, BorderLayout.CENTER);
		
		statusBar = new JLabel("Mouse outside of JPanel");
		add(statusBar, BorderLayout.SOUTH);
		
		MouseHandler handler = new MouseHandler();
		mousePanel.addMouseListener(handler);
		mousePanel.addMouseMotionListener(handler);
	}
	private class MouseHandler implements MouseListener, MouseMotionListener
	{
		@Override
		public void mouseClicked(MouseEvent event)
		{
			statusBar.setText(String.format("Mouse Clicked in [%d, %d]", event.getX(), event.getY()));
		}
		@Override
		public  void mousePressed(MouseEvent event)
		{
			statusBar.setText(String.format("Mouse Pressed in [%d, %d]", event.getX(), event.getY()));
		}
		@Override
		public void mouseReleased(MouseEvent event)
		{
			statusBar.setText(String.format("Mouse Released in [%d, %d]", event.getX(), event.getY()));
		}
		@Override
		public void mouseEntered(MouseEvent event)
		{
			statusBar.setText(String.format("Mouse entered in [%d, %d]", event.getX(), event.getY()));
			mousePanel.setBackground(Color.PINK);
		}
		
		public void mouseExited(MouseEvent event)
		{
			statusBar.setText("Mouse left JPanel");
			mousePanel.setBackground(Color.WHITE);
		}
		@Override
		public void mouseDragged(MouseEvent event)
		{
			
		}
		@Override
		public void mouseMoved(MouseEvent event)
		{
			
		}
	}
}

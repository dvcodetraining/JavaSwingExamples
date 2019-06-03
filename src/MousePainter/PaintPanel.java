package MousePainter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PaintPanel extends JPanel
{
	private int pointCount = 0;
	private Point[] points = new Point[10000];
	
	
	public PaintPanel()
	{
		addMouseMotionListener(
				new MouseMotionAdapter() // intern class anonymous
				{
					@Override
					public void mouseDragged(MouseEvent event)
					{
						if (pointCount < points.length)
						{
							points[pointCount] = event.getPoint();
							pointCount++;
							repaint();
						}
					}
				}); // end of anonymous class
	} // end constructor
	
	// draw ovals in delimited square 4x4 in designated location
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g); // clear drawing area
		
		//draw all points in array
		for(int i = 0; i < pointCount; i++)
		{
			g.setColor(Color.BLUE);
			g.fillRect(points[i].x, points[i].y, 4, 4);
		}
	}
	
	public static void main(String[] args) 
	{
		JFrame app = new JFrame("Drawing Program Example by Damian Vaz");
		PaintPanel paintPanel = new PaintPanel();
		app.add(paintPanel, BorderLayout.CENTER);
		app.add(new JLabel("move your mouse to draw"), BorderLayout.SOUTH);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(400, 200);
		app.setVisible(true);
	}
}

package Java2D;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class LinesRectsOvals extends JPanel
{
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		this.setBackground(Color.WHITE);
		
		g.setColor(Color.RED);
		g.drawLine(5, 30, 380, 30);
		
		g.setColor(new Color(100, 100, 185));
		g.drawRect(5, 40, 90, 55);
		g.fillRect(100, 40, 90, 55);
		
		g.setColor(Color.BLACK);
		g.fillRoundRect(200, 40, 90, 55, 50, 50);
		g.drawRoundRect(300, 40, 90, 55, 5, 5);
		
		g.drawArc(5, 100, 90, 90, -80, 340);
		g.fillArc(100, 100, 90, 55, 0, 360);
		
		
	}
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Drawing lines, rectangles and ovals");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LinesRectsOvals linesRectsOvals = new LinesRectsOvals();
		frame.add(linesRectsOvals);
		frame.setSize(410, 240);
		frame.setVisible(true);
		
	}
}

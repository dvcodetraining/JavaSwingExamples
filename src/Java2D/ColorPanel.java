package Java2D;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ColorPanel extends JPanel
{
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		this.setBackground(Color.WHITE);
		
		g.setColor(new Color(255, 0, 0)); //RED
		g.fillRect(15, 25, 100, 20);
		g.drawString("Current RGB " + g.getColor(), 130, 40);
		
		g.setColor(new Color(0.5f, 0.75f, 0.0f));
		g.fillRect(15, 50, 100, 20);
		g.drawString("Current RGB: " + g.getColor(), 130, 65);
	}
	
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Color Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ColorPanel colorPanel = new ColorPanel();
		frame.add(colorPanel);
		frame.setSize(400, 180);
		frame.setVisible(true);
	}
}

package PanelFrame;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelFrame extends JFrame
{
	private JPanel buttonPanel1; // Panel to store buttons
	private JPanel buttonPanel2;
	private JButton[] buttons, northButtons; 
	
	public PanelFrame()
	{
		super("Panel Manager Demo by Damian Vaz");
		buttons = new JButton[5];
		northButtons = new JButton [5];
		buttonPanel1 = new JPanel();
		buttonPanel1.setLayout(new GridLayout(1, buttons.length));
		buttonPanel2 = new JPanel();
		buttonPanel2.setLayout(new GridLayout(1, buttons.length));
		
		//creates buttons
		for (int i = 0; i < buttons.length; i++)
		{
			buttons[i]      = new JButton("South " + (i+1));
			northButtons[i] = new JButton("North" + (i+1));
			buttonPanel1.add(buttons[i]); // adds button to panel 1
			buttonPanel2.add(northButtons[i]); // adds button to panel 2
		}
		add(buttonPanel1, BorderLayout.SOUTH);
		add(buttonPanel2, BorderLayout.NORTH);
	}
	
	public static void main(String[] args)
	{
		PanelFrame panel = new PanelFrame();
		
		panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setSize(450, 200);
		panel.setVisible(true);
	}
}

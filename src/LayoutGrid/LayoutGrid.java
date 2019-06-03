package LayoutGrid;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class LayoutGrid extends JFrame implements ActionListener
{
	private JButton[] buttons;
	private static final String[] names = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
	private boolean toggle = true; // alternats between 2 layouts
	private Container container;   // frame container
	private GridLayout gridLayout1; 
	private GridLayout gridLayout2;
	
	public LayoutGrid()
	{
		super("GridLayout Demo by Damian Vaz");
		gridLayout1 = new GridLayout(4 ,3, 5, 5); // 4x3 grid with space 5 horizontally and vertically in between cells
		gridLayout2 = new GridLayout(6,2);        // 6x2 whithout spaces
		container   = getContentPane();           // gets Panel from content
		setLayout(gridLayout1);
		buttons =     new JButton[names.length];
		
		for (int i = 0; i < names.length; i++)
		{
			buttons[i] = new JButton(names[i]);
			buttons[i].addActionListener(this);
			add(buttons[i]);
		}
	}	
	@Override
	public void actionPerformed(ActionEvent event)
	{
		if (toggle)
		{
			container.setLayout(gridLayout2);
		}
		else
		{
			container.setLayout(gridLayout1);
		}
		toggle = !toggle;
		container.validate(); // remakes layout container
	}
	
	public static void main(String[] args)
	{
		LayoutGrid gridLayoutFrame = new LayoutGrid();
		gridLayoutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gridLayoutFrame.setSize(300,300);
		gridLayoutFrame.setVisible(true);
	}
	
}

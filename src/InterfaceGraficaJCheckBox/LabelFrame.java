package InterfaceGraficaJCheckBox;


import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class LabelFrame extends JFrame
{
	private JTextField textField;
	private JCheckBox boldCheckBox;
	private JCheckBox italicCheckBox;
	
	public LabelFrame()
	{
		super("JCheckBox Example by Damian Vaz");
		setLayout(new FlowLayout());
		
		textField = new JTextField("Check out the change in Style of the font", 20);
		textField.setFont(new Font("Serif", Font.PLAIN, 14));
		add(textField);
		
		boldCheckBox   = new JCheckBox("BOLD");
		italicCheckBox = new JCheckBox("ITALIC");
		add(boldCheckBox);
		add(italicCheckBox);
		
		
		HandlerCheckBox handler = new HandlerCheckBox();
		boldCheckBox.addItemListener(handler);
		italicCheckBox.addItemListener(handler);
	}
	
	//Intern Class for handling events
	
	private class HandlerCheckBox implements ItemListener
	{
		@Override
		public void itemStateChanged(ItemEvent event)
		{
			Font font = null; // stores the new font
			
			// checks which checkBox is selected and creates font
			if(boldCheckBox.isSelected() && italicCheckBox.isSelected())
			{
				font = new Font("Arial", Font.BOLD + Font.ITALIC, 14);
			}
			else if (boldCheckBox.isSelected())
			{
				font = new Font("Papyrus", Font.BOLD, 14);
			}
			else if (italicCheckBox.isSelected())
			{
				font = new Font("Comic Sans", Font.ITALIC, 14);
			}
			else
			{
				font = new Font("Serif", Font.PLAIN, 14);
			}
			textField.setFont(font);
		}
	}
}

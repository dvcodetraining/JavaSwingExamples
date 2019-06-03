package JRadioButton;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class LabelFrame extends JFrame
{
	private JTextField textField;
	private JRadioButton boldRadioButton;
	private JRadioButton italicRadioButton;
	private JRadioButton plainRadioButton;
	private ButtonGroup radioGroup;
	
	public LabelFrame()
	{
		super("JRadioButton Example by Damian Vaz");
		setLayout(new FlowLayout());
		
		textField = new JTextField("Check out the change in Style of the font", 30);
		textField.setFont(new Font("Serif", Font.PLAIN, 14));
		add(textField);
		
		boldRadioButton   = new JRadioButton("BOLD");
		italicRadioButton = new JRadioButton("ITALIC");
		plainRadioButton  = new JRadioButton("PLAIN");
		add(boldRadioButton);
		add(italicRadioButton);
		add(plainRadioButton);
		
		// create relationship <3 between buttons
		radioGroup = new ButtonGroup();
		radioGroup.add(boldRadioButton);
		radioGroup.add(italicRadioButton);
		radioGroup.add(plainRadioButton);
		
		
		HandlerRadioButton handler = new HandlerRadioButton();
		boldRadioButton.addItemListener(handler);
		italicRadioButton.addItemListener(handler);
		plainRadioButton.addItemListener(handler);
	}
	
	//Intern Class for handling events
	
	private class HandlerRadioButton implements ItemListener
	{
		@Override
		public void itemStateChanged(ItemEvent event)
		{
			Font font = null; // stores the new font
			
			// checks which checkBox is selected and creates font
			if (boldRadioButton.isSelected())
			{
				font = new Font("Arial", Font.BOLD, 14);
			}
			else if (italicRadioButton.isSelected())
			{
				font = new Font("Papyrus", Font.ITALIC, 14);
			}
			else if (plainRadioButton.isSelected())
			{
				font = new Font("Comic Sans", Font.PLAIN, 14);
			}
			else
			{
				font = new Font("Times", Font.PLAIN, 14);
			}
			textField.setFont(font);
		}
	}
}

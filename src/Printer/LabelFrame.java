package Printer;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

public class LabelFrame extends JFrame
{
	private JLabel printer, printQuality;
	private JRadioButton selection, all, applet;
	private ButtonGroup radioGroup;
	private JButton ok, cancel, setup, help;
	private JComboBox quality;
	private JCheckBox image, text, code, printToFile;
	private JPanel panelCenter, panelSouth, panelEast, panelFather;
	
	
	
	public LabelFrame()
	{
		super("Printer Example by Damian Vaz");
		setLayout(new FlowLayout());
		
		printer = new JLabel("Printer: MyPrinter");
		
		image = new JCheckBox("Image");
		text  = new JCheckBox("Text");
		code  = new JCheckBox("Code");
		
		selection = new JRadioButton("Selection");
		all       = new JRadioButton("All");
		applet    = new JRadioButton("Applet");
		
		radioGroup = new ButtonGroup();
		radioGroup.add(selection);
		radioGroup.add(all);
		radioGroup.add(applet);
		
		panelCenter = new JPanel();
		panelCenter.setLayout(new FlowLayout());
		
		JPanel blank1 = new JPanel();
		blank1.setPreferredSize(new Dimension(50,65));
		blank1.setBackground(Color.WHITE);
		
		panelCenter.add(blank1);
		
		Box checkBoxBox = Box.createVerticalBox();
		checkBoxBox.add(image);
		checkBoxBox.add(text);
		checkBoxBox.add(code);
		
		panelCenter.add(checkBoxBox);
		
		JPanel blank2 = new JPanel();
		blank2.setPreferredSize(new Dimension(40,65));
		blank2.setBackground(Color.WHITE);
		
		panelCenter.add(blank2);
		
		Box radioButtonBox = Box.createVerticalBox();
		radioButtonBox.add(selection);
		radioButtonBox.add(all);
		radioButtonBox.add(applet);
		
		panelCenter.add(radioButtonBox);
		
		JPanel blank3 = new JPanel();
		blank3.setPreferredSize(new Dimension(50,65));
		blank3.setBackground(Color.WHITE);
		
		panelCenter.add(blank3);
		
		panelSouth = new JPanel();
		
		printQuality = new JLabel("Print Quality: ");
		
		panelSouth.add(printQuality);
		
		String[] printQuality = {"HIGH", "MEDIUM", "LOW"};
		quality = new JComboBox(printQuality);
		
		panelSouth.add(quality);
		
		printToFile = new JCheckBox("Print to File");
		panelSouth.add(printToFile);
		
		ok = new JButton("OK");
		cancel = new JButton("Cancel");
		setup = new JButton("Setup...");
		help = new JButton("Help");
		
		panelEast = new JPanel();
		panelEast.setLayout(new GridLayout(4, 1, 15, 15));
		panelEast.add(ok);
		panelEast.add(cancel);
		panelEast.add(setup);
		panelEast.add(help);
		panelEast.setBorder(new EmptyBorder(0,0,0,0));
		
		
		panelFather = new JPanel();
		panelFather.setLayout(new BorderLayout());
		panelFather.add(printer, BorderLayout.NORTH);
		panelFather.add(panelCenter, BorderLayout.CENTER);
		panelFather.add(panelSouth, BorderLayout.SOUTH);
		panelFather.setBorder(new EmptyBorder(20,0,0,0));
		
	//	panelFather.add(panelEast, BorderLayout.EAST);
		
		add(panelFather);
		add(panelEast, BorderLayout.EAST);
		
	}
	
	//Intern Class for handling events
	
	/*private class HandlerRadioButton implements ItemListener
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
	*/
}

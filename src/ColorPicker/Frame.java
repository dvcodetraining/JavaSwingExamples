package ColorPicker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;

import InterfaceGraficaButton.LabelFrame;

public class Frame extends JFrame
{
	private JComboBox comboBox;
	private JPanel panelDad, panel1, panel2;
	private JCheckBox background, foreground;
	private JButton ok, cancel;
	private static final String[] colorName = {"White", "Black", "Blue", "Yellow", "Red", "Green", "Pink"};
	private static final Color[]  color     = {Color.WHITE, Color.BLACK, Color.BLUE, Color.YELLOW, Color.RED, Color.GREEN, Color.PINK};
	
	public Frame()
	{
		super("Color Picker Example by Damian Vaz");
		//setLayout(new FlowLayout());
		
		comboBox = new JComboBox(colorName);
		comboBox.setMaximumRowCount(3);
		add(comboBox, BorderLayout.NORTH);
		
		panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		background = new JCheckBox("Background");
		foreground = new JCheckBox("Foreground");
		ok = new JButton("OK");
		cancel = new JButton("Cancel");
		
		ButtonHandler buttonHandler = new ButtonHandler();
		ok.addActionListener(buttonHandler);
		cancel.addActionListener(buttonHandler);
		
		HandlerCheckBox handler = new HandlerCheckBox();
		background.addItemListener(handler);
		foreground.addItemListener(handler);
		
		panel1.add(background);
		panel1.add(foreground);
		
		panel2 = new JPanel();
		panel2.add(ok);
		panel2.add(cancel);
		
		panelDad = new JPanel();
		panelDad.add(panel1, BorderLayout.CENTER);
		panelDad.add(panel2, BorderLayout.SOUTH);
		
		add(panelDad);
	}
	
	//Intern Class for handling events
	private class HandlerCheckBox implements ItemListener
	{
		@Override
		public void itemStateChanged(ItemEvent event)
		{			
			if(background.isSelected() && event.getItemSelectable() == background)
			{
				//changes backgroung of all panels to the color selected in the comboBox when backgroiund is toggle
				panelDad.setBackground(color[comboBox.getSelectedIndex()]);
				panel1.setBackground(color[comboBox.getSelectedIndex()]);
				panel2.setBackground(color[comboBox.getSelectedIndex()]);
			}
			else if (foreground.isSelected() && event.getItemSelectable() == foreground)
			{
				// changer foreground of all buttons and comboBox to the color selected on comboBox when foregroiund is toggled
				background.setForeground(color[comboBox.getSelectedIndex()]);
				foreground.setForeground(color[comboBox.getSelectedIndex()]);
				ok.setForeground(color[comboBox.getSelectedIndex()]);
				cancel.setForeground(color[comboBox.getSelectedIndex()]);
				comboBox.setForeground(color[comboBox.getSelectedIndex()]);
			}
			
		}
	}
	private class ButtonHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{
			if (event.getSource() == ok)
			{
				ok.setBackground(Color.GREEN);
			}
			else if (event.getSource() == cancel)
			{
				cancel.setBackground(Color.RED);
			}
		}
	}
}

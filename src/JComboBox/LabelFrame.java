package JComboBox;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LabelFrame extends JFrame
{
	private JComboBox comboBox;
	private JLabel label;
	private static final String[] img = {"img1.png", "img2.png", "img3.png", "img4.png", "img5.png"};
	private Icon[] icons = new Icon[img.length];
	
	public LabelFrame()
	{
		super("JComboBox Example by Damian Vaz");
		for (int i = 0; i < img.length; i++)
		{
			icons[i] = new ImageIcon(getClass().getResource(img[i]));
		}
		setLayout(new FlowLayout());
		
		comboBox = new JComboBox(img);
		comboBox.setMaximumRowCount(3);
		add(comboBox);
		
		
		HandlerComboBox handler = new HandlerComboBox();
		comboBox.addItemListener(handler);
		
		label = new JLabel(icons[0]);
		add(label);
	}
	
	//Intern Class for handling events
	
	private class HandlerComboBox implements ItemListener
	{
		@Override
		public void itemStateChanged(ItemEvent event)
		{
			label.setIcon(icons[comboBox.getSelectedIndex()]);
		}
	}
}

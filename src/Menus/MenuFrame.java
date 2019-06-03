package Menus;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SwingConstants;


public class MenuFrame extends JFrame
{
	private final Color colorValues[] = {Color.BLACK, Color.BLUE, Color.RED, Color.GREEN};
	private final String fontNames[] = {"Serif", "Monospaced", "SansSerif", "Papyrus"};
	private JRadioButtonMenuItem colorItems[];
	private JRadioButtonMenuItem fonts[];
	private JCheckBoxMenuItem styleItems[];
	private JLabel displayJLabel;
	private ButtonGroup fontButtonGroup;
	private ButtonGroup colorButtonGroup;
	private int style; // used to make font styles
	
	public MenuFrame()
	{
		super("Menu example by Damian Vaz");
		
		//set up label to display text
		displayJLabel = new JLabel("Sample Text", SwingConstants.CENTER);
		displayJLabel.setForeground(colorValues[0]);
		displayJLabel.setFont(new Font("Serif", Font.PLAIN, 72));
		
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		
		//create About menu item
		JMenuItem aboutItem = new JMenuItem("About...");
		aboutItem.setMnemonic(KeyEvent.VK_A);
		fileMenu.add(aboutItem);
		
		aboutItem.addActionListener(new ActionListener()
				{
					// Anonymous internal class
					@Override
					public void actionPerformed(ActionEvent arg0)
					{
						JOptionPane.showMessageDialog(MenuFrame.this, "This is an example\nof using menus by Damian Vaz", "About", JOptionPane.PLAIN_MESSAGE);
					}
				});
		
		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		bar.add(fileMenu);
		
		JMenu formatMenu = new JMenu("Format");
		formatMenu.setMnemonic(KeyEvent.VK_R);
		
		String colors[] = {"Black", "Blue", "Red", "Green"};
		JMenu colorMenu = new JMenu("Color");
		colorMenu.setMnemonic(KeyEvent.VK_C);
		
		//create radio button menu items for colors
		colorItems = new JRadioButtonMenuItem[colors.length];
		colorButtonGroup = new ButtonGroup();
		ColorsHandler colorsHandler = new ColorsHandler();
		FontsHandler fontsHandler = new FontsHandler();
		
		//create color radio buttons
		for(int i = 0; i < colors.length; i++)
		{
			colorItems[i] = new JRadioButtonMenuItem(colors[i]);
			colorMenu.add(colorItems[i]);
			colorButtonGroup.add(colorItems[i]);
			colorItems[i].addItemListener(colorsHandler);
		}
		
		colorItems[0].setSelected(true);
		formatMenu.add(colorMenu);
		formatMenu.addSeparator();
		
		// array listing font names
		
		JMenu fontMenu = new JMenu("Font");
		fontMenu.setMnemonic(KeyEvent.VK_N);
		
		//create radio button menu items for font names
		fonts = new JRadioButtonMenuItem[fontNames.length];
		fontButtonGroup = new ButtonGroup();
		
		//create Font radio button menu items
		for(int i = 0; i < fonts.length; i++)
		{
			fonts[i] = new JRadioButtonMenuItem(fontNames[i]);
			fontMenu.add(fonts[i]);
			fontButtonGroup.add(fonts[i]);
			fonts[i].addItemListener(fontsHandler);
		}
		
		fonts[0].setSelected(true);
		fontMenu.addSeparator();
		
		formatMenu.add(fontMenu);
		bar.add(formatMenu);
		
		//set up label to display text
		displayJLabel = new JLabel("Sample Text", SwingConstants.CENTER);
		displayJLabel.setForeground(colorValues[0]);
		displayJLabel.setFont(new Font("Serif", Font.PLAIN, 72));
		
		getContentPane().setBackground(Color.CYAN);
		add(displayJLabel, BorderLayout.CENTER);
	}
	public static void main(String[] args)
	{
		MenuFrame f = new MenuFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);
	}
	private class ColorsHandler implements ItemListener
	{
		@Override
		public void itemStateChanged(ItemEvent e)
		{
			for (int i = 0; i < colorItems.length; i++)
			{
				if(colorItems[i].isSelected())
				{
					getContentPane().setBackground(colorValues[i]);
				//	displayJLabel.setFont(new Font(fontNames[i], Font.PLAIN, 30));
					break;
				}
			}
		}
		
	}
	private class FontsHandler implements ItemListener
	{
		@Override
		public void itemStateChanged(ItemEvent e)
		{
			for (int i = 0; i < fonts.length; i++)
			{
				if(fonts[i].isSelected())
				{
					displayJLabel.setFont(new Font(fontNames[i], Font.PLAIN, 52));
					break;
				}
			}
		}
		
	}
}

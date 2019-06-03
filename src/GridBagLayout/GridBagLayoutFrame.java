package GridBagLayout;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GridBagLayoutFrame extends JFrame
{
	private GridBagLayout layout;
	private GridBagConstraints constraints;
	
	public GridBagLayoutFrame()
	{
		super("GridBagLayoutn Example by Damian Vaz");
		layout = new GridBagLayout();
		setLayout(layout);
		constraints = new GridBagConstraints();
		 
		// create GUI componets
		JTextArea textArea1 = new JTextArea("TextArea1", 5, 10 );
		JTextArea textArea2 = new JTextArea("TextArea2", 2, 2);
		
		String[] names = { "Iron", "Steel", "Brass" };
		JComboBox comboBox = new JComboBox(names);
		
		JTextField textField = new JTextField("TextField");
		JButton button1 = new JButton("Button 1");
		JButton button2 = new JButton("Button 2");
		JButton button3 = new JButton("Button 3");
		
		constraints.fill = GridBagConstraints.BOTH;
		addComponent(textArea1, 0, 0, 1, 3);
		
		constraints.fill = GridBagConstraints.NONE;

		constraints.ipadx = 100;
		addComponent(button1, 0, 1, 1, 1);
		constraints.ipadx = 0;
		addComponent(new JButton("Button w"), 0, 2, 1, 1);
		
		
		addComponent(comboBox, 2, 1, 2, 1);
		
		//button 2 
	
		constraints.weightx = 0;
		constraints.weighty = 0;
		constraints.anchor = GridBagConstraints.WEST;
		constraints.fill = GridBagConstraints.NONE;
		addComponent(button2, 1, 1, 1, 1);
		
		// fill is BOTH for button 3
		constraints.weightx = 0;
		constraints.weighty = 0;
		addComponent(button3, 1, 2, 1, 1);
		
		//weightx and weighty for textField are both 0, fill is BOTH
		addComponent(textField, 3, 0, 2, 1);
		
		//weightx and weighty for textArea2 are both 0, fill is BOTH
		addComponent(textArea2, 3, 2, 1, 1);

	 }
	
	private void addComponent(Component component, int row, int col, int width, int height)
	{
		constraints.gridx = col;
		constraints.gridy = row;
		constraints.gridwidth = width;
		constraints.gridheight = height;
		layout.setConstraints(component, constraints);
		add(component);
	}
	public static void main(String[] args) 
	{
		GridBagLayoutFrame frame = new GridBagLayoutFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 200);
		frame.setVisible(true);
	}
}
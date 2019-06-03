package flowLayout;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Layout extends JFrame
{
	private JButton leftButton;
	private JButton centerButton;
	private JButton rightButton;
	private FlowLayout flowLayout;
	private Container container;

	public Layout()
	{
		super("Layout Demo by Damian Vaz");

		flowLayout = new FlowLayout();
		container = getContentPane(); // get container for layout
		setLayout(flowLayout);

		leftButton   = new JButton("Left");
		rightButton  = new JButton("Right");
		centerButton = new JButton("Center");
		add(leftButton);
		add(centerButton);
		add(rightButton);
		
		ButtonHandler handler = new ButtonHandler();
		leftButton.addActionListener(handler);
		rightButton.addActionListener(handler);
		centerButton.addActionListener(handler);
	}

	public static void main(String[] args)
	{
		Layout layoutFrame = new Layout();
		layoutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		layoutFrame.setSize(300, 75);
		layoutFrame.setVisible(true);
	}
	
	private class ButtonHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{
			if(event.getSource() == leftButton)
			{
				flowLayout.setAlignment(FlowLayout.LEFT);
				// realigns atached components
				flowLayout.layoutContainer(container);
			}
			else if(event.getSource() == rightButton)
			{
				flowLayout.setAlignment(FlowLayout.RIGHT);
				flowLayout.layoutContainer(container);
			}
			else
			{
				flowLayout.setAlignment(FlowLayout.CENTER);
				flowLayout.layoutContainer(container);
			}
		}
	}
}

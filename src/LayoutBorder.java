import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class LayoutBorder extends JFrame implements ActionListener
{
	private JButton[] buttons;
	private static final String[] names = {"Hide North", "Hide South", "Hide East", "Hide West", "Hide Center"};
	private BorderLayout borderLayout;
	
	public LayoutBorder()
	{
		super("BorderLayout Demo by Damian Vaz");
		
		borderLayout = new BorderLayout(5,5);
		setLayout(borderLayout);
		buttons = new JButton[names.length];
		
		//creates buttons
		for (int i = 0; i < names.length; i++)
		{
			buttons[i] = new JButton(names[i]);
			buttons[i].addActionListener(this);
		}
		
		// add all the buttons / hack all things / drink all booze
		add(buttons[0], BorderLayout.NORTH);
		add(buttons[1], BorderLayout.SOUTH);
		add(buttons[2], BorderLayout.EAST);
		add(buttons[3], BorderLayout.WEST);
		add(buttons[4], BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent event)
	{
		//checks  for event source and content panel from layout
		for(JButton button : buttons)
		{
			if (event.getSource() == button)
			{
				button.setVisible(false);
			}
			else
			{
				button.setVisible(true);
			}
		}
		borderLayout.layoutContainer(getContentPane());
	}
	public static void main(String[] args)
	{
		LayoutBorder layout = new LayoutBorder();
		layout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		layout.setSize(700, 500);
		layout.setVisible(true);
	}
	
}

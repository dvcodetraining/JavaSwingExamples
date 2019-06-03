package JList;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class LabelFrame extends JFrame
{
	private JList colorList;
	private static final String[] colorName = {"White", "Black", "Blue", "Yellow", "Red", "Green", "Pink"};
	private static final Color[]  color     = {Color.WHITE, Color.BLACK, Color.BLUE, Color.YELLOW, Color.RED, Color.GREEN, Color.PINK};
	
	public LabelFrame()
	{
		super("JList Example by Damian Vaz");
		setLayout(new FlowLayout());
		colorList = new JList(colorName);
		colorList.setVisibleRowCount(4);
		colorList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		add(new JScrollPane(colorList));
		
		colorList.addListSelectionListener(
				new ListSelectionListener() // intern class anonymous;
				{
					@Override
					public void valueChanged(ListSelectionEvent event)
					{
						getContentPane().setBackground(color[colorList.getSelectedIndex()]);
					}
				});
	}
}

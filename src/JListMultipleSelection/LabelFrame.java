package JListMultipleSelection;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class LabelFrame extends JFrame
{
	private JList colorList;
	private JList copyList;
	private JButton copyButton;
	
	private static final String[] colorName = {"White", "Black", "Blue", "Yellow", "Red", "Green", "Pink"};
	private static final Color[]  color     = {Color.WHITE, Color.BLACK, Color.BLUE, Color.YELLOW, Color.RED, Color.GREEN, Color.PINK};
	
	public LabelFrame()
	{
		super("JListMultiple Example by Damian Vaz");
		setLayout(new FlowLayout());
		
		colorList = new JList(colorName);
		colorList.setVisibleRowCount(5);
		colorList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		add(new JScrollPane(colorList));
		
		copyButton = new JButton("Copy >>>");
		add(copyButton);
		
		copyButton.addActionListener(
				new ActionListener() // intern class anonymous
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						copyList.setListData(colorList.getSelectedValuesList().toArray());
					}
				}); // end of intern class anonymous
		
		copyList = new JList();
		copyList.setVisibleRowCount(5);
		copyList.setFixedCellWidth(100);
		copyList.setFixedCellHeight(15);
		copyList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		add(new JScrollPane(copyList));
		
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

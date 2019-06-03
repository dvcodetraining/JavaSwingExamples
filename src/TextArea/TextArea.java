package TextArea;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextArea extends JFrame
{
	private JTextArea textArea1; // exibts String demo
	private JTextArea textArea2; // selected text is copy to here
	private JButton   copyButton; 
	
	public TextArea()
	{
		super("Text Area Demo by Damian Vaz");
		Box box = Box.createHorizontalBox();
		String demo = "This is a demo String to \n"
				    + " ilustrate the copied text \n"
				    + " from area1 to area 2 using \n "
				    + "external event \n";
		textArea1 = new JTextArea(demo, 10, 15); 
		box.add(new JScrollPane(textArea1));
		
		copyButton = new JButton("Copy >>>");
		box.add(copyButton);
		copyButton.addActionListener(
				new ActionListener() // anonymous intern class
				{
					@Override
					public void actionPerformed(ActionEvent event)
					{
						textArea2.setText(textArea1.getSelectedText());
					}					
				});
		textArea2 = new JTextArea(10,15);
		textArea2.setEditable(false);
		box.add(new JScrollPane(textArea2));
		add(box);
	}
	public static void main(String[] args)
	{
		TextArea textArea = new TextArea();
		textArea.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textArea.setSize(600, 200);
		textArea.setVisible(true);
	}
}

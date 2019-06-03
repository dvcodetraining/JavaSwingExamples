package InterfaceGraficaHandlerEventos;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LabelFrame extends JFrame
{
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JPasswordField password;
	
	public LabelFrame()
	{
		super("Handler de eventos");
		setLayout(new FlowLayout());
		
		// constroi field 10 col
		textField1 = new JTextField(10);
		add(textField1);
		
		// constroi texto padrão 
		textField2 = new JTextField("Insita o texto aqui");
		add(textField2);
		
		// constroi texto padrao com 21 col
		textField3 = new JTextField("Campo de texto não Editavel", 21);
		textField3.setEditable(false);
		add(textField3);
		
		//controi passwordField
		password = new JPasswordField("Texto escondido");
		add(password);
		
		TextFieldHandler handler = new TextFieldHandler();
		textField1.addActionListener(handler);
		textField2.addActionListener(handler);
		textField3.addActionListener(handler);
		password.addActionListener(handler);
	}
	
	//classe interna private para tratamento de envento
	private class TextFieldHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{
			String string = "";
			// user pressed enter in any field
			if(event.getSource() == textField1)
			{
				string = String.format("Campo de texto 1: %s ", event.getActionCommand());
			}
			else if (event.getSource() == textField2)
			{
				string = String.format("Campo de texto 2: %s", event.getActionCommand());
			}
			else if (event.getSource() == textField3)
			{
				string = String.format("Campo de texto 3: %s", event.getActionCommand());
			}
			else if(event.getSource() == password)
			{
				string = String.format("Campo de password: %s", event.getActionCommand());
			}
			JOptionPane.showMessageDialog(null, "<html><h1 style = 'color:purple'>" + string + "</h1></html>");
		}
	}
}

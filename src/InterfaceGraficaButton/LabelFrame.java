package InterfaceGraficaButton;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class LabelFrame extends JFrame
{
	private JButton button1;
	private JLabel label1;
	private JTextField textField;
	
	public LabelFrame()
	{
		super("Alo");
		setLayout(new FlowLayout());
		
		label1 = new JLabel("Escreva seu nome");
		add(label1);
		
		textField = new JTextField(15);
		add(textField);
		
		button1 = new JButton("Clique aqui");
		add(button1);
		
		OuvidorTexto handlerText = new OuvidorTexto();
		textField.addActionListener(handlerText);
		
		ButtonHandler handler = new ButtonHandler();
		button1.addActionListener(handler);
	}
	
	//classe interna private para tratamento de envento
	
	private class OuvidorTexto implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{
			JOptionPane.showMessageDialog(LabelFrame.this, String.format("<html><h1 style = 'color: purple;'>Nome: %s</h1></html>", event.getActionCommand()));
		}
	}
	private class ButtonHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{
			JOptionPane.showMessageDialog(LabelFrame.this, String.format("<html><h1 style = 'color:purple'>O seu nome é: %s </h1></html>", textField.getText()));
		}
	}
}

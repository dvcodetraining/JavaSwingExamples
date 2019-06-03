package InterfaceGraficaTextField;


import java.awt.FlowLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LabelFrame extends JFrame
{
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JPasswordField password;
	
	public LabelFrame()
	{
		super("Campos de texto e password");
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
	}
}

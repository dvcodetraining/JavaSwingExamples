package InterfaceGrafica;

import java.awt.FlowLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class LabelFrame extends JFrame
{
	private JLabel label1;
	private JLabel label2;
	//private JLabel label3;
	
	public LabelFrame()
	{
		super("Testando JLabel");
		
		setLayout(new FlowLayout());
		label1 = new JLabel("Exercicio");
		label1.setToolTipText("mensagem de dica");
		add(label1);
		
		Icon me = new ImageIcon(getClass().getResource("me.png"));
		label2 = new JLabel("Texto img", me, SwingConstants.LEFT);
		add(label2);
		/*
		label3 = new JLabel("JLabel texto icone add");
		label3.setIcon(me);
		label3.setHorizontalTextPosition(SwingConstants.CENTER);
		label3.setVerticalTextPosition(SwingConstants.BOTTOM);
		add(label3);
		*/
	}
}

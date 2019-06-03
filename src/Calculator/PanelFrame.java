package Calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class PanelFrame extends JFrame
{
	private JPanel buttonPanel; // Panel to store buttons
	private JPanel operationsPanel;
	private JButton[] buttons;
	private JButton div, mult, sub, add, squareRoot, cubicRoot, fatorial, percentage, square, cube, pow, exp, equal, dot, c;
	private JTextField display;
	private String    textDisplay = "";
	private static final String[] calcButtons = {"7", "8", "9","4", "5", "6", "1", "2", "3", "0", ".", "="};
	//private static final String[] calcButtons = {"7", "8", "9", "/", "\u221A","³\u221A", "4", "5", "6", "*", "x!", "%", "1", "2", "3", "-", "x", "x²", "0", ".", "=", "+", "e^", "x³"};
	private GridLayout gridButtons = new GridLayout(4, 3, 5, 5);
	private double a, b;
	int op;
	//private Container container;
	
	public PanelFrame()
	{
		super("Calculator by Damian Vaz");
		
		display = new JTextField(textDisplay, 1);
		display.setHorizontalAlignment(SwingConstants.RIGHT);
		display.setFont(new Font("Arial", Font.BOLD, 16));
		display.setEditable(false);
		display.setBackground(Color.WHITE);
		
		c = new JButton("C");
		
		Box box = Box.createHorizontalBox();
		box.add(display);
		box.add(c);
		
		buttons = new JButton[calcButtons.length];
		ButtonHandler handler = new ButtonHandler();
		buttonPanel = new JPanel();
		for (int i = 0; i < calcButtons.length; i++)
		{
			buttons[i] = new JButton(calcButtons[i]);
			buttons[i].addActionListener(handler);
			buttonPanel.add(buttons[i]); // add buttons to panel
		}
		
		// creating operations buttons
		div          = new JButton("/");
		mult         = new JButton("*");
		sub          = new JButton("-");
		add          = new JButton("+");
		squareRoot   = new JButton("\u221A");
		cubicRoot    = new JButton("³\u221A");
		fatorial     = new JButton("x!");
		percentage   = new JButton("%");
		square       = new JButton("x²");
		cube         = new JButton("x³");
		exp          = new JButton("e^");
		pow          = new JButton("x^");
		dot   = buttons[10];
		equal = buttons[11];
		
		// making operations buttons listener
		div.addActionListener(handler);
		mult.addActionListener(handler);
		sub.addActionListener(handler);
		add.addActionListener(handler);
		squareRoot.addActionListener(handler);
		cubicRoot.addActionListener(handler);
		fatorial.addActionListener(handler);
		percentage.addActionListener(handler);
		square.addActionListener(handler);
		cube.addActionListener(handler);
		exp.addActionListener(handler);
		pow.addActionListener(handler);
		c.addActionListener(handler);
		
		operationsPanel = new JPanel();
		
		operationsPanel.add(div);
		operationsPanel.add(squareRoot);
		operationsPanel.add(cubicRoot);
		operationsPanel.add(mult);
		operationsPanel.add(fatorial);
		operationsPanel.add(percentage);
		operationsPanel.add(sub);
		operationsPanel.add(square);
		operationsPanel.add(cube);
		operationsPanel.add(add);
		operationsPanel.add(exp);
		operationsPanel.add(pow);
	
		
				
		operationsPanel.setLayout(new GridLayout(4, 3, 5, 5));
		operationsPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		buttonPanel.setLayout(gridButtons);
		buttonPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		add(box, BorderLayout.NORTH);
		add(buttonPanel);
		add(operationsPanel, BorderLayout.EAST);
	}
	
	private class ButtonHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{
			// when the sign equal is pressed, takes to value stored in b, 
			//and performs whatever operations stored in op to the current variable A
			if(event.getSource() == equal)
			{
				switch (op)
				{
					case(1):
					{
						a = Calculator.div(b, a);                        // calculates ond value b divided by new value a
						textDisplay = ("" + a);                          // refresh textDisplay with the result
						display.setText(textDisplay);
						break;
					}
					case(2):
					{
						a = Calculator.mult(b, a);
						textDisplay = ("" + a);
						display.setText(textDisplay);
						break;
					}
					case(3):
					{
						a = Calculator.sub(b, a);
						textDisplay = ("" + a);
						display.setText(textDisplay);
						break;
					}
					case(4):
					{
						a = Calculator.add(b, a);
						textDisplay = ("" + a);
						display.setText(textDisplay);
						break;
					}
					case(5):
					{
						a = Calculator.exp(b, a);
						textDisplay = ("" + a);
						display.setText(textDisplay);
						break;
					}
					// if there isn't a operation defined, then just print to the display whatever is in a
					default:
					{
						textDisplay="" + a;
						display.setText(textDisplay);
					}
				}
			}
			else if(event.getSource() == div)
			{
				b =a;                                                    // stores a in b
				op = 1;                                                  // division
				// clear text 
				textDisplay = "";
				display.setText("" + b + "/");                           // shows old value b/ 
			}
			else if(event.getSource() == mult)
			{
				b =a;
				op = 2;
				// clear text 
				textDisplay = "";
				display.setText("" + b + "*");
			}
			else if(event.getSource() == sub)
			{
				b =a;
				op = 3;
				// clear text 
				textDisplay = "";
				display.setText("" + b + "-");
			}
			else if(event.getSource() == add)
			{
				b =a;
				op = 4;
				// clear text 
				textDisplay = "";
				display.setText("" + b + "+");
			}
			else if(event.getSource() == squareRoot)
			{
				a = Calculator.squareRoot(a);
				textDisplay = "" + a;
				display.setText(textDisplay);
			}
			else if(event.getSource() == cubicRoot)
			{
				a = Calculator.cubicRoot(a);
				textDisplay = "" + a;
				display.setText(textDisplay);
			}
			else if(event.getSource() == fatorial)
			{
				a = Calculator.fatorial((int)(a));
				textDisplay = "" + a;
				display.setText(textDisplay);
			}
			else if(event.getSource() == percentage)
			{
				a = Calculator.percentage(a);
				textDisplay = "" + a;
				display.setText(textDisplay);
			}
			else if(event.getSource() == square)
			{
				a = Calculator.square(a);
				textDisplay = "" + a;
				display.setText(textDisplay);
			}
			else if(event.getSource() == cube)
			{
				a = Calculator.cube(a);
				textDisplay = "" + a;
				display.setText(textDisplay);
			}
			else if(event.getSource() == exp)
			{
				a = Calculator.expE((int)(a));
				textDisplay = "" + a;
				display.setText(textDisplay);
			}
			else if(event.getSource() == pow)
			{
				b =a;
				op = 5;
				// clear text 
				textDisplay = "";
				display.setText("" + b + "^");
			}
			else if(event.getSource() == c)
			{
				//clear everything
				b =0;
				a=0;
				op = 0;
				// clear text 
				textDisplay = "";
				display.setText(textDisplay);
			}
			else
			{
				textDisplay +=  event.getActionCommand();
				a = Double.parseDouble(textDisplay);
				display.setText(textDisplay);
			}
		}
	}
}
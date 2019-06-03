package KeyDemoFrame;

import java.awt.Color;

import java.awt.TextArea;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.security.auth.callback.TextOutputCallback;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class KeyDemoFrame extends JFrame implements KeyListener 
{
	private String line1 = ""; // primeira linha da area de texto
	private String line2 = ""; // segunda linha da area de texto
	private String line3 = ""; // terceira linha da area de texto
	private JTextArea textArea; // area de texto que exibira a saida

	// construtor KeyDemoFrame
	public KeyDemoFrame() {
		super("Demonstrando Eventos de Teclado");
		textArea = new JTextArea(10, 15); // configura JTextArea
		textArea.setText("Pressiona qualquer tecla do teclado");
		textArea.setEnabled(false);// desativa area de texto
		textArea.setDisabledTextColor(Color.BLACK);// configura cor de texto
		add(textArea);// adiciona area de texto ao Frame
		addKeyListener(this);// permite que o frame processe os eventos do teclado
	}

	@Override // trata pressionamento de qualquer tecla
	public void keyPressed(KeyEvent event) {
		line1 = String.format("Tecla pressionada: %s/n " + event.getExtendedKeyCode(), KeyEvent.getKeyText(event.getKeyCode()));// mostra a tecla
																								// pressionada
		setLines2and3(event);// configura a sa�da das linhas dois e tr�s
	}

	@Override // trata libera��o de qualquer tecla
	public void keyReleased(KeyEvent event) {
		// DESENVOLVER C�DIGO
	}

	@Override // trata pressionamento de uma tecla de a��o
	public void keyTyped(KeyEvent event) {
		// DESENVOLVER C�DIGO
	}

	// configura 2a e 3a linhas de saida
	private void setLines2and3(KeyEvent event) {
		line2 = String.format("Esta tecla %s � uma tecla de a��o", (event.isActionKey() ? "" : "n�o"));
		String temp = KeyEvent.getKeyModifiersText(event.getModifiers());
		line3 = String.format("Tecla modificador pressionada: %s", (temp.equals("") ? "none" : temp)); // modificadores
																										// de saida
		textArea.setText(String.format("%s\n%s\n%s\n", line1, line2, line3));// gera saida de tr�s linhas de texto
	}

	public static void main(String[] args) {
		KeyDemoFrame keyDemoFrame = new KeyDemoFrame();
		keyDemoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		keyDemoFrame.setSize(350, 100);
		keyDemoFrame.setVisible(true);
	}
}

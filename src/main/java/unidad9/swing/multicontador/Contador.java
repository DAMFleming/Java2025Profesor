package unidad9.swing.multicontador;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public abstract class Contador extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JButton buttonReset = new JButton("RESET");
	private JTextField textFieldValor = new JTextField("0", 5);
	private int valor;
	
	public Contador() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		textFieldValor.setEditable(false);
		textFieldValor.setBackground(Color.WHITE);
		buttonReset.addActionListener(e -> reset());
		add(buttonReset);
		add(textFieldValor);
		setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createEmptyBorder(10, 10, 10, 10),
				BorderFactory.createCompoundBorder(
						BorderFactory.createLineBorder(Color.BLACK),
						BorderFactory.createEmptyBorder(5, 5, 5, 5))
		));
		textFieldValor.setBorder(
				BorderFactory.createCompoundBorder(
						BorderFactory.createEmptyBorder(0, 5, 0, 5),
						textFieldValor.getBorder()));
	}
	
	public void reset() {
		valor = 0;
		textFieldValor.setText("0");
	}
	
	public void inc() {
		valor++;
		textFieldValor.setText(String.valueOf(valor));
	}
	
	public void dec(int n) {
		valor -= n;
		textFieldValor.setText(String.valueOf(valor));
	}
	
	public int getValor() {
		return valor;
	}
	
	
}

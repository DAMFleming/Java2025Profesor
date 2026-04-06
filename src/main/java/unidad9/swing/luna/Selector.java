package unidad9.swing.luna;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Selector extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton anterior;
	private JButton siguiente;
	
	public Selector(Main vp) {
		setBackground(Color.BLACK);
		setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createEmptyBorder(30, 0, 0, 0),
				getBorder()
				));
		anterior = new JButton(new ImageIcon(Selector.class.getResource("/luna/anterior.png")));
		anterior.addActionListener(vp.getVisor()::anterior);
		siguiente = new JButton(new ImageIcon(Selector.class.getResource("/luna/siguiente.png")));
		siguiente.addActionListener(vp.getVisor()::siguiente);
		add(anterior);
		add(siguiente);
	}
	
	public void habilitar(boolean enabled) {
		anterior.setEnabled(enabled);
		siguiente.setEnabled(enabled);
	}
}

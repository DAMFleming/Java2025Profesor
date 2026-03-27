package unidad9.swing.luna;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Selector extends JPanel {

	private static final long serialVersionUID = 1L;

	public Selector(Visor visor) {
		setBackground(Color.BLACK);
		setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createEmptyBorder(30, 0, 0, 0),
				getBorder()
				));
		JButton anterior = new JButton(new ImageIcon(Selector.class.getResource("/luna/anterior.png")));
		anterior.addActionListener(visor::anterior);
		JButton siguiente = new JButton(new ImageIcon(Selector.class.getResource("/luna/siguiente.png")));
		siguiente.addActionListener(visor::siguiente);
		add(anterior);
		add(siguiente);
	}
}

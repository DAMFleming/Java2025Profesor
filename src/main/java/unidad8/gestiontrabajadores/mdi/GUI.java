package unidad8.gestiontrabajadores.mdi;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI {

	public static JButton crearBoton(String icono, ActionListener listener, boolean enabled) {
		JButton b;
		b = new JButton(new ImageIcon(GUI.class.getResource(icono)));
		b.setEnabled(enabled);
		b.addActionListener(listener);
		return b;
	}
	
	public static void etiqueta(JPanel panel, int fil, int col, String s) {
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = col;
		c.gridy = fil;
		c.ipadx = 10;
		c.ipady = 10;
		JLabel l = new JLabel(s);
		l.setFont(l.getFont().deriveFont(Font.BOLD));
		panel.add(l, c);
	}
	
	public static JTextField texto(JPanel panel, int fil, int col, boolean enabled, boolean editableFocusable) {
		GridBagConstraints c = new GridBagConstraints();
		JTextField txt = new JTextField(20);
		txt.setEnabled(enabled);
		txt.setEditable(editableFocusable);
		txt.setFocusable(editableFocusable);
		c.gridx = col;
		c.gridy = fil;
		c.ipadx = 10;
		c.ipady = 10;
		panel.add(txt, c);
		return txt;
	}
	
}

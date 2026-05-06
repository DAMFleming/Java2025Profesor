package unidad8.gestiontrabajadores;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class PanelDatos extends JPanel {

	private static final long serialVersionUID = 1L;
	
	JTextField nif;
	JTextField nombre;
	JTextField fecha;
	JTextField salario;
	JTextField hijos;
	
	public PanelDatos() {
		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createEmptyBorder(10, 10, 10, 10),
				BorderFactory.createCompoundBorder(
						BorderFactory.createBevelBorder(BevelBorder.LOWERED),
						BorderFactory.createEmptyBorder(10, 10, 10, 10)
		)));
		etiqueta(0, 0, "NIF");
		nif = texto(0, 1);
		etiqueta(1, 0, "Nombre");
		nombre = texto(1, 1);
		etiqueta(2, 0, "Fecha de alta");
		fecha = texto(2, 1);
		etiqueta(3, 0, "Salario");
		salario = texto(3, 1);
		etiqueta(4, 0, "Número de hijos");
		hijos = texto(4, 1);
	}
	
	private void etiqueta(int fil, int col, String s) {
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = col;
		c.gridy = fil;
		c.ipadx = 10;
		c.ipady = 10;
		add(new JLabel(s), c);
	}
	
	private JTextField texto(int fil, int col) {
		GridBagConstraints c = new GridBagConstraints();
		JTextField txt = new JTextField(20);
		txt.setEnabled(false);
		c.gridx = col;
		c.gridy = fil;
		c.ipadx = 10;
		c.ipady = 10;
		add(txt, c);
		return txt;
	}
	
	public void habilitar(boolean habilitado) {
		nif.setEnabled(habilitado);
		nombre.setEnabled(habilitado);
		fecha.setEnabled(habilitado);
		salario.setEnabled(habilitado);
		hijos.setEnabled(habilitado);
	}
	
}

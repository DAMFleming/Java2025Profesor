package unidad8.gestiontrabajadores;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

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
		nif.requestFocus();
	}
	
	public void limpiar() {
		nif.setText("");
		nombre.setText("");
		fecha.setText("");
		salario.setText("");
		hijos.setText("");
		nif.requestFocus();
	}
	
	public void guardar(File f) throws FileNotFoundException, IOException, Exception {
		try (DataOutputStream out = new DataOutputStream(new FileOutputStream(f, true))) {
			int nif = validarNIF();
			validarFecha();
			float salario = validarSalario();
			int hijos = validarHijos();
			out.writeInt(nif);
			out.writeUTF(nombre.getText());
			out.writeUTF(fecha.getText());
			out.writeFloat(salario);
			out.write(hijos);
		}
	}
	
	private char letraNIF(int nif) {
		return "TRWAGMYFPDXBNJZSQVHLCKE".charAt(nif % 23);
	}
	
	private int validarNIF() throws Exception {
		String txtNIF = nif.getText();
		if (txtNIF.length() < 2)
			throw new Exception("el nif introducido no es válido");
		int i = txtNIF.length() - 1;
		int numero = Integer.parseInt(txtNIF.substring(0,  i));
		if (txtNIF.toUpperCase().charAt(i) != letraNIF(numero))
			throw new Exception("el nif introducido no es válido");
		return numero;
	}
	
	private void validarFecha() throws Exception {
		try {
			DateTimeFormatter.ofPattern("dd/MM/yyyy").withResolverStyle(ResolverStyle.STRICT).parse(fecha.getText());
		} catch (DateTimeParseException e) {
			throw new Exception("el salario introducido no es válido"); 
		}
	}
	
	private float validarSalario() throws Exception {
		try {
			return Float.parseFloat(this.salario.getText());
		} catch (NumberFormatException e) {
			throw new Exception("la fecha introducida no es válida");
		}
	}
	
	private int validarHijos() throws Exception {
		try {
			return Integer.parseInt(this.hijos.getText());
		} catch (NumberFormatException e) {
			throw new Exception("el número de hijos introducido no es válido");
		}
	}
	
}

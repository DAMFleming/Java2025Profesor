package unidad8.gestiontrabajadores.mdi;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.BevelBorder;

public class PanelAltas extends Panel {

	private static final long serialVersionUID = 1L;
	
	private JTextField nif;
	private JTextField nombre;
	private JTextField fecha;
	private JTextField salario;
	private JTextField hijos;
	
	private JToolBar toolBar;
	private JButton guardar;
	private JButton limpiar;
	
	public PanelAltas(Main main) {
		super(main);
		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createEmptyBorder(10, 10, 10, 10),
				BorderFactory.createCompoundBorder(
						BorderFactory.createBevelBorder(BevelBorder.LOWERED),
						BorderFactory.createEmptyBorder(10, 10, 10, 10)
		)));
		GUI.etiqueta(this, 0, 0, "NIF");
		nif = GUI.texto(this, 0, 1, false, true);
		GUI.etiqueta(this, 1, 0, "Nombre");
		nombre = GUI.texto(this, 1, 1, false, true);
		GUI.etiqueta(this, 2, 0, "Fecha de alta");
		fecha = GUI.texto(this, 2, 1, false, true);
		GUI.etiqueta(this, 3, 0, "Salario");
		salario = GUI.texto(this, 3, 1, false, true);
		GUI.etiqueta(this, 4, 0, "Número de hijos");
		hijos = GUI.texto(this, 4, 1, false, true);
		crearToolBar();
	}	
	private void crearToolBar() {
		toolBar = new JToolBar();
		toolBar.add(guardar = GUI.crearBoton("/gestiontrabajadores/guardar.png", this::guardarActionPerformed, false));
		toolBar.add(limpiar = GUI.crearBoton("/gestiontrabajadores/limpiar.png", this::limpiarActionPerformed, false));
	}
	
	public void guardarActionPerformed(ActionEvent evt) {
		try {
			int numero = NIF.validar(nif.getText());
			validarFecha();
			float salario = validarSalario();
			int hijos = validarHijos();
			try (DataOutputStream out = new DataOutputStream(new FileOutputStream(main.getFile(), true))) {
				out.writeInt(numero);
				out.writeUTF(nombre.getText());
				out.writeUTF(fecha.getText());
				out.writeFloat(salario);
				out.write(hijos);
				limpiar();
				nif.requestFocus();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, e.getLocalizedMessage(), "Error guardando datos", JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getLocalizedMessage(), "Error de validación", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void limpiarActionPerformed(ActionEvent e) {
		limpiar();
		nif.requestFocus();
	}
	
	private void validarFecha() throws Exception {
		try {
			DateTimeFormatter.ofPattern("dd/MM/yyyy").withResolverStyle(ResolverStyle.STRICT).parse(fecha.getText());
		} catch (DateTimeParseException e) {
			throw new Exception("Fecha no válida"); 
		}
	}
	
	private float validarSalario() throws Exception {
		try {
			return Float.parseFloat(this.salario.getText());
		} catch (NumberFormatException e) {
			throw new Exception("Salario no válido");
		}
	}
	
	private int validarHijos() throws Exception {
		try {
			return Integer.parseInt(this.hijos.getText());
		} catch (NumberFormatException e) {
			throw new Exception("Número de hijos no válido");
		}
	}
	
	private void limpiar() {
		nif.setText("");
		nombre.setText("");
		fecha.setText("");
		salario.setText("");
		hijos.setText("");
	}

	@Override
	public void setEnabled(boolean enabled) {
		nif.setEnabled(enabled);
		nombre.setEnabled(enabled);
		fecha.setEnabled(enabled);
		salario.setEnabled(enabled);
		hijos.setEnabled(enabled);
		guardar.setEnabled(enabled);
		limpiar.setEnabled(enabled);
		if (!enabled)
			limpiar();
	}
	
	@Override
	public void setSelected() {
		nif.requestFocus();
	}
	
	@Override
	public JToolBar getToolBar() {
		return toolBar;
	}
	
}

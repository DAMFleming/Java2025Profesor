package unidad8.gestiontrabajadores.mdi;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.BevelBorder;

public class PanelConsultas extends Panel {

	private static final long serialVersionUID = 1L;
	
	private JTextField nif;
	private JTextField nombre;
	private JTextField fecha;
	private JTextField salario;
	private JTextField hijos;
	private JTextField datoBusqueda;
	
	private JToolBar toolBar;
	private JButton buscarNIF;
	private JButton buscarNombre;
	private JButton limpiar;
	
	
	public PanelConsultas(Main main) {
		super(main);
		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createEmptyBorder(10, 10, 10, 10),
				BorderFactory.createCompoundBorder(
						BorderFactory.createBevelBorder(BevelBorder.LOWERED),
						BorderFactory.createEmptyBorder(10, 10, 10, 10)
		)));
		GUI.etiqueta(this, 0, 0, "NIF");
		nif = GUI.texto(this, 0, 1, true, false);
		GUI.etiqueta(this, 1, 0, "Nombre");
		nombre = GUI.texto(this, 1, 1, true, false);
		GUI.etiqueta(this, 2, 0, "Fecha de alta");
		fecha = GUI.texto(this, 2, 1, true, false);
		GUI.etiqueta(this, 3, 0, "Salario");
		salario = GUI.texto(this, 3, 1, true, false);
		GUI.etiqueta(this, 4, 0, "Número de hijos");
		hijos = GUI.texto(this, 4, 1, true, false);
		crearToolBar();
	}
	
	private void crearToolBar() {
		toolBar = new JToolBar();
		toolBar.add(limpiar = GUI.crearBoton("/gestiontrabajadores/limpiar.png", this::limpiarActionPerformed, false));
		toolBar.add(datoBusqueda = new JTextField(20));
		datoBusqueda.setEnabled(false);
		toolBar.add(buscarNIF = GUI.crearBoton("/gestiontrabajadores/buscar.png", this::buscarNIFActionPerformed, false));
		toolBar.add(buscarNombre = GUI.crearBoton("/gestiontrabajadores/buscar.png", this::buscarNombreActionPerformed, false));
	}
	
	private void buscarNIFActionPerformed(ActionEvent evt) {
		buscar(0);
	}
	
	private void buscarNombreActionPerformed(ActionEvent evt) {
		buscar(1);
	}
	
	private void buscar(int criterio) {
		try (DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(main.getFile())))) {
			boolean encontrado = false;
			String nif, nombre, fecha;
			float salario;
			int hijos;
			do {
				int aux = in.readInt();
				nif = String.valueOf(aux) + NIF.letra(aux);
				nombre = in.readUTF();
				fecha = in.readUTF();
				salario = in.readFloat();
				hijos = in.readUnsignedByte();
				encontrado = datoBusqueda.getText().equalsIgnoreCase(criterio == 0 ? nif : nombre);
			} while (!encontrado);
			this.nif.setText(nif);
			this.nombre.setText(nombre);
			this.fecha.setText(fecha);
			this.salario.setText(String.valueOf(salario));
			this.hijos.setText(String.valueOf(hijos));
		} catch (EOFException e) {
			JOptionPane.showMessageDialog(this, "Empleado no encontrado.", "Búsqueda", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Error: " + e.getLocalizedMessage(), "Leyendo datos", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	private void limpiarActionPerformed(ActionEvent e) {
		limpiar();
		datoBusqueda.requestFocus();
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
		limpiar.setEnabled(enabled);
		datoBusqueda.setEnabled(enabled);
		buscarNIF.setEnabled(enabled);
		buscarNombre.setEnabled(enabled);
		if (!enabled)
			limpiar();
	}
	
	@Override
	public void setSelected() {
		datoBusqueda.requestFocus();
	}

	@Override
	public JToolBar getToolBar() {
		return toolBar;
	}
	
}

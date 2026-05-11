package unidad8.gestiontrabajadores;

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
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;

public class PanelConsultas extends Panel {

	private static final long serialVersionUID = 1L;
	
	private JTextField nifTextField;
	private String nif;
	private JTextField nombreTextField;
	private String nombre;
	private JTextField fechaTextField;
	private String fecha;
	private JTextField salarioTextField;
	private float salario;
	private JTextField hijosTextField;
	private int hijos;
	private JTextField busquedaTextField;
	
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
		nifTextField = GUI.texto(this, 0, 1, true, false);
		GUI.etiqueta(this, 1, 0, "Nombre");
		nombreTextField = GUI.texto(this, 1, 1, true, false);
		GUI.etiqueta(this, 2, 0, "Fecha de alta");
		fechaTextField = GUI.texto(this, 2, 1, true, false);
		GUI.etiqueta(this, 3, 0, "Salario");
		salarioTextField = GUI.texto(this, 3, 1, true, false);
		GUI.etiqueta(this, 4, 0, "Número de hijos");
		hijosTextField = GUI.texto(this, 4, 1, true, false);
		crearToolBar();
	}
	
	private void crearToolBar() {
		toolBar = new JToolBar();
		toolBar.add(limpiar = GUI.crearBoton("/gestiontrabajadores/limpiar.png", this::limpiarActionPerformed, false));
		toolBar.add(busquedaTextField = new JTextField(20));
		busquedaTextField.setEnabled(false);
		toolBar.add(buscarNIF = GUI.crearBoton("/gestiontrabajadores/buscarnif.png", this::buscarNIFActionPerformed, false));
		toolBar.add(buscarNombre = GUI.crearBoton("/gestiontrabajadores/buscarnombre.png", this::buscarNombreActionPerformed, false));
	}
	
	private void buscarNIFActionPerformed(ActionEvent evt) {
		buscar(0);
	}
	
	private void buscarNombreActionPerformed(ActionEvent evt) {
		buscar(1);
	}
	
	private void buscar(int criterio) {
		main.getExecutorService().submit(()-> {
			try (DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(main.getFile())))) {
				boolean encontrado = false;
				do {
					int aux = in.readInt();
					nif = String.valueOf(aux) + NIF.letra(aux);
					nombre = in.readUTF();
					fecha = in.readUTF();
					salario = in.readFloat();
					hijos = in.readUnsignedByte();
					encontrado = busquedaTextField.getText().equalsIgnoreCase(criterio == 0 ? nif : nombre);
				} while (!encontrado);
				SwingUtilities.invokeLater(() -> {
					nifTextField.setText(nif);
					nombreTextField.setText(nombre);
					fechaTextField.setText(fecha);
					salarioTextField.setText(String.valueOf(salario));
					hijosTextField.setText(String.valueOf(hijos));
				});
			} catch (EOFException e) {
				JOptionPane.showMessageDialog(this, "No encontrado.", "Búsqueda de empleado", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Error: " + e.getLocalizedMessage(), "Leyendo datos", JOptionPane.ERROR_MESSAGE);
			}
		});
	}
	
	
	private void limpiarActionPerformed(ActionEvent e) {
		limpiar();
		busquedaTextField.requestFocus();
	}
	
	@Override
	public void limpiar() {
		nifTextField.setText("");
		nombreTextField.setText("");
		fechaTextField.setText("");
		salarioTextField.setText("");
		hijosTextField.setText("");
	}
	
	@Override
	public void setEnabled(boolean enabled) {
		limpiar.setEnabled(enabled);
		busquedaTextField.setEnabled(enabled);
		buscarNIF.setEnabled(enabled);
		buscarNombre.setEnabled(enabled);
		if (!enabled)
			limpiar();
	}
	
	@Override
	public void setSelected() {
		busquedaTextField.requestFocus();
	}

	@Override
	public JToolBar getToolBar() {
		return toolBar;
	}
	
}

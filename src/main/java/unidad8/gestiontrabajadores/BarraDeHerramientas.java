package unidad8.gestiontrabajadores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class BarraDeHerramientas extends JToolBar {
	
	private static final long serialVersionUID = 1L;
	private PanelDatos pd;
	private JFileChooser fc = new JFileChooser();
	private File file;
	private JButton guardar;
	private JButton cerrar;
	private JButton limpiar;
	
	public BarraDeHerramientas(PanelDatos pd) {
		this.pd = pd;
		agregarBoton("/gestiontrabajadores/abrir.png", this::abrir, true);
		guardar = agregarBoton("/gestiontrabajadores/guardar.png", this::guardar, false);
		cerrar = agregarBoton("/gestiontrabajadores/cerrar.png", this::cerrar, false);
		add(new JSeparator(SwingConstants.VERTICAL));
		limpiar = agregarBoton("/gestiontrabajadores/limpiar.png", this::limpiar, false);
	}

	private JButton agregarBoton(String icono, ActionListener listener, boolean enabled) {
		JButton b;
		b = new JButton(new ImageIcon(getClass().getResource(icono)));
		b.setEnabled(enabled);
		b.addActionListener(listener);
		add(b);
		return b;
	}
	
	private void abrir(ActionEvent e) {
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			file = fc.getSelectedFile();
			pd.habilitar(true);
			guardar.setEnabled(true);
			cerrar.setEnabled(true);
			limpiar.setEnabled(true);
		}
	}
	
	private void guardar(ActionEvent e) {
		
	}
	
	private void limpiar(ActionEvent e) {
		pd.limpiar();
	}
	
	private void cerrar(ActionEvent e) {
		
	}
}

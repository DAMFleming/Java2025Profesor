package unidad8.gestiontrabajadores;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class GestionDeTrabajadores extends JFrame {

	private static final long serialVersionUID = 1L;

	private GestionDeTrabajadores() {
		super("Gestión de Trabajadores");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		crearGUI();
		pack();
		setLocationRelativeTo(null);
	}
	
	private void crearGUI() {
		PanelDatos pd = new PanelDatos();
		add(pd, BorderLayout.CENTER);
		add(new BarraDeHerramientas(pd), BorderLayout.SOUTH);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new GestionDeTrabajadores().setVisible(true));
	}

}

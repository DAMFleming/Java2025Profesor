package unidad9.swing.luna;

import java.awt.BorderLayout;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private String [] nombres = {"Luna Nueva", "Luna Creciente", "Cuarto Creciente", 
			"Quinto Octante", "Luna Llena", "Tercer Octante", "Cuarto Menguante", "Luna Menguante"};
	private List<Luna> lunas = new LinkedList<>();
	private JLabel luna;
	
	
	public Main() {
		super("Fases de la Luna");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cargarLunas();
		Luna luna = lunas.getFirst();
		this.luna = new JLabel(luna.getNombre(), luna.getImagen(), JLabel.CENTER);
		add(this.luna, BorderLayout.CENTER);
		pack();
		setLocationRelativeTo(null);
	}
	
	private void cargarLunas() {
		for (String nombre: nombres)
			lunas.add(new Luna(
					nombre,
					new ImageIcon(Main.class.getResource("/luna/" + nombre + ".png"))
			));
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new Main().setVisible(true));
	}
	
	private static class Luna {
		private String nombre;
		private ImageIcon imagen;
		public Luna(String nombre, ImageIcon imagen) {
			this.nombre = nombre;
			this.imagen = imagen;
		}
		public String getNombre() {
			return nombre;
		}
		public ImageIcon getImagen() {
			return imagen;
		}
	}

}

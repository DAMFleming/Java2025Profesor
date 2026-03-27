package unidad9.swing.luna;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Visor extends JLabel {

	private static final long serialVersionUID = 1L;

	private static final String [] nombres = {"Luna Nueva", "Luna Creciente", "Cuarto Creciente", 
			"Quinto Octante", "Luna Llena", "Tercer Octante", "Cuarto Menguante", "Luna Menguante"};
	private static final List<Luna> lunas = new ArrayList<>();
	private static int lunaActual = 0;
	
	static {
		for (String nombre: nombres)
			lunas.add(new Luna(
					nombre,
					new ImageIcon(Visor.class.getResource("/luna/" + nombre + ".png"))
			));
	}
	
	public Visor() {
		super(lunas.get(lunaActual).getNombre(), lunas.get(lunaActual).getImagen(), JLabel.CENTER);
		setVerticalTextPosition(BOTTOM);
		setHorizontalTextPosition(CENTER);
		setForeground(Color.WHITE);
		setBackground(Color.BLACK);
	}
	
	public void anterior(ActionEvent e) {
		if (--lunaActual < 0)
			lunaActual = lunas.size() - 1;
		setText(lunas.get(lunaActual).getNombre());
		setIcon(lunas.get(lunaActual).getImagen());
	}
	public void siguiente(ActionEvent e) {
		if (++lunaActual == lunas.size())
			lunaActual = 0;
		setText(lunas.get(lunaActual).getNombre());
		setIcon(lunas.get(lunaActual).getImagen());
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

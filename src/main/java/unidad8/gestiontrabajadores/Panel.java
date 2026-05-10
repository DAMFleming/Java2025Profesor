package unidad8.gestiontrabajadores;

import javax.swing.JPanel;
import javax.swing.JToolBar;

public abstract class Panel extends JPanel {

	private static final long serialVersionUID = 1L;
	protected Main main;
	
	public Panel(Main main) {
		this.main = main;
	}

	public abstract void setEnabled(boolean enabled);
	public abstract void setSelected();
	public abstract void limpiar();
	public abstract JToolBar getToolBar();
	
	
}

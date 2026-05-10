package unidad8.gestiontrabajadores;

import java.awt.BorderLayout;
import java.beans.PropertyVetoException;

import javax.swing.JInternalFrame;

public class FormularioMDI extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private Panel panel;

	public FormularioMDI(String titulo, Panel panel) throws PropertyVetoException {
		super(titulo, false, false, true, false);
		this.panel = panel;
		add(panel, BorderLayout.CENTER);
		add(panel.getToolBar(), BorderLayout.SOUTH);
		setDefaultCloseOperation(JInternalFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setMaximizable(false);
		setIconifiable(false);
		pack();
	}
	
	public void setEnabled(boolean enabled) {
		panel.setEnabled(enabled);
	}
	
	public void limipiar() {
		panel.limpiar();
	}
	
	@Override
	public void setSelected(boolean selected) {
		try {
			super.setSelected(selected);
		} catch (PropertyVetoException e) {
		}
		panel.setSelected();
	}
	
}

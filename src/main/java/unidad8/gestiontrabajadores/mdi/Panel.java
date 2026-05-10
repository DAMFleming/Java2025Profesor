package unidad8.gestiontrabajadores.mdi;

import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

public abstract class Panel extends JPanel implements InternalFrameListener {

	private static final long serialVersionUID = 1L;
	protected Main main;
	
	public Panel(Main main) {
		this.main = main;
	}

	public abstract void setEnabled(boolean enabled);
	public abstract void setSelected();
	public abstract JToolBar getToolBar();
	

	@Override
	public void internalFrameOpened(InternalFrameEvent e) {
	}

	@Override
	public void internalFrameClosing(InternalFrameEvent e) {		
	}

	@Override
	public void internalFrameClosed(InternalFrameEvent e) {		
	}

	@Override
	public void internalFrameIconified(InternalFrameEvent e) {		
	}

	@Override
	public void internalFrameDeiconified(InternalFrameEvent e) {		
	}

	@Override
	public void internalFrameActivated(InternalFrameEvent e) {
	}

	@Override
	public void internalFrameDeactivated(InternalFrameEvent e) {
	}
	
}

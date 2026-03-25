package unidad9.swing.multicontador;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

public class ContadorParcial extends Contador{

	private static final long serialVersionUID = 1L;
	
	private JButton buttonInc = new JButton("+");
	private ContadorGlobal cg;
	
	public ContadorParcial(ContadorGlobal cg) {
		this.cg = cg;
		buttonInc.addActionListener(this::inc);
		add(buttonInc);
	}
	
	private void inc(ActionEvent e) {
		inc();
		cg.inc();
	}
	
	@Override
	public void reset() {
		cg.dec(getValor());
		super.reset();
	}
	
}

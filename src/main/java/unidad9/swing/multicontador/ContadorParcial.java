package unidad9.swing.multicontador;

import javax.swing.JButton;

public class ContadorParcial extends Contador{

	private static final long serialVersionUID = 1L;
	
	private JButton buttonInc = new JButton("+");
	private ContadorGlobal cg;
	
	public ContadorParcial(ContadorGlobal cg) {
		this.cg = cg;
		add(buttonInc);
	}
	
}

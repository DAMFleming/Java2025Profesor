package unidad9.swing.multicontador;

import java.util.ArrayList;
import java.util.List;

public class ContadorGlobal extends Contador {

	private static final long serialVersionUID = 1L;
	
	private List<ContadorParcial> parciales = new ArrayList<>();
	
	public ContadorGlobal() {
		
	}
	
	public void addContadorParcial(ContadorParcial c) {
		parciales.add(c);
	}
	
	@Override
	public void reset() {
		super.reset();
		parciales.forEach(Contador::reset);
	}
	
}

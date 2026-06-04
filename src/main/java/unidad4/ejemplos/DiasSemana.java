package unidad4.ejemplos;

public enum DiasSemana {
	
	lUNES(4), MARTES(3.1f), MIERCOLES(7), JUEVES(.45f), VIERNES(12.33f), SABADO(4), DOMINGO(10);
	
	private float valor;
	
	DiasSemana(float valor) {
		this.valor = valor;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	
	@Override 
	public String toString() {
		return super.toString() + valor;
	}
	
}

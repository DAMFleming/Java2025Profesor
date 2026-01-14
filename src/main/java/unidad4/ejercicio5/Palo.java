package unidad4.ejercicio5;

public enum Palo {
	PICAS('♠'), CORAZONES('♥'), TREBOLES('♣'), DIAMANTES('♦');
	
	public char simbolo;
	
	Palo(char simbolo) {
		this.simbolo = simbolo;
	}

	public char getSimbolo() {
		return simbolo;
	}

}

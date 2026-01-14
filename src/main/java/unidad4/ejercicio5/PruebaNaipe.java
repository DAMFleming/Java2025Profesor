package unidad4.ejercicio5;

public class PruebaNaipe {

	public static void main(String[] args) {
		Naipe naipe1 = new Naipe(Palo.CORAZONES, "K", 0);
		Naipe naipe2 = new Naipe(Palo.TREBOLES, "K", 0);
		System.out.println(naipe1);
		System.out.println(naipe1.getPalo().ordinal());
		System.out.println(naipe2);
		if (naipe1.getPalo() == naipe2.getPalo())
			System.out.println("son del mismo palo");
		else
			System.out.println("no son del mismo palo");
		
		Palo [] palos = Palo.values();
		System.out.println(palos[0]);
		System.out.println(Palo.PICAS);
		System.out.println(Palo.TREBOLES.simbolo);
	}

}

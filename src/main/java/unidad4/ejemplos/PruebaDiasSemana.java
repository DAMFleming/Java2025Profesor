package unidad4.ejemplos;
import static unidad4.ejemplos.DiasSemana.*;

public class PruebaDiasSemana {

	public static boolean tengoQueMadrugar(DiasSemana dia) {
		if (dia == DOMINGO)
			return false;
		else
			return true;
	}
	
	public static void main(String[] args) {
		DiasSemana d;
		d = DOMINGO;
		IO.println("Tengo que madrugar: " + (tengoQueMadrugar(d) ? "si" : "no"));
		IO.println(DiasSemana.values()[5]);
		IO.println(SABADO.ordinal());
	}

}

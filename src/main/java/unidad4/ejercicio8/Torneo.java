package unidad4.ejercicio8;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
Ash Charizard fuego 100
Brock Squirtle agua 38
Ash Pikachu electricidad 10
torneo
fuego
electricidad
fin
*/

/*
Misty Blastoise agua 18
Clemont Pikachu electricidad 22
Millo Kadabra psíquico 90
torneo
fuego
electricidad
fuego
fin
*/

public class Torneo {

	public static void main(String[] args) {
		List<Entrenador> entrenadores = leerDatosParticipantes();
		realizarTorneo(entrenadores);
		mostrarResultados(entrenadores);
	}
	
	static List<Entrenador> leerDatosParticipantes() {
		List<Entrenador> entrenadores = new ArrayList<>();
		String linea;
		while (!(linea = IO.readln()).equalsIgnoreCase("torneo")) {
			String [] datos = linea.split(" ");
			Entrenador entrenador = null;
			for (Entrenador e: entrenadores) {
				if (e.getNombre().equals(datos[0])) {
					entrenador = e;
					break;
				}
			}
			if (entrenador == null) {
				entrenador = new Entrenador(datos[0]);
				entrenadores.add(entrenador);
			}
			entrenador.addPokemon(datos[1], datos[2], Integer.parseInt(datos[3]));
		}
		return entrenadores;
	}
	
	static void realizarTorneo(List<Entrenador> entrenadores) {
		String elemento;
		while (!(elemento = IO.readln()).equalsIgnoreCase("fin")) {
			for(Entrenador e: entrenadores)
				e.combatir(elemento);
		}
	}
	
	static void mostrarResultados(List<Entrenador> entrenadores) {
		entrenadores.forEach(e -> System.out.println(e));
	}
	
}

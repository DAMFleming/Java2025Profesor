package unidad4.ejercicio8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Entrenador {
	
	private String nombre;
	private int insignias; 
	private ArrayList<Pokemon> pokemons = new ArrayList<>();
	
	public Entrenador(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return nombre + " " + insignias + " " + pokemons.size();
	}

	@Override
	public int hashCode() {
		return Objects.hash(insignias, nombre, pokemons);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entrenador other = (Entrenador) obj;
		return insignias == other.insignias && Objects.equals(nombre, other.nombre)
				&& Objects.equals(pokemons, other.pokemons);
	}

	public String getNombre() {
		return nombre;
	}

	public int getInsignias() {
		return insignias;
	}

	public List<Pokemon> getPokemons() {
		return Collections.unmodifiableList(pokemons);
	}
	
	public int getNumPokemos() {
		return pokemons.size();
	}
	
	public void addPokemon(String nombre, String elemento, int puntos) {
		pokemons.add(new Pokemon(nombre, elemento, puntos));
	}
	
	public void addPokemon(Pokemon pokemon) {
		pokemons.add(pokemon);
	}
	
	public void combatir(String elemento) {
		boolean premio = false;
		for (Pokemon p: pokemons) {
			if (p.getElemento().equals(elemento)) {
				premio = true;
				break;
			}
		}
		if (premio)
			insignias++;
		else {
			Iterator<Pokemon> i = pokemons.iterator();
			while (i.hasNext()) {
				Pokemon p = i.next();
				if (p.restarSalud() <= 0)
					i.remove();
			}
		}
	}
}

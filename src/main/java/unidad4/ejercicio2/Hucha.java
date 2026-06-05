package unidad4.ejercicio2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Hucha {

	private String password;
	private boolean abierta;
	private Map<Integer, Item> monedas = Map.of(1, new Item(Item.Tipo.MONEDA), 2, new Item(Item.Tipo.MONEDA), 5,
			new Item(Item.Tipo.BILLETE), 10, new Item(Item.Tipo.BILLETE), 20, new Item(Item.Tipo.BILLETE), 50,
			new Item(Item.Tipo.BILLETE));

	private static class Item {
		enum Tipo {
			MONEDA, BILLETE
		}

		Tipo tipo;
		int cantidad;

		Item(Tipo tipo) {
			this.tipo = tipo;
		}
	}

	public Hucha(String password) {
		this.password = password;
	}

	public Hucha(String password, int uno, int dos, int cinco, int diez, int veinte, int cincuenta) {
		this.password = password;
		monedas.get(1).cantidad = uno;
		monedas.get(2).cantidad = dos;
		monedas.get(5).cantidad = cinco;
		monedas.get(10).cantidad = diez;
		monedas.get(20).cantidad = veinte;
		monedas.get(50).cantidad = cincuenta;
	}

	public Hucha(String password, int valor) {
		this.password = password;

		Set<Integer> s = monedas.keySet();
		List<Integer> l = new ArrayList<Integer>(s);
		Collections.sort(l, Collections.reverseOrder());
		for (Integer key : l) {
			monedas.get(key).cantidad = valor / key;
			valor %= key;
		}
	}
	
	

}

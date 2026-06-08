package unidad4.ejercicio2;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

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

//		Set<Integer> s = monedas.keySet();
//		List<Integer> l = new ArrayList<Integer>(s);
		List<Integer> l = monedas.keySet().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		for (Integer key : l) {
			monedas.get(key).cantidad = valor / key;
			valor %= key;
		}
	}
	
	public boolean abrir(String password) {
		return abierta = this.password.equals(password);
	}
	
	public boolean cerrar(String password) {
		if (abierta && this.password.equals(password)) {
			abierta = false;
			return true;
		}
		return false;
	}
	
	public int getTotal() {
		int total = 0;
		for (Entry<Integer, Item> entry: monedas.entrySet())
			total += entry.getKey() * entry.getValue().cantidad;
		return total;
	}
	
	public List<Integer> getCantidadDeMonedas() {
		return monedas.entrySet().stream()
				.sorted(Comparator.comparingInt(Entry::getKey))
				.map(entry -> entry.getValue().cantidad)
				.toList();
	}
	
//	public int getCantidadDeMonedas(int tipo) {
//		if (tipo != 1 && tipo != 2 && tipo != 5 && tipo != 10 && tipo != 20 && tipo != 50)
//			throw new IllegalArgumentException("no existen monedas de " + tipo + " euros");
//		return monedas.get(tipo).cantidad;
//	}
	
	public Integer getCantidadDeMonedas(int tipo) {
		return  monedas.get(tipo) == null ? null : monedas.get(tipo).cantidad;
//		if (monedas.get(tipo) == null)
//			return null;
//		else
//			return monedas.get(tipo).cantidad;
	}
	
	public Integer retirar(int tipo, int cantidad) {
		Item i = monedas.get(tipo);
		if (i == null)
			return null;
		if (i.cantidad >= cantidad) {
			i.cantidad -= cantidad;
			return cantidad;
		} else {
			int c = i.cantidad;
			i.cantidad = 0;
			return c;
		}
	}
	
	public int retirar(int total) {
		int totalRetirado = 0;
//		Set<Integer> s = monedas.keySet();
//		List<Integer> l = new ArrayList<Integer>(s);
		List<Integer> l = monedas.keySet().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		for (Integer tipo: l) {
			int cantidad = total / tipo;
			Item i = monedas.get(tipo);
			if (cantidad >= i.cantidad) {
				i.cantidad -= cantidad;
				int euros = cantidad * tipo;
				totalRetirado += euros;
				total -= euros;
			}
			else {
				int euros = i.cantidad * tipo;
				totalRetirado += euros;
				total -= euros;
				i.cantidad = 0;
			}	
		}
		return totalRetirado;
	}
	
	public static void main(String[] args) {
		Hucha hucha = new Hucha("", 377);
		System.out.println(hucha.getTotal());
		System.out.println(hucha.getCantidadDeMonedas(50));
		System.out.println(hucha.getCantidadDeMonedas());
	}

}

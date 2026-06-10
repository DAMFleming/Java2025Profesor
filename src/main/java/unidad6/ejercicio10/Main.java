package unidad6.ejercicio10;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		Queue<String> linea = new LinkedList<>();
		List<Robot> robots = new ArrayList<>();
		String s = IO.readln();
		for (String r: s.split(";")) {
			String[] datosRobot = r.split("-");
			Robot robot = new Robot(datosRobot[0], Integer.parseInt(datosRobot[1]));
			robots.add(robot);
		}
		s = IO.readln();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("H:mm:ss");
		LocalTime time = LocalTime.parse(s, dtf);
		while (!(s = IO.readln().trim()).equalsIgnoreCase("fin")) {
			linea.offer(s);
		}
		while (!linea.isEmpty()) {
			time = time.plusSeconds(1);
			boolean retirado = false;
			for (Robot r: robots) {
				if (r.estaOcupado())
					r.procesarDuranteUnSegundo();
				else if (!retirado) {
						r.recogerProducto(linea.poll());
						IO.println(r.getNombre() + " - " + r.getProducto() + " [" + time.format(dtf) + "]");
						retirado = true;
				}
			}
			if (!retirado)
				linea.offer(linea.poll());
		}
	}
	
}

/*
ROB-15;SS2-10;NX8000-3
8:00:00
disco duro
procesador
memoria RAM
placa base
fin
*/

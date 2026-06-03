package unidad3.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ejercicio11 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] secuencias = new int[n][];
		for (int i = 0; i < n; i++) {
			int m = sc.nextInt();
			secuencias[i] = new int[m];
			for (int j = 0; j < m; j++) {
				secuencias[i][j] = sc.nextInt();
			}
		}
	}

}

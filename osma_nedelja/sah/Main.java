package sah;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		char[][] beli = kreiranjeTable("C:\\Users\\Dusan\\Desktop\\beli.txt");
		char[][] crni = kreiranjeTable("C:\\Users\\Dusan\\Desktop\\crni.txt");
		char[] horizontala = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H' };
		int[] vertikala = { 8, 7, 6, 5, 4, 3, 2, 1 };

		int[][] pozicije = { { -1, -2 }, { -2, -1 }, { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 } };

		for (int i = 0; i < beli.length; i++) {
			for (int j = 0; j < beli[i].length; j++) {
				if (beli[i][j] == 'S') {
					System.out.print("S (" + horizontala[j] + vertikala[i] + ") : ");
					for (int k = 0; k < pozicije.length; k++) {
						if (proveraSkoka(i, j, pozicije[k][0], pozicije[k][1], crni)) {

							if (crni[i + pozicije[k][0]][j + pozicije[k][1]] != 'O') {

								System.out.print(" " + crni[i + pozicije[k][0]][j + pozicije[k][1]] + "("
										+ horizontala[j + pozicije[k][1]] + vertikala[i + pozicije[k][0]] + ")");
							}

						}

					}
					System.out.println();
				}

			}
		}

	}

	public static void print(char[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}

	public static char[][] kreiranjeTable(String putanja) {
		char tabla[][] = new char[8][8];
		try (BufferedReader r = new BufferedReader(new FileReader(putanja))) {
			for (int i = 0; i < tabla.length; i++) {
				String line = r.readLine();
				for (int j = 0; j < tabla[i].length; j++) {
					tabla[i][j] = line.charAt(j);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tabla;
	}

	public static boolean proveraSkoka(int x, int y, int i, int j, char[][] tabla) {
		if (x + (i) >= 0 && y + (j) >= 0 && x + (i) < tabla.length && y + (j) < tabla.length)
			return true;
		else
			return false;
	}

}

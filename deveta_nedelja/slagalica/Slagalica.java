package slagalica;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Timer;

public class Slagalica {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		String azbuka = "АБВГДЂЕЖЗИЈКЛЉМНЊОПРСТЋУФХЦЧЏШ";

		char[] izvucena = new char[12];
		for (int i = 0; i < 12; i++) {
			izvucena[i] = azbuka.charAt((int) (Math.random() * 30));
			System.out.print(izvucena[i] + " ");
		}

		System.out.println("\n------------------------------------");
		long pocetnoVreme = System.currentTimeMillis();
		long limit = 60000L;
		boolean flag = true;
		System.out.println("Unesite slova:");
		SPOLJASNJI: while ((System.currentTimeMillis() - pocetnoVreme) < limit) {
			String rec = sc.nextLine();

			rec = rec.toUpperCase();

			if ((System.currentTimeMillis() - pocetnoVreme) > limit)
				break SPOLJASNJI;
			if (provera(rec, izvucena)) {
				try (BufferedReader bf = new BufferedReader(new FileReader("recnik.txt"))) {

					String line = bf.readLine();

					while (line != null) {

						if (line.toLowerCase().equals(rec.toLowerCase())) {
							System.out.println(rec.toUpperCase());
							System.out.println("Osvojili ste " + (rec.length() * 2) + " poena");
							flag = false;
							break SPOLJASNJI;
						}
						line = bf.readLine();
					}
					System.out.println("rec ne postoji, unesite opet");
				} catch (FileNotFoundException e) {

					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

			} else
				System.out.println("Користили сте недозовољена слова! Пробајте опет");

		}
		if (flag)
			System.out.println("Нажалост, време је истекло!");

		sc.close();
	}

	// provera da li se slova nalaze u poneudjenim
	public static boolean provera(String s, char[] niz) {
		char[] rec = s.toCharArray();
		int brojac = 0;
		int pozicija = 0;
		char trenutni;

		for (int i = 0; i < rec.length; i++) {
			char temp = rec[i];
			for (int j = 0 + pozicija; j < niz.length; j++) {
				if (temp == niz[j]) {
					brojac++;

					trenutni = niz[pozicija];
					niz[pozicija] = niz[j];
					niz[j] = trenutni;
					pozicija++;
					break;
				}

			}

		}
		if (brojac != rec.length)
			return false;
		return true;
	}
}

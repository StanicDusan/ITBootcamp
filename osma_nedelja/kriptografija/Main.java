package kriptografija;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite duzinu kljuca");
		int duzinaKljuca = sc.nextInt();
		System.out.println("Unesite kljuc - cifre od 1 do " + duzinaKljuca + " nasumicnim redosledom bez ponavljanja");

		String kljuc = sc.next();
		while (kljuc.length() != duzinaKljuca) {
			System.out.println("Uneli ste neodgovarajucu duzinu kljuca, probajte opet\nkljuc:");
			kljuc = sc.next();
		}
		sc.nextLine();
		System.out.println("Unesite tekst za sifrovanje:");
		String text = sc.nextLine();

		System.out.println(citanjeSifre(matrica(duzinaKljuca, kljuc, text)));

		sc.close();
	}

//vraca niz ispunjen tekstom iz stringa
	public static String[][] matrica(int duzinaKljuca, String kljucic, String text) {
		String[] nizKljuc = kljuc(kljucic);
		String[][] enigma = new String[(int) (Math.ceil(text.length() / (double) duzinaKljuca))][duzinaKljuca];
		inicijalizacijaMatrice(enigma);
		int brojac = 0;
		OUTER: for (int i = 0; i < enigma.length; i++) {
			for (int j = 0; j < enigma[i].length; j++) {
				if (brojac == text.length()) break OUTER;
				enigma[i][(Integer.parseInt(nizKljuc[j]) - 1)] = String.valueOf(text.charAt(brojac));
				
				brojac++;
			}
		}
		return enigma;
	}

//kreira niz elemntima iz kljuca
	public static String[] kljuc(String kljucic) {
		String[] kljuc = new String[kljucic.length()];
		for (int i = 0; i < kljucic.length(); i++) {
			kljuc[i] = String.valueOf(kljucic.charAt(i));
		}
		return kljuc;
	}

//stampa dvodimenzionalni niz
	public static void print(String[][] matrica) {
		for (int i = 0; i < matrica.length; i++) {
			for (int j = 0; j < matrica[i].length; j++) {
				System.out.print(matrica[i][j]);
			}
			System.out.println();
		}
	}

//ispunjava dvodimenzionalni niz praznim stringom
	public static String[][] inicijalizacijaMatrice(String[][] matrica) {
		for (int i = 0; i < matrica.length; i++) {
			for (int j = 0; j < matrica[i].length; j++) {
				matrica[i][j] = "";
			}
		}
		return matrica;
	}

//vraca sifrovani string
	public static String citanjeSifre(String[][] matrica) {
		String s = "";
		for (int i = 0; i < matrica[0].length; i++) {
			for (int j = 0; j < matrica.length; j++) {

				s += matrica[j][i];
			}
		}
		return s;
	}

}

package anagam;

import java.util.Scanner;

public class Main {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Unesite velicinu niza, velicina je ista za oba"
				+ " niza\ntako da zajebancije tipa razlicite velicine nizova ne prolaze!!\n"
				+ "Validne vrednosti su izmedju 1 i 100");
		int velicina = sc.nextInt();
		if(velicina>0 && velicina<101) {
			System.out.println("unesite elemente prvog");
			int[] niza = ucitavanje(velicina);
			System.out.println("unesite elemente drugog");
			int[] nizb = ucitavanje(velicina);

			System.out.println(proveraAnagramnosti(niza, nizb));
		}else {
			System.err.println("greska");
		}
	

	}

	public static int[] ucitavanje(int velicina) {
		int[] niz = new int[velicina];
		for (int i = 0; i < velicina; i++) {
			int a = sc.nextInt();
			if (a < 0 || a > 9) {
				System.out.println("Molimo Vas unesite cifru (0-9)");
				i--;
				continue;
			}
			niz[i] = a;
		}
		return niz;
	}

	public static String proveraAnagramnosti(int[] a, int[] b) {
		int[] sudija = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		for (int i = 0; i < a.length; i++) {
			sudija[a[i]]++;
			sudija[b[i]]--;
		}
		for (int i = 0; i < sudija.length; i++) {
			if (sudija[i] != 0) {
				return "nisu anagrami";
			}
		}
		return "jesu anagrami";
	}
}

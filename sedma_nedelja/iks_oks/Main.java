package iks_oks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		try (BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\Dusan\\Desktop\\iksoksr.txt"))) {
			String[] nums = r.readLine().split(" ");
			int N = Integer.parseInt(nums[0]);
			int M = Integer.parseInt(nums[1]);

			char matrix[][] = new char[N][N];

			for (int i = 0; i < matrix.length; i++) {
				String line = r.readLine();
				for (int j = 0; j < matrix[i].length; j++) {
					matrix[i][j] = line.charAt(j);
				}
			}

			print(matrix);

/////provera po redu
			int kolona = N;
			int brPogodaka = M;
			char[][] niz = matrix;
			int offset = kolona - brPogodaka;
			int dOffset = brPogodaka - 1;
			boolean flag = false;
			/////////////////
			if(proveraPoRedu('X', matrix, offset, dOffset, brPogodaka)) {}
			if(proveraPoRedu('O', matrix, offset, dOffset, brPogodaka)){}
				

//////provera po koloni
			if(proveraPoKoloni('X', matrix, offset, dOffset, brPogodaka)) {}
			if(proveraPoKoloni('O', matrix, offset, dOffset, brPogodaka)) {}
			/////////////////////////////

/////Provera dijagonalno opadajuce
			if(proveraDijagonalnoOpadajuce('X', matrix, offset, dOffset, brPogodaka)) {}
			if(proveraDijagonalnoOpadajuce('O', matrix, offset, dOffset, brPogodaka)) {}

/////Provera dijagonalno rastuce
			if(proveraDijagonalnoRastuce('X', matrix, offset, dOffset, brPogodaka, N)){}
			if(proveraDijagonalnoRastuce('O', matrix, offset, dOffset, brPogodaka, N)){}		

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
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
	public static boolean proveraPoRedu(char slovo,char[][] niz,int offset,int dOffset,int brPogodaka) {
		boolean flag=false;
		for (int i = 0; i < niz.length - offset; i++) {
			for (int j = 0; j < niz.length - dOffset; j++) {
				if (niz[i][j] == slovo) {
					flag = true;
					for (int brP = 0; brP < brPogodaka; brP++) {
						if (niz[i][j + brP] != slovo)
							flag = false;
					}
					if (flag) {
						System.out.println("pobednik je "+slovo+" po redu");
						return true;
					}
				}

			}

		}
		return false;
	}
	
	public static boolean proveraPoKoloni(char slovo,char[][] niz,int offset,int dOffset,int brPogodaka) {
		boolean flag=false;
		for (int i = 0; i < niz.length - dOffset; i++) {
			for (int j = 0; j < niz.length; j++) {
				if (niz[i][j] == slovo) {
					flag = true;
					for (int brP = 0; brP < brPogodaka; brP++) {
						if (niz[i + brP][j] != slovo)
							flag = false;
					}
					if (flag) {
						System.out.println("pobednik je "+slovo+" po koloni");
						return true;
					}
				}

			}

		}
		return false;
	}

	public static boolean proveraDijagonalnoOpadajuce(char slovo,char[][] niz,int offset,int dOffset,int brPogodaka) {
		boolean flag=false;
		for (int i = 0; i < niz.length - dOffset; i++) {
			for (int j = 0; j < niz.length - dOffset; j++) {
				if (niz[i][j] == slovo) {
					flag = true;
					for (int brP = 0; brP < brPogodaka; brP++) {
						if (niz[i + brP][j + brP] != slovo)
							flag = false;
					}
					if (flag) {
						System.out.println("pobednik je "+slovo+" dijagonalno opadajuce");
						return true;
					}
				}

			}

		}return false;
	}
	
	public static boolean proveraDijagonalnoRastuce(char slovo,char[][] niz,int offset,int dOffset,int brPogodaka,int brojKolona) {
		boolean flag=false;
		for (int i = brojKolona - 1; i > niz.length - dOffset; i--) {
			for (int j = 0; j < niz.length - dOffset; j++) {
				if (niz[i][j] == slovo) {
					flag = true;
					for (int brP = 0; brP < brPogodaka; brP++) {
						if (niz[i - brP][j + brP] != slovo)
							flag = false;
					}
					if (flag) {
						System.out.println("pobednik je "+slovo+" dijagonalno rastuce");
						return true;
					}
				}

			}

		}
		return false;
	}
	
}

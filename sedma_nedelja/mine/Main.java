package mine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		//citajFajl("C:\\Users\\Dusan\\Desktop\\mina.txt");
		int[][] ar = konvert(citajFajl("C:\\Users\\Dusan\\Desktop\\mina.txt"));
		upisUFajl(bomba(ar));

	}
//cita fjal i vraca niz
	public static int[][] citajFajl(String putanjaDoFajla) {
		try (BufferedReader r = new BufferedReader(new FileReader(putanjaDoFajla))) {
			String[] nums = r.readLine().split(" ");
			int N = Integer.parseInt(nums[0]);
			int M = Integer.parseInt(nums[1]);

			int mine[][] = new int[N][N];

			for (int i = 0; i < mine.length; i++) {
				String line = r.readLine();
				for (int j = 0; j < mine[i].length; j++) {
					mine[i][j] = Character.getNumericValue(line.charAt(j));
				}
			}
		return mine;

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
//stampa niz
	public static void print(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}
	
//pretvara vrednost polja mine iz 0 u -1 	
	public static int[][] konvert(int[][] niz) {
		int[][] nizKonvertovan = new int[niz.length][niz.length];
		for (int i = 0; i < niz.length; i++) {
			for (int j = 0; j < niz[i].length; j++) {
				if (niz[i][j] == 1) {
					nizKonvertovan[i][j] = -1;
				} else
					nizKonvertovan[i][j] = niz[i][j];
			}
		}
		return nizKonvertovan;
	}

//proverava da li je indeks niza izvan opsega 
	public static boolean proveraOpsega(int i, int j, int[][] niz) {
		if (i < 0 || j < 0 || i > niz.length - 1 || j > niz.length - 1)
			return false;
		return true;
	}
//metod koji nije trazen postavlja na mesto mine broj 9
	public static int[][] bombaSmrt(int[][] niz) {
		int[][] nizB = new int[niz.length][niz.length];
		for (int i = 0; i < niz.length; i++) {
			for (int j = 0; j < niz[i].length; j++) {
				if (niz[i][j] == -1) {
					nizB[i][j] =9;
					if (proveraOpsega(i - 1, j - 1, niz) && niz[i - 1][j - 1] != -1)
						nizB[i - 1][j - 1]++;
					if (proveraOpsega(i - 1, j, niz) && niz[i - 1][j] != -1)
						nizB[i - 1][j]++;
					if (proveraOpsega(i - 1, j + 1, niz) && niz[i - 1][j + 1] != -1)
						nizB[i - 1][j + 1]++;
					if (proveraOpsega(i, j - 1, niz) && niz[i][j - 1] != -1)
						nizB[i][j - 1]++;
					if (proveraOpsega(i, j + 1, niz) && niz[i][j + 1] != -1)
						nizB[i][j + 1]++;
					if (proveraOpsega(i + 1, j - 1, niz) && niz[i + 1][j - 1] != -1)
						nizB[i + 1][j - 1]++;
					if (proveraOpsega(i + 1, j, niz) && niz[i + 1][j] != -1)
						nizB[i + 1][j]++;
					if (proveraOpsega(i + 1, j + 1, niz) && niz[i + 1][j + 1] != -1)
						nizB[i + 1][j + 1]++;
				}

			}

		}
		return nizB;
	}
//uvecava vrednost polja za svaku minu sa kojom se granici
	public static int[][] bomba(int[][] niz) {
		int[][] nizB = new int[niz.length][niz.length];
		for (int i = 0; i < niz.length; i++) {
			for (int j = 0; j < niz[i].length; j++) {
				if (niz[i][j] == -1) {
					
					if (proveraOpsega(i - 1, j - 1, niz) )
						nizB[i - 1][j - 1]++;
					if (proveraOpsega(i - 1, j, niz))
						nizB[i - 1][j]++;
					if (proveraOpsega(i - 1, j + 1, niz))
						nizB[i - 1][j + 1]++;
					if (proveraOpsega(i, j - 1, niz))
						nizB[i][j - 1]++;
					if (proveraOpsega(i, j + 1, niz))
						nizB[i][j + 1]++;
					if (proveraOpsega(i + 1, j - 1, niz))
						nizB[i + 1][j - 1]++;
					if (proveraOpsega(i + 1, j, niz))
						nizB[i + 1][j]++;
					if (proveraOpsega(i + 1, j + 1, niz))
						nizB[i + 1][j + 1]++;
				}

			}

		}
		return nizB;
	}
	

	public static void upisUFajl(int [][] niz) {
		try(FileWriter fw = new FileWriter("C:\\Users\\Dusan\\Desktop\\bomba.txt")){
			fw.write("rezultat:"); 
			fw.write('\n');
			for(int i=0;i<niz.length;i++) {
				for(int j=0;j<niz[i].length;j++) {
					String c=""+niz[i][j];
					fw.write(c );
				}
				fw.write('\n');
			}
			} catch(IOException e) {
			e.printStackTrace();
			}
	}
}

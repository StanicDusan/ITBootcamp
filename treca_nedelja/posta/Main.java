package posta;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Salter pis = new Salter(10);
		
		int brojac=0;
		System.out.println("Dobrodosli u pametni sistem poste\n----------------------------------");
		
		String index = "pocetak";
		while(!(index.equals("kraj"))) {
			
			for(int i =0;i<pis.pisma.length;i++) {
				System.out.println("Unesite ime posiljaoca, ime primaoca,\n"+ 
			                       "postanski broj, tezinu i prioritet");
				String imePosiljaoca = sc.next();
				//System.out.println("Unesite ime primaoca");
				String imePrimaoca = sc.next();
			//	System.out.println("Unesite ime postanski broj");
				int postanskiBroj = sc.nextInt();
			//	System.out.println("Unesite tezinu");
				double tezina = sc.nextDouble();
			//	System.out.println("Unesite prioritet");
				int prioritet = sc.nextInt();
				
				pis.pisma[i]= new Pisma(imePosiljaoca,imePrimaoca,postanskiBroj,tezina,prioritet);
				brojac++;
				
				System.out.println("unesi -1 za kraj ili bilo koji broj drugi broj za nasatavak");
				int ender = sc.nextInt();
				sc.nextLine();
				if(ender==-1) {
					index="kraj";
					break;
				}
			}
		
			
		}
		System.out.println("Pisma uspesno ucitana");
		String str ="----------------------------\nUpisiste postanski broj grada ";
		System.out.println(str);
		int trazeniPAK=sc.nextInt();
		do {
			
		
		
		
		for(int i =0; i<brojac;i++)
			if(pis.pisma[i].getPostanskiBroj()==trazeniPAK) {
		System.out.println(pis.pisma[i].toString());
			}
		System.out.println(str+" ili -1 za izlaz");
		 trazeniPAK=sc.nextInt();
		}while(trazeniPAK !=-1);

	}

}

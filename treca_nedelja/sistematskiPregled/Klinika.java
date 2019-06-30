package sistematskiPregled;


	import java.util.Arrays;
	import java.util.Scanner;

	public class Klinika {


		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Dobrodosli na sistematski pregled\n--------------------------------");
	         System.out.println("Unesite broj pacijenata");
			 int a = sc.nextInt();
			
			Persona[] nizOsoba = new Persona[a];
			
			BMI neuhranjen= new BMI(1.2,22);
			BMI normalan= new BMI(1.9, 76);
			BMI prekomeran= new BMI(1.9, 96);
			BMI gojazan= new BMI(1.9, 136);

			int[] bminiz = { 0, 0, 0, 0 };
			int n=0;
			int im=0;
			int p =0;
			int g =0;

			for (int i = 0; i < a; i++) {
				System.out.println("Unesite ime, prezima, visinu u tezinu");
				String ime = sc.next();
				String prezime = sc.next();
				double visina = sc.nextDouble();
				double tezina = sc.nextDouble();

				Persona osoba = new Persona(ime, prezime, visina, tezina);
				nizOsoba[i] = osoba;
				//System.out.println(osoba.indexBmi(visina, tezina));
				double idexBmiOsobe = osoba.indexBmi(visina, tezina);
				if (idexBmiOsobe < 18.5) {
					n++;
					bminiz[0] = n;
					neuhranjen= new BMI(visina,tezina);
				}else if (idexBmiOsobe>=18.5 && idexBmiOsobe<=24.9) {
					im++;
					bminiz[1] = im;
					normalan= new BMI(visina,tezina);
				}else if(idexBmiOsobe>=25 && idexBmiOsobe<=29.9) {
					p++;
					bminiz[2] = p;
					prekomeran= new BMI(visina,tezina);
				}else {
					g++;
					bminiz[3] = g;
					gojazan= new BMI(visina,tezina);
				}
			
			}
				System.out.println("-------------------------------");	
			System.out.println("Osobe uspesno ucitane\n------------------------------------");
			for(int i =0;i<a;i++) {
				
				if(nizOsoba[i].indexBmi(nizOsoba[i].getVisina(), nizOsoba[i].getTezina())<18.5 ) {
					System.out.println(nizOsoba[i].toString()+ neuhranjen.kategorija); 
				}else if(nizOsoba[i].indexBmi(nizOsoba[i].getVisina(), nizOsoba[i].getTezina())>=18.5 &&
						nizOsoba[i].indexBmi(nizOsoba[i].getVisina(), nizOsoba[i].getTezina())<=24.9) {
					System.out.println(nizOsoba[i].toString()+ normalan.kategorija);
				}else if(nizOsoba[i].indexBmi(nizOsoba[i].getVisina(), nizOsoba[i].getTezina())>=25 &&
						nizOsoba[i].indexBmi(nizOsoba[i].getVisina(), nizOsoba[i].getTezina())<=29.9) {
					System.out.println(nizOsoba[i].toString()+ prekomeran.kategorija);
				}else {
					System.out.println(nizOsoba[i].toString()+ gojazan.kategorija);
				}
						
				
			}
			System.out.println("------------------------------------");
			
			
			System.out.println("\n-----Histogram-----");
			
			int [] niz = bminiz;
			int max=0;
			for(int i =0; i<4;i++) {
				if(max<bminiz[i]) max =bminiz[i];
			}
			
			boolean a0=false;
			boolean a1 =false;
			boolean a2=false;
			boolean a3 =false;
			for (int i =max; i>=0;i--) {
			
				
				if(niz[0]==i+1)a0=true;
				if(niz[1]==i+1)a1=true;
				if(niz[2]==i+1)a2=true;
				if(niz[3]==i+1)a3=true;
				
				System.out.print(i+1);
				if(a0)System.out.print(" *");
				else System.out.print("  ");
				if(a1)System.out.print(" * ");
				else System.out.print("  ");
				if(a2)System.out.print(" *");
				else System.out.print("  ");
				if(a3)System.out.print(" *");
				else System.out.print("  ");
				
				System.out.println("");
				
			}
			System.out.println("  N IM P G");
		
		}
	}

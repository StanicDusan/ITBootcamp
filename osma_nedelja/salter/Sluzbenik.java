package salter;

public class Sluzbenik extends Radnik{

	private char salter;
	
	public Sluzbenik(char salter) {
		this.vrsta='S';
		this.salter=salter;
	}	
		
		public void obradiKlijenta(Lista[] l,int i) {
			if(!l[i].isEmpty()) {
				this.k=l[i].obrisiPrvog();
				System.out.println(super.toString() +" Uspesno obradjen klijent");
			}else System.out.println("greska");
	}
}

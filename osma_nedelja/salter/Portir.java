package salter;

public class Portir extends Radnik{

	public Portir() {
		this.vrsta='P';
	}
	
	public void uRedi(Lista l) {
		Klijent kl = new Klijent();
	    this.k=kl;
		l.insert(kl);
		
		System.out.println(super.toString() +" Klijent prosledjen u pocetni red");
	}
	
	
}

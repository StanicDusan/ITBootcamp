package salter;

public class Razvodnik extends Radnik{
	
	public Razvodnik() {
		this.vrsta='R';
	}
	
	public void proslediNaSalter( Lista[] salteri,Lista l) {

		if(!l.isEmpty()) {
			Klijent kl=l.GetKlijent();
			l.obrisiPrvog();
			char u=kl.getUsluga();
			int x=-1;
			switch(u) {
			case 'a': x=0;break;
			case 'b': x=1;break;
			case 'c': x=2;break;
			}
			salteri[x].insert(kl);
			this.k=kl;
			System.out.println(super.toString()+ " Uspesno dodat u salter " + u);
		}
		else System.out.println("Greska");
		
	}
	
	public void redZaSalter(Lista l,Klijent k) {
		l.insert(k);
		
	}


}

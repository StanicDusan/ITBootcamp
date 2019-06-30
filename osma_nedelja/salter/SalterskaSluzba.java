package salter;

public class SalterskaSluzba {
	private Lista ulaznaLista;
	private Lista[] salteri;
	private Portir portir;
	private Razvodnik razvodnik;
	private Sluzbenik [] sluzbenici;
	
	public SalterskaSluzba() {
		ulaznaLista=new Lista();
		Lista redA=new Lista();
		Lista redB=new Lista();
		Lista redC=new Lista();
		salteri=new Lista[3];
		salteri[0]=redA;
		salteri[1]=redB;
		salteri[2]=redC;
		portir=new Portir();
		razvodnik=new Razvodnik();
		sluzbenici= new Sluzbenik[3];
		sluzbenici[0]=new Sluzbenik('A');
		sluzbenici[1]=new Sluzbenik('B');
		sluzbenici[2]=new Sluzbenik('C');
		
	}

	public Lista getUlaznaLista() {
		return ulaznaLista;
	}

	public Lista[] getSalteri() {
		return salteri;
	}

	public Portir getPortir() {
		return portir;
	}

	public Razvodnik getRazvodnik() {
		return razvodnik;
	}

	public Sluzbenik[] getSluzbenici() {
		return sluzbenici;
	}
	
	
	
}

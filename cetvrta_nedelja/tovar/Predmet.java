package tovar;

public class Predmet extends Tovar {
	
	private String vrsta;
	private double tezina;
	
	public Predmet(String vrsta, double tezina) {
		super();
		this.vrsta = vrsta;
		this.tezina = tezina;
	}

	@Override
	public String getVrsta() {
		
		return this.vrsta;
	}

	@Override
	public double getTezina() {
		return this.tezina;
	}
	
	public String toString() {
		String s="";
		s+= getVrsta() +"("+ getTezina()+")";
		return s;
	}
	
	

}

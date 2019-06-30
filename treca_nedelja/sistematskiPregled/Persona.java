package sistematskiPregled;

public class Persona {

	private String ime;
	private double visina;
	private double tezina;

	public Persona(String ime, String prezime, double visina, double tezina) {
		this.ime = ime + " " + prezime;
		this.visina = visina;
		this.tezina = tezina;
	}

	public String getIme() {
		return ime;
	}

	public double getVisina() {
		return visina;
	}

	public double getTezina() {
		return tezina;
	}

	public String toString() {
		String str;
		str = getIme();
		str += " ( " + getVisina() + "m, " + getTezina() + "kg) : ";
		return str;
	}
	
	public double indexBmi(double vis, double tez) {
		vis=getVisina();
	    tez= getTezina();
	    //System.out.println("index je " + (bb/(aa*aa) ));
		return tez/(vis*vis);
	}
}

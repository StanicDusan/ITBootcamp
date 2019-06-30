package energija;

public class Pice extends Namirnica{
	

	private double kolicina;
	private double enVr;
	
	public Pice(String ime,double kolicina,double enVr ) {
		super(ime);
		this.kolicina=kolicina;
		this.enVr=enVr;
		
	}
	
	public double getKolicina() {
		return kolicina;
	}

	@Override
	public double energVr() {
		return this.kolicina*this.enVr;
		 
	}
	
	public String toString() {
		return super.toString()+"(" + this.kolicina + "l, " + this.enVr +"Kj)";
	}

}

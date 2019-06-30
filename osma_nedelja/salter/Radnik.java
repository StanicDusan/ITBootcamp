package salter;

public abstract class Radnik extends Osoba {
	
	protected Klijent k;
	

	public String toString() {
		return super.toString() + "[" +this.k+"]";
	}

}

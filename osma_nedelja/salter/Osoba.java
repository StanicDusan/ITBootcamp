package salter;

public abstract class Osoba {
	public static int globalId;
	public char vrsta;
	public int id;
	
	public Osoba() {
		super();
		this.id=++globalId;
		
	}
	
public String toString() {
	return this.vrsta + ":" + this.id;
}

}

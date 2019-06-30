package energija;

public abstract class Namirnica extends Energent {
	
	private String ime;
	public static int globaId=0;
	private int id;

	public Namirnica(String ime) {
		this.ime=ime;
		this.id=++globaId;
	}

	public String getIme() {
		return ime;
	}

	public int getId() {
		return id;
	}

	public String toString() {
		return "[" +this.id + "] " + this.ime;
	}
	
}

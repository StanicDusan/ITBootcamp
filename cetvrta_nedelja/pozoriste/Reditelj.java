package pozoriste;

public class Reditelj extends Zaposleni {
	
	
	
	public Reditelj(String ime, Pozoriste pozoriste) {
		super(ime, pozoriste);
		
	}

	public String imePosla() {
		return this.getClass().getSimpleName();
	}
	
	

}

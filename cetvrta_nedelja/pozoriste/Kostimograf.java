package pozoriste;

public class Kostimograf extends Zaposleni {

	public Kostimograf(String ime, Pozoriste pozoriste) {
		super(ime, pozoriste);
		
	}

	public String imePosla() {
		return this.getClass().getSimpleName();
	}

}

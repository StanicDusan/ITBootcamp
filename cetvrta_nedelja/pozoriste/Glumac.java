package pozoriste;

public class Glumac extends Zaposleni {

	public Glumac(String ime, Pozoriste pozoriste) {
		super(ime, pozoriste);
		
	}

	public String imePosla() {
		return this.getClass().getSimpleName();
	}
}

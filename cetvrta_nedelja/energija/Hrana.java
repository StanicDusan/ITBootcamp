package energija;

public class Hrana extends Namirnica {
	
	private final double energijaBelancevina=16.7;
	private final double energijaMasti=37.6;
	private final double energijaUgljHidrata=17.2;
	private double tezina;
	private double belancevine;
	private double masti;
	private double ugljHidrati;
	
	public Hrana(String ime,double tezina, double belancevine,double masti, double ugljHidrati) {
		super(ime);
		this.tezina=tezina;
		this.belancevine=belancevine;
		this.masti=masti;
		this.ugljHidrati=ugljHidrati;
	}

	public double getTezina() {
		return tezina;
	}

	public double getBelancevine() {
		return belancevine;
	}

	public double getMasti() {
		return masti;
	}

	public double getUgljHidrati() {
		return ugljHidrati;
	}

	@Override
	public double energVr() {
		double ukupnaEnergija=(((this.tezina*this.belancevine)/100)*energijaBelancevina)
				+ (((this.tezina*this.masti)/100)*energijaMasti)
				+ (((this.tezina*this.ugljHidrati)/100)*energijaUgljHidrata);
		return ukupnaEnergija;
	}
	
	public String toString() {
		String s="";
		s+= super.toString() + "(" +this.tezina + "gr," + this.energVr() +"Kj)";
		return s;
	}
	
}

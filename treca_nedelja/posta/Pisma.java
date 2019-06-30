package posta;

public class Pisma {

	private String posiljalc;
	private String primalac;
	private int postanskiBroj;
	private double tezina;
	private int prioritetno;

	public double getTezina() {
		return this.tezina;
	}


	public Pisma(String posiljalc, String primalac, int postanskiBroj, double tezina, int prioritetno) {
		super();
		this.posiljalc = posiljalc;
		this.primalac = primalac;
		this.postanskiBroj = postanskiBroj;
		this.tezina = tezina;
		this.prioritetno = prioritetno;
	}

	public int getPrioritetno() {
		return this.prioritetno;
	}

	public boolean isPrioritetno() {
		int a = getPrioritetno();
		boolean pri = true;
		if (a == 1)
			pri = true;
		else if (a == 0)
			pri = false;
		return pri;
	}

	public String getPosiljalc() {
		return posiljalc;
	}

	public String getPrimalac() {
		return primalac;
	}

	public int getPostanskiBroj() {
		return postanskiBroj;
	}


	public String toString() {
		String prioritetno="";
		if(isPrioritetno())prioritetno="prioritetno";
		String str = (getPosiljalc() + " -> " + getPrimalac() + " : ");
		str += postanskiBroj + ", " + (int)tezina + "g " + prioritetno + " ";
		str += " => " +(int)cena() +"din";
		return str;
	}

	public double cena() {
		//double tezina = getTezina();
		boolean a = isPrioritetno();
		int cena = 0;
		if (a)
			cena += 46;
		if (this.tezina <= 20)
			cena = 23;
		else if (this.tezina >= 21 && this.tezina <= 100)
			cena += 35;
		else if (this.tezina >= 101 && this.tezina <= 250)
			cena = 46;
		else if (this.tezina >= 251 && this.tezina <= 500)
			cena = 81;
		else if (this.tezina >= 501 && this.tezina <= 1000)
			cena = 92;
		else if (this.tezina >= 1001 && this.tezina <= 2000)
			cena = 127;
		else {
			System.err.println("obratit se na salter za pakete");
			return -1;
		}
		
	
		return cena;

	}

}

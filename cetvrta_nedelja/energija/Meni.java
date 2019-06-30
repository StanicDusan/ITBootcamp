package energija;

public class Meni {
	
	private Namirnica[] niz;
	private int brNamirnica;
	private int brojNamirnica=0;
	
	public Meni(int brNamirnica) {
		this.brNamirnica=brNamirnica;
		niz=new Namirnica[brNamirnica];
	}
	
	public void dodaj(Namirnica namirnica) {
		niz[brojNamirnica]=namirnica;
		brojNamirnica++;
	}
	
	public double energVr() {
		double ukupnaEnergijaMeni=0;
		for(int i =0;i<brojNamirnica;i++) {
			ukupnaEnergijaMeni+=niz[i].energVr();
		}
		return ukupnaEnergijaMeni;
	}
	
	public String toString() {
		String s="";
		s="Meni (" +energVr() +"Kj):\n";
		for(int i =0;i<brojNamirnica;i++) {
			s+="  "+  niz[i].toString() + "\n";
		} 
		return s;
	}
}

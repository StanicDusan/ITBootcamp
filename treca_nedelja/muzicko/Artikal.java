package muzicko;

public abstract class Artikal {
	private static int globalID=0;
	private  int id;
	private double cena;
	private int kolicina;
	
	public Artikal(double cena, int kolicina) {
		this.cena=cena;
		this.kolicina=kolicina;
		id=++globalID;
	}
	

	
	
	
	public abstract String ime();

	public  int getId() {
		return id;
	}

	public double getCena() {
		return cena;
	}

	public int getKolicina() {
		return kolicina;
	}
	

	


	public boolean kupi() {
		if(kolicina>0) {
			kolicina--;
			return true;
		}else 
			return false;
	}
	
	public String toString() {
		String s = "";
		s= "#"+ getId() + " " + ime()+ " " +getCena()+ " [kol: "+ getKolicina()+ " ]";
		return s;
	}
	
	

}

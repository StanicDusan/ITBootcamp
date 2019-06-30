package muzicko;

import java.util.LinkedList;

public class Prodavnica {
	
	private String ime;
	private String lokacija;
	private LinkedList<Artikal> inventar;
	
	public Prodavnica(String ima, String lokacija) {
		this.ime=ime;
		this.lokacija=lokacija;
		inventar=new LinkedList<Artikal>();
	}
	
	public String getLokacija() {
		return lokacija;
	}
	public LinkedList<Artikal> pretrazi(String tekst) {
		LinkedList<Artikal>	l=new LinkedList<Artikal>();
		for(int i =0; i<inventar.size();i++) {
			if((inventar.get(i).ime().toLowerCase().contains(tekst.toLowerCase()))){
				l.add(inventar.get(i));
			}
		}
		return l;
			
	}
	
	public void dodaj(Artikal artikal) {
		
		inventar.add(artikal);
			
	}
	
	public String toString() {
		
		String prodavnica="MusicShop: " + getLokacija()+ " [\n";
		for(int i =0;i<inventar.size();i++) {
			prodavnica+= "#" + inventar.get(i).getId() + " : " + inventar.get(i).ime()+
				" - " +	inventar.get(i).getCena() + " [kol: " +inventar.get(i).getKolicina()+"]\n";
			//System.out.println("");
		}
		prodavnica += "\n]";
		return prodavnica;
	}
	


}

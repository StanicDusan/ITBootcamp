package muzicko;

import java.util.LinkedList;

public class Album {
	private String naziv;
	private String izvodjac;
	private Date datum;
	private LinkedList<Numera> lista;

	public Album(String naziv, String izvodjac, Date datum) {
		this.naziv = naziv;
		this.izvodjac = izvodjac;
		this.datum = datum;
		lista = new LinkedList<>();
	}

	public void dodaj(Numera n) {
		lista.add(n);
	}

	public void dodaj(String name, String trajanje) {
		lista.add(new Numera(name, getIzvodjac(), trajanje));

	}

	public String getIzvodjac() {
		return izvodjac;
	}

	public String getNaziv() {
		return naziv;
	}

	public String getTrajanje() {
		int ukupno = 0;
		for (int i = 0; i < lista.size(); i++) {
			String[] parts = lista.get(i).getTrajanje().split(":");
			ukupno += (Integer.parseInt(parts[0])) * 60 + Integer.parseInt(parts[1]);
		}
		String s = ukupno / 60 + ":" + ukupno % 60;
		return s;
	}
	
	public Date getDatum() {
		return datum;
	}
	
	public Numera getNumera(int broj) {
		return lista.get(broj);
	}
	
	public Numera getNumera(String ime) {
		int index=-1;
		for(int i =0; i<lista.size();i++) {
			if(lista.get(i).getNaziv().equals(ime)) index=i;
			
		}
		return lista.get(index);
	
	}

	public String toString() {
		int d= this.datum.getGodina();
		String numere="";
		for(int i =0;i<lista.size();i++) {
			numere+= lista.get(i).getIzvodjac() + " : " + lista.get(i).getNaziv() + " : " + lista.get(i).getTrajanje()+"\n";
		}
		String s = "";
		s = getIzvodjac() + " - " + getNaziv() + "(" + d + ") : [\n";
		s += numere + "] : " +getTrajanje();

		return s;
	}
}

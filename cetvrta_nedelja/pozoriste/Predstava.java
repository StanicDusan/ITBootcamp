package pozoriste;

import java.util.LinkedList;

public class Predstava {
	
	private String naziv;
	private Pozoriste pozoriste;
	private LinkedList<Zaposleni> zaposleni;
	
	
	public Predstava(String naziv, Pozoriste pozoriste, Reditelj reditelj) {
		this.naziv=naziv;
		this.pozoriste=pozoriste;
		zaposleni= new LinkedList<Zaposleni>();
		zaposleni.add(reditelj);
	}
	
	public boolean dodaj(Glumac glumac) {
		zaposleni.add(glumac);
		return true;
	}
	
	public boolean dodaj(Kostimograf kostimograf) {
		int brojKostimografa = 0;
		for(int i =0; i<zaposleni.size();i++) {
			if(zaposleni.get(i).imePosla().equals("kostimograf")) brojKostimografa++;
		}
		
		if(brojKostimografa<2) {
			zaposleni.add(kostimograf);
			return true;
		}else {
			System.out.println("maksimalno 2 kostimografa dozvoljeno");
			return false;	
		}
	}
	
	public String getNaziv() {
		return naziv;
	}
	
	public Pozoriste getPozoriste() {
		return pozoriste;
	}
	
	public String toString() {
		
		String s= "   " +getNaziv() + ":\n";
		for(int i =0;i<zaposleni.size();i++) {
			s+="\t(" + zaposleni.get(i) +")\n";
		}
		return  s;
				
	}

}

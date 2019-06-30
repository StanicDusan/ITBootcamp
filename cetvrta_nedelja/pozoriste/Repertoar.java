package pozoriste;

import java.util.LinkedList;

public class Repertoar {
	
	private Pozoriste pozoriste;
	private LinkedList<Predstava> predstava;
	
	public Repertoar(Pozoriste pozoriste) {
		this.pozoriste=pozoriste;
		predstava= new LinkedList<Predstava>();
	}
	
	public void dodaj(Predstava predstava) {
		this.predstava.add(predstava);
		
	}
	
	public void ukloni (String imePredstave) {
		for(int i =0; i<predstava.size();i++) {
			if(predstava.get(i).getNaziv().equals(imePredstave)) {
				predstava.remove(i);
			}
		}
	}
	public String toString() {
		String s ="";
		
		for(int i =0;i<Pozoriste.idGlobal;i++) {
			s+=pozoriste.toString()+"\n"+ predstava.toString() + "\n";
		}

		return s;
	}

}

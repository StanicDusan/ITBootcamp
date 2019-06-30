package tovar;

import java.util.LinkedList;
import java.util.List;

public class Paket extends Tovar{
	
	private LinkedList<Tovar> tovar;
	
	

	public Paket() {
		super();
		this.tovar= new LinkedList<Tovar>();
	}

	@Override
	public String getVrsta() {
		String s= "";
		for(int i =0; i<tovar.size();i++) {
			s+=tovar.get(i).getVrsta();
		if(i!=tovar.size()-1)s+=", ";
		}
		return s;
	}

	@Override
	public double getTezina() {
		double ukupnaTezina=0;
		for(int i =0; i<tovar.size();i++) {
			ukupnaTezina+=tovar.get(i).getTezina();
		}
			
		return ukupnaTezina;
	}
	
	public void dodaj(Tovar tovar) {
		this.tovar.add(tovar);
		
	}
	
	public String toString() {
		String s="paket" +"["+this.getVrsta()+ "]";
					s+=  "(" + this.getTezina() + ")";
		return s;
	}

}

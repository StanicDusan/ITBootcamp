package tovar;

import java.util.LinkedList;
import java.util.List;

public class Kamion {
	
	private String regBroj;
	private LinkedList<Tovar> tovar;
	private double nosivost;
	private double teret;
	
	
	public Kamion(String regBroj, double nosivost) {
		this.regBroj=regBroj;
		this.nosivost=nosivost;
	    tovar= new LinkedList<Tovar>();
	}
	
	public boolean stavi(Tovar t) {
		if (teret() + t.getTezina()>nosivost) return false;
		else {
			tovar.add(t);
			teret();
			return true;
		}
	}
	
	public void skini() {
		tovar.remove(tovar.size()-1);
	}
	
	public double teret() {
		teret=0;
		for(int i =0;i<tovar.size();i++) {
			teret+=tovar.get(i).getTezina();
		}
		return teret;
	}
	
	public String toString() {
		String s="";
		s+= this.regBroj + " (" + this.teret +"/"+this.nosivost+ ")\n" ;
		for(int i =0; i<tovar.size();i++) 
			s+= tovar.get(i).toString() +"\n";
		return s;
	}

}

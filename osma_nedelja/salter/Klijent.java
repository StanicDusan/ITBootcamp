package salter;

import java.util.Random;

public class Klijent extends Osoba{
	
	private char usluga;
	public Klijent next;
	
	public Klijent() {
		super();
		this.vrsta='K';
		Random r = new Random();
		int a = r.nextInt(3);
		switch(a) {
		case 0: this.usluga='a';break;
		case 1: this.usluga='b';break;
		case 2: this.usluga='c';break;
		}
		
	}

	public char getUsluga() {
		return usluga;
	}
	

	
	public String toString() {
	
		return super.toString() +" ["+this.usluga+"]";
	}
	
}

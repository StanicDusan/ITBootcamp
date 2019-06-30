package pozoriste;

public class Pozoriste {
	
	public static int idGlobal=0;
	private int id;
	private String naziv;
	
	
	public Pozoriste(String naziv) {
		this.naziv=naziv;
		id = ++idGlobal;
		
	}
	
	public int getId() {
		return id;
	}
	
	public String getNaziv() {
		return naziv;
	}
	
	public String getSkracenica() {
		String[] part = naziv.split(" ");
		String skracenica ="";
		for(int i =0; i<part.length; i++) {
			skracenica += part[i].charAt(0);
		}
		return skracenica.toUpperCase();
	}
	
	public String toString() {
		return naziv  +  " [";
	}

}

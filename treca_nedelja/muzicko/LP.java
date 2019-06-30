package muzicko;

public class LP extends AlbumArtikal {
	
	private int tezina;

	
		



	public LP(Album album, String izdavac, double cena, int kolicina, int tezina) {
		super(album, izdavac, cena, kolicina);
		this.tezina = tezina;
	}

	public String ime() {
		String s = getAlbum().getIzvodjac()+ " - " + getAlbum().getNaziv() + " (" + tezina + "g LP) ";
		return s;
	}

}

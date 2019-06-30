package muzicko;

public class CD  extends AlbumArtikal{
	
	public CD(Album album, String izdavac, double cena, int kolicina) {
		super(album, izdavac, cena, kolicina);
		
	}

	public String ime() {
		String s = getAlbum().getIzvodjac()+ " - " +getAlbum().getNaziv() + " (CD) ";
		return s;
	}

}

package muzicko;

public abstract class AlbumArtikal extends Artikal{
	private String izdavac= "mika";
	private Album album;

	public AlbumArtikal(Album album,String izdavac, double cena, int kolicina) {
		super(cena, kolicina);
		this.album=album;
		
	}
	
	public abstract String ime();

	public String getIzdavac() {
		return izdavac;
	}

	public Album getAlbum() {
		return album;
	}


	

	
	

}

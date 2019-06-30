package sistematskiPregled;

public class BMII {

	public final int id;
	public final String kategorija;
	public final String Skracenica;
	public double vrednost;

	
	
	public BMII(double visina, double tezina) {
		
		if(indexBmi(visina, tezina)<18.5) {
			this.id =0;
			this.kategorija="neuhranjenost";
			this.Skracenica="N";
		}
		else if((indexBmi(visina, tezina))>=18.5 && (indexBmi(visina, tezina))<=24.9) {
			this.id =1;
			this.kategorija="Idealna masa";
			this.Skracenica="IM";
		}
		else if((indexBmi(visina, tezina))>=25 && (indexBmi(visina, tezina))<=29.9) {
			this.id =2;
			this.kategorija="Prekomerna masa";
			this.Skracenica="PM";
		}
		else {
			this.id =3;
			this.kategorija="Gojaznost";
			this.Skracenica="G";
		}
  
    }
	
	public double indexBmi(double vis, double tez) {
		double aa = vis;
	    double bb = tez;
	    //System.out.println("index je " + (bb/(aa*aa) ));
		return bb/(aa*aa);
	}
	
}

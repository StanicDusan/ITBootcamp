package salter;

public class Test {

	public static void main(String[] args) {
		SalterskaSluzba posta=new SalterskaSluzba();
		Portir rade=posta.getPortir();
		Lista ul=posta.getUlaznaLista();
		rade.uRedi(ul);
		rade.uRedi(ul);
		rade.uRedi(ul);
				
		Razvodnik sinisa=posta.getRazvodnik();
				
		sinisa.proslediNaSalter(posta.getSalteri(), posta.getUlaznaLista());
		sinisa.proslediNaSalter(posta.getSalteri(), posta.getUlaznaLista());
		sinisa.proslediNaSalter(posta.getSalteri(), posta.getUlaznaLista());
				
		for(int i =0;i<posta.getSalteri().length;i++) {
			while(!posta.getSalteri()[i].isEmpty()) {
				posta.getSluzbenici()[i].obradiKlijenta(posta.getSalteri(), i);
			}
		}
		
		System.out.print("Red za salter A ");
		posta.getSalteri()[0].print();
		System.out.print("Red za salter B ");
		posta.getSalteri()[1].print();
		System.out.print("Red za salter C ");
		posta.getSalteri()[2].print();

		
		
	}
}

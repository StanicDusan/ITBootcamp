package salter;

public class Lista {
	
	public Klijent pocetak;
	
	public void insert(Klijent k) {
		k.next=null;
	
	if(this.pocetak==null) {
		pocetak=k;
	}else {
		Klijent n = pocetak;
		while(n.next!=null) {
			n=n.next;
		}
		n.next = k;
	}
	
    }

	public void print() {
		if(!isEmpty()) {
			Klijent klijent = this.pocetak;
			while(klijent.next!=null) {
				System.out.println(klijent.getUsluga());
				klijent=klijent.next;
			}
			System.out.println(klijent.getUsluga());	
		}else System.out.println("lista je prazna");
	
	}
	
	public  boolean isEmpty(){
		return (pocetak==null);
	}
	
	public Klijent GetKlijent() {
		return this.pocetak;
	}
	
	public Klijent obrisiPrvog(){
		if(!isEmpty()) {
			Klijent k=pocetak;
			pocetak=pocetak.next;
			return k;	
		}
		else {
			System.out.println("Lista je prazna");
			return null;
		}
	}
}

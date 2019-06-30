package vremenskaPrognoza;

import java.util.Arrays;
import java.util.Calendar;

public class Kalendar {
	Calendar calendar = Calendar.getInstance(); //dobijamo instancu
	int index = calendar.get(Calendar.DAY_OF_WEEK) - 1;
	//String[] dani = {"Ned","Pon","Uto","Sre","Čet","Pet","Sub"};
	
	
	public int[] petDana(Calendar calendar ) {
		int index=calendar.get(Calendar.DAY_OF_WEEK) - 1;
		int[] niz=new int[5];
		for (int i =0;i<5;i++) {
			int broj =index+i+1;
			if(broj>=7)broj=broj-7;
			niz[i]=broj;
		}
		return niz;
	}
	
	public String dani(int a) {
		String dan="";
		switch(a) {
		case 0 : dan="nedelja";break;
		case 1 : dan="ponedeljak";break;
		case 2 : dan="utorak";break;
		case 3 : dan="sreda";break;
		case 4 : dan="cetvrtak";break;
		case 5 : dan="petak";break;
		case 6 : dan="subota";break;
		}
		return dan;
	}
	


}
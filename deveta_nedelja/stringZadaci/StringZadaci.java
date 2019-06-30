package stringZadaci;

public class StringZadaci {

	public static void main(String[] args) {
		String s = "danas je lep dan";
		// String d = "pasmmmtasom";
		// String d = "pasalatasomer";
		// System.out.println(ukloniKarakter(s, 'l'));
		// System.out.println(obrniRec(s));
		// System.out.println(duplikati(s));
		// System.out.println(palindrom(d));
		// System.out.println(rotacija(s,d));
		System.out.println(cezarSifra(s, 9));

	}

//1.uklanja karakter iz stringa
	public static String ukloniKarakter(String s, char c) {
		String novi = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == c)
				continue;
			else
				novi += s.charAt(i);
		}
		return novi;
	}

	// 2.obrce rec
	public static String obrniRec(String s) {
		String[] nizS = s.split(" ");
		String obrnuti = "";
		String temp = "";
		for (int i = 0; i < nizS.length; i++) {
			for (int j = nizS[i].length() - 1; j >= 0; j--) {
				temp += nizS[i].charAt(j);
			}
			obrnuti += " " + temp;
			temp = "";
		}
		return obrnuti.trim();
	}

//3.duplikati u stringu
	public static String duplikati(String s) {
		String s1 = s.toLowerCase();
		char[] nizC = s1.toCharArray();
		char[] slova = new char[nizC.length];
		int br = 0;
		boolean fl = false;
		for (int i = 0; i < nizC.length; i++) {
			char temp = s1.charAt(i);
			for (int j = i + 1; j < nizC.length; j++) {
				if (temp >= 'a' && temp <= 'z') {
					if (temp == nizC[j]) {
						fl = true;
						slova[br] = temp;
						nizC[j] = '1';
					}
				}

			}
			nizC[br] = temp;
			if (fl) {
				br++;
				fl = false;
			}
		}
		String povrat = s + "=> ";
		for (int i = 0; i < slova.length; i++) {
			br = 0;
			char temp = slova[i];
			for (int j = 0; j < s1.length(); j++) {
				if (temp == s1.charAt(j))
					br++;
			}
			if (br > 0)
				povrat += temp + ":" + br + " ";

		}
		return povrat;
	}

//4.rotacija
	public static String rotacija(String a, String b) {
		try {
			if (a.length() != b.length())
				return "false";
			int br = 0;
			for (int i = 0; i < a.length(); i++) {
				for (int j = 0; j < a.length(); j++) {

					if (a.charAt(i) == b.charAt(j)) {
						if (a.substring(0, a.length() - br).equals(b.substring(br))
								&& a.substring(a.length() - br).equals(b.substring(0, br))) {
							return "true : " + (a.length() - br);
						}
						if (j == a.length())
							j = 0;
					}
					br++;
				}
			}
			return "false";
		} catch (StringIndexOutOfBoundsException e) {
			return "false";

		}

	}

	// 5.palindorm
	public static boolean palindrom(String a) {
		String test = "";
		for (int i = a.length() - 1; i >= 0; i--) {
			test += a.charAt(i);
		}
		if (a.toLowerCase().equals(test.toLowerCase()))
			return true;
		else
			return false;
	}

	// 6.cezar
	public static String cezarSifra(String s, int a) {
		String b = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ')
				b += ' ';
			else if ((s.charAt(i) + a - 97) > 25) {
				b += (char) (97 + (s.charAt(i) + a - 97) % 26);
			} else {
				b += (char) (s.charAt(i) + a);

			}
		}
		return b;
	}
}

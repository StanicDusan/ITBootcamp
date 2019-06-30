package izomorfizam;

import java.util.HashMap;

public class Test {

	public static void main(String[] args) {
		String str1="noaz";
		String str2="bodf";
		HashMap<Character,Character> mapaA=new HashMap<>();
		HashMap<Character,Character> mapaB=new HashMap<>();
		System.out.println("=>"+izomorf(str1, str2, mapaA,mapaB));
//		for(char a:map.keySet()) {
//			System.out.println(a);
//		}
		

	}
	
	public static boolean izomorf(String a, String b,HashMap<Character,
			Character> mapA,HashMap<Character,Character> mapB) {
		boolean flag=true;
		if(a.length()!=b.length()) return false;
		for(int i =0;i<a.length();i++) {
			if(mapA.containsKey(a.charAt(i))) {
				if(mapA.get(a.charAt(i))==b.charAt(i)) {
					continue;
				}else {
					System.out.print(" !"+mapA.get(a.charAt(i))+":"+b.charAt(i)+"!");
					flag=false;
					continue;
					
				}
			}
				//////////////////////
				if(mapB.containsKey(b.charAt(i))) {
					if(mapB.get(b.charAt(i))==a.charAt(i)) {
						continue;
					}else {
						System.out.print(" !"+mapB.get(b.charAt(i))+":"+a.charAt(i)+"!");
						flag=false;
						continue;
						
					}
				/////////////////////
			}
			
			mapA.put(a.charAt(i), b.charAt(i));
			mapB.put(b.charAt(i), a.charAt(i));
			System.out.print(" " +a.charAt(i)+":"+mapA.get(a.charAt(i)));
			
		}
		if(flag==false)return false;
		return true;
	}
	
}

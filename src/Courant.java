
public class Courant {
	
	//des constantes qui serviront pour les couleurs

	static String retourner(String s){
		//cette fonction renvoie le String retourné
		//Pour cela on procède comme pour les piles, il suffit d'empiler la pile vide en même temps qu'on dépile
		
		String answer = "";
		int n = s.length();
		while(answer.length()<=n-1){
			answer += s.charAt(s.length()-1);
			s = s.substring(0, s.length()-1);
	}
		return answer;
	}
	
	
	static void nice_display(String s, String t){
		char sc;
		char tc;
		String x = "";
		for(int i = 0; i<s.length();i++){
			tc = t.charAt(i);
			sc = s.charAt(i);
			if(sc==tc){
				x = x + "|";
			}
			else{
					x = x + " ";
				}
			
		}
		System.out.println(s);
		System.out.println(x);
		System.out.println(t);
	}

}



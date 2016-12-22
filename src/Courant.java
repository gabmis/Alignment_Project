
public class Courant {

	static String retourner(String s){
		//cette fonction renvoie le String retourné
		
		String answer = "";
		int n = s.length();
		while(answer.length()<=n-1){
			answer += s.charAt(s.length()-1);
			s = s.substring(0, s.length()-1);
	}
		return answer;
	}
}

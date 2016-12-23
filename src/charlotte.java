
public class charlotte {
	
	static int somme(int n){
		int s = 0;
		int i = 1;
		while(i<=n){
			s = s + i;
			i = i +1;
		}
		return s;
	}
	
	static int somme2(int n){
		if(n==1){
			return 1;
		}
		else{
			return somme2(n-1)+n;
		}
	}
	
	public static void main(String[] args) {
		int i = 0;
		System.out.println("salut");
		while(i<10){
			i = i +1;
			if(i > 2 && i <8){
			System.out.println("salut je suis dans la boucle numero "+i);
			}
			
		}
		
		System.out.println(somme(15));
	}
	

}

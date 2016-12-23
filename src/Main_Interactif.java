import java.io.BufferedReader;
import java.util.Date;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main_Interactif {
	private static final String FILENAME = "/Users/gabrielmisrachi/IdeaProjects/Alignment_Project/src/test320.txt";

	public static void main(String[] args) {
//		String t = "CGAACCTGTTTCGAAAGGCTCAAGTGGCCTCTATCCTACACGACAGACCACCCAGAACAAAGAGGATGTGGCCAT";
//		String s = "GGCGGCTATATTTAGCACACACAATTTTTAGGTCGCACGATCGGGATGGCGGCGCGCGATCAACAGCCTGCACACTTCTAAGGAAAATAGTCACACTCCC";
		String t = "CGAACACAAAGAGGATGTGGCCAT";
		String s = "GGCGGACAGCCTGCACACTTCTAAGGAAAATAGTCACACTCCC";
		/*String s = "non initialisée";
		String t = "non initialisée";
		try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
			s = br.readLine();
			t = br.readLine();
		}
		catch (IOException e) {
			e.printStackTrace();
		}*/
		
		char[] alphabet = new char[] {'A', 'R', 'N', 'D', 'C', 'Q', 'E', 'G', 'H', 'I', 'L', 'K', 'M', 'F', 'P', 'S', 'T', 'W', 'Y', 'V'};
		
		String reponse;
		long startTime;
		long endTime;
		long totalTime;
		double gap_1;
		double gap_2;
		int k;
		double th;
		double thl;
		
		
		//Introduction
		
		System.out.println("Une série de test effectués sur les chaînes de caractères suivantes: ");
		System.out.println("Chaîne t: "+t);
		System.out.println("Chaîne s: "+s);
		System.out.println("");
		
		//Task2:
		System.out.println("****Task2*********************************************************");
		
		
		System.out.println("La plus grande sous-séquence commune entre s et t est de taille "+Task2.lsubsq(s, t));
		System.out.println("");
		
		//Task3:
		System.out.println("****Task3*********************************************************");
		
		
		System.out.println("Voici un visuel d'un alignement correspondant au nombre optimal de caractères communs entre s et t ");
		Task3.display(s, t);
		System.out.println("");
		
		//Task4:
		System.out.println("****Task4*********************************************************");
		
		
		System.out.println("Voici un visuel d'un alignement de s et de t maximisant le score par rapport à la matrice Blosum 50: ");
		Task4.display(s, t);
		System.out.println("");
		
		//Task5:
		System.out.println("****Task5*********************************************************");
		
		
		System.out.println("On tient maintenant compte des gap, c'est à dire que l'on va sanctionner l'ouverture d'une séquence d'insertion ou de délétion.");
		System.out.println("On sanctionne encore plus si deux séquences insertions/délétion s'enchainent.");
		System.out.println("Cela permet de se rapprocher du cas réel ou les tirets ne sont que rarement isolés");
		System.out.println("");
		System.out.println("On vous propose de tester notre algorithme avec trois paramétrages différents");
		System.out.println("");

		System.out.println("Premier essai :");
		Scanner reader = new Scanner(System.in);  // Va lire les paramètres rentrés par l'utilisateur
		System.out.println("Enter gap_penalty: ");
		gap_1 = reader.nextDouble();
		System.out.println("Enter increasing_gap_penalty: ");
		gap_2 = reader.nextDouble();
		System.out.println("");
		System.out.println("Les paramètres utilisés sont: gap_penalty = "+gap_1+" et increasing_gap_penalty = "+gap_2);
		Task5.display(s, t,gap_1,gap_2);
		System.out.println("");
		
		
		System.out.println("Deuxième essai :");  // Va lire les paramètres rentrés par l'utilisateur
		System.out.println("Enter gap_penalty: ");
		gap_1 = reader.nextDouble();
		System.out.println("Enter increasing_gap_penalty: ");
		gap_2 = reader.nextDouble();
		System.out.println("");
		System.out.println("Les paramètres utilisés sont: gap_penalty = "+gap_1+" et increasing_gap_penalty = "+gap_2);
		Task5.display(s, t,gap_1,gap_2);
		System.out.println("");
		
		
		System.out.println("Troisième essai :");  // Va lire les paramètres rentrés par l'utilisateur
		System.out.println("Enter gap_penalty: ");
		gap_1 = reader.nextDouble();
		System.out.println("Enter increasing_gap_penalty: ");
		gap_2 = reader.nextDouble();
		System.out.println("");
		System.out.println("Les paramètres utilisés sont: gap_penalty = "+gap_1+" et increasing_gap_penalty = "+gap_2);
		Task5.display(s, t,gap_1,gap_2);
		System.out.println("");
		
		
		
		
		//Task6:
		System.out.println("****Task6*********************************************************");
		System.out.println("would you like to run Task6 ? This method can take a lot of time for long strings.");
		reader.nextLine();
		reponse = reader.nextLine();
		if(reponse.charAt(0) == 'y'){
			System.out.println("Enter gap_penalty: ");
			gap_1 = reader.nextDouble();
			System.out.println("Enter increasing_gap_penalty: ");
			gap_2 = reader.nextDouble();
			System.out.println("");
			Task6.best_local_score(s,t,gap_1,gap_2);
		}
		else{System.out.println("ok then let's go to the next task");}
		
		
		
		//Task7bis:
		System.out.println("****Task7bis*********************************************************");
		
		System.out.println("would you like to run Task7bis; Fist Method : Naive?.");
		reponse = reader.nextLine();
		reponse = reader.nextLine();
		if(reponse.charAt(0) == 'y'){
		
			System.out.println("Enter k: ");
			k = reader.nextInt();

			String g = "AACACGRTTT";

			System.out.println("Enter th: ");
			th = reader.nextDouble();
		
			startTime = System.currentTimeMillis();

			ArbreSeeds U = Task7bis.Seeds(g, th, k, alphabet);
			
			endTime   = System.currentTimeMillis();
			totalTime = endTime - startTime;
			System.out.println("First Method a mis "+totalTime/1000.0+" secondes à s'executer");
			
			System.out.println("nombre de graines pour th = "+th+" : "+U.size());
			U.print();
			System.out.println("");
			
			
			List<Integer> index = Task7bis.index(g, t, k, th, alphabet);
			for(Integer j : index){
				System.out.println("index : "+j);
				}
			
		}
		

		
		
		//Task7:
		System.out.println("****Task7*********************************************************");
		
		System.out.println("would you like to run Task7; Second Method : Optimising with trees.");
		System.out.println("this method requires a lot of memory, we do not recommend it for k>5");
		
		reponse = reader.nextLine();
		reponse = reader.nextLine();
		if(reponse.charAt(0) == 'y'){
		
			System.out.println("Enter k: ");
			k = reader.nextInt();

			String g = "AACACGRTTTC";

			System.out.println("Enter th: ");
			th = reader.nextDouble();
		
			startTime = System.currentTimeMillis();

			ArbreSeeds U = Task7.Seeds(g, th, k);
			
			endTime   = System.currentTimeMillis();
			totalTime = endTime - startTime;
			System.out.println("First Method a mis "+totalTime/1000.0+" secondes à s'executer");
			
			System.out.println("nombre de graines pour th = "+th+" : "+U.size());
			//U.print();
			System.out.println("");
			
			
			System.out.println("voici les indices de perfect match dans t: ");
			
			List<Integer> index = Task7.index(g, t, k, th);
			for(Integer j : index){
				System.out.println("index : "+j);
				}
			if(index.isEmpty()){
				System.out.println("pas de matchs trouvés");
			}
			
		}
		
		
		
		//Task8:
		System.out.println("****Task8**********************************************************");
		
		System.out.println("Enter k: ");
		k = reader.nextInt();
		System.out.println("Enter th: ");
		th = reader.nextDouble();
		System.out.println("Enter thl: ");
		thl = reader.nextDouble();
		System.out.println("");
		
		String g = "AACACGRTTTC";
		
		Task8.match(g, t,k,th,thl);

		
	}
	}


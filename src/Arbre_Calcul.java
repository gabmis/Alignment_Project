import java.util.ArrayList;
import java.util.List;
/* A R N D C Q E G H I L K M F P S T W Y V */
//un autre arbre qui va nous permettre de générer tous les mots de k lettres et d'évaluer leurs scores par rapport à un chaine de caractères
//on économise donc du temps de calcul à l'aide de la structure d'abre et on élimine au fur et à mesure les branches mortes.

//classe à tester
    class Arbre_Calcul {
      char contenu;
      List<Arbre_Calcul> fils = new ArrayList<Arbre_Calcul>();
      float score = 0;
      int depth;
      String s;
      double th;
      double[] best_possible;
      
      Arbre_Calcul(char c){
    	  contenu = c;
    	  depth = -1;
      }
      
      Arbre_Calcul(char c, int d){
    	  contenu = c;
    	  depth = d;
      }
    	   
      Arbre_Calcul(char c, Arbre_Calcul bb){
    	  contenu = c;
    	  fils.add(bb);
      }
      /* A R N D C Q E G H I L K M F P S T W Y V */
      
      Arbre_Calcul(String f, double tha){
    	  score = 0;
    	  s = f;
    	  th = tha;
    	  depth = -1;
    	  int k = f.length();
    	  best_possible = new double[k];
    	  for(int i=0; i<k;i++){
    		  best_possible[i]=Task8.score(s.substring(i,k),s.substring(i,k));
    	  }
    	  
    	  for(int i = 0; i<k;i++){
    		  ajouter_etage(i-1);
    	  }
    	  
      }
      
      public void ajouter_etage(int d){
    	  if(depth == d ){
    		  if(score+best_possible[depth+1]>=th*best_possible[0]){
        		  add('A');
            	  add('R');
            	  add('N');
            	  add('D');
            	  add('C');
            	  add('Q');
            	  add('E');
            	  add('G');
            	  add('H');
            	  add('I');
            	  add('L');
            	  add('M');
            	  add('F');
            	  add('P');
            	  add('S');
            	  add('T');
            	  add('W');
            	  add('Y');
            	  add('V');
    		  }
    	  }
    	  else{
    		  if(depth<d){
    		  for(Arbre_Calcul B : fils){
    			  B.ajouter_etage(d);
    		  }
    		  }
    	  }
      }
      
      public void add(char c){
    	  add(new Arbre_Calcul(c));
      }
      
      public void add(Arbre_Calcul B){
    	  B.depth = depth + 1;
    	  B.score = score + Blosum50.getScore(B.contenu, s.charAt(B.depth));
    	  B.s=s;
    	  B.best_possible = best_possible;
    	  B.th = th;
    	  fils.add(B);
      }
      
      
      public void add(String f){
    	  if(f.isEmpty()==false){
    		  char c = f.charAt(0);
    		  boolean indicateur = true;
    		  if (fils.isEmpty()==false){
    			  for(Arbre_Calcul B : fils){
    			  if(B.contenu == c){
    				  indicateur = false;
    				  B.add(f.substring(1, f.length()));
    				  break;
    			  }
    		  }
    		  }
    		  if(indicateur){
    			  add(new Arbre_Calcul(c));
    			  add(f);
    		  
    		  }
    	  
    	  }
      }
      
      
      public void clear_scores(){
    	  if(fils.isEmpty()==false){
    		  for (Arbre_Calcul B : fils){
    			  B.score = 0;
    			  B.clear_scores();
    		  }
    	  }
      }
      
      public void compute_scores(String s){//calcule tous les scores relatifs à ce string s
    	  									//pas de soucis dans les tests
    	  clear_scores();
    	  if(fils.isEmpty()==false){
    		  for (Arbre_Calcul B : fils){
    			  B.score = score + Blosum50.getScore(B.contenu, s.charAt(0));
    			  B.compute_scores(s.substring(1,s.length()));
    		  }
    	  }
      }
      
      public void print(){
    	  List<String> answer = to_list();
    	  for(String s : answer){
    		  System.out.println("string : "+s);
    	  }
      }
      public List<String> to_list(){
    	  double kills = 0.0;
    	  List<String> answer = new ArrayList<String>();
    	  to_listAux("", answer);
    	  return answer;
    	  
      }
      
      public void to_listAux(String f, List<String> answer){
    	  if(f.length() == s.length()){
    		  if(score>=best_possible[0]*th){
    			  answer.add(f);
    		  }
    	  }
    	  else{

    		  for(Arbre_Calcul B : fils){
    			  B.to_listAux(f+B.contenu,answer);
    		  }
    	  }
      }
      
      public float score(String s){//cette fonction va chercher le score du string s
    	  							//tout ca a l'air de bien marcher
    	  if(s.isEmpty()){return score;}
    	  else{
    		  for(Arbre_Calcul B : fils){
    			  if(B.contenu==s.charAt(0)){
    				  return B.score(s.substring(1,s.length()));
    			  }
    		  }
    		  System.out.println("le String "+s+" n'est pas dans l'arbre");
    		  return -100000000;
    			  }
    		  }
      }
      

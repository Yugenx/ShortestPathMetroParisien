package graphes;


import java.util.HashMap;
import java.util.Map;



public class Dijkstra {

	public static void dijkstra(IGrapheConst graphe, String source, Map<String, Integer> dist, Map<String, String> pred) {
		HashMap<String, Integer> NonVisite = new HashMap<>();
		for (String sommet : graphe.getSommets()) {
			NonVisite.put(sommet, Integer.MAX_VALUE);
		}
		NonVisite.replace(source, 0);
		String sommetPred = null;
		
		while(!NonVisite.isEmpty()) {
			//Chercher le minimum
			int minimum = Integer.MAX_VALUE;
			String sommetAct = "";
	        for (Map.Entry<String, Integer> sommet : NonVisite.entrySet()) { //Choisir le prochain qui sera visité
	        	if (sommet.getValue() < minimum) {
	        		minimum = sommet.getValue(); 
	        		sommetAct = sommet.getKey();
	        	}
	        }
	        
	        if (minimum == Integer.MAX_VALUE) {//Tous les sommets atteignables ont déjà été visité
	        	break;
	        	//return;
	        }
	        
	        dist.put(sommetAct, minimum);
	        pred.put(sommetAct, sommetPred);
	        sommetPred = sommetAct;

	        
	        for (String sommetSucc : graphe.getSucc(sommetAct)) {
	        	
	        	int valuation = graphe.getValuation(sommetAct, sommetSucc) + minimum;
	        	if(NonVisite.containsKey(sommetSucc)) {
		        	if (valuation < NonVisite.get(sommetSucc))
		        		NonVisite.replace(sommetSucc, valuation);  
	        	}
   	
	        }
	        NonVisite.remove(sommetAct);
	        
		}
	}
	
	
}

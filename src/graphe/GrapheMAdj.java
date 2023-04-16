package Graphe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrapheMAdj implements IGraphe{
	private int[][] matrice;
	private Map<String, Integer> indices;

	public GrapheMAdj () {
		this.indices = new HashMap<>();
		this.matrice = new int[0][0];
	}
	
	public GrapheMAdj(String str) {
		this.peupler(str);
	}

	@Override
	public String toString() {
	    List<String> sommetsTries = new ArrayList<>(getSommets());
	    Collections.sort(sommetsTries);

	    List<String> descriptionsArcs = new ArrayList<>();

	    for (String sommet : sommetsTries) {
	        List<String> successeurs = getSucc(sommet);

	        if (successeurs.isEmpty()) {
	            descriptionsArcs.add(sommet + ":");
	        } 
	        else {
	            Collections.sort(successeurs);

	            for (String successeur : successeurs) {
	                int poids = getValuation(sommet, successeur);
	                descriptionsArcs.add(sommet + "-" + successeur + "(" + poids + ")");
	            }
	        }
	    }
	    return String.join(", ", descriptionsArcs);
	}
	
	@Override
	public List<String> getSommets() { 
		List<String> sommets = new ArrayList<String>();
		for (Map.Entry<String,Integer> mapEntry : indices.entrySet()) {
			sommets.add(mapEntry.getKey());
		}
		return sommets;
	}
	
	@Override
	public List<String> getSucc(String sommet) {
		assert(contientSommet(sommet));
		List<String> succ = new ArrayList<String>();
		for (int i = 0; i < matrice.length; ++i) {
			if (matrice[indices.get(sommet)][i] != -1 && matrice[indices.get(sommet)][i] != -2) {
				for (Map.Entry<String,Integer> mapEntry : indices.entrySet()) {
					if (mapEntry.getValue() == i) 
						succ.add(mapEntry.getKey());
				}
			}
		}
		return succ;
	}
	
	@Override
	public int getValuation(String src, String dest) { 
		assert(contientSommet(src) && contientSommet(dest));
		return matrice[indices.get(src)][indices.get(dest)];
	}
	
	@Override
	public boolean contientSommet(String sommet) {
		return indices.containsKey(sommet);
	}
	
	@Override
	public boolean contientArc(String src, String dest) {
		if (contientSommet(src) && contientSommet(dest)); {
			if (matrice[indices.get(src)][indices.get(dest)] == -1)
				return false;
			else return true;
		}
	}
	
	@Override
	public void ajouterSommet(String noeud) {
		if (!contientSommet(noeud)) {
			int newTaille = matrice.length + 1;
			int[][] newMatrice = new int[newTaille][newTaille];
			for (int i = 0; i < matrice.length; ++i) {
				for (int y = 0; y < matrice.length; ++y) {
					newMatrice[i][y] = matrice[i][y];
				}
			}
			matrice = newMatrice;
			indices.put(noeud,indices.size());
			for(int i = 0; i < matrice.length ; ++i) { 
				matrice[(indices.size()-1)][i] = -1;
				matrice[i][(indices.size()-1)] = -1;
			}
		}
	} 
	
	@Override
	public void ajouterArc(String source, String destination, Integer valeur) {
		if (!contientSommet(source))
			ajouterSommet(source);
		if (!contientSommet(destination))
			ajouterSommet(destination);
		if (valeur < 0) 
			throw new IllegalArgumentException("La valuation est négative");
		if (matrice[indices.get(source)][indices.get(destination)] != -1)
			throw new IllegalArgumentException("Un arc existe déjà");		
		matrice[indices.get(source)][indices.get(destination)] = valeur;
	}
	
	@Override
	public void oterSommet(String noeud){
		if (contientSommet(noeud)) {
			for(int i = 0; i < matrice.length ; ++i) { 
				matrice[indices.get(noeud)][i] = -2;
				matrice[i][indices.get(noeud)] = -2;
			}
			indices.remove(noeud);
		}
	}
	
	@Override
	public void oterArc(String source, String destination) {
		if (!contientSommet(source) && !contientSommet(destination))
			throw new IllegalArgumentException("Un des sommets n'existe pas");
		if (matrice[indices.get(source)][indices.get(destination)] != -1)
			matrice[indices.get(source)][indices.get(destination)] = -1;
		}
}

package Graphe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrapheLAdj extends Graphe {

	private Map<String, List<Arc>> ladj;
	
	public GrapheLAdj() {
		this.ladj = new HashMap<String, List<Arc>>();
	}
	
	public GrapheLAdj(String str) {
		this();
		this.peupler(str);
	}
	


	@Override
	public List<String> getSommets() {
		// TODO Auto-generated method stub
		List<String> l = new ArrayList<String>();
		for(String s : this.ladj.keySet()) {
			l.add(s);
		}
		return l;
	}

	
	@Override
	public List<String> getSucc(String sommet) {
		assert(this.contientSommet(sommet));
		List<String> l  =  new ArrayList<String>();
		for (Arc arc : this.ladj.get(sommet)) {
			l.add(arc.getDestination());
		}

		return l;
	}

	@Override
	public int getValuation(String src, String dest) {
		if(this.contientArc(src, dest)) {
			List<Arc> l = this.ladj.get(src);
			for (int i = 0; i < l.size(); ++i) {
				if (l.get(i).getDestination().equals(dest)) {
					return l.get(i).getValuation();
				}
			}
		}
		return -1;

	}

	@Override
	public boolean contientSommet(String sommet) {
		return this.ladj.containsKey(sommet);
	}

	@Override
	public boolean contientArc(String src, String dest) {
		if (this.contientSommet(dest)) {
			for (String s : this.getSucc(src)) {
				if (s.equals(dest))
					return true;
			}
		}
		return false;
	}

	@Override
	public void ajouterSommet(String noeud) {
		if (!this.contientSommet(noeud)) {
		    ladj.put(noeud, new ArrayList<Arc>());
		}	
	}

	@Override
	public void ajouterArc(String source, String destination, Integer valeur) {
		
		//Tester si la destination existe deja
		this.ajouterSommet(destination);
			
		//Tester si la source existe deja : 
		this.ajouterSommet(source);
		
		Arc a = new Arc(source, destination, valeur);
		this.ladj.get(source).add(a);
		
		
	}

	@Override
	public void oterSommet(String noeud) {
		// TODO Auto-generated method stub
		this.ladj.remove(noeud);
		
	}

	@Override
	//Ne marche peut être pas
	//Mettre une exception si l'arc n'existe pas
	public void oterArc(String source, String destination) {
		List<Arc> l = this.ladj.get(source);
		for (int i = 0; i < l.size(); ++i) {
			if (l.get(i).getDestination() == destination) {
				l.remove(i);
				return;
			}
		}	
	}
	
}

package Graphe;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;


public class GrapheLArcs implements IGraphe {
    private List<Arc> arcs;

    public GrapheLArcs() {
        arcs = new ArrayList<>();
    }

    public GrapheLArcs(String str) {
        arcs = new ArrayList<>();
        peupler(str);
    }

    @Override
    public void ajouterSommet(String noeud) { 
    
    if (!contientSommet(noeud)) {
            // On ajoute un arc qui part et arrive sur le sommet pour le créer
            arcs.add(new Arc(noeud, noeud, 0));
        }
       
    }

    @Override
    public void ajouterArc(String source, String destination, Integer valeur) {
         if (valeur < 0) {
            throw new IllegalArgumentException("La valuation d'un arc ne peut pas être négative.");
        }
        if (!contientSommet(source)) {
            ajouterSommet(source);
        }
        if (!contientSommet(destination)) {
            ajouterSommet(destination);
        }
        arcs.add(new Arc(source, destination, valeur));
    }
        
    }

    @Override
    public void oterSommet(String noeud) {
        arcs.removeIf(arc -> arc.getSource().equals(noeud) || arc.getDestination().equals(noeud));

    @Override
    public void oterArc(String source, String destination) {
        arcs.removeIf(arc -> arc.getSource().equals(source) && arc.getDestination().equals(destination));
    }

    @Override
    public List<String> getSommets() {
        Set<String> sommets = new HashSet<>();
        for (Arc arc : arcs) {
            sommets.add(arc.getSource());
            sommets.add(arc.getDestination());
        }
        return new ArrayList<>(sommets);
        }
       
 

    @Override
    public List<String> getSucc(String sommet) {
        List<String> succ = new ArrayList<>();
        for (Arc arc : arcs) {
            if (arc.getSource().equals(sommet)) {
                succ.add(arc.getDestination());
            }
        }
        return succ;
    }

    @Override
   public int getValuation(String src, String dest) {
        for (Arc arc : arcs) {
            if (arc.getSource().equals(src) && arc.getDestination().equals(dest)) {
                return arc.getValuation();
            }
        }
        throw new IllegalArgumentException("L'arc (" + src + ", " + dest + ") n'existe pas.");
        }

   public boolean contientSommet(String sommet) {
        for (Arc arc : arcs) {
            if (arc.getSource().equals(sommet) || arc.getDestination().equals(sommet)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contientArc(String src, String dest) {
        for (Arc arc : arcs) {
            if (arc.getSource().equals(src) && arc.getDestination().equals(dest)) {
                return true;
            }
        }
        return false;
    }


   @Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Arc arc : arcs) {
        sb.append(String.format("%s-%s(%d), ", arc.getSource(), arc.getDestination(), arc.getValuation()));
    }
    if (sb.length() > 0) {
        sb.deleteCharAt(sb.length() - 1); // supprime la dernière virgule
        sb.deleteCharAt(sb.length() - 1); // supprime l'espace en fin de chaîne
    }
    return sb.toString();
    }


}

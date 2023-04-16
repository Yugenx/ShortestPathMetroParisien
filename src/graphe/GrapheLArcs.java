package graphe;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GrapheLArcs implements IGraphe {

    private List<Arc> arcs;

    public GrapheLArcs() {
        arcs = new ArrayList<>();
    }

    @Override
    public void ajouterSommet(String noeud) {
        if (!contientSommet(noeud)) {
            arcs.add(new Arc(noeud, noeud, 0));
        }
    }

    @Override
    public void ajouterArc(String source, String destination, Integer valeur) {
        if (valeur == null || valeur < 0) {
            throw new IllegalArgumentException("La valuation doit être positive.");
        }
        if (!contientSommet(source)) {
            ajouterSommet(source);
        }
        if (!contientSommet(destination)) {
            ajouterSommet(destination);
        }
        if (contientArc(source, destination)) {
            throw new IllegalArgumentException("L'arc (" + source + ", " + destination + ") existe déjà.");
        }
        arcs.add(new Arc(source, destination, valeur));
    }
    @Override
    public void oterSommet(String noeud) {
        arcs.removeIf(arc -> arc.getSource().equals(noeud) || arc.getDestination().equals(noeud));
    }

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
        return -1; // Renvoie -1 si l'arc n'existe pas.
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
            if (arc.getSource().equals(arc.getDestination())) {
                continue; // Ignore les boucles (arcs ayant la même source et destination)
            }
            sb.append(String.format("%s->%s(%d), ", arc.getSource(), arc.getDestination(), arc.getValuation()));
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 2); // Supprime les deux derniers caractères (', ')
        }
        return sb.toString();
    }
}
  
  




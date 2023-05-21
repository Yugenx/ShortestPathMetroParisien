package main.java.graphe.implems;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class GrapheLArcs extends Graphe {

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
        if (valeur < 0) {
            throw new IllegalArgumentException("Valuation négative.");
        }
        if (!this.contientSommet(source)) {
            this.ajouterSommet(source);
        }
        if (!this.contientSommet(destination)) {
            this.ajouterSommet(destination);
        }
        if (this.contientArc(source, destination)) {
            throw new IllegalArgumentException("Arc déjà présent.");
        }
        this.arcs.add(new Arc(source, destination, valeur));
    }


    @Override
    public void oterSommet(String noeud) {
        arcs.removeIf(arc -> arc.getSource().equals(noeud) || arc.getDestination().equals(noeud));
    }

    @Override
    public void oterArc(String source, String destination) {
        if(!this.contientArc(source, destination))
            throw new IllegalArgumentException("L'arc n'existe pas");
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
            if (arc.getSource().equals(sommet) && !arc.getDestination().equals(sommet)) {
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


}

package graphe;

import java.util.ArrayList;
import java.util.List;


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
        // Pas besoin d'ajouter un sommet individuellement en utilisant une liste d'arcs
        // car chaque arc relie un sommet source à un sommet destination
        // donc tous les sommets impliqués dans les arcs seront automatiquement ajoutés à la liste
    }

    @Override
    public void ajouterArc(String source, String destination, Integer valeur) {
        Arc arc = new Arc(source, destination, valeur);
        arcs.add(arc);
    }

    @Override
    public void oterSommet(String noeud) {
        // Pas besoin de retirer un sommet individuellement en utilisant une liste d'arcs
        // car chaque arc relie un sommet source à un sommet destination
        // donc tous les arcs impliquant le sommet seront automatiquement retirés de la liste
        arcs.removeIf(arc -> arc.source.equals(noeud) || arc.destination.equals(noeud));
    }

    @Override
    public void oterArc(String source, String destination) {
        arcs.removeIf(arc -> arc.getSource().equals(source) && arc.destination.equals(destination));
    }

    @Override
    public List<String> getSommets() {
        List<String> sommets = new ArrayList<>();
        for (Arc arc : arcs) {
            if (!sommets.contains(arc.source)) {
                sommets.add(arc.source);
            }
            if (!sommets.contains(arc.destination)) {
                sommets.add(arc.destination);
            }
        }
        // Ajouter un sommet factice de nom "" et de valuation 0
        if (!sommets.contains("")) {
            sommets.add("");
            arcs.add(new Arc("", "", 0));
        }
        return sommets;
    }

    @Override
    public List<String> getSucc(String sommet) {
        return null;
    }

    @Override
    public int getValuation(String src, String dest) {
        return 0;
    }

    @Override
    public boolean contientSommet(String sommet) {
        return false;
    }

    @Override
    public boolean contientArc(String src, String dest) {
        return false;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Arc arc : arcs) {
            sb.append(String.format("%s-%s(%d), ", arc.source, arc.destination, arc.valuation));
        }
        return sb.toString();
    }

}
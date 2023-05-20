package graphes;

import java.util.*;

public class GrapheHHAdj extends Graphe {



        private Map<String, Map<String, Integer>> hhadj;

        public GrapheHHAdj() {
            this.hhadj = new HashMap<>();
        }

        public GrapheHHAdj(String str) {
            this();
            this.peupler(str);
        }



        @Override
        public List<String> getSommets() {
            return new ArrayList<>(hhadj.keySet());
        }



        @Override
        public List<String> getSucc(String sommet) {
    		if (!this.contientSommet(sommet))
    			throw new IllegalArgumentException("Le sommet doit exister");
            return new ArrayList<>(hhadj.get(sommet).keySet());
        }

        @Override
        public int getValuation(String src, String dest) {
            if(hhadj.get(src).containsKey(dest) && hhadj.containsKey(src)) {
                return hhadj.get(src).get(dest);
            }
            return -1;
        }

        @Override
        public boolean contientSommet(String sommet) {
            return getSommets().contains(sommet);
        }

        @Override
        public boolean contientArc(String src, String dest) {
           return hhadj.containsKey(src) && hhadj.get(src).containsKey(dest);
        }

        @Override
        public void ajouterSommet(String noeud) {
            if (!this.contientSommet(noeud)) {
                this.hhadj.put(noeud, new HashMap<>());
            }
        }

        @Override
        public void ajouterArc(String src, String dest, Integer val) {

    		if(val < 0)
    			throw new IllegalArgumentException("La valuation doit être positive");
    		if(this.contientArc(src, dest))
    			throw new IllegalArgumentException("L'arc existe déjà");
            if (!hhadj.containsKey(src)){
                hhadj.put(src, new HashMap<>());
            }
            Map<String, Integer> tmp = this.hhadj.get(src);
            tmp.put(dest, val);

            this.hhadj.put(src, tmp);

        }

        @Override
        public void oterSommet(String noeud) {
            this.hhadj.remove(noeud);
            for (String sommet : this.hhadj.keySet()){
                if (getSucc(sommet).contains(noeud)){
                    hhadj.get(sommet).remove(noeud);
                }
            }

        }

        @Override

        public void oterArc(String src, String dest) {
    		if(!this.contientArc(src, dest
    				)) 
    			throw new IllegalArgumentException("L'arc n'existe pas");
            hhadj.get(src).remove(dest);
        }

        


    }



# ShortestPathMetroParisien
Dans le cadre de notre dernière SAE en développement orienté objets, nous devons implémenter en Java différentes représentations de graphes orientés valués. Le but est d'appliquer l'algorithme de Dijkstra afin de trouver le chemin le plus court entre deux stations de métro, et de comparer les performances de ces différentes représentations.

# Notre équipe : (GR 107)

- Suyi Lin
- Matthieu Juin
- Yasmine Benali
- Alexandre Carounanithi

# 01: Les différentes classes représentant un Graphe et implémentant l'interface IGraphe :

- les classes à réaliser ont été tiré au sort pour chacun d'entre nous.

1) Représentation en Liste d'arcs : __GrapheLArcs__ --> __Yasmine Benali__ :
- Cette classe fournit des méthodes pour __ajouter/supprimer__ des sommets et des arcs, __obtenir__ les sommets et les successeurs d'un sommet, __vérifier__ si un sommet ou un arc existe dans le graphe et __récupérer la valuation__ d'un arc. Elle dispose également d'une méthode __toString()__ pour afficher une représentation textuelle du graphe.

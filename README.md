# ShortestPathMetroParisien :

Dans le cadre de notre dernière SAE du semestre en Développement Orienté Objets, nous devions implémenter en Java différentes représentations de graphes orientés et valués. 

Notre but était d'appliquer l'algorithme de Dijkstra sur ces graphes afin de trouver le chemin le plus court entre deux points donnés, qui sont dans notre cas, deux stations de métro. 
Ainsi, nous devions comparer les performances de ces différentes représentations.

# Notre équipe (Groupe 107) :

- Suyi Lin
- Matthieu Juin
- Yasmine Benali
- Alexandre Carounanithi

# Les différentes classes codées :

Parmi les classes demandées lors de la première partie, toutes sont codées et fonctionnelles. Toutes nos réprésentations passent avec succès les tests de la classe IGrapheTest. 
Egalement, l'algorithme de Dijkstra a été codé par nous-même, nous permettant de passer la majorité des tests donnés (graphes et réponses) qui vérifient le bon fonctionnement de notre programme. Toutefois, certaines réprésentations de graphes ne passent pas pour certains tests et sont définis en italique dans notre fichier performances. 
Globalement, tous les tests passent correctement pour les 3 types de graphes jusqu'à certains niveaux : 
  - Full connected : tous les niveaux passent avec succès (Full 101-1 à 5001-1).
  - Barabasi-Albert : l'algorithme de Dijkstra fonctionne correctement notamment pour les réprésentations LArcs et      LAdj (Barabasi 102-1 à 10000002-1), sauf pour certains définis dans performances.pdf qui ne passent pas (MAdj et HHAdj).
  - Dorogovtsev Mendes : tous les niveaux passent (Dorogovtsev Mendes 100-1 à 100000-1) sauf pour le graphe 1000000- 1 et 1000-1 (pour MAdj et HHAdj).





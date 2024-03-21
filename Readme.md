# KataPanier

## Build

Run `mvn clean install` to build the project. The build artifacts will be stored in the `dist/` directory.

## Running unit tests

Run `mvn test` to execute the unit tests.

## Statement

Réalisation d’une application de gestion d’un panier d’articles

Fonctionnalités à réaliser

1. Articles :
   a. Afficher la liste des articles avec les infos relatives à l’article (nom produit, catégorie)
   b. Calculer et afficher le prix TTC sur chaque card article (voir section taxes)
   c. Filtrer les articles par catégorie
   d. Ajouter un article au panier
   e. Afficher un compteur d’articles rajoutés
   f. Sélectionner la quantité d’articles à ajouter avant d’ajouter l’article au panier.
   g. Si l’article n’est plus disponible en stock afficher « Non disponible »

2. Panier :
   a. Afficher les articles du panier avec les infos :
   • Nom Article
   • Quantité
   • Taxes
   • Prix unitaire HT,
   • Prix unitaire TTC
   • Total Taxes
   • Prix total TTC
   b. Pouvoir supprimer un article du panier
   c. Afficher le message « Panier vide » dans le cas où tous les articles du panier sont supprimés.

Règles générales

Taxes :
Aucune taxe n'est appliquée sur les produits de première nécessité, à savoir la nourriture et les médicaments.
Une taxe sur la valeur ajoutée de 10% est appliquée sur les livres.
Une taxe sur la valeur ajoutée de 20% est appliquée sur tous les autres produits.
Une taxe additionnelle de 5% est appliquée sur les produits importés, sans exception.

Le montant de chacune des taxes est arrondi aux 5 centimes supérieurs, selon la règle suivante :
Taxe calculée Taxe imputée
0,99 1,00
1,00 1,00
1,01 1,05
1,02 1,05

Le montant TTC est calculé comme suit :
Pttc = Pht + somme(arrondi(Pht*t/100))
Pttc: Prix TTC
Pht : Prix hors taxes
t : taxe applicable

# Documentation des requêtes http

### Requêtes permettant de tester l'absence de données dans la base de données

**GET** : http://localhost:9000/api/produits

**GET** : http://localhost:9000/api/categories

Résultat : chacune des deux exception est lancée avec son message (Aucun produit/Aucune catégorie trouvée dans la base de données)

### 1.Requêtes permettant de tester l'ajout d'un produit en base de données

**POST** http://localhost:9000/api/produit

Body d'une requête valide au format JSON :

``
{
    "nom":"Les Hauts de Hurlevent",
    "prix":14.90,
    "produit_categorie":1
}
``

Résultat : produit ajouté avec code 201

Body d'une requête non valide au format JSON :

``
{
    "nom":"sc",
    "prix":0,
    "produit_categorie":1
}
``

Résultat : 2 erreurs 400 : "Le prix du produit doit être d'au moins 1 euro", et "Le nom du produit doit faire au minimum 3 caractères"

### 2.Requêtes permettant de récupérer tous les produits

**GET** : http://localhost:9000/api/produits

Résultat : Affichage de la liste des produits avec code 200

### 3.Requêtes permettant de récupérer une catégorie par son id

**GET** : http://localhost:9000/api/categorie/1

Résultat : La requête aboutit avec succès. Catégorie trouvée : Livre

Test avec un id non existant en base de données

**GET** http://localhost:9000/api/categorie/4

Résultat : Erreur 404 : la catégorie avec l'id 4 n'existe pas
Déploiement de la base de données :


		----	----	----

Création de la base de données (ce guide propose une manière de procéder, il en existe d'autres) :

1) Télécharger pgAdmin3

2) Créer un utilisateur "postgres" lors de l'installation (seule la création d'un mot de passe devrait être demandée. Attention, ce mot de passe sera par la suite stocké dans un fichier de l'application. Dans le cadre de tests il est suffisant de renseigner "password" par exemple)

3) Lancer pgAdmin3 et connecter le serveur avec le mot de passe choisi en "2)"

4) Cliquer-droit sur "Databases" (Server Groups > server (1) > Postgresql [version](localhost:5432) > Databases)

5) Choisir "Add database"

6) Renseigner le nom "gcfaDB" dans le premier champ puis cliquer sur "ok"



Si le mot de passe choisi pour le compte postgres est "password", l'étape "Mappage de la base de donnée" qui suit n'est pas nécessaire, passer à l'étape "Initialisation de la base de données".

		----	----	----

Mappage de la base de données :

1) Ouvrir src/main/resources/META-INF/persistence.xml (sous windows :  avec un outil comme notepad++ de préférence : le boc-note classique n'est pas adapté à ce type d'usage)

2) A la ligne n°15 (<property name="javax.persistence.jdbc.password" value="password"/>) changer ' value="password" ' en renseignant à la place de "password" le mot de passe choisi au point "2)" de la création de la base de données.


		----	----	----


Initialisation de la base de données

Cette étape ne doit être utilisé que pour une présentation ou pour des tests, il ne faut en aucun cas l'exécuter sur l'application finale.
Suite à cette instruction des utilisateurs factices seront crées.

Ouvrir une console et exécuter la commande suivante (en se plaçant à la racine du projet)

java -jar script/dbFiller.jar




Votre application a maintenant accès à une base de données.
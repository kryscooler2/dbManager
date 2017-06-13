D�ploiement de la base de donn�es :


		----	----	----

Cr�ation de la base de donn�es (ce guide propose une mani�re de proc�der, il en existe d'autres) :

1) T�l�charger pgAdmin3

2) Cr�er un utilisateur "postgres" lors de l'installation (seule la cr�ation d'un mot de passe devrait �tre demand�e. Attention, ce mot de passe sera par la suite stock� dans un fichier de l'application. Dans le cadre de tests il est suffisant de renseigner "password" par exemple)

3) Lancer pgAdmin3 et connecter le serveur avec le mot de passe choisi en "2)"

4) Cliquer-droit sur "Databases" (Server Groups > server (1) > Postgresql [version](localhost:5432) > Databases)

5) Choisir "Add database"

6) Renseigner le nom "gcfaDB" dans le premier champ puis cliquer sur "ok"



Si le mot de passe choisi pour le compte postgres est "password", l'�tape "Mappage de la base de donn�e" qui suit n'est pas n�cessaire, passer � l'�tape "Initialisation de la base de donn�es".

		----	----	----

Mappage de la base de donn�es :

1) Ouvrir src/main/resources/META-INF/persistence.xml (sous windows :  avec un outil comme notepad++ de pr�f�rence : le boc-note classique n'est pas adapt� � ce type d'usage)

2) A la ligne n�15 (<property name="javax.persistence.jdbc.password" value="password"/>) changer ' value="password" ' en renseignant � la place de "password" le mot de passe choisi au point "2)" de la cr�ation de la base de donn�es.


		----	----	----


Initialisation de la base de donn�es

Cette �tape ne doit �tre utilis� que pour une pr�sentation ou pour des tests, il ne faut en aucun cas l'ex�cuter sur l'application finale.
Suite � cette instruction des utilisateurs factices seront cr�es.

Ouvrir une console et ex�cuter la commande suivante (en se pla�ant � la racine du projet)

java -jar script/dbFiller.jar




Votre application a maintenant acc�s � une base de donn�es.
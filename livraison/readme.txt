En étant à la racine du dossier livraison/src

Compilation du main/ pour exécuter l'application : 

javac -d ../build -cp main/bataillenavale/model/joueur/Humain.java  main/bataillenavale/model/joueur/*.java main/bataillenavale/model/jouer/*.java main/bataillenavale/model/navire/*.java main/bataillenavale/model/*.java main/bataillenavale/observer/*.java main/bataillenavale/vue/*.java

Exécution de la version en ligne de commande : 

java -cp ../build main.bataillenavale.core.Demo


Exécution de la version avec interface graphique : 

java -cp ../build main.bataillenavale.vue.Demo


==================================================================================================

Pour générer la javadoc : (en étant à la racine de livraison/)

javadoc -d doc -cp build -sourcepath src -classpath dist/junit-3.8.2.jar $(find src -name "*.java")


===================================================================================================

Pour générer l'exécutable .jar : (en étant à la racine de livraison/dist)

jar cfm bataillenavale.jar manifest.mf -C ../build/ .

exécution du .jar : 

java -jar bataillenavale.jar


==================================================================================================================
Seconde version avec ant.

En etant a la racine du projet c'est a dire dans livraison lancer les commandes suivantes:

	- `ant compile` : pour compiler le projet
	
	- `ant run` : pour executer le jeu sur la console
	
	- `ant test` :  pour lancer les tests unitaires
	
	- `ant install` : pour installer les librairies manquantes si necessaires
	
	- `ant jar` :  pour generer les jar
	
	- `ant dist` : pour generer la distribution
	
Pour lancer en interface graphique vous pouvez taper la commande suivante

	`ant jar && java -jar jar/GraphiqueBataille_navale-1.0.jar` 



































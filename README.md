# Wikipedia Matrix (benchmark)

# Principe du projet :

On souhaite extraire les tableaux de plus 300 pages wikipédia. Pour se faire nous devons construire un extracteur de page an JAVA.
Cet extrateur devra tout automatiser afin de réaliser cette tâche.

# Exécution du programme 

Pour pouvoir exécuter ce programme vous devez posséder un éditeur de texte java style Ecclipse ainsi qu'un JEE.

Une fois ceci fait, il vous suffit d'exécuter la classe App.java contenant la fonction main qui réalisera alors la tâche.

# dependencies

Un certains nombre de dependances ont été rajoutées. Il est donc nécessaire de mettre à jour le pom.xml avec les nouvelles dépendances.

<dependencies>
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.12</version>
			<scope>test</scope>
		</dependency>
		<dependency>
			<!-- jsoup HTML parser library @ https://jsoup.org/ -->
			<groupId>org.jsoup</groupId>
			<artifactId>jsoup</artifactId>
			<version>1.11.3</version>
		</dependency>
		<dependency>
			<groupId>org.apache.commons</groupId>
			<artifactId>commons-csv</artifactId>
			<version>1.6</version>
		</dependency>
	</dependencies>


# entrée

Le fichier des noms d'entrée wikiurls.txt se trouve dans wikimatrix/inputdata.

# sortie

Les sorties se trouve dans le dossier wikimatrix/output/html au format .csv.

# console

Pendant l'exécution du programme, vous pouvez suivre dans la console, l'évolution de l'extraction.
Vous y trouverez la page en cours de traitement, si la page a été trouvé, si l'url est valide, et si la page a été écrite ou non.


License libre de droit opensource.

Joaquim Morais

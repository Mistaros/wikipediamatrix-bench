# Wikipedia Matrix (benchmark)

Extracting Wikipedia tables into CSV files (basic skeleton for testing/benchmarking solutions). Once the git is cloned:
```
cd wikimatrix 
mvn test
``` 

We give 300+ Wikipedia URLs and the challenge is to:
 * integrate the extractors' code (HTML and Wikitext)
 * extract as many relevant tables as possible 
 * serialize the results into CSV files (within `output/html` and `output/wikitext`) 
 
More details can be found in `BenchTest.java`. We are expecting to launch `mvn test` and the results will be in `output` folder 


Pour lancer le programme il suffit de lancer la fonction main se trouvant App.java.

Il récupére les tableaux wikitable et les tableaux ayant l'option sortable.

License libre de droit opensource.

Joaquim Morais
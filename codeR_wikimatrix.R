### analyse entete des tables extraites 

setwd("D:/Programmation/Java/GITHUB/wikipediamatrix-bench/wikimatrix/output/html")


temp = list.files(pattern="*.csv")
for (i in 1:length(temp)) assign(temp[i], read.csv(temp[i])) 
  

## nombre de lignes

nbligne = c()
i=1
for ( obj in temp ) {
   tempo = get(obj)
   nbligne[i]= nrow(tempo)
   i=i+1
}

## nombre de colonnes

nbcol =c()
i=1
for ( obj in temp ) {
  tempo = get(obj)
  nbcol[i]= ncol(tempo)
  i=i+1
}

## nombre de cellules

nbcel=nbcol*nbligne

###########################################################
############## stat
###########################################################

### stat sur nombre de lignes

summary(nbligne)
sd(nbligne)

### stat sur nombre de colonnes

summary(nbcol)
sd(nbcol)

### stat sur le nombre de cellules

summary(nbcel)
sd(nbcel)

######################################################
#### etude des entetes

nom_var=c()
i=1
for (obj in temp) {
  tempo = get(obj)
  nom_var=c( nom_var,colnames(tempo) )
  i=i+ncol(tempo)
}

table_nom <- as.data.frame(table(nom_var))






/*
 * Cette class definit chaque cellule du tableau.
 * Dans cette classe on va definir le contenu de chaque cellule.
 * Pour ça on a besoin d'une variable content qui sera de Type AJouer.
 * Egalement on aura besoin de savoir la ligne et la colonne
 * de la cellule utilisé
 */
package stephane.tictactoe;

/**
 *
 * @author Ange Stephane
 */
public class Cellule {
    AJouer content;
    int ligne, colonne;
    
    public Cellule(int ligne, int colonne){
        this.ligne = ligne;
        this.colonne = colonne;
        clear();
    }
    
    /**
     * initialisation de la cellule
     */
    public void clear(){
        content = AJouer.VIDE;
    }
    
    /**
     * Definir un element à ajouter à la cellule
     */
    public void affiche(){
        switch (content) {
            case CROIX : System.out.print(" X "); break;
            case ROND  : System.out.print(" O "); break;
            case VIDE  : System.out.print("   "); break;
        }
    }
}

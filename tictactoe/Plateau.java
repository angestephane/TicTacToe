/*
 * Le plateau une l'une des partie les plus éssentielles du jeu. Nous aurons 
 * matrice 3 X 3 (trois ligne et trois colonnes ) qui sera de type Cellule. 
 * Dans cette class nous allons verifier l'etat du jeu (nulle ou victoire)
 */
package stephane.tictactoe;

/**
 *
 * @author Ange Stephane
 */
public class Plateau {
    public static final int LIGNE = 3; // on modifiera pas la valeur de la ligne
    public static final int COLONNE = 3; // on modifiera pas la valeur de la colonne
    
    Cellule[][] cells; //ligne colonne composé d'un type cellule
    int ligneCourente, colonneCourente;
    
    /**
     * initialisation du tableau
     */
    public Plateau(){
        cells = new Cellule[LIGNE][COLONNE]; // defini la taille du plateau
        for(int ligne = 0; ligne < LIGNE; ++ligne){
            for(int colonne = 0; colonne < COLONNE; ++colonne){
                cells[ligne][colonne] = new Cellule(ligne, colonne);
            }
        }
    }
    
    /**
     * Initialisationdu tableau
     */
    public void initialiserPlateau(){
        for(int ligne = 0; ligne < LIGNE; ligne++){
            for(int colonne = 0; colonne < COLONNE; colonne++){
                cells[ligne][colonne].clear();
            }
        }
    }
    
    public boolean nul(){
        for(int ligne = 0; ligne < LIGNE; ligne++){
           for(int colonne = 0; colonne < COLONNE; colonne++){
               if(cells[ligne][colonne].content == AJouer.VIDE)
                   return false;
           }
        }
        return true;
    }
    
    /**
     * retourn vrai si je courent entre un contenu
     * dans la cellule et la colonne courente,
     * qui est éguale à token
     * @param token
     * @return true
     */
    public boolean victoire(AJouer token){
        return (   cells[ligneCourente][0].content == token 
                && cells[ligneCourente][1].content == token 
                && cells[ligneCourente][2].content == token
             
                || cells[0][colonneCourente].content == token
                && cells[1][colonneCourente].content == token
                && cells[2][colonneCourente].content == token
                
                || cells[0][0].content == token
                && cells[1][1].content == token
                && cells[2][2].content == token
                
                || ligneCourente + colonneCourente == 2
                && cells[0][2].content == token
                && cells[1][1].content == token 
                && cells[2][0].content == token );
    }
    
    /**
     * Ajoute l'entrée du joueur dans une colonne. Grace à la methode affiche
     * de la class Cellule. Separe le contenu des cellule également. 
     */
    public void tableau(){
        for(int ligne = 0; ligne < LIGNE; ++ligne){
            for(int colonne = 0; colonne < COLONNE; ++colonne){
                cells[ligne][colonne].affiche();
                if(colonne != COLONNE - 1) System.out.print( " | ");
            }
            System.out.println();
            if(ligne != LIGNE - 1){
                System.out.println("---------------");
            }    
        }
    }
}

/*
 * C'est dans cette classe que nous allons controler le jeu
 * C'est un peu la class maitraisse
 * 
 */
package stephane.tictactoe;

import java.util.Scanner;

/**
 *
 * @author Ange Stephane
 */
public class Jeu {
   private EtatJeu etatCourent;
   private Plateau plateau;
   private AJouer joueurCourent;
  
   private static Scanner position = new Scanner(System.in);
   
   public Jeu(){
       plateau = new Plateau(); //Allocation du tableau
       
       initialiseJeu();
           do{
                                               //mise à jour de la ligne actuel et la
               positionJoueur(joueurCourent); //colonne actuel 
               plateau.tableau(); // initialisation du plateau
               miseAJourJeu(joueurCourent);// mise à jour de l'etat actuel
               //message de fin de jeu
               if(etatCourent == EtatJeu.JOUEUR1_GAGNE){
                   System.out.print(" JOUEUR 1 A GAGNER ! ");
               }
               else if(etatCourent == EtatJeu.JOUEUR2_GAGNE){
                   System.out.print(" JOUEUR 2 A GAGNER ! ");
               }
               else if(etatCourent == EtatJeu.NULLE){
                   System.out.print(" MATCH NUL ! ");
               }
               joueurCourent = (joueurCourent == AJouer.CROIX) ? AJouer.ROND : AJouer.CROIX;
           }while (etatCourent == EtatJeu.JOUER);
       }

   /**
    * Par defaut on donne le pion X au joueur courent.
    * Par defaut le jeu reste en cours.
    */ 
   private void initialiseJeu() {
         plateau.initialiserPlateau();
         joueurCourent = AJouer.CROIX;
         etatCourent = EtatJeu.JOUER;
    }

    /**
     * on attribut un pion au joeurs, et demande la position à laquelle il souhaite
     * jouer
     * @param token 
     */
    private void positionJoueur(AJouer token) {
        boolean validerposition = false; //pour valider l'entré du jouer
        
        do{
            /**
             * Si le joeur courent joue un X
             */
            if(token == AJouer.CROIX){
               System.out.print(" JOUEUR 1 : 'X', entrez la position"
                       + " ligne[1 - 3] colonne[1 - 3] : ");
            }
            /**
             * Si le joeur courent joue un O
             */
            else{
                System.out.print(" JOUEUR 2 : 'O', entrez la position"
                       + " ligne[1 - 3] colonne[1 - 3] : ");
            }
            
            int ligne   = position.nextInt() - 1;
            int colonne = position.nextInt() - 1;
            /**
             * On va introduire la valeur dans la colonne et la ligne
             * courente !
             */
            if(ligne >= 0 && ligne < Plateau.LIGNE 
               && colonne >= 0 && colonne < Plateau.COLONNE
               && plateau.cells[ligne][colonne].content == AJouer.VIDE){
                plateau.cells[ligne][colonne].content = token;
                plateau.ligneCourente = ligne;
                plateau.colonneCourente = colonne;
                
                validerposition = true; //position saisi est correcte
            }else{
                System.out.println("la position (" + (ligne + 1) + " , " + 
                (colonne + 1) + " ) n'est pas valide. essayer une autre position...");
            }
        }while(!validerposition); // reperte jusqu'a une saisir invalide
    }


    private void miseAJourJeu(AJouer token) {
        /**
         * verifie l'etat du jeu après la saisi d'un pion
         */
        if(plateau.victoire(token)){
           etatCourent = (token == AJouer.CROIX) ? EtatJeu.JOUEUR1_GAGNE : EtatJeu.JOUEUR2_GAGNE;
        }else if(plateau.nul()){ //Verification pou le match nul
            etatCourent = EtatJeu.NULLE; 
        }
    }
   
}

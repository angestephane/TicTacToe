/*
 * Ce projet est une première version du jeu tictactoe.
 * une version plus ameliorer avec une interface graphique  
 * sera proposée
 * 
 */
package stephane.tictactoe;

/**
 *
 * @author Ange Stephane
 */
public class Tictactoe extends Thread {
    public static void main(String[] args){
        Bienvenue msgBienvenue = new Bienvenue() ;
        System.out.println(msgBienvenue.msgWelcom());
        msgBienvenue.affichePlateau();
        new Jeu();
    }
}

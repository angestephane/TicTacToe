/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stephane.tictactoe;

/**
 *
 * @author Ange Stephane
 */
public class Bienvenue {
    public String msgWelcom(){
        return "\t\t-----------Tic Tac Toe GAME-------------\n"
                + "\t\tLe joueur 1 aura comme pion X \n"
                + "\t\tLe joueur 2 aura comme pion O \n";
    }
    
    public void affichePlateau(){
        System.out.println("\t 1 - 1 | 1 - 2 | 1 -3 \n"
                +          "\t---------+-------+------\n "
                +          "\t2 - 1 | 2 - 2 | 2 - 3 \n"
                +          "\t------+-------+---------\n "
                +          "\t3 - 1 | 3 - 2 | 3 - 3 ");
    }
}

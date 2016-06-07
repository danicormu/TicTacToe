/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import Controller.GameController;
import Model.GameModel;
import View.GameView;

/**
 *
 * @author Daniel
 */
public class TicTacToeGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Singleton applied
        GameModel game = GameModel.getInstance();
        GameView mainView = new GameView();
        GameController controller = new GameController(mainView, game);
        controller.showView();
        mainView.setVisible(true);
    }
    
}

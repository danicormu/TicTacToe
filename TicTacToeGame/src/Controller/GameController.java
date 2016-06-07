/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.GameModel;
import View.GameView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
public class GameController implements ActionListener{

    private GameView view;
    private GameModel game;
    private String title = "Tic-Tac-Toe";
    
    //Constructor, here is initializes the objects
    public GameController(GameView view, GameModel game){
        this.view = view;
        this.game = game;
    }
    
    //Function that start jFrame values with the models data and add buttons actionlistener
    public void showView(){
        view.setTitle(this.title);
        view.setLocationRelativeTo(null);
        this.view.btnSpace1.addActionListener(this);
        this.view.btnSpace2.addActionListener(this);
        this.view.btnSpace3.addActionListener(this);
        this.view.btnSpace4.addActionListener(this);
        this.view.btnSpace5.addActionListener(this);
        this.view.btnSpace6.addActionListener(this);
        this.view.btnSpace7.addActionListener(this);
        this.view.btnSpace8.addActionListener(this);
        this.view.btnSpace9.addActionListener(this);
    }
    
    //Function that get the buttons action
    @Override
    public void actionPerformed(ActionEvent e) {
        Object button = e.getSource();
        if(this.game.getWinner() == 0){
            if(button == this.view.btnSpace1)
                this.view.btnSpace1.setText(this.game.setMove(1));
            else if(button == this.view.btnSpace2)
                this.view.btnSpace2.setText(this.game.setMove(2));
            else if(button == this.view.btnSpace3)
                this.view.btnSpace3.setText(this.game.setMove(3));
            else if(button == this.view.btnSpace4)
                this.view.btnSpace4.setText(this.game.setMove(4));
            else if(button == this.view.btnSpace5)
                this.view.btnSpace5.setText(this.game.setMove(5));
            else if(button == this.view.btnSpace6)
                this.view.btnSpace6.setText(this.game.setMove(6));
            else if(button == this.view.btnSpace7)
                this.view.btnSpace7.setText(this.game.setMove(7));
            else if(button == this.view.btnSpace8)
                this.view.btnSpace8.setText(this.game.setMove(8));
            else if(button == this.view.btnSpace9)
                this.view.btnSpace9.setText(this.game.setMove(9));
            
            if(this.game.getError())
                JOptionPane.showMessageDialog(null, "La casilla está marcada \n Turno perdido!!");    
                
            this.view.lblShowTurn.setText(this.game.getTurn());
        }
        if( this.game.getWinner()== 1 )
            showMessage(" 'X' ");
        else if( this.game.getWinner()== 2 )
            showMessage(" 'O' ");
        else if( this.game.getWinner()== 3 )
            showMessage(" 'Es un empate' ");
    }
    
    //Function that show a message, depends on the model response.
    public void showMessage(String message){
        int selection = JOptionPane.showOptionDialog(null,"Gana " + message + "\n ¿Que desea hacer?", "Fin del juego",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,null,    
                       new Object[] { "Jugar de nuevo ", "Salir. " },
                       "Jugar de nuevo");
        
        if (selection != -1)
                if( (selection+1)==1 )
                {
                    this.game.startGame();
                    this.view.setTitle(title);
                    this.view.btnSpace1.setText( "" );
                    this.view.btnSpace2.setText( "" );
                    this.view.btnSpace3.setText( "" );
                    this.view.btnSpace4.setText( "" );
                    this.view.btnSpace5.setText( "" );
                    this.view.btnSpace6.setText( "" );
                    this.view.btnSpace7.setText( "" );
                    this.view.btnSpace8.setText( "" );
                    this.view.btnSpace9.setText( "" );
                }
                else
                    System.exit(0);
    }    
    
}

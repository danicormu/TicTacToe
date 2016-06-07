/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Daniel
 */
public class GameModel {
    private String digitX = "X";
    private String digit0 = "O";
    private boolean error = false;//It's for a message
    private byte turn = 1;//1 = X and 2=O
    private byte winner = 0;//1 and 2 = player, 3 = tie game
    private String board[][] = {{"", "", ""},//Matrix that store the moves
                                {"", "", ""},
                                {"", "", ""}};
    
    //Constructor
    private GameModel(){};
    
    //Varible is private and static and it should refer to the instance
    private static GameModel gameInstance = new GameModel();
    
    //Accesor function
    public static GameModel getInstance(){
        return gameInstance;
    }
    
    //Clean the board and restart the values.
    public void startGame(){
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board.length; j++)
                board[i][j] = "";
        this.error = false;
        this.winner = 0;
        this.turn = 1;
    }
    
    //Function that set the digit X or O 
    //The variable out shows the box checked
    public String setMove(int position){
        String out = "";
        if(turn == 1){
            out = checkSpace(position, this.digitX);
            turn = 2;
            if(wonGame(this.board, this.digitX))
                this.winner = 1;
            else if(tieGame())
                this.winner = 3;
        }else{
            out = checkSpace(position, this.digit0);
            turn = 1;
            if(wonGame(this.board, this.digit0))
                this.winner = 2;
            else if(tieGame())
                this.winner = 3;
        }        
        return out;
    }
    
    //Function that check the box 
    private String checkSpace(int position, String value){
        String check = "";
        switch(position){
            case 1: 
                check = subCheck(0, 0, value);
                break;
            case 2: 
                check = subCheck(0, 1, value);
                break;
            case 3: 
                check = subCheck(0, 2, value);
                break;
            case 4: 
                check = subCheck(1, 0, value);
                break;
            case 5: 
                check = subCheck(1, 1, value);
                break;
            case 6: 
                check = subCheck(1, 2, value);
                break;
            case 7: 
                check = subCheck(2, 0, value);
                break;
            case 8: 
                check = subCheck(2, 1, value);
                break;
            case 9: 
                check = subCheck(2, 2, value);
                break;            
        }
        return check;
    }
    
    //Function that verify the space, if the space is checked now the flag going to be True. 
    private String subCheck(int x, int y, String value){
        String check = "";
        this.error = false;        
        if(this.board[x][y].equals("")){
            this.board[x][y] = value;
            check = value;            
        }else{
            check = this.board[x][y];
            this.error = true;
        }
        return check;
    }  
    
    //Function that determines who's won the game
    public boolean wonGame(String matrix[][], String check){
        //search the winner by rows
        for(int i = 0; i < matrix.length; i++){
            byte count = 0;
            for(int j = 0; j < matrix.length; j++)
                count += (matrix[i][j].equals(check))?1:0;
            if(count == 3)
                return true;
        }
        //search the winner by columns
        for(int j = 0; j < matrix.length; j++){
            byte count = 0;
            for(int i = 0; i < matrix.length; i++)
                count += (matrix[i][j].equals(check))?1:0;
            if(count == 3)
                return true;
        }
        verifyDiagonal(matrix, check);        
        return false;
    }
    
    //Function that check the diagonals
    public boolean verifyDiagonal(String matrix[][], String check){
        if(matrix[0][0].equals(check) && matrix[1][1].equals(check) && matrix[2][2].equals(check))
            return true;
        if(matrix[0][2].equals(check) && matrix[1][1].equals(check) && matrix[2][0].equals(check))
            return true;        
        return false;
    }
    
    //Function that determine if can continue playing 
    private boolean tieGame(){
        for(int i = 0; i < board.length ; i++)
            for(int j = 0; j < board.length; j++)
                if(board[i][j].equals(""))
                    return false;         
        return true;
    }
    
    //Function that return an error
    public boolean getError(){
        return this.error;
    }
    
    //Function that return the turn
    public String getTurn(){
        return (this.turn==1)? "Turno para jugador: X" : "Turno para jugador: O";
    }
    
    //Function that return the winner
    public byte getWinner(){
        return  this.winner;
    } 
}

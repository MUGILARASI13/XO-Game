
package game;

import java.util.Scanner;

public class TicTacToe {

    private char[][] board = new char[3][3];
    private char current = 'X';

    public TicTacToe() {
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                board[i][j]='-';
    }

    public void printBoard() {
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    public boolean playMove(int r,int c){
        if(r<0||c<0||r>2||c>2||board[r][c] != '-') return false;
        board[r][c]=current;
        current = (current=='X'?'O':'X');
        return true;
    }

    public String checkWinner(){
        for(int i=0;i<3;i++){
            if(board[i][0]==board[i][1]&&board[i][1]==board[i][2]&&board[i][0]!='-') return String.valueOf(board[i][0]);
            if(board[0][i]==board[1][i]&&board[1][i]==board[2][i]&&board[0][i]!='-') return String.valueOf(board[0][i]);
        }
        if(board[0][0]==board[1][1]&&board[1][1]==board[2][2]&&board[0][0]!='-') return String.valueOf(board[0][0]);
        if(board[0][2]==board[1][1]&&board[1][1]==board[2][0]&&board[0][2]!='-') return String.valueOf(board[0][2]);

        boolean empty=false;
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                if(board[i][j]=='-') empty=true;

        return empty?null:"Draw";
    }
}

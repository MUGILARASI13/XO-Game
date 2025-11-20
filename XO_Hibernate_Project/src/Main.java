
import game.TicTacToe;
import dao.GameResultDAO;
import entity.GameResult;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GameResultDAO dao = new GameResultDAO();

        while(true){
            System.out.println("\n1. Play Game");
            System.out.println("2. View History");
            System.out.println("3. Exit");
            int ch = sc.nextInt();

            if(ch==1){
                System.out.print("Enter Player X name: ");
                String px = sc.next();
                System.out.print("Enter Player O name: ");
                String po = sc.next();

                TicTacToe t = new TicTacToe();
                String winner=null;

                while(winner==null){
                    t.printBoard();
                    System.out.print("Enter row and col: ");
                    int r=sc.nextInt();
                    int c=sc.nextInt();
                    t.playMove(r,c);
                    winner = t.checkWinner();
                }

                System.out.println("Winner: "+winner);

                dao.save(new GameResult(px,po,winner, LocalDateTime.now()));

            } else if(ch==2){
                List<GameResult> list = dao.getAll();
                for(GameResult g: list){
                    System.out.println(g.getPlayerX()+" vs "+g.getPlayerO()+" -> "+g.getWinner());
                }
            } else break;
        }
    }
}

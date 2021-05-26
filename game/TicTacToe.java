package game;
import java.util.Random;
import java.util.Scanner;
public class TicTacToe {
    public int winner =4;
    public static char[] chooseletter = new char[2];
    public static Scanner scanner = new Scanner(System.in);
    public static final int[] win = {448,56,7,292,146,73,273,84};
    public static char[] board;
    public static int[] playersinfo;
    public void displayBoard(){
        System.out.println(  board[1] + " | " + board[2] + " | " + board[3]);
        System.out.println("---------");
        System.out.println(board[4] + " | " + board[5] + " | " + board[6]);
        System.out.println("---------");
        System.out.println(board[7] + " | " + board[8] + " | " + board[9]);
    }
    public char[] choose(){
        char[] chooseletter = new char[2];
        while(chooseletter[0] != 'X' && chooseletter[0] != 'O'){
            System.out.println("choose X or O");
            chooseletter[0] = scanner.next().charAt(0);
            switch (chooseletter[0]) {
                case 'X' -> chooseletter[1] = 'O';
                case 'O' -> chooseletter[1] = 'X';
            }
        }
        return chooseletter;
    }
    public boolean moveBoard(int location,char chooseletter){
        if(((int) board[location])-48==location){
            board[location]=chooseletter;
            System.out.println(location + " " + chooseletter);
            return true;
        }
        else
            return false;

    }

    public int checkWinner(){
            TicTacToe value = new TicTacToe();
            value.playerbytevalues();
          for (int i=0;i<8;i++){
            if((int)(playersinfo[0]&win[i]) == win[i]) {
                value.winner = 1; // player is game1.winner
                System.out.println("..................player won the game.................");
            }
            else if((int)(playersinfo[1]&win[i]) == win[i]) {
                value.winner = 2; // computer is game1.winner is game1.winner
                System.out.println("..................system won the game.................");
            }
        }
        if(value.winner ==4 && playersinfo[1]+playersinfo[0]==511) {
            value.winner = 3; //game tie
            System.out.println("..................game tied.................");
        }
        else if(value.winner == 4 && playersinfo[0]+playersinfo[1]<511)
            value.winner =4; //next turn
        return value.winner;
    }
    public void playerbytevalues(){
        playersinfo = new int[]{0, 0};
        for(int i=1;i<10;i++){
            if (board[i]==chooseletter[0])
                playersinfo[0]= (int) (playersinfo[0]+Math.pow(2,i-1));
            if(board[i]==chooseletter[1])
                playersinfo[1]= (int) (playersinfo[1]+Math.pow(2,i-1));
        }

    }


    public static void main(String[] args) {
        int playagain = 1;
        do {
            board = new char[]{' ', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
            TicTacToe game1 = new TicTacToe();
            game1.displayBoard();
            chooseletter = game1.choose();
            Computer computer1 = new Computer();
            Random random = new Random();
            int ran = random.nextInt(2);
            if (ran == 1)
                while (game1.winner == 4) {
                    computer1.computerWin();
                    game1.winner = game1.checkWinner();
                    game1.displayBoard();
                    if (game1.winner != 4)
                        break;
                    System.out.println("enter the location");
                    int location = scanner.nextInt();
                    game1.moveBoard(location, chooseletter[0]);
                    game1.displayBoard();
                    game1.winner = game1.checkWinner();//system first
                }
            else if (ran ==0) {
                while (game1.winner == 4) {
                    System.out.println("enter the location");
                    int location = scanner.nextInt();
                    game1.moveBoard(location, chooseletter[0]);
                    game1.winner = game1.checkWinner();
                    game1.displayBoard();
                    if (game1.winner != 4)
                        break;
                    computer1.computerWin();
                    game1.winner = game1.checkWinner();
                    game1.displayBoard();
                }
            }
            System.out.println("........do u want to play again....");
            System.out.println("1.yes\n2.no");
            playagain = scanner.nextInt();
        }while(playagain==1);
    }
}

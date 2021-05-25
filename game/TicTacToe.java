package game;

import java.util.Scanner;

public class TicTacToe {
    public static Scanner scanner = new Scanner(System.in);
    public void board(char[] board){

        System.out.println(  board[1] + " | " + board[2] + " | " + board[3]);
        System.out.println("---------");
        System.out.println(board[4] + " | " + board[5] + " | " + board[6]);
        System.out.println("---------");
        System.out.println(board[7] + " | " + board[8] + " | " + board[9]);
    }
   

    public static void main(String[] args) {
        char[] board = new char[10];
        TicTacToe game1 = new TicTacToe();
        game1.board(board);
        char computer=game1.choose();
        System.out.println(computer);
    }
}

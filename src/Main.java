
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
   //A 2D array of the gameboard before any play has happened
    private static final ArrayList<Integer> playedPos = new ArrayList<>();
    public static char[][] gameBoard = new char[][]{
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '}};

    public Main() {
    }

    public static void main(String[] args) {
        int count = 1;      //A count to switch between players

        //A while loop that runs until the gameboard is full
        while(count != 10) {
            //
            printGameBord(gameBoard);
            playerPos(count);
            ++count;
        }
        printGameBord(gameBoard);
    }

    private static void playerPos(int n) {
        char playerSymbol = ' ';
        if (n % 2 == 0) {
            playerSymbol = 'O';
        } else if (n % 2 == 1) {
            playerSymbol = 'X';
        }

        switch (playerInput()) {
            case 1:
                gameBoard[0][0] = playerSymbol;
                break;
            case 2:
                gameBoard[0][2] = playerSymbol;
                break;
            case 3:
                gameBoard[0][4] = playerSymbol;
                break;
            case 4:
                gameBoard[2][0] = playerSymbol;
                break;
            case 5:
                gameBoard[2][2] = playerSymbol;
                break;
            case 6:
                gameBoard[2][4] = playerSymbol;
                break;
            case 7:
                gameBoard[4][0] = playerSymbol;
                break;
            case 8:
                gameBoard[4][2] = playerSymbol;
                break;
            case 9:
                gameBoard[4][4] = playerSymbol;
        }

    }

    private static int playerInput() {

        Scanner in = new Scanner(System.in);
        while (true){
            int input = in.nextInt();
            if(input > 0 && input < 10){
                if(playedPos.contains(input)){
                    System.out.println("Please select a slot that has not been played.");
                }else {
                    playedPos.add(input);
                        return input;
                }
            }else{
                System.out.println("Please enter a number between 1 - 9.");
            }
        }
    }

    private static void printGameBord(char[][] gameBoard) {

        for (char[] c : gameBoard) {
            System.out.println(c);
        }

    }
}


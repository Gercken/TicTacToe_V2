
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final ArrayList<Integer> playedPos = new ArrayList<>(); //ArrayList that tracks what positions has been played

    private static char playerSymbol = ' ';

    //A 2D array of the gameboard before any play has happened
    public static char[][] gameBoard = new char[][]{
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '}};

    public static void main(String[] args) {
        int count = 1;      //A count to switch between players

        //A while loop that runs until the gameboard is full
        while(count != 10) {
            //
            printGameBord(gameBoard);
            playerPos(count);
            ++count;
            checkIfWon();
        }
        printGameBord(gameBoard);
    }

    /**
     * A method that switches between players and then places the according player symbol
     * @param n this is the count which keeps track of who's turn it is
     */
    private static void playerPos(int n) {

        if (n % 2 == 0) {
            playerSymbol = 'O';
        } else if (n % 2 == 1) {
            playerSymbol = 'X';
        }

        //Switch case that askes for player input and the places the according player symbol on the chosen slot
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

    /**
     * A method that takes the player input and checks if it is a valid input
     * @returns the player input
     */
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

    /**
     * Method that prints the current gameboard
     */
    private static void printGameBord(char[][] gameBoard) {

        for (char[] c : gameBoard) {
            System.out.println(c);
        }

    }

    /**
     * A method that check all win conditions and prints if someone won
     */
    private static void checkIfWon(){

        for (int i = 0; i < 5; i+=2){

            if(gameBoard[0][i] == playerSymbol && gameBoard[2][i] == playerSymbol && gameBoard[4][i] == playerSymbol){
                System.out.println(playerSymbol + " You won");
            }
            if(gameBoard[i][0] == playerSymbol && gameBoard[i][2] == playerSymbol && gameBoard[i][4] == playerSymbol){
                System.out.println(playerSymbol + " You won");
            }
        }
        if(gameBoard[0][0] == playerSymbol && gameBoard[2][2] == playerSymbol && gameBoard[4][4] == playerSymbol){
            System.out.println(playerSymbol + " You won");
        }
        if(gameBoard[0][4] == playerSymbol && gameBoard[2][2] == playerSymbol && gameBoard[4][0] == playerSymbol){
            System.out.println(playerSymbol + " You won");
        }
    }

}


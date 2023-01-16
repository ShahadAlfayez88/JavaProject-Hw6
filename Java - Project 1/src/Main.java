
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

        public class Main {

            public static void main(String[] args) {

                Scanner UserInput = new Scanner(System.in);
                char table[][] = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
                char Player1 = 'X';
                char Player2 = 'O';

                System.out.println("Welcome to the tic tac toe game, do you want to play with me 1- yes/ 2- no ? (BTW I'm the computer)");

                // try statement

                try {
                    int Userinput = UserInput.nextInt();

                    // if the user entered a number that it does not equal 1 or 2
                    if(Userinput!=1 && Userinput!=2)throw new Exception("Wrong input you should enter either 1 or 2");

                    if (Userinput == 1) {
                        // print game
                        printGame(table);


                        while (true) {


                            while (true) {
                                //player 1
                                System.out.println("Where do you like to play? (1-9)");
                                int usercoice = UserInput.nextInt();

                                // if the user entered a number out of the range 1 - 9
                                if(usercoice<1 || usercoice>9) throw new ArithmeticException("You Must Enter A number in this range 1 - 9");

                                // if the user tried to take a taken spot
                                if(!ValidMove(table, usercoice)) throw new IllegalArgumentException("The Spot is Already Taken") ;

                                else {
                                    SetPosstion(table, usercoice, Player1);
                                    break;
                                }
                            }

                            if (FinishGame(table, Player1, Player2)) {
                                break;
                            }

                            // throw valid
                            while (true) {
                                // player 2
                                Random rand = new Random();
                                int ComputerTurn = rand.nextInt(9) + 1;
                                if (ValidMove(table, ComputerTurn)) {
                                    System.out.println("Computer chose " + ComputerTurn);
                                    SetPosstion(table, ComputerTurn, Player2);
                                    break;
                                }
                            }

                            if (FinishGame(table, Player1, Player2)) {
                                break;
                            }

                        }
                    } else {
                        System.out.println("See you next time");
                    }
                }
                // catch statement if the user entered an invalid input
                catch (InputMismatchException i){
                    System.out.println("You have entered an invalid Input");
                }
                // printing exceptions messages
                catch (ArithmeticException e) {
                    System.out.println(e.getMessage());
                }
                catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());

                }
            }



            public static void printGame(char[][] table) {
                for (char[] row : table) {
                    for (char c : row) {
                        System.out.print((char) c + "|");
                    }
                    System.out.println(" \n-+-+-+");
                }
            }

            public static void SetPosstion(char[][] table, int position, char player) {
                int UserChoice = position;
                // User choice
                if (UserChoice == 1) {
                    table[0][0] = player;
                    printGame(table);
                } else if (UserChoice == 2) {
                    table[0][1] = player;
                    printGame(table);
                } else if (UserChoice == 3) {
                    table[0][2] = player;
                    printGame(table);
                } else if (UserChoice == 4) {
                    table[1][0] = player;
                    printGame(table);
                } else if (UserChoice == 5) {
                    table[1][1] = player;
                    printGame(table);
                } else if (UserChoice == 6) {
                    table[1][2] = player;
                    printGame(table);
                } else if (UserChoice == 7) {
                    table[2][0] = player;
                    printGame(table);
                } else if (UserChoice == 8) {
                    table[2][1] = player;
                    printGame(table);
                } else if (UserChoice == 9) {
                    table[2][2] = player;
                    printGame(table);
                }

            }

            public static boolean ValidMove(char[][] table, int position) throws IllegalArgumentException{
                int UserChoice = position;
                if(UserChoice==1){
                    return table[0][0] == ' ' ;
                }
                else if (UserChoice==2) {
                    return table[0][1] == ' '; }

                else if (UserChoice==3) {
                    return table[0][2] == ' ';}

                else if(UserChoice==4) {
                    return table[1][0] == ' '; }

                else if (UserChoice==5) {
                    return table[1][1] == ' '; }

                else if (UserChoice==6){
                    return table[1][2] == ' ' ; }

                else if (UserChoice==7){
                    return (table[2][0] == ' ');}

                else if (UserChoice==8){
                    return (table[2][1] == ' ');}

                else if (UserChoice==9){
                    return (table[2][2] == ' ');}
                else
                    return false;

            }

            public static boolean checkwinner(char [][] table, char player){
                if (    (table[0][0] == player && table [0][1] == player && table [0][2] == player) ||
                        (table[1][0] == player && table [1][1] == player && table [1][2] == player) ||
                        (table[2][0] == player && table [2][1] == player && table [2][2] == player) ||
                        (table[0][0] == player && table [1][0] == player && table [2][0] == player) ||
                        (table[0][1] == player && table [1][1] == player && table [2][1] == player) ||
                        (table[0][2] == player && table [1][2] == player && table [2][2] == player) ||
                        (table[0][0] == player && table [1][1] == player && table [2][2] == player) ||
                        (table[0][2] == player && table [1][1] == player && table [2][0] == player) ) {
                    return true;
                }
                return false;
            }

            public static boolean FinishGame(char[][] table, char Player1 , char Player2) {

                if (checkwinner(table, Player1)) {
                    System.out.println("you win :)");
                    return true;
                }

                if (checkwinner(table, Player2)) {
                    System.out.println("Computer wins :(");
                    return true;
                }

                for (int i = 0; i < table.length; i++) {
                    for (int j = 0; j < table[i].length; j++) {
                        if (table[i][j] == ' ') {
                            return false;
                        }
                    }
                }
                System.out.println("Its a draw....");
                return true;
            }

        }

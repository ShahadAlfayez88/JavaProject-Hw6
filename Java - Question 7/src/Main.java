import java.util.*;

public class Main {

    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);

        // Question 7
        System.out.println("7.Write a menu driven Java program with following option:");
        ArrayList<String> UserArray = new ArrayList<>();
        boolean exit = true;

        try {
            while (exit!=false) {
                System.out.println("Welcome the array program please select from the following menu:" +
                        "\n 1. Please select the size of the array and add the elements" +
                        "\n 2. Display elements of an array" +
                        "\n 3. Search the element within array." +
                        "\n 4. Sort the array the size of the array should be entered by the user." +
                        "\n 5. exit the program."
                );

                int UserInput = input.nextInt();
                input.nextLine();

                if (UserInput==0 || UserInput>5) throw new IllegalArgumentException("You Entered a number that is not in menu");

                // choice 1
                if (UserInput == 1) {
                    System.out.println("please enter the size of the array");
                    int arraysize = input.nextInt();
                    System.out.println("Please enter elements to the array");
                    for (int e = 0; e < arraysize; e++) {
                        String addElement = input.next();
                        UserArray.add(addElement);
                    }

                    // choice 2
                } else if (UserInput == 2) {
                    System.out.println(UserArray);

                    // choice 3
                } else if (UserInput == 3) {
                    System.out.println("Please enter the element that you want to search about it:");
                    int Element = input.nextInt();
                    System.out.println(UserArray.get(Element) + " is in the array");

                    // choice 4
                } else if (UserInput == 4) {
                    Collections.sort(UserArray);
                    System.out.println("The result after sorting" + UserArray);
                } else if (UserInput == 5) {
                    exit = false;
                }
                continue;
            }} catch (InputMismatchException i){
            System.out.println("You have entered Invalid Input");

        }catch (IndexOutOfBoundsException i){
            System.out.println(" You Have entered a number that is higher than the Available index number ");
        }catch (IllegalArgumentException i){
            System.out.println(i.getMessage());

        }


    }}
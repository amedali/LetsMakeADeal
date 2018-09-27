import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class LetsMakeADeal {

    public static Scanner console = new Scanner(System.in);
    public static int userChoiceForDoor;
    public static int doorNumberOfCar;
    public static String userChoiceForChange;
    public static int numberOfRemainingDoor;

    public static void main (String[] args) {

        System.out.println("Welcome to Let's Make A Deal!");

        intro();

    }

    public static void intro() {

        System.out.print("Play or simulate? (P/S): ");
        String userChoiceForPlay = console.nextLine();

        if (userChoiceForPlay.equalsIgnoreCase("P")) {

            play();

        } else if (userChoiceForPlay.equalsIgnoreCase("S")) {

            simulate();

        } else {

            System.out.println("Please enter either P or S");

            intro();
        }

    }

    public static void play() {

        Random random = new Random();
        Random random2 = new Random();
        ArrayList <Integer> allPossibleDoorNumbers =  new ArrayList <> ();

        doorNumberOfCar = random.nextInt(3) + 1;

        allPossibleDoorNumbers.add(1);
        allPossibleDoorNumbers.add(2);
        allPossibleDoorNumbers.add(3);

        System.out.print("Which door do you pick? (1/2/3): ");
        userChoiceForDoor = console.nextInt();
        // /n komutunu tüketmek için alttaki statement gerekli.
        console.nextLine();

        // index'e göre değil integer'in kendisinin çıkması gerektiği için integer casting gerekli.
        allPossibleDoorNumbers.remove((Integer)userChoiceForDoor);

        if (userChoiceForDoor==doorNumberOfCar) {

            int sizeOfAllPossibleDoorNumbers = allPossibleDoorNumbers.size();
            int randomIndex = random2.nextInt(sizeOfAllPossibleDoorNumbers);
            int numberOfGoat = allPossibleDoorNumbers.get(randomIndex);

            System.out.println("Door number " + numberOfGoat + " has a goat.");

            allPossibleDoorNumbers.remove((Integer)numberOfGoat);

            numberOfRemainingDoor = allPossibleDoorNumbers.get(0);

            System.out.print("Do you want to change your choice and pick door number " + numberOfRemainingDoor + "? (Y/N): ");
            userChoiceForChange = console.nextLine();

            responseToChange();

        } else {

            allPossibleDoorNumbers.remove((Integer)doorNumberOfCar);

            int numberOfGoat = allPossibleDoorNumbers.get(0);

            System.out.println("Door number " + numberOfGoat + " has a goat.");

            numberOfRemainingDoor = doorNumberOfCar;

            System.out.print("Do you want to change your choice and pick door number " + doorNumberOfCar + "? (Y/N): ");
            userChoiceForChange = console.nextLine();

            responseToChange();

        }

    }

    public static void simulate() {

        System.out.println("Simulation");

    }

    public static void result() {

        if (userChoiceForDoor == doorNumberOfCar){

            System.out.println("You won!");

        } else {

            System.out.println("You lost!");

        }

        startAgain();
    }

    public static void responseToChange() {

        if (userChoiceForChange.equalsIgnoreCase("Y")) {

            userChoiceForDoor = numberOfRemainingDoor;

            result();

        } else if (userChoiceForChange.equalsIgnoreCase("N")) {

            result();

        } else {

            System.out.println("Please enter either Y or N");

            responseToChange();

        }

    }

    public static void startAgain() {

        System.out.print("Start again? (Y/N): ");
        String userChoiceForPlayAgain = console.nextLine();

        if (userChoiceForPlayAgain.equalsIgnoreCase("Y")) {

            intro();

        } else if(userChoiceForPlayAgain.equalsIgnoreCase("N")) {

            System.out.println("Game Over");

        } else {

            System.out.println("Please enter either Y or N");

            startAgain();

        }

    }

}
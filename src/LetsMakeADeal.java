import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class LetsMakeADeal {

    public static Scanner console = new Scanner(System.in);
    public static int userChoiceForDoor;
    public static int doorNumberOfCar;
    public static String userChoiceForChange;
    public static int numberOfRemainingDoor;

    public static int simulationDoorNumberOfCar;
    public static int simulationChoiceForDoor;
    public static int simulationNumberOfRemainingDoor;

    public static int changeStrategyTimesWon = 0;
    public static int changeStrategyTimesLost = 0;
    public static int notChangeStrategyTimesWon = 0;
    public static int notChangeStrategyTimesLost = 0;

    public static int countOfPickingChangeStrategy = 0;
    public static int countOfPickingNotChangeStrategy = 0;

    public static void main (String[] args) {

        System.out.println("Welcome to Let's Make A Deal!");
        System.out.println();

        intro();

    }

    public static void intro() {

        System.out.print("Play or simulate? (P/S): ");
        String userChoiceForPlay = console.nextLine();
        System.out.println();

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
        console.nextLine();
        System.out.println();

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
            System.out.println();

            responseToChange();

        } else {

            allPossibleDoorNumbers.remove((Integer)doorNumberOfCar);

            int numberOfGoat = allPossibleDoorNumbers.get(0);

            System.out.println("Door number " + numberOfGoat + " has a goat.");

            numberOfRemainingDoor = doorNumberOfCar;

            System.out.print("Do you want to change your choice and pick door number " + doorNumberOfCar + "? (Y/N): ");
            userChoiceForChange = console.nextLine();
            System.out.println();

            responseToChange();

        }

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

    public static void result() {

        if (userChoiceForDoor == doorNumberOfCar){

            System.out.println("Door number " + userChoiceForDoor + " has a car.");
            System.out.println("You won!");
            System.out.println();

        } else {

            System.out.println("Door number " + userChoiceForDoor + " has a goat.");
            System.out.println("You lost!");
            System.out.println();

        }

        startAgain();
    }

    public static void startAgain() {

        System.out.print("Start again? (Y/N): ");
        String userChoiceForStartAgain = console.nextLine();
        System.out.println();

        if (userChoiceForStartAgain.equalsIgnoreCase("Y")) {

            intro();

        } else if(userChoiceForStartAgain.equalsIgnoreCase("N")) {

            System.out.println("Game Over");

        } else {

            System.out.println("Please enter either Y or N");

            startAgain();

        }

    }

    public static void simulate() {

        System.out.print("How many iterations? ");
        int numberOfIterations = console.nextInt();
        console.nextLine();
        System.out.println();

        for (int i = 0; i < numberOfIterations; i++) {

            simulation();

        }

        simulationResults();

    }

    public static void simulation() {

        Random random = new Random();
        Random random2 = new Random();
        Random random3 = new Random();

        ArrayList <Integer> allPossibleDoorNumbers =  new ArrayList <> ();

        simulationDoorNumberOfCar = random.nextInt(3) + 1;
        simulationChoiceForDoor = random2.nextInt(3) + 1;

        allPossibleDoorNumbers.add(1);
        allPossibleDoorNumbers.add(2);
        allPossibleDoorNumbers.add(3);

        allPossibleDoorNumbers.remove((Integer)simulationChoiceForDoor);

        if (simulationChoiceForDoor==simulationDoorNumberOfCar) {

            int sizeOfAllPossibleDoorNumbers = allPossibleDoorNumbers.size();
            int randomIndex = random3.nextInt(sizeOfAllPossibleDoorNumbers);
            int simulationNumberOfGoat = allPossibleDoorNumbers.get(randomIndex);

            allPossibleDoorNumbers.remove((Integer)simulationNumberOfGoat);

            simulationNumberOfRemainingDoor = allPossibleDoorNumbers.get(0);

            strategyChoice();

        } else {

            allPossibleDoorNumbers.remove((Integer)simulationDoorNumberOfCar);

            simulationNumberOfRemainingDoor = simulationDoorNumberOfCar;

            strategyChoice();

        }

    }

    public static void strategyChoice() {

        Random random4 = new Random();

        int simulationChoiceForStrategy = random4.nextInt(2);

        if (simulationChoiceForStrategy == 0) { //değiştirme stratejisi

            simulationChoiceForDoor = simulationNumberOfRemainingDoor;

            winConditionForChangeStrategy();

        } else {

            winConditionForNotChangeStrategy();

        }

    }

    public static void winConditionForChangeStrategy() {

        countOfPickingChangeStrategy++;

        if (simulationChoiceForDoor == simulationDoorNumberOfCar) {

            changeStrategyTimesWon++;

        } else {

            changeStrategyTimesLost++;

        }
    }

    public static void winConditionForNotChangeStrategy() {

        countOfPickingNotChangeStrategy++;

        if (simulationChoiceForDoor == simulationDoorNumberOfCar) {

            notChangeStrategyTimesWon++;

        } else {

            notChangeStrategyTimesLost++;

        }
    }

    public static void simulationResults() {

        double winningProbabilityOfChangeStrategy = ((double) changeStrategyTimesWon / countOfPickingChangeStrategy );
        double winningProbabilityOfNotChangeStrategy = ((double) notChangeStrategyTimesWon / countOfPickingNotChangeStrategy );

        System.out.println("The strategy of switching to the host’s choice won " + changeStrategyTimesWon + " times out of " + countOfPickingChangeStrategy + " times.");
        System.out.printf("Estimated winning probability of the strategy is %.2f\n", winningProbabilityOfChangeStrategy);
        System.out.println();
        System.out.println("The strategy of sticking with the original choice won " + notChangeStrategyTimesWon + " times out of " + countOfPickingNotChangeStrategy + " times.");
        System.out.printf("Estimated winning probability of the strategy is %.2f\n", + winningProbabilityOfNotChangeStrategy);
        System.out.println();

        if (winningProbabilityOfChangeStrategy > winningProbabilityOfNotChangeStrategy) {

            System.out.println("The strategy of switching to the host’s choice is better.");

        } else if (winningProbabilityOfChangeStrategy < winningProbabilityOfNotChangeStrategy) {

            System.out.println("The strategy of sticking with the original choice is better.");

        } else {

            System.out.println("Both strategies are equally successful.");

        }

    }

}
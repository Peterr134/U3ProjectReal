import java.util.Scanner;
public class Main {
    static boolean[] doorValues = new boolean[3];
    public static void main(String[] args) {
        for(int i = 0; i<3; i++){
            doorValues[i] = false;
        }
        int randomNum = (int)(Math.random()*3);
        doorValues[randomNum] = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Monty Hall simulator!");
        System.out.println("There are 3 doors. One has a car, and the other two have goats");
        System.out.println("Which door will you choose? 1, 2, or 3?");
        int playerChoice = scanner.nextInt()-1;
        Monty monty = new Monty(playerChoice, randomNum);
        System.out.println("There is a goat behind door " + monty.goatReveal() + "!");
        System.out.println("Do you want to switch your pick?");
        monty.updateChoice();
        int winDoor;
        if(doorValues[0]){
            System.out.println("The car is behind door 1!");
            winDoor = 0;
        }else if(doorValues[1]){
            System.out.println("The car is behind door 2!");
            winDoor = 1;
        }else{
            System.out.println("The car is behind door 3!");
            winDoor = 2;
        }
        if(monty.getNewPlayerChoice() == winDoor){
            System.out.println("You win the car!");
        }else{
            System.out.println("You win a goat!");
        }

    }
}
import java.util.Scanner;
public class Monty {
    private int playerChoice;
    private int carDoor;
    private int newPlayerChoice;
    private int revealedDoor;
    public Monty(int playerChoice, int carDoor){
        this.playerChoice = playerChoice;
        this.carDoor = carDoor;
    }
    public int goatReveal() {
        int goatReveal;
        while (true) {
            goatReveal = (int) (Math.random() * 3);
            if (!(goatReveal == carDoor || goatReveal == (playerChoice))) {
                revealedDoor = goatReveal;
                return(goatReveal+1);
            }
        }
    }
    public void updateChoice() {
        Scanner scanner = new Scanner(System.in);
        String playerSwitch = scanner.nextLine();
        if (playerSwitch.equalsIgnoreCase("yes")) {
            if (revealedDoor == 1) {
                if (playerChoice == 0) {
                    newPlayerChoice = 2;
                } else {
                    newPlayerChoice = 0;
                }
            } else if (revealedDoor == 0) {
                if (playerChoice == 1) {
                    newPlayerChoice = 2;
                } else {
                    newPlayerChoice = 1;
                }
            } else {
                if (playerChoice == 0) {
                    newPlayerChoice = 1;
                } else {
                    newPlayerChoice = 0;
                }
            }
        } else if (playerSwitch.equalsIgnoreCase("Peter")){
            newPlayerChoice = carDoor;
        } else {
            newPlayerChoice = playerChoice;
        }
        if (newPlayerChoice != playerChoice) {
            System.out.println("Guess switched from " + (playerChoice + 1) + " to " + (newPlayerChoice + 1));
        }else{
            System.out.println("Guess not switched");
        }
    }

    public int getNewPlayerChoice() {
        return newPlayerChoice;
    }
}

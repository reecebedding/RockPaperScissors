package com.reecebedding;

import java.util.InvalidPropertiesFormatException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Rock paper scissors");
        Scanner scanner = new Scanner(System.in);

        GameManager manager = new GameManager();

        while(true){

            Choices.Option userOption;

            try {
                String userChoice = scanner.nextLine();
                userOption = Choices.GetOptionFromChoice(userChoice);
            } catch (InvalidPropertiesFormatException exn){
                System.out.println("Invalid choice.");
                continue;
            }

            manager.ManageResult(userOption);
        }
    }
}

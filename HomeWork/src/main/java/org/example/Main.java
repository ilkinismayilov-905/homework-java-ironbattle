package org.example;

import org.example.entity.BattleSimulator;
import org.example.entity.Warrior;
import org.example.entity.Wizard;
import java.util.Scanner;
import org.example.entity.Character;

import java.util.Random;


public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        Character player1 = null;
        Character player2 = null;
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n==================================");
            System.out.println("       RPG BATTLE SIMULATOR       ");
            System.out.println("==================================");
            System.out.println("1. Create Player 1 " + (player1 != null ? "[" + player1.getName() + " Ready]" : "[Not Created]"));
            System.out.println("2. Create Player 2 " + (player2 != null ? "[" + player2.getName() + " Ready]" : "[Not Created]"));
            System.out.println("3. Start Battle");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    player1 = createCharacter(1);
                    break;
                case "2":
                    player2 = createCharacter(2);
                    break;
                case "3":
                    if (player1 != null && player2 != null) {
                        BattleSimulator simulator = new BattleSimulator();
                        simulator.startBattle(player1, player2);

                        player1 = null;
                        player2 = null;
                    } else {
                        System.out.println("\nYou must create both players before starting the battle!");
                    }
                    break;
                case "4":
                    System.out.println("Exiting simulator. Goodbye!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static Character createCharacter(int playerNum) {
        System.out.println("\nSelect Class for Player " + playerNum + ":");
        System.out.println("1. Warrior");
        System.out.println("2. Wizard");
        System.out.print("Choice: ");

        int type = -1;
        try {
            type = Integer.parseInt(scanner.nextLine());
            if (type != 1 && type != 2) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            System.out.println("Invalid class selection. Creation cancelled.");
            return null;
        }

        System.out.print("Enter Character Name: ");
        String name = scanner.nextLine();

        if (type == 1) {
            int hp = random.nextInt(101) + 100;
            int stamina = random.nextInt(41) + 10;
            int strength = random.nextInt(10) + 1;
            System.out.println("Player " + playerNum + " (Warrior) created successfully!");
            return new Warrior(name, hp, stamina, strength);
        } else {
            int hp = random.nextInt(51) + 50;
            int mana = random.nextInt(41) + 10;
            int intelligence = random.nextInt(50) + 1;
            System.out.println("Player " + playerNum + " (Wizard) created successfully!");
            return new Wizard(name, hp, mana, intelligence);
        }
    }
}
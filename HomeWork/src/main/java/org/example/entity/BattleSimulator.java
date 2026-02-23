package org.example.entity;

public class BattleSimulator {

    public void startBattle(Character player1, Character player2) {
        System.out.println("BATTLE START!");
        System.out.println(player1.getName() + " VS " + player2.getName());
        Character p1Backup = cloneCharacter(player1);
        Character p2Backup = cloneCharacter(player2);

        boolean battleOver = false;

        while (!battleOver) {
            int round = 1;

            while (player1.isAlive() && player2.isAlive()) {
                System.out.println("\n--- Round " + round + " ---");

                player1.attack(player2);
                player2.attack(player1);

                System.out.println("=> " + player1.getName() + " HP: " + player1.getHp());
                System.out.println("=> " + player2.getName() + " HP: " + player2.getHp());

                round++;
            }

            if (!player1.isAlive() && !player2.isAlive()) {
                System.out.println("\nIT'S A TIE!");
                System.out.println("Restarting the battle to find a true winner...\n");
                player1 = cloneCharacter(p1Backup);
                player2 = cloneCharacter(p2Backup);
            } else if (!player1.isAlive()) {
                System.out.println(player2.getName() + " wins the battle!");
                battleOver = true;
            } else {
                System.out.println(player1.getName() + " wins the battle!");
                battleOver = true;
            }
        }
    }

    private Character cloneCharacter(Character c) {
        if (c instanceof Warrior) {
            Warrior w = (Warrior) c;
            return new Warrior(w.getName(), w.getHp(), w.getStamina(), w.getStrength());
        } else if (c instanceof Wizard) {
            Wizard w = (Wizard) c;
            return new Wizard(w.getName(), w.getHp(), w.getMana(), w.getIntelligence());
        }
        return null;
    }
}
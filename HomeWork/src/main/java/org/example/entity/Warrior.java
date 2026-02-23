package org.example.entity;

import java.util.Random;
public class Warrior extends Character {
    private int stamina;
    private int strength;

    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        this.stamina = stamina;
        this.strength = strength;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public void attack(Character target) {
        Random rand = new Random();
        boolean attemptHeavyAttack = rand.nextBoolean();
        int damage = 0;

        if (attemptHeavyAttack && this.stamina >= 5) {
            damage = this.strength;
            this.stamina -= 5;
            System.out.println(this.getName() + " uses a Heavy Attack! (Damage: " + damage + ")");
        } else if (this.stamina >= 1) {
            damage = this.strength / 2;
            this.stamina += 1;
            System.out.println(this.getName() + " uses a Weak Attack! (Damage: " + damage + ")");
        } else {
            this.stamina += 2;
            System.out.println(this.getName() + " has no stamina! Recovers 2 stamina.");
        }
        target.setHp(target.getHp() - damage);
    }
}
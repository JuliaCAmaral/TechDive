package model;

public abstract class Enemy extends Character {

    public Enemy(int healthPoints, int attackPoints, int defensePoints, WeaponEnum weapon) {
        super(healthPoints, attackPoints, defensePoints, weapon);
    }
}

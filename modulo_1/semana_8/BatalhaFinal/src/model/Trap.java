package model;

public class Trap implements Attacker {

    private int attack;
    private WeaponEnum weapon;

    public Trap() {
        this.attack = 5;
        this.weapon = WeaponEnum.TRAP;
    }

    public AttackResult attack(Character character) {
        int dice = (int) (Math.random() * 10 + 1);

        boolean missed = dice == 1;
        boolean dead = false;
        int damage = 0;

        if (!missed) {
            int attackPoints = this.attack + this.weapon.getAttack() + dice;

            damage = attackPoints - character.getDefensePoints();

            damage = Math.max(damage, 0);

            character.setHealthPoints(Math.max(character.getHealthPoints() - damage, 0));

            dead = character.getHealthPoints() <= 0;
        }

        int health = character.getHealthPoints();

        return new AttackResult(damage, health, dead, false, missed, weapon);
    }

}

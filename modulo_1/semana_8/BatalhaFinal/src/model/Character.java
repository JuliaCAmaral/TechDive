package model;

abstract class Character {

    private int healthPoints;
    private int attackPoints;
    private int defensePoints;
    private WeaponEnum weapon;
    private Armor armor;

    public Character(int healthPoints, int attackPoints, int defensePoints, WeaponEnum weapon) {
        this.healthPoints = healthPoints;
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
        this.weapon = weapon;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public int getDefensePoints() {
        if (armor == null) {
            return defensePoints;
        } else {
            return defensePoints + armor.getDefensePoints();
        }
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public WeaponEnum getWeapon() {
        return weapon;
    }

    public AttackResult attack(Character character) {
        int dice = (int) (Math.random() * 20 + 1);

        boolean missed = dice == 1;
        boolean critical = dice == 20;
        boolean dead = false;
        int damage = 0;

        if (!missed) {
            int attackPoints = getAttackPoints() + getWeapon().getAttack() + dice;

            damage = critical ? attackPoints : attackPoints - character.getDefensePoints();

            damage = Math.max(damage, 0);

            character.healthPoints = Math.max(character.healthPoints - damage, 0);

            dead = character.getHealthPoints() <= 0;
        }

        int health = character.getHealthPoints();

        return new AttackResult(damage, health, dead, critical, missed, weapon);
    }
}

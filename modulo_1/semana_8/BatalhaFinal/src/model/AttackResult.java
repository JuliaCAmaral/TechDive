package model;

public class AttackResult {

    private final int damage;

    private final int health;

    private final boolean dead;

    private final boolean critical;

    private final boolean missed;

    private final WeaponEnum weapon;

    public AttackResult(int damage, int health, boolean dead, boolean critical, boolean missed, WeaponEnum weapon) {
        this.damage = damage;
        this.health = health;
        this.dead = dead;
        this.critical = critical;
        this.missed = missed;
        this.weapon = weapon;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public boolean isDead() {
        return dead;
    }

    public boolean isCritical() {
        return critical;
    }

    public boolean isMissed() {
        return missed;
    }

    public WeaponEnum getWeapon() {
        return weapon;
    }
}

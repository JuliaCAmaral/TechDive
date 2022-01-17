package model;

public abstract class Player extends Character {

    private String name;
    private String gender;
    private GoalEnum goalEnum;

    public Player(int attackPoints, int defensePoints, String name, String gender, WeaponEnum weapon) {
        super(300, attackPoints, defensePoints, weapon);
        if (name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.name = name;

        if (gender.equalsIgnoreCase("M") || gender.equalsIgnoreCase("F")) {
            this.gender = gender;
        }
    }

    public void restoreHealth() {
        super.setHealthPoints(100);
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public GoalEnum getGoalEnum() {
        return goalEnum;
    }

    public void setGoalEnum(GoalEnum goalEnum) {
        this.goalEnum = goalEnum;
    }
}

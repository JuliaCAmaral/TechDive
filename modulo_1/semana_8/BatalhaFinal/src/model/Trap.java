package model;

public class Trap implements Attacker {

    private int attackPoints;
    private WeaponEnum weapon;

    public Trap() {
        this.attackPoints = 5;
        this.weapon = WeaponEnum.TRAP;
    }

    @Override
    public void attack(Character character) {
        int dice = (int) (Math.random() * 10 + 1);

        if (dice == 1) {
            System.out.println("\nO ataque da armadilha pegou de raspão e você não sofreu dano.\n");
        } else {
            int totalPoints = attackPoints + dice;

            int healthPoints = character.getHealthPoints() - totalPoints;
            character.setHealthPoints(healthPoints);

            System.out.printf("\nVocê sofreu %d de dano e agora possui %d pontos de vida.\n", totalPoints, healthPoints);
        }
    }
}

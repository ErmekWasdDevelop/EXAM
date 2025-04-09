public class Warrior extends Hero {
    public Warrior(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.CRITICAL_DAMAGE);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int coeff = RPG_Game.random.nextInt(2, 6);
        boss.setHealth(boss.getHealth() - coeff * this.getDamage());
        System.out.println("Warrior " + this.getName() + " hits critically "
                           + coeff * this.getDamage());
    }
}

public class Boss extends GameEntity {
    private SuperAbility defence;

    public Boss(String name, int health, int damage) {
        super(name, health, damage);
    }

    public void attack(Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                if (heroes[i] instanceof Berserk b
                    && this.defence != SuperAbility.BLOCK_AND_REVERT) {
                    int chance = RPG_Game.random.nextInt(1, 3); // 1, 2
                    b.setBlockedDamage(5 * chance);
                    heroes[i].setHealth(heroes[i].getHealth() -
                                        (this.getDamage() - b.getBlockedDamage()));
                } else {
                    heroes[i].setHealth(heroes[i].getHealth() - this.getDamage());
                }
            }
        }
    }

    public void chooseDefence() {
        SuperAbility[] variants = SuperAbility.values();
        int randomIndex = RPG_Game.random.nextInt(variants.length);
        this.defence = variants[randomIndex];
    }

    public SuperAbility getDefence() {
        return defence;
    }

    @Override
    public String toString() {
        return "BOSS " + super.toString() + " defence: " + this.defence;
    }
}

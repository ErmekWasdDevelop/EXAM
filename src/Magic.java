public class Magic extends Hero {
    public Magic(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.BOOST);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (RPG_Game.getRoundNumber()<5)
       { int n = RPG_Game.random.nextInt(2,5);
           boss.setHealth(boss.getHealth() - getDamage() * n);
           System.out.println("SuperBoost : "+n+"X");
       }

    }
}

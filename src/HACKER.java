public class HACKER extends Hero {
    public HACKER(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.HEALTH_STEAL);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int stealHealth = RPG_Game.random.nextInt(5, 11);
        int a = RPG_Game.random.nextInt(heroes.length);
        int b;
        do {
            b = RPG_Game.random.nextInt(heroes.length);
        } while (a != b);
        if (RPG_Game.getRoundNumber() != 1 && RPG_Game.getRoundNumber() % 2 == 0) {
            if (boss.getHealth() >= 5) {
                boss.setHealth(boss.getHealth() - stealHealth);
                for (int i = 0; i < heroes.length; i++) {
                    if (heroes[i].getHealth() > 0 && this != heroes[i]) {
                        if (heroes[a].getHealth() > 0 && heroes[b].getHealth() > 0) {
                            if (stealHealth % 2 == 0) {
                                heroes[a].setHealth(heroes[a].getHealth() + (stealHealth / 2));
                                heroes[b].setHealth(heroes[b].getHealth() + (stealHealth / 2));
                            } else {
                                heroes[a].setHealth(heroes[a].getHealth() + (stealHealth / 2));
                                heroes[b].setHealth(heroes[b].getHealth() + (stealHealth / 2 + 1));
                            }
                        } else if (heroes[a].getHealth() == heroes[i].getHealth()
                                && heroes[b].getHealth() <= 0) {
                            heroes[a].setHealth(heroes[b].getHealth() + stealHealth);
                        } else if (heroes[b].getHealth() == heroes[i].getHealth()
                                && heroes[a].getHealth() <= 0) {
                            heroes[b].setHealth(heroes[b].getHealth() + stealHealth);
                        }
                    }
                }
            }
        }

        System.out.println("HEALTH WAS STEAL :" + stealHealth + "HEALTH");
    }
}


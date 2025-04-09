import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HACKER extends Hero {
    public HACKER(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.HEALTH_STEAL);
    }


    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int stealHealth = RPG_Game.random.nextInt(5, 11);
        /*
        int a = RPG_Game.random.nextInt(heroes.length);
        int b;
        do {
            b = RPG_Game.random.nextInt(heroes.length);
        } while (a != b);
        */
        if (RPG_Game.getRoundNumber() != 1 && RPG_Game.getRoundNumber() % 2 == 0) {
            if (boss.getHealth() >= 5) {
                boss.setHealth(boss.getHealth() - stealHealth);
                List<Hero> alive = new ArrayList<>();
                for (Hero hero : heroes) {
                    if (hero.getHealth() > 0 && hero != this) {
                        alive.add(hero);
                    }
                }
                if (alive.size() >= 2) {
                    Collections.shuffle(alive);
                    Hero hero1 = alive.get(0);
                    Hero hero2 = alive.get(1);
                    if (stealHealth/2 == 0) {
                        hero1.setHealth(hero1.getHealth() + stealHealth / 2);
                        hero1.setHealth(hero2.getHealth() + stealHealth / 2);
                    }else {
                        hero1.setHealth(hero1.getHealth() + stealHealth / 2);
                        hero1.setHealth(hero2.getHealth() + stealHealth / 2 +1);
                    }
                } else if (alive.size() == 1) {
                    Hero hero = alive.getFirst();
                    hero.setHealth(hero.getHealth() + stealHealth);
                }
                /*
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
                */
            }
        }
        System.out.println("HEALTH WAS STEAL :" + stealHealth + "HEALTH");
    }
}



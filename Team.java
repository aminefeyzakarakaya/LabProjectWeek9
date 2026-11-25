package labweek9;

import java.util.ArrayList;

public class Team {
    private ArrayList<GameCharacter> members = new ArrayList<>();

    public void addCharacter(GameCharacter character) {
        if (findByName(character.getName()) != null) {
            System.out.println("Error: a character named " + character.getName() + " is already in the team.");
            return;
        }
        members.add(character);
        System.out.println(character.getName() + " joined the team.");
    }

    public void removeCharacter(String name) {
        GameCharacter c = findByName(name);
        if (c == null) {
            System.out.println("Error: no character named " + name + " in the team.");
            return;
        }
        members.remove(c);
        System.out.println(name + " was removed from the team.");
    }

    public GameCharacter findByName(String name) {
        for (GameCharacter c : members) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }

    public void attackAll(GameCharacter target) {
        for (GameCharacter c : members) {
            if (c.isAlive() && c instanceof Attacker) {
                int damage = ((Attacker) c).attack(target);
                System.out.println(c.getName() + " attacks " + target.getName() + " for " + damage + " damage.");
            }
        }
    }

    public void healTeam() {
        for (GameCharacter c : members) {
            if (c.isAlive() && c instanceof Supporter) {
                GameCharacter lowest = null;
                for (GameCharacter m : members) {
                    if (m.isAlive()) {
                        if (lowest == null || (double) m.getHealth() / m.getMaxHealth()
                                < (double) lowest.getHealth() / lowest.getMaxHealth()) {
                            lowest = m;
                        }
                    }
                }
                if (lowest != null) {
                    int restored = ((Supporter) c).heal(lowest);
                    System.out.println(c.getName() + " heals " + lowest.getName() + " for " + restored + " health.");
                }
            }
        }
    }

    public int getTotalPower() {
        int total = 0;
        for (GameCharacter c : members) {
            if (c.isAlive()) {
                total += c.calculatePower();
            }
        }
        return total;
    }

    public void displayTeam() {
        for (GameCharacter c : members) {
            System.out.println(c.getCharacterInfo());
        }
    }
}

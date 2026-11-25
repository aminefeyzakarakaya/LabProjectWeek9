package labweek9;



public class Warrior extends GameCharacter implements Attacker {
    
    private int armor;

    public Warrior(String name, int level, int maxHealth, int armor) {
        super(name, level, maxHealth);
        this.armor = armor;
    }

    @Override
    public int calculatePower() {
        return getLevel() * 10 + armor * 2;
    }

    @Override
    public int takeDamage(int damage) {
        int reduced = damage - armor / 2;
        if (reduced < 1) {
            reduced = 1; 
        }
        return super.takeDamage(reduced);
    }

    @Override
    public int attack(GameCharacter target) {
        if (!isAlive() || !target.isAlive()) {
            return 0;
        }
        return target.takeDamage(calculatePower() / 4);
    }

    @Override
    public String getCharacterInfo() {
        return "Warrior [" + getName() + "] Level: " + getLevel()
                + ", Health: " + getHealth() + "/" + getMaxHealth()
                + ", Armor: " + armor + ", Power: " + calculatePower();
    }
}

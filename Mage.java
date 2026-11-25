package labweek9;

public class Mage extends GameCharacter implements Attacker, Supporter {
    private int mana;

    public Mage(String name, int level, int maxHealth, int mana) {
        super(name, level, maxHealth);
        this.mana = mana;
    }

    @Override
    public int calculatePower() {
        return getLevel() * 8 + mana;
    }

    @Override
    public int attack(GameCharacter target) {
        if (!isAlive() || !target.isAlive()) {
            return 0;
        }
        if (mana < 20) {
            System.out.println(getName() + " does not have enough mana to attack!");
            return 0;
        }
        int power = calculatePower(); 
        mana -= 20;
        return target.takeDamage(power / 3);
    }

    @Override
    public int heal(GameCharacter target) {
        if (!isAlive()) {
            return 0;
        }
        if (mana < 15) {
            System.out.println(getName() + " does not have enough mana to heal!");
            return 0;
        }
        mana -= 15;
        return target.restoreHealth(getLevel() * 2);
    }

    @Override
    public String getCharacterInfo() {
        return "Mage [" + getName() + "] Level: " + getLevel()
                + ", Health: " + getHealth() + "/" + getMaxHealth()
                + ", Mana: " + mana + ", Power: " + calculatePower();
    }
}

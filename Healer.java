package labweek9;

public class Healer extends GameCharacter implements Supporter {
    private int healAmount;

    public Healer(String name, int level, int maxHealth, int healAmount) {
        super(name, level, maxHealth);
        this.healAmount = healAmount;
    }

    @Override
    public int calculatePower() {
        return getLevel() * 5 + healAmount;
    }

    @Override
    public int heal(GameCharacter target) {
        if (!isAlive()) {
            return 0;
        }
        return target.restoreHealth(healAmount + getLevel());
    }

    @Override
    public String getCharacterInfo() {
        return "Healer [" + getName() + "] Level: " + getLevel()
                + ", Health: " + getHealth() + "/" + getMaxHealth()
                + ", HealAmount: " + healAmount + ", Power: " + calculatePower();
    }
}

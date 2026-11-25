package labweek9;

public class Main {
    
    public static void main(String[] args) {
        Team team = new Team();
        team.addCharacter(new Warrior("Arthur", 10, 120, 10));
        team.addCharacter(new Mage("Merlin", 8, 80, 60));
        team.addCharacter(new Healer("Elara", 7, 90, 15));

        Warrior golem = new Warrior("Golem", 12, 400, 20);

        String[] names = {"Arthur", "Merlin", "Elara"};

        for (int round = 1; round <= 2; round++) {
            System.out.println("\n===== ROUND " + round + " =====");

            System.out.println("-- Team attacks --");
            team.attackAll(golem);
            System.out.println("Golem health: " + golem.getHealth() + "/" + golem.getMaxHealth());

            System.out.println("-- Golem attacks --");
            for (String n : names) {
                GameCharacter member = team.findByName(n);
                if (member != null) {
                    int damage = golem.attack(member);
                    System.out.println("Golem attacks " + member.getName() + " for " + damage + " damage.");
                }
            }

            System.out.println("-- Team heals --");
            team.healTeam();

            System.out.println("-- Team status --");
            team.displayTeam();
        }

        System.out.println("\n===== AFTER BATTLE =====");
        team.removeCharacter("Arthur");

        GameCharacter found = team.findByName("Merlin");
        System.out.println("Search Merlin: " + (found != null ? found.getCharacterInfo() : "not found"));
        GameCharacter notFound = team.findByName("Arthur");
        System.out.println("Search Arthur: " + (notFound != null ? notFound.getCharacterInfo() : "not found"));

        team.displayTeam();
        System.out.println("Total power of alive members: " + team.getTotalPower());

        System.out.println("\n===== INVALID INPUT TESTS =====");
        team.addCharacter(new Healer("Elara", 5, 70, 10)); 
        Warrior invalid = new Warrior("Bad", 150, -5, 5);  
        System.out.println(invalid.getCharacterInfo());
    }
}

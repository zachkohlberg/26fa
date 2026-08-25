public class MonsterTest {
    public static void main(String[] args) {
        Monster a = new Monster("Goblin", 100, 10);

        System.out.printf("%s is here to show how monsters work!\n", a.getName());
        System.out.printf("%s has the following stats:\n", a.getName());
        System.out.printf("\thealth: %.2f\n", a.getHealth());
        System.out.printf("\tstrength: %.2f\n", a.getStrength());
        System.out.println();

        System.out.println("We can also print the monster like this:");
        System.out.println(a);
        System.out.println("If that doesn't look right, then you need to fix your toString().");

        System.out.printf(
                "%s accidentally punches itself to demonstrate attacking:\n", a.getName());

        // monster a attacks something
        double dmg = a.attack();

        // monster a receives the damage from an attack
        a.damage(dmg);

        // we report the incident
        System.out.printf("%s attacked %s for %.2f damage.\n", a.getName(), a.getName(), dmg);
        System.out.println(a);

        // falling rocks are a workplace hazard
        double boulderDamage = 100;
        a.damage(boulderDamage);
        System.out.printf(
                "A large boulder landed on %s, dealing %.2f damage!\n", a.getName(), boulderDamage);

        if (a.isAlive()) {
            System.out.printf("%s survived the boulder.\n", a.getName());
        } else {
            System.out.printf("%s was squashed by the boulder.\n", a.getName());
        }
    }
}

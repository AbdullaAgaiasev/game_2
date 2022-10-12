import java.sql.SQLOutput;
import java.util.Random;

public class Main {
    public static void Main(String[] args) {
        System.out.println("Hello word");

    }

        public static int bossHealth = 800;
        public static int bossDamage = 50;
        public static String bossDefenceType;
    public static String[] heroesAttackType = {"Physical", "Magical", "Kinetic", "Medic", "Golem", "Lucky", "Berserk", "Thor"};
        public static int[] heroesHealth = {250, 270, 280, 300, 390, 280, 265, 273};
        public static int[] heroesDamage = {30, 25, 20, 0, 10, 18, 35, 39};
        public static int roundNumber = 0;





        public static void main (String[]args){
        printStatistics();
        while (!isGameFinished()) {
            playRound();
        }
    }

        public static void playRound () {
        roundNumber++;
        chooseBossDefence();
        bossHits();
        heroesHit();
        medicHils();
        damagGolem();
        lucky();
        berserkShoot();
        Thor();
        printStatistics();
        //setHeroesRegeneration ();
    }
    //public static void setHeroesRegeneration () {


        public static void printStatistics () {
        System.out.println("ROUND " + roundNumber + " ---------------");
        System.out.println("Boss health: " + bossHealth + "; damage: "
                + bossDamage + "; defence: " + (bossDefenceType == null ? "No defence" : bossDefenceType));
        for (int i = 0; i < heroesHealth.length; i++) {
            System.out.println(heroesAttackType[i] + " health: " + heroesHealth[i] + "; damage: "
                    + heroesDamage[i]);


                    }

                }
                public static void medicHils() {
                    for (int i = 0; i < heroesHealth.length; i++) {
                        if(i==3) {
                            continue;
                        }
                        if (heroesHealth[i]>0 && heroesHealth[i]<100){
                            heroesHealth[i]= heroesHealth[i] + 20;
                            System.out.println(" Медик вылечил " + heroesAttackType);
                            break;
                        }

                    }
                }
                public static void damagGolem() {
                    for (int i = 0; i < heroesAttackType.length; i++) {
                        if (heroesHealth[4] > 0 && heroesHealth[i] > 0 && heroesHealth[4] != heroesHealth[i]) {
                            heroesHealth[i] = heroesHealth[i] - bossDamage / 5;
                            heroesHealth[4] = heroesHealth[4] - bossDamage / 5;

                            System.out.println(" Golem ударил " );
                        }
                    }
                    }
                    public static void lucky() {
                    Random random = new Random();
                    int randomLucky = random.nextInt(4) + 1;
                    switch (randomLucky) {
                        case 1:
                            heroesHealth[5] = heroesHealth[5] + bossDamage;
                            System.out.println("Lucky уклонился");
                        case 2:

                        case 3:

                        case 4:
                    }

                    }
    public static void berserkShoot () {
        Random random = new Random();
        int randomDamage = random.nextInt(15) + 1;
        int randomC = random.nextInt(3) + 1;
        if (heroesHealth[6] > 0 && bossHealth > 0) {
            switch (randomC) {
                case 1:
                    heroesDamage[6] = (heroesDamage[6] + bossDamage) - randomDamage;
                    System.out.println("Урон от Берсерка критический " + randomDamage);
                    break;
                case 2:
                    bossDamage = 50;
                    break;
                case 3:
                    bossDamage = 50;
                    break;
            }
        }

    }
                public static void Thor() {
                Random random = new Random();
                boolean Thor = random.nextBoolean();
                if (Thor) {
                    bossDamage = 0;
                    System.out.println("Босс оглушен");
                    } else {
                    bossDamage = 50;
                }

    }




                //}

           // }
        //}
        //}
    //}


        public static void chooseBossDefence () {
        Random random = new Random();
        int randomIndex = random.nextInt(heroesAttackType.length); // 0,1,2
        bossDefenceType = heroesAttackType[randomIndex];
    }

        public static boolean isGameFinished () {
        if (bossHealth <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }

        boolean allHeroesDead = true;
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

        public static void bossHits () {
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0) {
                if (heroesHealth[i] - bossDamage < 0) {
                    heroesHealth[i] = 0;
                } else {
                    heroesHealth[i] = heroesHealth[i] - bossDamage;
                }
            }
        }
    }

        public static void heroesHit () {
        for (int i = 0; i < heroesDamage.length; i++) {
            if (heroesHealth[i] > 0 && bossHealth > 0) {
                int hit = heroesDamage[i];
                if (heroesAttackType[i] == bossDefenceType) {
                    Random random = new Random();
                    int coeff = random.nextInt(6) + 2; // 2,3,4,5,6,7
                    hit = heroesDamage[i] * coeff;
                    System.out.println("Critical damage: " + hit);
                }
                if (bossHealth - hit < 0) {
                    bossHealth = 0;
                } else {
                    bossHealth = bossHealth - hit;
                }

            }
        }
    }
    }
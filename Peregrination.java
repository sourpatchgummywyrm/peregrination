package Adventure;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Peregrination {

	public static void main (String [] args) {
		

		System.out.println("Welcome to your long and endless journey to become the greatest hero or heroine of all time. Your neverending peregrination begins in a remote village overrun by ogres.");
		int str = 1, agi = 1, spd = 1, intel = 1, def = 1, chealth = 20, basehealth = 20, tmoney = 0, txp = 0, level = 1, pointscount = 10;
		System.out.println("First, you need to distribute your stats and pick your skills. Your choices here will also determine your back story");
		System.out.println("(s)Strength: " + str + "\n(a)Agility: " + agi + "\n(p)Speed: " + spd + "\n(i)Intelligence: " + intel + "\n(d)Defense: " + def + "\nYou have 10 points to distribute.");
		
		while (chealth > 0) {
			Scanner keys = new Scanner(System.in);
			char points;

			int restoreh;
			String combatd;
			
			
			ArrayList<String> monTypes = new ArrayList<String>();
			String[] stats = {"HP", "Def", "Agi", "Spd", "Str", "Exp", "Gold"};
			monTypes.add("Ogre");
			monTypes.add("Princess");
			monTypes.add("Dragon");
			
			Random rand = new Random();
			MonsterGen newMon = new MonsterGen();
			int[] enemyStat = new int[7];
			while(pointscount>0){
				System.out.println("Pick an attribute: ");
				points = keys.next().charAt(0);
				if(points == 's') {
					str++;
					System.out.println("  You have "+str+" strength points. Points left: " + (pointscount-1));
				}
				if(points == 'a') {
					agi++;
					System.out.println("  You have "+agi+" agility points. Points left: " + (pointscount-1));
				}
				if(points == 'p') {
					spd++;
					System.out.println("  You have "+spd+" speed points. Points left: " + (pointscount-1));
				}
				if(points == 'i') {
					intel++;
					System.out.println("  You have "+intel+" intelligence points. Points left: " + (pointscount-1));
				}
				if(points == 'd') {
					def++;
					System.out.println("  You have "+def+" defense points. Points left: " + (pointscount-1));
				}
				pointscount--;
			}
			String chosenMon = monTypes.get(rand.nextInt(monTypes.size()));
			newMon.createMonster(monTypes.indexOf(chosenMon));
			System.out.println("\n\nYou encounter a(n) " + chosenMon);
			for (int i = 0; i < newMon.monStats.size(); i++)
			{
				enemyStat[i] = newMon.monStats.get(i);
				System.out.print(stats[i] + ": ");
				System.out.println(enemyStat[i]);
			}
			
			
			System.out.println("Attack by entering a, defend by entering b");
			while(chealth>0 && enemyStat[0]>0) {
				combatd = keys.next().intern();
				if(combatd == "a") {
					if(spd>enemyStat[2] && str>enemyStat[1]) {
						enemyStat[0] = enemyStat[0]-(str-enemyStat[1]);
						System.out.println("You hit the " + chosenMon + " for "+(str-enemyStat[1])+" hitpoints! The " + chosenMon + " has "+enemyStat[0]+" health left");
					}
					if(enemyStat[3]>agi && enemyStat[4]>def) {
						chealth = chealth-(enemyStat[4]-def);
						System.out.println("The " + chosenMon + " bashes you for "+(enemyStat[4]-def)+" hitpoints! You have "+chealth+" health left");
					}
					if(spd<=enemyStat[2]) {
						System.out.println("You inflict a critical... miss!");
					}
					if(str<=enemyStat[1]) {
						System.out.println("Your weak attempt connects with the enemy, but they don't seem to notice or be affected at all. You even scratch youself in the process." );
						chealth--;
						System.out.println("You have "+chealth+" health left");
					}
					if(enemyStat[3]<=agi) {
						System.out.println("The " + chosenMon + " scores a hit on you... if you were 2 feet right of where you were actually standing");
					}
					if(enemyStat[4]<def && enemyStat[3]>=agi) {
						System.out.println("The " + chosenMon + " hits you, but your iron pecs absorb the blow effortlessly. The " + chosenMon + " loses one health for punching stone");
						enemyStat[0]--;
						System.out.println("The " + chosenMon + " has "+enemyStat[0]+" health left");
					}	
				}
				if(combatd == "b") {
					if(enemyStat[3]>agi && enemyStat[4]>def) {
						chealth = chealth-(enemyStat[4]-def);
						System.out.println("The " + chosenMon + " bashes you for "+(enemyStat[4]-def)+" hitpoints! You have "+chealth+" health left");
					}
					if(enemyStat[3]<=agi) {
						System.out.println("The " + chosenMon + " scores a hit on you... if you were 2 feet right of where you were actually standing");
					}
					if(enemyStat[4]>def && enemyStat[3]<=agi) {
						System.out.println("The " + chosenMon + " hits you, but your iron pecs absorb the blow effortlessly. The " + chosenMon + " loses one health for punching stone");
						enemyStat[0]--;
					}
					PlayerStats heal = new PlayerStats();
					restoreh = heal.genRestoreHP(0, 1);
					if(restoreh>0) {
					System.out.println("You eat a hearty meal in the middle of the battle and restore some health.");
					chealth=chealth+restoreh;
					}
					else {
						System.out.println("You attempt to apply some bandages but you mess up and waste your turn.");
					}
				}
			}
			if(chealth == 0 && enemyStat[0] > 0) {
				System.out.println("The " + chosenMon + " has killed you. Maybe you just weren't hero material after all");
			}
			if(chealth < 0) {
				System.out.println("The " + chosenMon + " kills you, t-bags your dead body, and proceeds to cut up your remains and tear into them like a four-year-old on a sugar rampage!");
				
			}
			if(enemyStat[0] == 0 && chealth > 0) {
				System.out.println("You have vanquished a " + chosenMon + ", do you think you're cool? Anyway, you recieved "+enemyStat[6]+" experience points and "+enemyStat[5]+" gold");
				txp = txp+enemyStat[6];
				tmoney = tmoney+enemyStat[5];
			}
			if(enemyStat[0] < 0) {
				System.out.println("You pound the " + chosenMon + " into a fine powder. What overkill! You recieved "+(enemyStat[6]+1)+" experience points and "+enemyStat[5]+" gold");
				txp = txp+enemyStat[6];
				txp++;
				tmoney = tmoney+enemyStat[5];
			}
			if(enemyStat[0] <= 0 && chealth <= 0) {
				System.out.println("Looks like you both killed each other at the same time! What a coincidence!");
			}
			if(chealth>0) {
				chealth = basehealth;
			}
			newMon.monStats.clear();
			enemyStat = new int[7];
			if(txp==100) {
				level++;
				System.out.println("Congratulations on gaining a new experience level. You want a cookie? Fine I'll bless your miserly quest with 10 more attribute points. I'll even double your HP out of pity. Even though your more massive, the extra pecs will attract way more powerful monsters, so have fun fighting overpowered beasts! XD");
				pointscount = pointscount + 10;
			}
		}
	}

}

package Adventure;

import java.util.Random;

public class Monster {

	public Monster() {	
	}
		
		int hp;
		int mdef;
		int mspd;
		int magi;
		int mstr;
		int exp;
		int mone;
		Random rand = new Random();
		
		public int genHP(int frange, int erange)
		{
			hp = rand.nextInt(erange - frange) + frange;
			return hp;
		}
		
		public int genDef(int frange, int erange)
		{
			mdef = rand.nextInt(erange - frange) + frange;
			return mdef;
		}

		public int genSpd(int frange, int erange)
		{
			mspd = rand.nextInt(erange - frange) + frange;
			return mspd;
		}
		public int genAgi(int frange, int erange)
		{
			magi = rand.nextInt(erange - frange) + frange;
			return magi;
		}
		public int genStr(int frange, int erange)
		{
			mstr = rand.nextInt(erange - frange) + frange;
			return mstr;
		}

		public int getExp(int frange, int erange)
		{
			exp = rand.nextInt(erange - frange) + frange;
			return exp;
		}

		public int getMone(int frange, int erange)
		{
			mone = rand.nextInt(erange - frange) + frange;
			return mone;
		}
		
}


package Adventure;
import java.util.ArrayList;

public class MonsterGen {

	public MonsterGen()
	{
		
	}
	
	public ArrayList<Integer> monStats = new ArrayList<Integer>();
	
	public void createMonster(int type)
	{
		Monster mon = new Monster();
		monStats.add(mon.genHP(5+type, 20)*(1+type));
		monStats.add(mon.genDef(1+type, 4)*(1+type));
		monStats.add(mon.genAgi(0+type, 3)*(1+type));
		monStats.add(mon.genSpd(4+type, 7)*(1+type));
		monStats.add(mon.genStr(4+type, 9)*(1+type));
		monStats.add(mon.getExp(2+type, 5)*(1+type));
		monStats.add(mon.getMone(1+type, 10)*(1+type));
	}
}

package Adventure;
import java.util.Random;
public class PlayerStats {

	public PlayerStats() {
		// TODO Auto-generated constructor stub
	}
	int restoreh;
	Random r = new Random();
	public int genRestoreHP(int frange, int erange) {
		restoreh = r.nextInt(erange) + frange;
		return restoreh;
	}
}

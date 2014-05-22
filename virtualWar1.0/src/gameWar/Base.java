package gameWar;

/**
 * @author Robin
 *
 */
public class Base extends Cellule {
	
	
	
	/**
	 * @param equipe
	 */
	public Base (int equipe) {
		this.base=equipe;
	}
	
	/* (non-Javadoc)
	 * @see gameWar.Cellule#placerSur(gameWar.Robot)
	 */
	public void placerSur(Robot r) {
		this.r.add(r);
	}
	
	public void retirerRobot(Robot r){
		this.r.remove(r);
	}

	public void videCase() {
		for (int i=0; i<this.r.size(); i++)
			this.r.remove(0);
	}
	
	public boolean estDans (int num) {
		for (int i=0; i<this.r.size(); i++)
			if (this.r.get(i).getNum()==num)
				return true;
		return false;
	}
	
	public Robot getContenu() {
		if (r.size()!=0)
			return r.get(0);
		else
			return null;
	}
	
	public Robot getRobot(int equipe, int num) {
		if (r.size()==0)
			return null;
		else {
			for (int i=0; i<r.size(); i++) {
			if(this.r.get(i).getEquipe()==equipe && this.r.get(i).getNum()==num)
				return this.r.get(i);
			}
		}
		return null;
	}
}

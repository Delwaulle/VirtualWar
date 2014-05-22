package gameWar;

public class Case extends Cellule {

	/* (non-Javadoc)
	 * @see gameWar.Cellule#placerSur(gameWar.Robot)
	 */
	void placerSur(Robot r) {
		this.r.add(r);
	}

	/* (non-Javadoc)
	 * @see gameWar.Cellule#videCase()
	 */
	void videCase() {
		this.r.remove(0);
		this.mine=0;
		this.base=0;
	}
	
	public void retirerRobot(Robot r) {
		this.r.remove(r);
	}
	
	public boolean estDans (int num) {
		return this.r.get(0).getNum()==num;
	}
	
	public Robot getContenu() {
		if (r.size()!=0)
			return r.get(0);
		else
			return null;
	}
	
	public Robot getRobot(int equipe, int num) {
		if (this.r.size()!=0 && this.r.get(0).getEquipe()==equipe && this.r.get(0).getNum()==num)
			return this.r.get(0);
		else
			return null;
	}
}

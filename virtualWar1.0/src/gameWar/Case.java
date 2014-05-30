package gameWar;

/**
 * @author Robin
 *
 */
public class Case extends Cellule {

	/* (non-Javadoc)
	 * @see gameWar.Cellule#placerSur(gameWar.Robot)
	 */
	@Override
	void placerSur(Robot r) {
		this.r.add(r);
	}

	/* (non-Javadoc)
	 * @see gameWar.Cellule#videCase()
	 */
	@Override
	void videCase() {
		this.r.remove(0);
		this.mine=0;
		this.base=0;
	}

	/* (non-Javadoc)
	 * @see gameWar.Cellule#retirerRobot(gameWar.Robot)
	 */
	@Override
	public void retirerRobot(Robot r) {
		this.r.remove(r);
	}

	/* (non-Javadoc)
	 * @see gameWar.Cellule#estDans(int)
	 */
	@Override
	public boolean estDans (int num) {
		return this.r.get(0).getNum()==num;
	}

	/* (non-Javadoc)
	 * @see gameWar.Cellule#getContenu()
	 */
	@Override
	public Robot getContenu() {
		if (r.size()!=0)
			return r.get(0);
		else
			return null;
	}

	/* (non-Javadoc)
	 * @see gameWar.Cellule#getRobot(int, int)
	 */
	@Override
	public Robot getRobot(int equipe, int num) {
		if (this.r.size()!=0 && this.r.get(0).getEquipe()==equipe && this.r.get(0).getNum()==num)
			return this.r.get(0);
		else
			return null;
	}
}

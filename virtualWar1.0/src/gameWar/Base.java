package gameWar;

public class Base extends Cellule {
	
	public Base (int equipe) {
		this.base=equipe;
	}

	void placerSur(Robot r) {
		this.r=r;
	}

	void videCase() {
		this.r=null;
		this.mine=0;
	}

}

package gameWar;

public class Base extends Cellule {

	void placerSur(Robot r) {
		this.r=r;
	}

	void videCase() {
		this.r=null;
		this.mine=0;
	}

}

package gameWar;

public class Game {

	public static void main(String[] args) {
		Plateau p = new Plateau();
		if(!p.plateauValide())
			System.out.print("GG");
	}
}

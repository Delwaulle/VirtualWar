package gameController;

import java.util.Scanner;

public class EntrerAction {
	public static String entrerAction () {
		System.out.println("Entrez une action (attaquer ou deplacer");
		Scanner sc = new Scanner(System.in);
		String rep="";
		while (!rep.equals("attaquer") && !rep.equals("deplacer"))
			rep = sc.nextLine();
		return rep;
	}
}

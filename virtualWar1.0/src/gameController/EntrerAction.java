package gameController;

import java.util.Scanner;

public class EntrerAction {
	public static String entrerAction () {
		Scanner sc = new Scanner(System.in);
		String rep="";
		while (!rep.equals("attaquer") && !rep.equals("deplacer"))
			rep = sc.nextLine();
		return rep;
	}
}

package gameController;

import java.util.Scanner;

public class EntrerRobot {

	public static String entrerRobot() {
		Scanner sc = new Scanner(System.in);
		String rep="";
		while (!rep.equals("tireur") && !rep.equals("piegeur")) 
			rep = sc.nextLine();
		return rep;
	}
}

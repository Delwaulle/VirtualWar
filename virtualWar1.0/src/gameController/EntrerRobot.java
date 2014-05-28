package gameController;

import java.util.Scanner;

public class EntrerRobot {

	public static String rep="";
	public static String entrerRobot() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		rep=sc.nextLine().toLowerCase();
		while (!rep.equals("tireur") && !rep.equals("piegeur") && !rep.equals("char")) {
			System.out.println("Saisie incorrecte, veuillez recommencez.");
			rep = sc.nextLine().toLowerCase();
		}
		return rep;
	}
}

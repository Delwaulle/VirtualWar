package gameController;
import java.util.Scanner;

public class EntrerDirection {

	public static int entrerDirection() {
		Scanner sc = new Scanner(System.in);
		String rep=sc.nextLine();
		if (rep.equals("haut"))
			return 0;
		else if (rep.equals("bas"))
			return 2;
		else if (rep.equals("droite"))
			return 1;
		else
			return 3;
		
	}
}

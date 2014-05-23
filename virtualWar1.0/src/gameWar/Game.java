package gameWar;

import gameGraphic.AffichageBronzeV;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class Game {

	public static void main(String[] args) {
		JFrame fr = new JFrame("Virtual War");
		fr.setIconImage(new ImageIcon("rsc/images/icon.png").getImage());
		fr.getContentPane().add(new AffichageBronzeV(0));
		fr.setBounds(200,80,800,600);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setResizable(false);
		fr.setVisible(true);
		gameGraphic.AfficherLogo.afficherLogo();
		String partie = gameController.EntrerIA.entrerIA();
		if (partie.equals("jcj"))
			partieJcJ();
		else if (partie.equals("jcia"))
			partieJcIARandom();
		else if (partie.equals("iacia"));
		partieIAcIA();
	}

	public static void partieJcJ () {
		Plateau p = new Plateau();
		System.out.print(p.toString(1, 0));
		Joueur.creerRobots(p, 1);
		Joueur.creerRobots(p, 2);
		while (!p.fini) {
			Joueur.jouer(p, 1);
			testFini(p);
			Joueur.jouer(p, 2);
			testFini(p);
			try{
				Thread.sleep(2000);
			}
			catch(Exception e){System.out.println(e.getMessage());}
		}
	}

	public static void partieJcIARandom() {
		Plateau p = new Plateau();
		System.out.print(p.toString(1, 0));
		Joueur.creerRobots(p, 1);
		IARandom.creerRobots(p, 2);
		while (!p.fini) {
			Joueur.jouer(p, 1);
			testFini(p);
			IARandom.jouer(p, 2);
			testFini(p);
			try{
				Thread.sleep(2000);
			}
			catch(Exception e){System.out.println(e.getMessage());}
		}
	}

	public static void partieIAcIA() {
		Plateau p = new Plateau();
		System.out.print(p.toString(1, 0));
		IARandom.creerRobots(p, 1);
		IARandom.creerRobots(p, 2);
		while (!p.fini) {
			IARandom.jouer(p, 1);
			testFini(p);
			System.out.print(p.toString(0, 0));
			try{
				Thread.sleep(2000);
			}
			catch(Exception e){System.out.println(e.getMessage());}
			IARandom.jouer(p, 2);
			testFini(p);
			System.out.print(p.toString(0, 0));
			try{
				Thread.sleep(2000);
			}
			catch(Exception e){System.out.println(e.getMessage());}
		}
	}

	private static void testFini(Plateau p) {
		int equipe1 = 0;
		int equipe2 = 0;
		for (int i=0; i<p.grille.length; i++) {
			for (int j=0; j<p.grille[0].length; j++) {
				if (p.grille[i][j].getContenu()!= null && p.grille[i][j].getContenu().getEquipe()==1)
					equipe1++;
				else if (p.grille[i][j].getContenu()!= null && p.grille[i][j].getContenu().getEquipe()==2)
					equipe2++;
			}
		} if (equipe1 == 0 && equipe2 == 0) {
			p.fini=true;
			System.out.println("Egalité !!");
		} else if (equipe1 == 0) {
			p.fini=true;
			System.out.println("Joueur 2 à gagner !!");
		} else if (equipe2 == 0) {
			p.fini=true;
			System.out.println("Joueur 1 à gagner !!");
		}

	}
}



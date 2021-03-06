package gameWar;




public class Game {

	public static Plateau p;
	public static void main(String[] args) {
		new gameGraphic.Window();
		String partie = gameController.EntrerIA.entrerIA();
		if (partie.equals("jcia"))
			partieJcIARandom();
		else if (partie.equals("iacia"));
		partieIAcIA();
	}



	/**
	 * 	Execute une partie Joueur contre IA
	 */
	public static void partieJcIARandom() {
		Plateau p = new Plateau(0);
		System.out.print(p.toString(1, 0));
		Joueur.creerRobots(p,true);
		IARandom.creerRobots(p, 2);
		while (!p.fini) {
			regeneBases();
			//Joueur.jouer(p, 1);
			testFini(p);
			IARandom.jouer(p, 2);
			testFini(p);
			try{
				Thread.sleep(2000);
			}
			catch(Exception e){System.out.println(e.getMessage());}
		}
	}

	/**
	 * 	Execute une partie IA contre IA
	 */
	public static void partieIAcIA() {
		IARandom.creerRobots(gameGraphic.BoardDisplayer.board, 1);
		IARandom.creerRobots(gameGraphic.BoardDisplayer.board, 2);
		System.out.println(gameGraphic.BoardDisplayer.board.toString(0,0));
		gameGraphic.WarPanel.bd.repaint();

		while (!gameGraphic.BoardDisplayer.board.fini) {
			regeneBases();
			IARandom.jouer(gameGraphic.BoardDisplayer.board, 1);
			testFini(gameGraphic.BoardDisplayer.board);
			gameGraphic.WarPanel.bd.repaint();

			try{
				Thread.sleep(500);
			}
			catch(Exception e){System.out.println(e.getMessage());}

			IARandom.jouer(gameGraphic.BoardDisplayer.board, 2);
			testFini(gameGraphic.BoardDisplayer.board);
			gameGraphic.WarPanel.bd.repaint();

			try{
				Thread.sleep(500);
			}
			catch(Exception e){System.out.println(e.getMessage());}
		}
	}

	/**
	 * @param p
	 * 
	 * 	Test si la partie est termin�e est determine le vainqueur
	 */
	public static int testFini(Plateau p) {
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
			return 3;
		} else if (equipe1 == 0) {
			return 2;
		} else if (equipe2 == 0) {
			return 1;
		}
		return 0;
	}

	/**
	 * @param p
	 * 
	 * 	Rend 2 point d'energie aux robots qui sont dans leur base
	 */
	@SuppressWarnings("static-access")
	public static void regeneBases() {
		
		for (int i=0; i<gameGraphic.BoardDisplayer.board.grille[0][0].r.size(); i++)
			if (gameGraphic.BoardDisplayer.board.grille[0][0].r.get(i).getEnergie()+2<gameGraphic.BoardDisplayer.board.grille[0][0].r.get(i).getEnergieMax()) {
				gameGraphic.BoardDisplayer.board.grille[0][0].r.get(i).setEnergie(gameGraphic.BoardDisplayer.board.grille[0][0].r.get(i).getEnergie()+2);
			}
		for (int i=0; i<gameGraphic.BoardDisplayer.board.grille[gameGraphic.BoardDisplayer.board.hauteur-1][gameGraphic.BoardDisplayer.board.largeur-1].r.size(); i++)
			if (gameGraphic.BoardDisplayer.board.grille[gameGraphic.BoardDisplayer.board.hauteur-1][gameGraphic.BoardDisplayer.board.largeur-1].r.get(i).getEnergie()+2<gameGraphic.BoardDisplayer.board.grille[gameGraphic.BoardDisplayer.board.hauteur-1][gameGraphic.BoardDisplayer.board.largeur-1].r.get(i).getEnergieMax())
				gameGraphic.BoardDisplayer.board.grille[gameGraphic.BoardDisplayer.board.hauteur-1][gameGraphic.BoardDisplayer.board.largeur-1].r.get(i).setEnergie(gameGraphic.BoardDisplayer.board.grille[gameGraphic.BoardDisplayer.board.hauteur-1][gameGraphic.BoardDisplayer.board.largeur-1].r.get(i).getEnergie()+2);
	}
}



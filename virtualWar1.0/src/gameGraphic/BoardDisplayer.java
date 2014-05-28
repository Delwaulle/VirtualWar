package gameGraphic;

import gameWar.Plateau;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


/**
 * 
 * @author Benoît
 * 
 */
public class BoardDisplayer extends JPanel {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	private Plateau				board;
	private int					team;
	/**
	 * 
	 * @param board
	 */

	public BoardDisplayer(CardLayout cl, JPanel pan,Plateau b) {
		board = b;
	}

	public void displayGUI(Plateau board, int team) {
		this.board = board;
		this.team = team;
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		this.getSize();
		String s = new String();
		g.setColor(Color.WHITE);
		for (int i = 0; i < (Plateau.largeur); ++i) {
			for (int j = 0; j < (Plateau.hauteur); ++j) {
				s = "rsc/images/tiles/floor.png";
				if (board.estBase(i, j) == 1) {
					s = "rsc/images/team1/Base.png";
				} else if (board.estBase(i, j) == 2) {
					s = "rsc/images/team2/Base.png";
				} else if (board.getGrille()[i][j].estObstacle()) {
					s = "rsc/images/tiles/wall.png";
				} else if (board.getGrille()[i][j].estMine() == team) {
					s = "rsc/images/tiles/Mine.png";
				} else if (board.getContenu(i, j) != null) {
					if (board.getContenu(i, j).getEquipe() == 1) {
						s = "rsc/images/team1/TankFrHaut.png";
					} else {
						s = "rsc/images/team2/TankRuHaut.png";
					}
				}
				g.drawImage(getImage(s), (i * this.getSize().width)
						/ Plateau.largeur, (j * this.getSize().height)
						/ Plateau.hauteur, this.getSize().width
						/ Plateau.largeur, this.getSize().height
						/ Plateau.hauteur, null);
				g.setColor(Color.WHITE);
				g.drawRect((i * this.getSize().width) / Plateau.largeur, (j * this.getSize().height)
						/ Plateau.hauteur, this.getSize().width
						/ Plateau.largeur, this.getSize().height
						/ Plateau.hauteur);
			}
		}
	}

	private BufferedImage getImage(String url) {
		Image image = null;
		try {
			image = ImageIO.read(new File(url));
		} catch (IOException e) {
			System.out.println(url);
			e.printStackTrace();
		}
		BufferedImage buffered = (BufferedImage) image;
		return buffered;
	}
}
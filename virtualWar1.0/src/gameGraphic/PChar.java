package gameGraphic;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PChar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image img;
	public PChar() {
		try {
			img=ImageIO.read(new File("rsc/images/tanks/Caracteristiques.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(img,0,0,this);
	}
}

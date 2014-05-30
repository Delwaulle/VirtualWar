package gameGraphic;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Window extends JFrame{
	public Window() {
		super("Virtual War");
		this.setIconImage(new ImageIcon("rsc/images/icon.png").getImage());
		//this.init();
		this.getContentPane().add(new AffichageBronzeV(0,this));
		this.setBounds(200,80,800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}
}

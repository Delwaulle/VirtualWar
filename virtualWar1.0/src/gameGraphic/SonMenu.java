package gameGraphic;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SonMenu extends Thread{
	AudioInputStream audioInputStream = null;
	SourceDataLine line;
	int cpt;
	public boolean isDodo() {
		return dodo;
	}
	public void setDodo(boolean dodo) {
		this.dodo = dodo;
	}
	private boolean dodo;
	@Override
	public void run(){
		cpt++;
		if(cpt==1) {
			File fichier = new File("rsc/son/sonMenu.WAV");
			while (!dodo) {
				try {
					@SuppressWarnings("unused")
					AudioFileFormat format = AudioSystem.getAudioFileFormat(fichier);
				} catch (UnsupportedAudioFileException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				try {
					audioInputStream = AudioSystem.getAudioInputStream(fichier);
				} catch (UnsupportedAudioFileException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

				AudioFormat audioFormat = audioInputStream.getFormat();
				DataLine.Info info = new DataLine.Info(SourceDataLine.class,audioFormat);

				try {
					line = (SourceDataLine) AudioSystem.getLine(info);

				} catch (LineUnavailableException e) {
					e.printStackTrace();
					return;
				}

				try {
					line.open(audioFormat);
				} catch (LineUnavailableException e) {
					e.printStackTrace();
					return;
				}
				line.start();

				try {
					byte bytes[] = new byte[1024];
					int bytesRead=0;
					while ((bytesRead = audioInputStream.read(bytes, 0, bytes.length)) != -1) {
						line.write(bytes, 0, bytesRead);
					}
				} catch (IOException io) {
					io.printStackTrace();
					return;
				}
			}
		}
	}
}

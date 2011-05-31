
import java.awt.*;
import java.util.*;
import java.awt.color.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.applet.*;

import javax.imageio.ImageIO;
public class BattleSystem extends Applet implements Runnable,KeyListener{
	private ArrayList<String> commands = new ArrayList<String>();
	private ArrayList<String> moves = new ArrayList<String>();
	//private 
	public void init() {
		setSize(700, 500);
		setBackground(Color.WHITE);
		//initializes applet
	}

	public void start(){
		//
	}
	
	public void paint(Graphics g) {
		update(g);
		BufferedImage pokemon1 = null;
		try {
			pokemon1 = ImageIO.read(new File("Charizard.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(pokemon1, 100, 500, null);
		//Putting stuff on screen
	}
	
	public void update(Graphics g){
		//will prevent flickering>>look at double buffering
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//
		
	}
	
	
	
}

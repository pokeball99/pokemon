
import java.awt.*;
import java.util.*;
import java.awt.color.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
		Pokemon a = new Pokemon(2, "name", "type", "type",
				5, 0, 0, 0, 0, 0, 0,
				0);
		//initializes applet
	}

	public void start(){
		//
	}
	
	public void paint(Graphics g) {
		update(g);
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

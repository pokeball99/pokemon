
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
	Pokemon protagPKMN;
	Pokemon enemyPKMN;
	Image backbuffer;
	Graphics backg;
	BufferedImage protag;
	BufferedImage enemy;
	ArrayList<Pokemon> pkmn;
	ArrayList<Move> moves;
	
	//private 
	public void init() {
		Pokedex pokedex = new Pokedex();
		try {
			pokedex.makePokemon();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pkmn = pokedex.getPkmn();
		moves = pokedex.getMoves();
		setSize(400, 300);
		setBackground(Color.WHITE);
		addKeyListener(this);
		// create the backbuffer image that will later be swapped to the screen
		backbuffer = createImage(getSize().width, getSize().height);
		// get the backbuffer’s graphics (canvas) so that we can draw on it.
		backg = backbuffer.getGraphics();
		
	}

	public void start(){
		//
	}
	
	public void paint(Graphics g) {
		update(g);
		System.out.println("Hi");
		//Putting stuff on screen
	}
	
	public void update(Graphics g){
		drawPokemon();
		g.drawImage(backbuffer, 0, 0, this);
		try{
				Thread.sleep(10);
		}catch(InterruptedException e){}
		
		//if we want to continually update the canvas, we need to:
		repaint();
	}
	
	public void drawPokemon(){
		try {
			protag = ImageIO.read(new File("Pokemon Sprites/CharizardBack.png"));
			enemy = ImageIO.read(new File("Pokemon Sprites/ArceusFront.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Draw Moves Bar
		backg.drawRect(0, 249, 399, 49);
		backg.drawLine(0, 273, 399, 273);
		backg.drawLine(200, 249, 200, 298);
		
		//Draw Enemy HP Bar
		backg.drawRect(25, 25, 150, 5);
		backg.setColor(Color.GREEN);
		backg.fillRect(26, 26, 149, 4);
		backg.setColor(Color.BLACK);
		
		//Draw Protag HP Bar
		backg.drawRect(225, 175, 150, 5);
		backg.setColor(Color.GREEN);
		backg.fillRect(226, 176, 149, 4);
		backg.setColor(Color.BLACK);
		
		//backg.drawRect(x, y, width, height);
		backg.drawImage(protag, 50, 135, null);
		backg.drawImage(enemy, 260, 0, null);
		//will prevent flickering>>look at double buffering
		
		//drawImage draws the Backbuffer image to the screen at (0,0)
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

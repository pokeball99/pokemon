
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
	ArrayList<Move> protagMoveList;
	ArrayList<Move> enemyMoveList;
	boolean turn;
	int moveChance;
	/*Move protagMove1;
	Move protagMove2;
	Move protagMove3;
	Move protagMove4;*/
	/*Move enemyMove1;
	Move enemyMove2;
	Move enemyMove3;
	Move enemyMove4;*/
	
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
		//Pokemon "Grovyle" is glitched so it is made so protag cannot get "Grovyle"
		protagPKMN = pkmn.get((int)Math.round(Math.random() * 50));
		while(protagPKMN.getName().equals("Grovyle")){
			protagPKMN = pkmn.get((int)Math.round(Math.random() * 50));
		}
		enemyPKMN = pkmn.get((int)Math.round(Math.random() * 50));
		protagMoveList.add(protagPKMN.getMove1());
		protagMoveList.add(protagPKMN.getMove2());
		protagMoveList.add(protagPKMN.getMove3());
		protagMoveList.add(protagPKMN.getMove4());
		enemyMoveList.add(enemyPKMN.getMove1());
		enemyMoveList.add(enemyPKMN.getMove2());
		enemyMoveList.add(enemyPKMN.getMove3());
		enemyMoveList.add(enemyPKMN.getMove4());
	}

	public void start(){
		//
	}
	
	public void paint(Graphics g) {
		update(g);
		//Putting stuff on screen
	}
	
	public void update(Graphics g){
		drawPokemon();
		g.drawImage(backbuffer, 0, 0, this);
		turn = false;
		if(turn = true){
			try{
					Thread.sleep(10);
			}catch(InterruptedException e){}
			drawData();
			java.awt.KeyboardFocusManager.getCurrentKeyboardFocusManager()
			.addKeyEventDispatcher(new java.awt.KeyEventDispatcher() { 
			public boolean dispatchKeyEvent(java.awt.event.KeyEvent event) { 
				String key = javax.swing.KeyStroke.getKeyStrokeForEvent(event).toString(); 
				int chance = 100;
				int BP = 0;
				String form = "";
				double STAB = 1.0;
				
				if (key.equals("pressed LEFT")){ 
					System.out.println(protagPKMN.getName() + " used " + protagPKMN.getMove1() + "!");
					chance = (int) (Math.random() * protagMoveList.get(0).getAccuracy());
					if(chance <= 100 - protagMoveList.get(0).getAccuracy()){
						System.out.println("But it missed!");
					}
				

				}	
				if (key.equals("pressed UP")){ 
					System.out.println(protagPKMN.getName() + " used " + protagPKMN.getMove2() + "!");
					chance = (int) (Math.random() * protagMoveList.get(1).getAccuracy());
					if(chance <= 100 - protagMoveList.get(1).getAccuracy()){
						System.out.println("But it missed!");
					}
		
				
				}
				if (key.equals("pressed DOWN")){ 
					System.out.println(protagPKMN.getName() + " used " + protagPKMN.getMove3() + "!");
					chance = (int) (Math.random() * protagMoveList.get(2).getAccuracy());
					if(chance <= 100 - protagMoveList.get(2).getAccuracy()){
						System.out.println("But it missed!");
					}
				
				}
				if (key.equals("pressed RIGHT")){ 
					System.out.println(protagPKMN.getName() + " used " + protagPKMN.getMove4() + "!");
					chance = (int) (Math.random() * protagMoveList.get(3).getAccuracy());
					if(chance <= 100 - protagMoveList.get(3).getAccuracy()){
						System.out.println("But it missed!");
					}
					
				}
				turn = false;
					return true;
			}
		});
	}else {
		moveChance = (int)Math.round((Math.random() * 3));
		/*for(Move m: moves){
			if(enemyMoveList(0).equals(m.getName())){
				enemyMoveList(0)
			}
		}
		for(Move m: moves){
			if(enemyMoveList(1).equals(m.getName())){
				enemyMoveList(1) 
			}
		}
		for(Move m: moves){
			if(enemyMoveList(2).equals(m.getName())){
				enemyMoveList(2) 
			}
		}
		for(Move m: moves){
			if(enemyMoveList(3).equals(m.getName())){
				enemyMoveList(3) 
			}
		}*/
		if (moveChance == 0){
			System.out.println(enemyPKMN.getName() + " used " + enemyMoveList.get(0).getName());
		}
		if (moveChance == 1){
			System.out.println(enemyPKMN.getName() + " used " + enemyMoveList.get(1).getName());
		}
		if (moveChance == 2){
			System.out.println(enemyPKMN.getName() + " used " + enemyMoveList.get(2).getName());
		}
		if (moveChance == 3){
			System.out.println(enemyPKMN.getName() + " used " + enemyMoveList.get(3).getName());
		}
		turn = true;
	}
		//if we want to continually update the canvas, we need to:
		repaint();
	}
	public void drawPokemon(){
		try {
			protag = ImageIO.read(new File("Pokemon Sprites/" + protagPKMN.getName() + "Back.png"));
			enemy = ImageIO.read(new File("Pokemon Sprites/" + enemyPKMN.getName() + "Front.png"));
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
	
	public void drawData(){
		//Draws the four move's name and PP
		Move move1 = protagPKMN.getMove1();
		backg.drawString(move1.getName(), 100, 265);
		//backg.drawString("" + protagMove1.getPP(), 50, 265);
		
		Move move2 = protagPKMN.getMove2();
		backg.drawString(move2.getName(), 300, 265);
		//backg.drawString("" + protagMove2.getPP(), 250, 265);
		
		Move move3 = protagPKMN.getMove3();
		backg.drawString(move3.getName(), 100, 290);
		//backg.drawString("" + protagMove3.getPP(), 50, 290);
		
		Move move4 = protagPKMN.getMove4();
		backg.drawString(move4.getName(), 300, 290);
		//backg.drawString("" + protagMove4.getPP(), 250, 290);
		
		//Draws PKMN's name and HP
		backg.drawString(protagPKMN.getName(), 310, 170);
		backg.drawString(protagPKMN.getHP() + "", 295, 194);
		backg.drawString(enemyPKMN.getName() + "", 55, 20);
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




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
	int damageTaken;
	int damage;

	
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
		protagMoveList = protagPKMN.getMoveSet();
		enemyMoveList = enemyPKMN.getMoveSet();
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
					System.out.println(protagPKMN.getName() + " used " + protagPKMN.getMoveSet().get(0).getName() + "!");
					chance = (int) (Math.random() * protagMoveList.get(0).getAccuracy());
					if(chance <= 100 - protagMoveList.get(0).getAccuracy()){
						System.out.println("But it missed!");
					}
					damage(protagPKMN,enemyPKMN,0);

				}	
				if (key.equals("pressed UP")){ 
					System.out.println(protagPKMN.getName() + " used " + protagPKMN.getMoveSet().get(1).getName() + "!");
					chance = (int) (Math.random() * protagMoveList.get(1).getAccuracy());
					if(chance <= 100 - protagMoveList.get(1).getAccuracy()){
						System.out.println("But it missed!");
					}
					damage(protagPKMN,enemyPKMN,1);
				
				}
				if (key.equals("pressed DOWN")){ 
					System.out.println(protagPKMN.getName() + " used " + protagPKMN.getMoveSet().get(2).getName() + "!");
					chance = (int) (Math.random() * protagMoveList.get(2).getAccuracy());
					if(chance <= 100 - protagMoveList.get(2).getAccuracy()){
						System.out.println("But it missed!");
					}
					damage(protagPKMN,enemyPKMN,2);
				}
				
				if (key.equals("pressed RIGHT")){ 
					System.out.println(protagPKMN.getName() + " used " + protagPKMN.getMoveSet().get(3).getName() + "!");
					chance = (int) (Math.random() * protagMoveList.get(3).getAccuracy());
					if(chance <= 100 - protagMoveList.get(3).getAccuracy()){
						System.out.println("But it missed!");
					}
					damage(protagPKMN,enemyPKMN,3);
				}
				turn = false;
					return true;
			}
		});
		if(turn = false) {
			moveChance = (int)Math.round((Math.random() * 3));
			System.out.println("" + moveChance);
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
			//ADD  THISSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS DOWN THERE
			System.out.println(enemyPKMN.getName() + " used " + enemyPKMN.getMoveSet().get(moveChance).getName());
			
			turn = true;
		}
			//if we want to continually update the canvas, we need to:
		repaint();
		}
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
		enemyPKMN.setHP(enemyPKMN.getHP() - damage);
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
		backg.drawString(protagPKMN.getMoveSet().get(0).getName(), 100, 265);
		backg.drawString("" + protagPKMN.getMoveSet().get(0).getPP(), 50, 265);
		
		backg.drawString(protagPKMN.getMoveSet().get(1).getName(), 300, 265);
		backg.drawString("" + protagPKMN.getMoveSet().get(1).getPP(), 250, 265);

		backg.drawString(protagPKMN.getMoveSet().get(2).getName(), 100, 290);
		backg.drawString("" + protagPKMN.getMoveSet().get(2).getPP(), 50, 290);
		
		backg.drawString(protagPKMN.getMoveSet().get(3).getName(), 300, 290);
		backg.drawString("" + protagPKMN.getMoveSet().get(3).getPP(), 250, 290);
		
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
	
	public int damage(Pokemon atkPKMN, Pokemon defPKMN, int moveNum){
		damage = 0;
		int Crit = 1;
	
		if(Math.random()<=0.05){
		    Crit = 2;
		}
		if(protagPKMN.getMoveSet().get(0).getForm().equals("Physical")){
			damage = ((int)(((atkPKMN.getMoveSet().get(moveNum).getDamage() * (atkPKMN.getAtk()  / 5))  /  (defPKMN.getDef() + 2)) * Crit * (Math.random() / 2 + .75) /** STAB*/));
			System.out.println("" + damage);
			if(Crit == 2){
				System.out.println("It's a critical hit!");
			}
		}else{
			damage = ((int)(((atkPKMN.getMoveSet().get(moveNum).getDamage() * (atkPKMN.getSpAtk()  / 5))  /  (defPKMN.getSpDef() + 2)) * Crit * (Math.random() / 2 + .75) /** STAB*/));
			if(Crit == 2){
				System.out.println("It's a critical hit!");
			}
			System.out.println("" + damage);
		}
		
		return damage;
	}
}



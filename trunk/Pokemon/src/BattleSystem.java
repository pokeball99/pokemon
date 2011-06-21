
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
	int protagAtkDamage;
	int enemyAtkDamage;
	int enemyHPBar;
	int protagHPBar;
	int protagMaxHP;
	int enemyMaxHP;

	
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
		enemyHPBar = 150;
		protagHPBar = 150;
		protagMaxHP = protagPKMN.getHP();
		enemyMaxHP = enemyPKMN.getHP();
		drawPokemon();
	}
	
	public void start(){
		//
	}
	
	public void paint(Graphics g) {
		if((protagPKMN.getHP() != 0) || (enemyPKMN.getHP() != 0)){
			update(g);
		}
		if(protagPKMN.getHP() <= 0){
			System.out.println(protagPKMN.getName() + " fainted!");
		}
		if(enemyPKMN.getHP() <=0){
			System.out.println(enemyPKMN.getName() + " fainted!");
		}
		//Putting stuff on screen
	}
	
	public void update(Graphics g){
		g.drawImage(backbuffer, 0, 0, this);
		if(turn == false) {
			moveChance = (int)Math.round((Math.random() * 3));
			System.out.println(enemyPKMN.getName() + " used " + enemyPKMN.getMoveSet().get(moveChance).getName());
			damage(enemyPKMN, protagPKMN, moveChance);
			reDrawPokemon();
			turn = true;
		}
		if(turn == true){
			try{
					Thread.sleep(10);
			}catch(InterruptedException e){}
			drawData();
			java.awt.KeyboardFocusManager.getCurrentKeyboardFocusManager()
			.addKeyEventDispatcher(new java.awt.KeyEventDispatcher() { 
			public boolean dispatchKeyEvent(java.awt.event.KeyEvent event) { 
				String key = javax.swing.KeyStroke.getKeyStrokeForEvent(event).toString(); 
				int chance = 100;
				
				
				if (key.equals("pressed LEFT")){ 
					if(protagMoveList.get(0).getPP() <= 0){
						System.out.println(protagMoveList.get(0).getName() + " ran out of PP!");
					}else{
						System.out.println(protagPKMN.getName() + " used " + protagPKMN.getMoveSet().get(0).getName() + "!");
						chance = (int) (Math.random() * protagMoveList.get(0).getAccuracy());
						if(chance <= 100 - protagMoveList.get(0).getAccuracy()){
							System.out.println("But it missed!");
						}
						damage(protagPKMN,enemyPKMN,0);
						protagPKMN.getMoveSet().get(0).setPP(protagPKMN.getMoveSet().get(0).getPP() - 1);
						reDrawPokemon();
					}
				}	
				if (key.equals("pressed UP")){ 
					if(protagMoveList.get(1).getPP() <= 0){
						System.out.println(protagMoveList.get(1).getName() + " ran out of PP!");
					}else{
						System.out.println(protagPKMN.getName() + " used " + protagPKMN.getMoveSet().get(1).getName() + "!");
						chance = (int) (Math.random() * protagMoveList.get(1).getAccuracy());
						if(chance <= 100 - protagMoveList.get(1).getAccuracy()){
							System.out.println("But it missed!");
						}
						damage(protagPKMN,enemyPKMN,1);
						protagPKMN.getMoveSet().get(1).setPP(protagPKMN.getMoveSet().get(1).getPP() - 1);
						reDrawPokemon();
					}
				}
				if (key.equals("pressed DOWN")){ 
					if(protagMoveList.get(2).getPP() <= 0){
						System.out.println(protagMoveList.get(2).getName() + " ran out of PP!");
					}else{
						System.out.println(protagPKMN.getName() + " used " + protagPKMN.getMoveSet().get(2).getName() + "!");
						chance = (int) (Math.random() * protagMoveList.get(2).getAccuracy());
						if(chance <= 100 - protagMoveList.get(2).getAccuracy()){
							System.out.println("But it missed!");
						}
						damage(protagPKMN,enemyPKMN,2);
						protagPKMN.getMoveSet().get(2).setPP(protagPKMN.getMoveSet().get(2).getPP() - 1);
						reDrawPokemon();
					}
				}
				
				if (key.equals("pressed RIGHT")){ 
					if(protagMoveList.get(3).getPP() <= 0){
						System.out.println(protagMoveList.get(3).getName() + " ran out of PP!");
					}else{
						System.out.println(protagPKMN.getName() + " used " + protagPKMN.getMoveSet().get(3).getName() + "!");
						chance = (int) (Math.random() * protagMoveList.get(3).getAccuracy());
						if(chance <= 100 - protagMoveList.get(3).getAccuracy()){
							System.out.println("But it missed!");
						}
						damage(protagPKMN,enemyPKMN,3);
						protagPKMN.getMoveSet().get(3).setPP(protagPKMN.getMoveSet().get(3).getPP() - 1);
						reDrawPokemon();
					}
				}
				turn = false;
				return true;
			}
		});
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
		backg.drawRect(24, 25, 151, 5);
		backg.setColor(Color.GREEN);
		backg.fillRect(25, 26, enemyHPBar, 4);
		backg.setColor(Color.BLACK);
		
		//Draw Protag HP Bar
		backg.drawRect(224, 175, 151, 5);
		backg.setColor(Color.GREEN);
		backg.fillRect(225, 176, protagHPBar, 4);
		
		//backg.drawRect(x, y, width, height);
		backg.drawImage(protag, 50, 135, null);
		backg.drawImage(enemy, 260, 0, null);
		//will prevent flickering>>look at double buffering
		
		//drawImage draws the Backbuffer image to the screen at (0,0)
	}
	
	public void drawData(){
		//Draws the four move's name and PP
		backg.drawString(protagPKMN.getMoveSet().get(0).getName(), 100, 265);
		
		backg.setColor(Color.WHITE);
		backg.fillRect(50, 255, 20, 10);
		backg.setColor(Color.BLACK);
		backg.drawString("" + protagPKMN.getMoveSet().get(0).getPP(), 50, 265);
		
		
		backg.drawString(protagPKMN.getMoveSet().get(1).getName(), 300, 265);
		backg.setColor(Color.WHITE);
		backg.fillRect(250, 255, 20, 10);
		backg.setColor(Color.BLACK);
		backg.drawString("" + protagPKMN.getMoveSet().get(1).getPP(), 250, 265);

		backg.drawString(protagPKMN.getMoveSet().get(2).getName(), 100, 290);
		backg.setColor(Color.WHITE);
		backg.fillRect(50, 280, 20, 10);
		backg.setColor(Color.BLACK);
		backg.drawString("" + protagPKMN.getMoveSet().get(2).getPP(), 50, 290);
		
		backg.drawString(protagPKMN.getMoveSet().get(3).getName(), 300, 290);
		backg.setColor(Color.WHITE);
		backg.fillRect(250, 280, 20, 10);
		backg.setColor(Color.BLACK);
		backg.drawString("" + protagPKMN.getMoveSet().get(3).getPP(), 250, 290);
		
		//Draws PKMN's name and HP
		backg.drawString(protagPKMN.getName(), 310, 170);
		if(protagPKMN.getHP() <= 0){
			protagPKMN.setHP(0);
		}
		if(enemyPKMN.getHP() <=0){
			enemyPKMN.setHP(0);
		}
		backg.drawString(protagPKMN.getHP() + "", 295, 194);
		backg.drawString(enemyPKMN.getName() + "", 55, 20);
		backg.drawString(enemyPKMN.getHP() + "", 95, 45);
	}
	
	public void reDrawPokemon(){
		try {
			protag = ImageIO.read(new File("Pokemon Sprites/" + protagPKMN.getName() + "Back.png"));
			enemy = ImageIO.read(new File("Pokemon Sprites/" + enemyPKMN.getName() + "Front.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Draw Moves Bar
		backg.setColor(Color.BLACK);
		backg.drawRect(0, 249, 399, 49);
		backg.drawLine(0, 273, 399, 273);
		backg.drawLine(200, 249, 200, 298);
		
		//Draw Enemy HP Bar
		backg.setColor(Color.WHITE);
		backg.fillRect(25, 25, 150, 5);
		backg.setColor(Color.BLACK);
		enemyPKMN.setHP(enemyPKMN.getHP() - protagAtkDamage);
		enemyHPBar = (int) ((double) enemyPKMN.getHP() / enemyMaxHP * 150);
		backg.drawRect(24, 25, 151, 5);
		backg.setColor(Color.GREEN);
		backg.fillRect(25, 26, enemyHPBar, 4);
		backg.setColor(Color.BLACK);
		
		//Covers Previous enemyHP #
		backg.setColor(Color.WHITE);
		backg.fillRect(95, 35, 100, 10);
		backg.setColor(Color.BLACK);
		
		//Draw Protag HP Bar
		protagPKMN.setHP(protagPKMN.getHP() - enemyAtkDamage);
		protagHPBar = (int) ((double) protagPKMN.getHP() / protagMaxHP * 150);
		System.out.println(protagHPBar + "p");
		backg.drawRect(224, 175, 151, 5);
		backg.setColor(Color.GREEN);
		backg.fillRect(225, 176, protagHPBar, 4);
		backg.setColor(Color.BLACK);
		
		//Covers protagHP #
		backg.setColor(Color.WHITE);
		backg.fillRect(295, 185, 150, 10);
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
	
	public int damage(Pokemon atkPKMN, Pokemon defPKMN, int moveNum){
		int Crit  = 1;
		if(atkPKMN.equals(protagPKMN)){	
			protagAtkDamage = 0;
		
			if(Math.random()<=0.05){
			    Crit = 2;
			}
			if(protagPKMN.getMoveSet().get(0).getForm().equals("Physical")){
				protagAtkDamage = ((int)(((atkPKMN.getMoveSet().get(moveNum).getDamage() * (atkPKMN.getAtk()  / 5))  /  (defPKMN.getDef() + 2)) * Crit * (Math.random() / 2 + .75) /** STAB*/));
				System.out.println("" + protagAtkDamage);
				if(Crit == 2){
					System.out.println("It's a critical hit!");
				}
			}else{
				protagAtkDamage = ((int)(((atkPKMN.getMoveSet().get(moveNum).getDamage() * (atkPKMN.getSpAtk()  / 5))  /  (defPKMN.getSpDef() + 2)) * Crit * (Math.random() / 2 + .75) /** STAB*/));
				if(Crit == 2){
					System.out.println("It's a critical hit!");
				}
				System.out.println("" + protagAtkDamage);
			}
			return protagAtkDamage;
		}else{
			enemyAtkDamage = 0;
		
			if(Math.random()<=0.05){
			    Crit = 2;
			}
			if(enemyPKMN.getMoveSet().get(0).getForm().equals("Physical")){
				enemyAtkDamage = ((int)(((atkPKMN.getMoveSet().get(moveNum).getDamage() * (atkPKMN.getAtk()  / 5))  /  (defPKMN.getDef() + 2)) * Crit * (Math.random() / 2 + .75) /** STAB*/));
				System.out.println("" + enemyAtkDamage);
				if(Crit == 2){
					System.out.println("It's a critical hit!");
				}
			}else{
				enemyAtkDamage = ((int)(((atkPKMN.getMoveSet().get(moveNum).getDamage() * (atkPKMN.getSpAtk()  / 5))  /  (defPKMN.getSpDef() + 2)) * Crit * (Math.random() / 2 + .75) /** STAB*/));
				if(Crit == 2){
					System.out.println("It's a critical hit!");
				}
				System.out.println("" + enemyAtkDamage);
			}
			return enemyAtkDamage;
		}
	}
}



import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

//Make this into a constructor, have a get method, take out static 

public class Pokedex{
	private ArrayList<Pokemon> pkmn;
	private ArrayList<Move> moves;
	
	public Pokedex(){
		pkmn = new ArrayList<Pokemon>();
		moves = new ArrayList<Move>();
	}
	
	public void makePokemon() throws FileNotFoundException{
		Scanner s = new Scanner(new File("List of Pokemon.txt"));
		Scanner m = new Scanner(new File("List of Moves.txt"));
		while(m.hasNextLine()){
			String move = m.nextLine();
			Scanner moveScan = new Scanner(move);
			String name = moveScan.next();
			String type = moveScan.next();
			String form = moveScan.next();
			int damage = moveScan.nextInt();
			int accuracy = moveScan.nextInt();
			int pp = moveScan.nextInt();
			String effect = moveScan.next();
			Move nextMove = new Move(name, type, form, damage, accuracy, pp, effect);
			moves.add(nextMove);
		}
		while(s.hasNextLine()){
			String line = s.nextLine();
			Scanner lineScan = new Scanner(line);
			//String next = s.next();
			
			//Scanner tokenScan = new Scanner(next);
			int dex = lineScan.nextInt();
			String name = lineScan.next();
			String type1 = lineScan.next();
			String type2 = lineScan.next();
			if(type2.equals("Null")){
				type2 = null;
			}
			int hp = lineScan.nextInt();
			int atk = lineScan.nextInt();
			int def = lineScan.nextInt();
			int spAtk = (lineScan.nextInt());
			int spDef = (lineScan.nextInt());
			int spd = (lineScan.nextInt());
			String moveOne = lineScan.next();
			String moveTwo = lineScan.next();
			String moveThree = lineScan.next();
			String moveFour = lineScan.next();
			
			ArrayList<Move> moveList = new ArrayList<Move>();
			moveList.add(findMove(moveOne));
			moveList.add(findMove(moveTwo));
			moveList.add(findMove(moveThree));
			moveList.add(findMove(moveFour));
			
			Pokemon pokemon = new Pokemon(dex, name, type1, type2,
				1, hp, atk, def, spAtk, spDef, spd, 0, moveList);
			pkmn.add(pokemon);
		}
	}
	
	public Move findMove(String move){
		for(Move m: moves){
			if(move.equals(m.getName())){
				return m;
			}
		}
		return null;
	}
	
	public ArrayList<Pokemon> getPkmn(){
		return pkmn;
	}
	
	public ArrayList<Move> getMoves(){
		return moves;
	}
}
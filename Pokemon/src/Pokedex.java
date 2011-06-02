import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

//Doesn't work because elements in ArrayList "moves" = 
//"MegaHorn Bug Physical 120 85 10 Null" so it can't find "MegaHorn" by itself.

// Fix: use .get() method from moves to get the string to use in search.

public class Pokedex{
	public static void main (String[] args) throws FileNotFoundException{
		Scanner s = new Scanner(new File("src/List of Pokemon.txt"));
		Scanner m = new Scanner(new File("src/List of Moves.txt"));
		ArrayList<Pokemon> list = new ArrayList<Pokemon>();
		ArrayList<Move> moves = new ArrayList<Move>();
		ArrayList<Move> moveSet = new ArrayList<Move>();
		BufferedImage sprite = null;
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
		System.out.println(moves.toString());
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
			Move move1 = moves.get(3);
			System.out.println(moves.indexOf(moveOne));
			String moveTwo = lineScan.next();
			Move move2 = moves.get(moves.indexOf(moveTwo)+1);
			String moveThree = lineScan.next();
			Move move3 = moves.get(moves.indexOf(moveThree)+1);
			String moveFour = lineScan.next();
			Move move4 = moves.get(moves.indexOf(moveFour)+1);
			moveSet.add(move1);
			moveSet.add(move2);
			moveSet.add(move3);
			moveSet.add(move4);
			//try {
			//sprite = ImageIO.read(new File(name + ".png"));
			//} catch (IOException e) {
			//	e.printStackTrace();
			//}
			Pokemon pokemon = new Pokemon(dex, name, type1, type2,
				1, hp, atk, def, spAtk, spDef, spd, 0, moveSet, sprite);
			list.add(pokemon);	
		}
		System.out.print(list.toString());
	}
}


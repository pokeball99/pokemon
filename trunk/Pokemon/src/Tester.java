import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Tester{
	public static void main (String[] args) throws FileNotFoundException{
		Scanner s = new Scanner(new File("List of Pokemon.txt"));
		ArrayList<Pokemon> list = new ArrayList<Pokemon>();
		while(s.hasNextLine()){
			String line = s.nextLine();
			Scanner lineScan = new Scanner(line);
			//String next = s.next();
			//Scanner tokenScan = new Scanner(next);
			while(lineScan.hasNext()){
				String type2 = "";
				int dex = lineScan.nextInt();
				String name = (lineScan.next());
				String type1 = (lineScan.next());
				if(!(lineScan.next().equals("Null"))){
					type2 = (lineScan.next());
				}else {
					type2 = null;
				}
				int hp = (lineScan.nextInt());
				int atk = (lineScan.nextInt());
				int def = (lineScan.nextInt());
				int spAtk = (lineScan.nextInt());
				int spDef = (lineScan.nextInt());
				int spd = (lineScan.nextInt());
				//setSprite();
				Pokemon pokemon = new Pokemon(dex, name, type1, type2,
						100, hp, atk, def, spAtk, spDef, spd, 1000000);
				list.add(pokemon);
				System.out.print(list.toString());
			}
		}
	}
}


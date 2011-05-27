import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Tester{
	public static void main (String[] args) throws FileNotFoundException{
		Scanner s = new Scanner(new File("src/List of Pokemon.txt"));
		ArrayList<Pokemon> list = new ArrayList<Pokemon>();
		ArrayList<String> moves = new ArrayList<String>();
		while(s.hasNextLine()){
			String line = s.nextLine();
			Scanner lineScan = new Scanner(line);
			//String next = s.next();
			//Scanner tokenScan = new Scanner(next);
				int dex = lineScan.nextInt();
				String name = (lineScan.next());
				String type1 = (lineScan.next());
				String type2 = (lineScan.next());
				if((type2.equals("Null"))){
					type2 = null;
				}
				int hp = (lineScan.nextInt());
				int atk = (lineScan.nextInt());
				int def = (lineScan.nextInt());
				int spAtk = (lineScan.nextInt());
				int spDef = (lineScan.nextInt());
				int spd = (lineScan.nextInt());
				
				Pokemon pokemon = new Pokemon(dex, name, type1, type2,
						1, hp, atk, def, spAtk, spDef, spd, 0);
				list.add(pokemon);
				System.out.print(list.toString());
			
		}
	}
}


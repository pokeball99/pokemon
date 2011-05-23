/*
 * Kevin Fong and David Wong
	CCCCCCCCCCCCCCCCCC
 * APCS Period 6
 * Interface for Pokemon
 */
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.io.*;

public class Pokemon{
	private int dexNum;
	private String name;
	public String Type1;
	public String Type2;
	private int Level;
	private int HP;
	private int Atk;
	private int Def;
	private int SpAtk;
	private int SpDef;
	private int Spd;
	private int EXP;
	private BufferedImage sprite;
	
	
	public Pokemon()throws FileNotFoundException{
		Scanner s = new Scanner(new File("Base Stats.txt"));
		while(s.hasNextLine()){
			String line = s.nextLine();
			Scanner lineScan = new Scanner(line);
			//String next = s.next();
			//Scanner tokenScan = new Scanner(next);
			while(lineScan.hasNext()){
				setDexNum(lineScan.nextInt());
				setName(lineScan.next());
				setType1(lineScan.next());
				if(!(lineScan.next().equals("Null"))){
					setType2(lineScan.next());
				}
				//setLevel(1);
				setHP(lineScan.nextInt());
				setAtk(lineScan.nextInt());
				setDef(lineScan.nextInt());
				setSpAtk(lineScan.nextInt());
				setSpd(lineScan.nextInt());
				//setEXP(0);
				//setSprite();
			}
		}
	}

	public void setDexNum(int dexNum){
		this.dexNum = dexNum;
	}
	
	public int getDexNum(){
		return dexNum;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}


	public String getName() {
		return name;
	}

	public void setType1(String Type1){
		this.Type1 = Type1;
	}
	
	public String getType1(){
		return Type1;
	}
	
	public void setType2(String Type2){
		this.Type2 = Type2;
	}
	
	public String getType2(){
		return Type2;
	}	
	public void setLevel(int level) {
		Level = level;
	}


	public int getLevel() {
		return Level;
	}


	public void setHP(int hp) {
		HP = hp;
	}


	public int getHP() {
		return HP;
	}


	public void setAtk(int atk) {
		Atk = atk;
	}


	public int getAtk() {
		return Atk;
	}


	public void setDef(int def) {
		Def = def;
	}


	public int getDef() {
		return Def;
	}


	public void setSpAtk(int spAtk) {
		SpAtk = spAtk;
	}


	public int getSpAtk() {
		return SpAtk;
	}


	public void setSpDef(int spDef) {
		SpDef = spDef;
	}


	public int getSpDef() {
		return SpDef;
	}


	public void setSpd(int spd) {
		Spd = spd;
	}


	public int getSpd() {
		return Spd;
	}


	public void setEXP(int exp) {
		EXP = exp;
	}


	public int getEXP() {
		return EXP;
	}


	public void setSprite(BufferedImage sprite) {
		this.sprite = sprite;
	}


	public BufferedImage getSprite() {
		return sprite;
	}
	
}

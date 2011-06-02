/*
 * Kevin Fong and David Wong
 * APCS Period 6
 * Interface for Pokemon
 */ 
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.io.*;

public class Pokemon{
	private int DexNum;
	private String Name;
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
	private ArrayList<Move> MoveSet;
	private BufferedImage Sprite;
	

	public Pokemon(){
	}
	public Pokemon(int dexNum, String name, String type1, String type2,
			int level, int hp, int atk, int def, int spAtk, int spDef, int spd,
			int exp, ArrayList<Move> moveSet, BufferedImage sprite) {
		super();
		DexNum = dexNum;
		Name = name;
		Type1 = type1;
		Type2 = type2;
		Level = level;
		HP = hp;
		Atk = atk;
		Def = def;
		SpAtk = spAtk;
		SpDef = spDef;
		Spd = spd;
		EXP = exp;
		MoveSet = moveSet;
		Sprite = sprite;
	}

	
	public void setDexNum(int dexNum){
		DexNum = dexNum;
	}
	
	public int getDexNum(){
		return DexNum;
	}
	
	
	public void setName(String name) {
		Name = name;
	}


	public String getName() {
		return Name;
	}

	public void setType1(String type1){
		Type1 = type1;
	}
	
	public String getType1(){
		return Type1;
	}
	
	public void setType2(String type2){
		Type2 = type2;
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

	public void setMoveSet(ArrayList<Move> moveSet) {
		MoveSet = moveSet;
	}
	
	public ArrayList<Move> getMoveSet() {
		return MoveSet;
	}
	
	public void setSprite(BufferedImage sprite) {
		Sprite = sprite;
	}


	public BufferedImage getSprite() {
		return Sprite;
	}
	
	public String toString() {
		return DexNum + " " + Name + " " + Type1 + " " + Type2 + " " + Level + " "+ HP + " " + Atk + " " + Def + " " + SpAtk + " " + SpDef + " " + Spd + " "+ EXP + " " + MoveSet.toString();
	}
}

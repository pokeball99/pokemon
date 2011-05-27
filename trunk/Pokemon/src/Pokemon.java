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
	

	public Pokemon(){
	}
	public Pokemon(int dexNum, String name, String type1, String type2,
			int level, int hP, int atk, int def, int spAtk, int spDef, int spd,
			int EXP) {
		super();
		this.dexNum = dexNum;
		this.name = name;
		Type1 = type1;
		Type2 = type2;
		Level = level;
		HP = hP;
		Atk = atk;
		Def = def;
		SpAtk = spAtk;
		SpDef = spDef;
		Spd = spd;
		this.EXP = EXP;
		this.sprite = sprite;
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
	
	public String toString() {
		return dexNum + " " + name + " " + Level + " "+ HP + " " + Atk + " " + Def + " " + SpAtk + " " + SpDef + " " + Spd + " "+ EXP + " ";
	}
}

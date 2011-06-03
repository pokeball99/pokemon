import java.awt.*;

public class Move {
	private String Name;
	private String Type;
	private String Form;
	private int Damage;
	private int Accuracy;
	private int PP;
	private String Effect;
	
	public Move(){
	}
	
	public Move(String name, String type, String form, int damage,
				int accuracy, int pP, String effect){
		super();
		Name = name;
		Type = type;
		Form = form;
		Damage = damage;
		Accuracy = accuracy;
		PP = pP;
		Effect = effect;
	}
	
	public void setName(String name){
		Name = name;
	}
	
	public String getName(){
		return Name;
	}
	
	public void setType(String type){
		Type = type;
	}
	
	public String getType(){
		return Type;
	}
	
	public void setForm(String form){
		Form = form;
	}
	
	public String getForm(){
		return Form;
	}
	
	public void setDamage(int damage){
		Damage = damage;
	}
	
	public int getDamage(){
		return Damage;
	}
	
	public void setAccuracy(int accuracy){
		Accuracy = accuracy;
	}
	
	public int getAccuracy(){
		return Accuracy;
	}
	
	public void setPP(int pp){
		PP = pp;
	}
	
	public int getPP(){
		return PP;
	}
	
	public void setEffect(String effect){
		Effect = effect;
	}
	
	public String getEffect(){
		return Effect;
	}
	
	public String toString(){
		return Name + " " + Type + " " + Form + " " + Damage + " " + Accuracy + " " + PP + " " + Effect;
	}
}

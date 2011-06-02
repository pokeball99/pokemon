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
	
	public String toString(){
		return Name + " " + Type + " " + Form + " " + Damage + " " + Accuracy + " " + PP + " " + Effect;
	}
}

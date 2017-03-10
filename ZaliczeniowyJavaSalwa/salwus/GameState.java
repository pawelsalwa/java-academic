package salwus;

import java.awt.Color;
import java.io.Serializable;

public class GameState implements Serializable {
	
	public int ghp;
	public int gm;
	public int gvp;
	
	public int thp;
	public int tm;
	public int tvp;
	
	public String output = new String();
	
	public boolean player; // Thrall=0 , Garrosh=1
	public boolean winner; // Thrall=0 , Garrosh=1
	public boolean turn; // Thrall=0 , Garrosh=1
	
	GameState(){
		
		ghp = 30;
		gm = 10;
		gvp = 0;
		
		thp = 30;
		tm = 10;
		tvp = 0;
	}

	public void update() { // updatuje wyswietlane statystyki
		MyPanelBot.txtBotHp.setText("Health:" + this.thp);
        MyPanelBot.txtBotMana.setText("Mana: " + this.tm);
        MyPanelBot.txtBotVP.setText("Victory Points:" + this.tvp);
		
        MyPanelTop.txtTopHp.setText("Health:" + this.ghp);
        MyPanelTop.txtTopMana.setText("Mana: " + this.gm);
        MyPanelTop.txtTopVP.setText("Victory Points:" + this.gvp);
        
        //MyPanelTop.setBackground(Color.GREEN);
	}
	
	
}

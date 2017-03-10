package salwus;

import java.io.Serializable;

public class TurnAction implements Serializable{
	public int buttonPressed; //1/2/3
	
	public TurnAction(int bp){
		buttonPressed = bp;
	}
}

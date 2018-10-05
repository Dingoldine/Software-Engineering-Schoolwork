import java.awt.*; 
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

class MyButton extends JButton implements ActionListener{

	private Color color_state_0;
	private Color color_state_1;
	private String string_state_0;
	private String string_state_1;
	private int current_state = 0;


	public MyButton(Color c1, Color c2, String s1, String s2){
		//State zero
		color_state_0 = c1;
		string_state_0 = s1;
		setBackground(color_state_0);
		setText(string_state_0);
		addActionListener(this);
		//State 1 
		color_state_1 = c2;
		string_state_1 = s2;

	}

	public void actionPerformed(ActionEvent e){
		
		}
    	

    

	public void toggleState(){
		if (current_state == 0){
			setBackground(color_state_1);
			setText(string_state_1);
			current_state = 1;
		}
		else{
			setBackground(color_state_0);
			setText(string_state_0);
			current_state = 0;
		}
	}



}

import java.awt.*; 
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

class Program extends JFrame implements ActionListener{
  private JPanel panel;
  private JLabel authors;
  private Scanner scan;
  private String[] user_input;
  private ArrayList<MyButton> array_of_buttons;
  private ArrayList<String> parameters = new ArrayList<>();

  public ArrayList<MyButton> getButtonArray(){
    return array_of_buttons;
  }

  // constructor
  public Program(String title, String[] user_input){
    super(title); 
    this.user_input = user_input;
    String a_number = user_input[0];
    int number_of_buttons = Integer.parseInt(a_number);

    setLayout(new GridLayout(number_of_buttons, number_of_buttons, 20 ,20));
    //Jframe properties
                         // invoke the JFrame constructor
    setSize(800, 600);
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    


    //setVisible(true);           
    
    //JPanel
    panel = new JPanel();
    panel.setBackground(Color.cyan);
    setContentPane(panel);
    panel.setLayout(new FlowLayout());

    array_of_buttons = new ArrayList<MyButton>();
    for (int i = 1; i < user_input.length; i = i + 2){ 
      System.out.print(user_input[i]);
      System.out.print(user_input[i+1]);
      MyButton button = new MyButton(Color.green, Color.red, user_input[i], user_input[i+1]);
      button.addActionListener(this);
      array_of_buttons.add(button);
      add(button);
    }




    //JLabel
    authors = new JLabel("Philip Rumman y Erik Lundsten!");  // construct a JLabel
    //authors.revalidate();
    panel.add(authors);                        // add the label to the JFrame
    setVisible(true);               // ask it to become visible

    }

    public void actionPerformed(ActionEvent e){
        MyButton pressed_button = ((MyButton) e.getSource());
        array_of_buttons.remove(pressed_button);
        for(MyButton b : array_of_buttons){
          b.toggleState();
        }
        array_of_buttons.add(pressed_button);
      

    }
    
    public static void main(String[] args){
   

      Program frame = new Program("Knappar N stuff", args);

  }
}